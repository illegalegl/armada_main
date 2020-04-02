package org.example;

public class position {

    int x=0;
    int y=0;

    public position(int _x, int _y){
        x = _x;
        y = _y;
    }
    public boolean isInPosition(int _x, int _y){
        return x==_x && y==_y;
    }
    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }
    public int GetXDist(int xx){
        return xx-x;
    }
    public int GetYDist(int yy){
        return yy-y;
    }
}
