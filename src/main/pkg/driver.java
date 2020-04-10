package pkg;
import java.util.Random;

public class driver extends disc{

    Random r = new Random();
    public driver(int x, int y, String name){
        this.SetName(name);
        pos = new position(0,0);
        this.SetPos(new position(x,y));


        flightNums = new flightNumbers(10,6,3,1,2);
    }

    public driver(int x, int y, String name, int spd, int str, int trn, int gld, int fde){
        this.SetName(name);
        pos = new position(0,0);
        this.SetPos(new position(x,y));


        flightNums = new flightNumbers(spd,str,trn,gld,fde);
    }

    public double CalculatePuttDistance(int targetX, int targetY){
        position p = this.GetPos();
        return Math.sqrt(Math.pow(((double)p.GetXDist(targetX)*1.0) ,2.0) + Math.pow(p.GetYDist(targetY)*1.0,2));
    }

    public position CalculateDriverThrow(position fromPos, int targetX, int targetY){

        int distX = r.nextInt(flightNums.getSpd()/3)+flightNums.getGld()*2 - flightNums.getTrn()/2;
        int distY = r.nextInt(flightNums.getSpd())+flightNums.getGld()*3 + flightNums.getFde()*2 - flightNums.getTrn();

        position lay = new position(fromPos.GetX() + distX, fromPos.GetY() + distY);

        return lay;

    }

    public position CalculateAutoDriverThrow(position fromPos, int targetX, int targetY){
            int distX = r.nextInt(flightNums.getSpd()/3)+flightNums.getGld()*2 - flightNums.getTrn()/2;
            int distY = r.nextInt(flightNums.getSpd())+flightNums.getGld()*3 + flightNums.getFde()*2 - flightNums.getTrn();
            if(fromPos.GetXDist(targetX)<0){distX *= -1;}
            if(fromPos.GetYDist(targetY)<0){distY *= -1;}

        position lay = new position(fromPos.GetX() + distX, fromPos.GetY() + distY);

        return lay;
    }
    @Override
    public void ThrowDisc(int targetX, int targetY) {
        numThrows++;
        double dist= CalculatePuttDistance(targetX, targetY);
        if(dist<=4.0){
            position newPos = new position(targetX,targetY);

            System.out.println("Nice layup, easy putt from " + Math.round(this.GetPos().GetRealDist(newPos)) + " yards!");
            this.HitThePutt();
            this.SetPos(new position(targetX,targetY));
            return;
        }

        position lay = CalculateAutoDriverThrow(this.GetPos(),targetX,targetY);

        if(lay.isInPosition(targetX,targetY)){
            System.out.println("Nice Putt! You hit chains from "+ this.GetPos().GetRealDist(lay) + " ft away!");
            this.HitThePutt();
        }
        this.SetPos(lay);
    }

}
