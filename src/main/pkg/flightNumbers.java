package pkg;

public class flightNumbers {

    private int spd;
    private int str;
    private int trn;
    private int gld;
    private int fde;

    public flightNumbers(int _spd, int _str, int _trn, int _gld, int _fde){
        spd=_spd;
        str=_str;
        trn=_trn;
        gld=_gld;
        fde=_fde;
    }

    public int getSpd(){
        return spd;
    }
    public int getStr(){
        return str;
    }
    public int getTrn(){
        return trn;
    }
    public int getGld(){
        return gld;
    }
    public int getFde(){
        return fde;
    }

    public void printNums(){
        System.out.println("Speed: "+spd + " Strength: "+ str + " Turn: " + trn + " Glide: " + gld + " Fade: " + fde);
    }
}
