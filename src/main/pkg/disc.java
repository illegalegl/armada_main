package pkg;

public abstract class disc {

    protected position pos;
    protected position lastPos;

    protected int numThrows = 0;
    private boolean inBasket =false;

    private String playerName;
    flightNumbers flightNums;

    public int GetScore(){
        return numThrows;
    }
    public void ResetScore(){
        numThrows = 0;
    }
    public boolean isInBasket(){
        return inBasket;
    }
    public void HitThePutt(){
        inBasket=true;
    }
    public void SetName(String name){
        playerName = name;
    }
    public String GetName(){
        return playerName;
    }
    public position GetPos(){
        return pos;
    }
    public position GetLastPos(){
        return lastPos;
    }

    public void SetPos(position p){
        lastPos = pos; pos = p;
    }

    public abstract void ThrowDisc(int x, int y);


}
