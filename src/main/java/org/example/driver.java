package org.example;

import java.util.Random;

public class driver extends disc{

    public driver(int x, int y){
        pos = new position(x,y);

        flightNums = new flightNumbers(10,6,3,1,2);
    }

    @Override
    public void ThrowDisc(int targetX, int targetY) {
        double dist=Math.sqrt(Math.pow(((double)pos.GetXDist(targetX)*1.0) ,2.0) + Math.pow(pos.GetYDist(targetY)*1.0,2));
        if(dist<=3.0){
            pos = new position(targetX,targetY);
            System.out.println("Nice layup, easy putt!");
            return;
        }
        Random r = new Random();
        int distX = r.nextInt(flightNums.getSpd()/4)+flightNums.getGld()*2 - flightNums.getTrn()/2;
        int distY = r.nextInt(flightNums.getSpd())+flightNums.getGld()*2 + flightNums.getFde()*2 - flightNums.getTrn();
        if(pos.GetXDist(targetX)<0){distX *= -1;}
        if(pos.GetYDist(targetY)<0){distY *= -1;}


        pos = new position(pos.GetX()+distX, pos.GetY()+distY);
        double throwLength = Math.round(Math.sqrt(Math.abs(distX)+Math.abs(distY)));

        if(pos.isInPosition(targetX,targetY)){
            System.out.println("What a putt! You hit chains from "+ throwLength + " feet away!");
        }else
            System.out.println("You threw " + throwLength + "feet!");
    }

}
