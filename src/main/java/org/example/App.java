package org.example;

import java.util.Random;
import java.util.Scanner;

public class App
{


    public static void main( String[] args ) throws InterruptedException {
        int sizeX = 24;
        int sizeY=60;

        landscape l = new landscape(sizeX,sizeY,true,true);

        l.setTeeAndBasket();

        l.addTrees();
        l.addHazWat();

        driver drv = new driver(l.teePos.GetX(),l.teePos.GetY());

        l.addDisc(drv);
        l.printStaticDisplay();
        while(l.isPositionValid(l.discs[0].pos)&& l.discs[0].pos.isInPosition(l.basketPos.GetX(),l.basketPos.GetY())==false) {
            l.printDisplay();

            drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());

            if(l.isPositionValid(drv.GetPos())==false){
                System.out.println("You are OB. +1 Stroke");
                while(l.isPositionValid(drv.GetPos())==false){
                    drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
                }
            }

//            System.out.println(curDiscX+","+curDiscY+"  " + newDiscX +"," + newDiscY);
            l.addDisc(drv);
            Thread.sleep(640);
          //  l.TraceThrow(curDiscX,curDiscY,newDiscX,newDiscY);
        }
        l.printDisplay();
    }


}
