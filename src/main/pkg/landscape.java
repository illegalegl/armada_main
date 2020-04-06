package pkg;

import java.util.ArrayList;
import java.util.Random;

public class landscape {

    private int dim_X = 0;
    private int dim_Y = 0;
    private boolean hasTrees = false;
    private int numTrees = 0;
    ArrayList<position> treeGroves;
    private boolean hasWater = false;
    private int numWaters = 0;
    ArrayList<position> pondHazards;
    char[][] display;
    ArrayList<disc> discs;

    public position basketPos = new position(dim_X, dim_Y);
    public position teePos = new position(dim_X, dim_Y);

    public landscape(int size_X, int size_Y, boolean containsTrees, boolean containsWater) {
        SetX(size_X);
        SetY(size_Y);
        hasTrees = containsTrees;
        hasWater = containsWater;
        discs = new ArrayList<disc>();
        display = new char[GetX()][GetY()];
        treeGroves = new ArrayList<>();
        pondHazards = new ArrayList<>();
    }


    public void setTeeAndBasket() {
        Random rand = new Random();

        int xPos = rand.nextInt(dim_X / 2) + 1;
        int yPos = rand.nextInt(dim_Y / 4) + 1;

        setTeePos(xPos, yPos);

        xPos = rand.nextInt(dim_X / 2) - 1 + dim_X / 2;
        yPos = rand.nextInt(dim_Y / 2) - 1 + dim_Y / 2;

        setBasketPos(xPos, yPos);
    }

    private void setTeePos(int x, int y) {
        teePos = setArtifactPosition(x, y);
    }

    private void setBasketPos(int x, int y) {
        basketPos = setArtifactPosition(x, y);
    }


    private position setArtifactPosition(int x, int y) {
        position pos = new position(x, y);

        if (isPositionValid(pos) == false) {
            System.out.println("ERR: Cannot place marker outside bounds");
            pos = new position(0, 0);
        }
        return pos;
    }

    public boolean isPositionValid(position pos) {
        return pos.GetX() > 0 && pos.GetX() < this.GetX() - 1 && pos.GetY() > 0 && pos.GetY() < this.GetY() - 1;
    }

    public void addTrees(int trees, boolean exact) {
        Random rand = new Random();
        if (hasTrees) {

            numTrees = (exact) ? trees :  rand.nextInt(trees);

            for (int i = 0; i < numTrees; i++) {
                int xx = rand.nextInt(this.GetX() - 2) + 1;

                int yy = rand.nextInt(this.GetY() - 2) + 1;

                //   System.out.println("Tree at: " + xx + "_" + yy);

                position newTree = setArtifactPosition(xx, yy);

                if(newTree.GetX()!=0 && newTree.GetY()!=0){
                    treeGroves.add(newTree);
                }

            }
        }
    }

    public void addHazWat(int ponds, boolean exact) {
        Random rand = new Random();
        if (hasWater) {

            numWaters = (exact) ? ponds : rand.nextInt(ponds);
            int x = this.GetX();
            int y = this.GetY();

            for (int i = 0; i < numWaters; i++) {
                int xx = rand.nextInt(x - (x/4)) + (x/4);

                int yy = rand.nextInt(y - (y/4)) + (y/4)+1;

                System.out.println("Water at: " + xx + "_" + yy);
//
                int size = 12;
                int length = rand.nextInt(size)+2;

                position newPond = setArtifactPosition(xx, yy-length/2);

                if(newPond.GetX()!=0 && newPond.GetY()!=0){

                        pondHazards.add(newPond);
                }

            }
        }
    }

    public void addDisc(disc d){
            discs.add(d);
    }

    public void modifyDisc(disc d) {

        int x = d.GetPos().GetX();
        int y = d.GetPos().GetY();
        if(x>0 && x< this.GetX()-1 && y>0 && y< this.GetY()-1) {

            if(discs.stream().anyMatch(dd -> dd.GetName() == d.GetName())){
                display[x][y] = '@';
            }

        }else{
            System.out.println("Your disc landed out of bounds " + d.GetName() + ", please rethrow!");
        }
        x = d.GetLastPos().GetX();
        y = d.GetLastPos().GetY();
        if (display[x][y] == '#')
            display[x][y] = '=';
        else
            display[x][y] = ' ';
    }

    public int GetX() {
        return dim_X;
    }

    public void SetX(int x) {
        dim_X = x;
    }

    public int GetY() {
        return dim_Y;
    }

    public void SetY(int y) {
        dim_Y = y;
    }






    private char[][] expandWater(int x, int y){
        int size = 5 - new Random().nextInt(3);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i<j || j<i && (i+j<2*size-2) && (Math.abs(i-j)< size-1) || (i>0 && i<size-1 && j>0 && j<size-1) ){
                    display[i-1+x][j-1+y]=',';
                }
            }
        }
        return display;
    }

}
