package pkg;

import java.util.ArrayList;

public class Player {

    private String name;
    ArrayList<disc> playerDiscs;
    landscape currentHole;
    int numStrokes = 0;
    position currentPosition;
    disc currentDisc;
    position lastPosition;

    public Player(String _name){
        name = _name;
        playerDiscs = new ArrayList<>();
        currentPosition = new position(0,0);
        lastPosition = currentPosition;
        currentHole = new landscape(0,0,false,false);
    }

    public Player(String _name,ArrayList<disc> discs){
        name = _name;
        playerDiscs = discs;
        currentDisc = playerDiscs.get(0);
        currentPosition = new position(0,0);
        lastPosition = currentPosition;
        currentHole = new landscape(0,0,false,false);
    }

    public void ThrowDisc(disc d){ numStrokes++;
    currentDisc = d;
    var basket = currentHole.basketPos;
        d.ThrowDisc(basket.GetX(),basket.GetY());

        var newPos = d.GetPos();

        if(currentHole.isPositionValid(newPos)==false){
            System.out.println("out of bounds, +1 stroke");
            numStrokes++;

            var oobX = newPos.GetX();
            var oobY = newPos.GetY();
            if(oobX>=currentHole.GetX()-1){ oobX = currentHole.GetX()-2; }
            if(oobY>=currentHole.GetY()-1){ oobY = currentHole.GetY()-2; }
            if(oobX<1){ oobX=1; }
            if(oobY<1){ oobY=1; }
            newPos.x = oobX;
            newPos.y = oobY;

        }
        d.SetPos(newPos);

        SetPos(newPos);
    }
    public String GetName(){
        return name;
    }
    public void SetName(String _name){
        name = _name;
    }
    public void AddDisc(disc d){
        playerDiscs.add(d);
    }
    public void RemoveDisc(disc d){
        playerDiscs.stream().filter(x->x.GetName()==d.GetName());
    }
    public void SetLandscape(landscape cur){
        currentHole = cur;
    }

    public position GetPos(){
        return currentPosition;
    }
    public position GetLastPos(){
        return lastPosition;
    }
    public void SetPos(position p){
        lastPosition = currentPosition;
        currentPosition = p;
    }
}
