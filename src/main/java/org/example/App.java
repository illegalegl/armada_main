package org.example;

import java.util.Random;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        int sizeX = 16;
        int sizeY=70;

        landscape l = new landscape(sizeX,sizeY,false,false);

        Random rand = new Random();

        SetTeeAndBasket(sizeX, sizeY, l, rand);

        driver drv = new driver(l.teePos.GetX(),l.teePos.GetY());

        l.addDisc(drv);

        while(l.discs[0].GetPos().GetX()<l.dim_X && l.discs[0].GetPos().GetY()<l.dim_Y && l.discs[0].pos.isInPosition(l.basketPos.GetX(),l.basketPos.GetY())==false) {
            l.printDisplay();
            int curDiscX = drv.GetPos().GetX();
            int curDiscY = drv.GetPos().GetY();
            drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
            int newDiscX = drv.GetPos().GetX();
            int newDiscY = drv.GetPos().GetY();
            System.out.println(curDiscX+","+curDiscY+"  " + newDiscX +"," + newDiscY);
            l.addDisc(drv);
            Thread.sleep(640);
            l.TraceThrow(curDiscX,curDiscY,newDiscX,newDiscY);
        }
        l.printDisplay();
    }

    private static void SetTeeAndBasket(int sizeX, int sizeY, landscape l, Random rand) {
        int xPos = rand.nextInt(sizeX/2)+1;
        int yPos = rand.nextInt(sizeY/4)+1;

        l.setArtifactPosition(xPos,yPos,"tee");

        int xPos2 = rand.nextInt(sizeX/2)-1 + sizeX/2;
        int yPos2 = rand.nextInt(sizeY/2)-1 + sizeY/2;

        l.setArtifactPosition(xPos2,yPos2, "basket");
    }

}
