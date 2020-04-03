package org.example;

import java.util.ArrayList;
import java.util.Random;

public class landscape {
     int dim_X = 0;
     int dim_Y = 0;
     boolean hasTrees=false;
     int numTrees = 0;
     ArrayList<position> treeGroves;
     boolean hasWater=false;
     int numWaters=0;
     ArrayList<position> pondHazards;
     char[][] display;
     disc[] discs;

    public position basketPos = new position(dim_X,dim_Y);
    public position teePos = new position(dim_X,dim_Y);

    public landscape(int size_X, int size_Y, boolean containsTrees, boolean containsWater) {
        dim_X = size_X;
        dim_Y = size_Y;
        hasTrees = containsTrees;
        hasWater = containsWater;
        discs = new disc[3];
        display=new char[dim_X][dim_Y];
        treeGroves = new ArrayList<>();
        pondHazards = new ArrayList<>();
    }


    public void setTeeAndBasket(){
        Random rand = new Random();

        int xPos = rand.nextInt(dim_X/2)+1;
        int yPos = rand.nextInt(dim_Y/4)+1;

        setTeePos(xPos,yPos);

        xPos = rand.nextInt(dim_X/2)-1 + dim_X/2;
        yPos = rand.nextInt(dim_Y/2)-1 + dim_Y/2;

        setBasketPos(xPos,yPos);
    }
    private void setTeePos(int x, int y){
        teePos = setArtifactPosition(x,y);
    }
    private void setBasketPos(int x, int y){
        basketPos = setArtifactPosition(x,y);
    }
    private position setArtifactPosition(int x, int y)  {
        position pos = new position(x,y);

        if(isPositionValid(pos)==false){
            System.out.println("ERR: Cannot place marker outside bounds");
            pos = new position(0,0);
            }
        return pos;
    }
    public boolean isPositionValid(position pos){
        return pos.GetX() >0 && pos.GetX() < dim_X-1 && pos.GetY() > 0 && pos.GetY() < dim_Y-1;
    }

    public void addTrees(){
        Random rand = new Random();
        if(hasTrees){
            numTrees = rand.nextInt(45);
            for(int i= 0;i< numTrees;i++) {
                int xx = rand.nextInt(dim_X-2)+1;

                int yy = rand.nextInt(dim_Y-2)+1;

             //   System.out.println("Tree at: " + xx + "_" + yy);

                treeGroves.add(setArtifactPosition(xx,yy));

            }
        }
    }

    public void addHazWat(){
        Random rand = new Random();
        if(hasWater){
            numWaters = 3;//rand.nextInt(45);
            for(int i= 0;i< numWaters;i++) {
                int xx = rand.nextInt(dim_X-2)+1;

                int yy = rand.nextInt(dim_Y-2)+1;

                System.out.println("Water at: " + xx + "_" + yy);

                if(yy-5>0 && yy+3 < dim_Y){
                    for(int j = yy-3;j<yy+4;j++){
                        pondHazards.add(setArtifactPosition(xx,j));
                    }
                }

            }
        }
    }




    public void addDisc(disc d){
        discs[0] = d;

    }

    public int GetX(){
        return dim_X;
    }
    public void SetX(int x){
        dim_X = x;
    }
    public int GetY(){
        return dim_Y;
    }
    public void SetY(int y){
        dim_Y = y;
    }
    public void printDisplay(){

        String msg = "";
        char c = ' ';
        for(int i=0; i<dim_X;i++){
            c=' ';
            for(int j=0;j<dim_Y;j++){
                boolean isOnTee=false;
                boolean isOnBasket=false;
                boolean isOnDisc=false;
                boolean isOnWater=false;
                boolean isOnTree=false;
                c=' ';
                if(i==0 || i == dim_X-1){
                    c='_';
                }else if(j==0 || j==dim_Y-1){
                        c='|';
                }
                for(position tPos : treeGroves){
                    if(tPos.isInPosition(i,j)){
                        c= 'T';
                        isOnTree = true;
                    }
                }
                for(position wPos : pondHazards){
                    if(wPos.isInPosition(i,j)){
                        c= ',';
                        isOnWater = true;
                    }
                }

                if(teePos.isInPosition(i,j)){
                    c= '=';
                    isOnTee=true;
                }if(basketPos.isInPosition(i,j)){
                    c='&';
                    isOnBasket=true;
                }if(discs[0].GetPos().isInPosition(i,j)){
                    c='@';
                    isOnDisc=true;
                }

                if(isOnDisc&&isOnWater){c='*';msg="YOU IN THE DRINK M8";}
                if(isOnDisc&&isOnTree){c='*';msg="Were you aiming for that??";}

                if(isOnDisc&&isOnTee){c='#';} if (isOnDisc && isOnBasket) {c='$';}
                display[i][j]=c;
                System.out.print(c);
            }
            System.out.print("\n");
        }
        System.out.println(msg);
    }

    public void TraceThrow(int fromX, int fromY, int toX, int toY){

       while(fromX!=toX || fromY!=toY){
           if(fromX<toX){
               fromX++;
           }else if(fromX!=toX)
               fromX--;

           if(fromY<toY){
               fromY++;
           }else if(fromY!=toY)
               fromY--;
       display[fromX][fromY]=',';
       }
    }

}
