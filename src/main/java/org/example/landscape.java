package org.example;

public class landscape {
     int dim_X = 0;
     int dim_Y = 0;
     boolean hasTrees=false;
     int numTrees = 0;
     boolean hasWater=false;
     int numWaters=0;
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
    }

    public boolean isPositionValid(position pos){

        return pos.GetX() >0 && pos.GetX() < dim_X-1 && pos.GetY() > 0 && pos.GetY() < dim_Y-1;
    }


    public void setArtifactPosition(int x, int y, String artifact)  {
        position pos = new position(x,y);
        switch(artifact){
            case("tee"):
                teePos=pos;
                break;
            case("basket"):
                basketPos=pos;
                break;
        }

        if(isPositionValid(pos)==false){

            switch(artifact){
                case("tee"):
                    System.out.println("ERR: Cannot place Tee outside bounds");
                    teePos=new position(0,0);
                    break;
                case("basket"):
                    System.out.println("ERR: Cannot place Basket outside bounds");
                    basketPos=new position(0,0);
                    break;
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


        char c = ' ';
        for(int i=0; i<dim_X;i++){
            c=' ';
            for(int j=0;j<dim_Y;j++){
                boolean isOnTee=false;
                boolean isOnBasket=false;
                boolean isOnDisc=false;
                c=' ';
                if(i==0 || i == dim_X-1){
                    c='_';
                }else if(j==0 || j==dim_Y-1){
                        c='|';
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
                if(isOnDisc&&isOnTee){c='#';} if (isOnDisc && isOnBasket) {c='$';}
                display[i][j]=c;
                System.out.print(c);
            }
            System.out.print("\n");
        }
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
