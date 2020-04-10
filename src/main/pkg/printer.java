package pkg;

import java.util.ArrayList;
import java.util.function.BiPredicate;

public class printer {
    public static final String RESET = "\033[0m";  // Text Reset

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[0;32m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[7;49;39m"; // WHITE

    public String addPlayerDiscs(int i, int j, ArrayList<Player> players){
        String[] playerColors = new String[]{RED_BOLD_BRIGHT,BLUE_BOLD_BRIGHT,GREEN_BOLD_BRIGHT,PURPLE_BOLD_BRIGHT};
        int k=0;
        for(Player pl : players){
            if(pl.currentDisc!=null && pl.GetPos().GetX()!=0 && pl.GetPos().GetY()!=0) {
                if (pl.GetPos().isInPosition(i, j)) {
                    return playerColors[k];
                }
            }
                k++;

        }
        return "";
    }

    public void AreDiscsOverlapping(char[][] display,ArrayList<Player> players){

        ArrayList<disc> discs = new ArrayList<disc>();
        players.forEach(x->discs.add(x.currentDisc));

        BiPredicate<disc,disc> predicate = (item1, item2) -> item1.pos.GetX()==item2.pos.GetX()
                && item1.pos.GetY()==item2.pos.GetY();

        boolean overlapping = false;

        for(int i=0;i<discs.size();i++){
            for(int j=0;j<discs.size();j++){
                if(i!=j && predicate.test(discs.get(i),discs.get(j))==true){
                    display[discs.get(i).GetPos().GetX()][discs.get(i).GetPos().GetY()] = '%';
                    overlapping = true;
                }
                if(overlapping){break;}
            }
            if(overlapping){break;}
        }

    }

    public void printMap(char[][] display, position basketPos, ArrayList<Player> players){
        int dim_X = display.length;
        int dim_Y = display[0].length;
        String color = "";
        AreDiscsOverlapping(display,players);
        for(int i=0; i< dim_X; i++){
            for(int j=0; j<dim_Y;j++){
                color = "";

                if(basketPos.isInPosition(i,j) && display[i][j]=='@'){
                    display[i][j]='$';
                }

                color = addPlayerDiscs(i,j,players);

                switch(display[i][j]){
                    case('|'):
                    case('_'):
                        color = BLACK_BOLD_BRIGHT;
                        break;
                    case('#'):
                        color = PURPLE_BOLD_BRIGHT;
                        break;
                    case('='):
                        color = BLUE_BOLD_BRIGHT;
                        break;
                    case('&'):
                    case('$'):
                        color = YELLOW_BOLD_BRIGHT;
                        break;
                    case('*'):
                        color = RED_BOLD_BRIGHT;
                        break;
                    case('T'):
                        color = GREEN_BOLD_BRIGHT;
                        break;
                    case(','):
                        color = CYAN_BOLD_BRIGHT;
                        break;
                    case('%'):
                        color= WHITE_BOLD_BRIGHT;
                        break;
                }

                System.out.print( color + display[i][j] + RESET);

            }
            System.out.println();
        }
    }

    public void setStaticItems(char[][] display, ArrayList<position> treeGroves,ArrayList<position> pondHazards, ArrayList<Player> players, position basketPos, position teePos){

        int dim_X = display.length;
        int dim_Y = display[0].length;

    char c = ' ';
    for (int i = 0; i < dim_X; i++) {
        c = ' ';
        for (int j = 0; j < dim_Y; j++) {

            boolean isOnTee = false;
            boolean isOnBasket = false;
            boolean isOnDisc = false;
            boolean isOnWater = false;
            boolean isOnTree = false;
            c = ' ';
            if (i == 0 || i == dim_X - 1) {
                c = '_';
            } else if (j == 0 || j == dim_Y - 1) {
                c = '|';
            }
            for (position tPos : treeGroves) {
                if (tPos.isInPosition(i, j)) {
                    c = 'T';
                    isOnTree = true;
                }
            }
            for (position wPos : pondHazards) {
                if (wPos.isInPosition(i, j)) {
                    //display=expandWater(i,j);
                    c = ',';
                    isOnWater = true;
                }
            }

            if (teePos.isInPosition(i, j)) {
                c = '=';
                isOnTee = true;
            }
            if (basketPos.isInPosition(i, j)) {
                c = '&';
                isOnBasket = true;
            }
            for(Player pl: players) {
                if (pl.GetPos().isInPosition(i, j)) {
                    c = '@';
                    isOnDisc = true;
                }
            }

            if (isOnDisc && (isOnWater || isOnTree)) {
                c = '*';
            }

            if (isOnDisc && isOnTee) {
                c = '#';
            }
            if (isOnDisc && isOnBasket) {
                c = '$';
            }
            if(display[i][j]==','){c=display[i][j];}
            display[i][j] = c;
        }
    }
}

    public void TraceThrow(position fromPos, position toPos, char[][] display) {

        int fromX, toX, fromY, toY;
        fromX = fromPos.GetX();
        fromY = fromPos.GetY();

        toX=toPos.GetX();
        toY=toPos.GetY();

        while (Math.abs(fromX - toX) + Math.abs(fromY - toY) > 2) {

            if (fromY < toY) {
                fromY++;
            } else if (fromY != toY)
                fromY--;
             if(Math.abs(fromY - toY) <2 ) {
                if (fromX < toX) {
                    fromX++;
                } else if (fromX != toX)
                    fromX--;
            }

             if(display[fromX][fromY]=='T' || display[fromX][fromY] == ','){
                 display[fromX][fromY] = '*';
             }else
            display[fromX][fromY] = '.';
        }
    }
}
