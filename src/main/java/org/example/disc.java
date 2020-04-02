package org.example;

public abstract class disc {

    protected position pos;

    flightNumbers flightNums;

    public position GetPos(){
        return pos;
    }
    public void SetPos(position p){
        pos = p;
    }

    public abstract void ThrowDisc(int x, int y);


}
