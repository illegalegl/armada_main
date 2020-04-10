package pkg;

import java.util.ArrayList;

public class App
{


    public static void main( String[] args ) throws InterruptedException {
        int sizeX = 12;
        int sizeY=120;

        landscape l = new landscape(sizeX,sizeY,true,true);
        printer printr = new printer();

        l.setTeeAndBasket();

        l.addTrees(25,true);
        l.addHazWat(5,false);

        ArrayList<disc> drvs = new ArrayList<disc>(); drvs.add(new driver(l.teePos.GetX(),l.teePos.GetY(), "disc1",5,2,1,1,1));
        ArrayList<disc> drvs2 = new ArrayList<disc>(); drvs2.add(new driver(l.teePos.GetX(),l.teePos.GetY(), "disc2",10,2,2,2,1));
        Player p1 = new Player("Player1",drvs);
        Player p2 = new Player("Player2",drvs2);

        ArrayList<Player> players = new ArrayList<>();

        players.add(p1);
        players.add(p2);

        players.forEach(x->{x.SetLandscape(l); x.SetPos(x.playerDiscs.get(0).GetPos());});
        l.addPlayer(p1);
        l.addPlayer(p2);
//        driver drv2 = new driver(l.teePos.GetX(),l.teePos.GetY()+1, "player2");
//
//        driver drv3 = new driver(l.teePos.GetX(),l.teePos.GetY()+2, "player3");
//
//        driver drv4 = new driver(l.teePos.GetX(),l.teePos.GetY()+3, "player4");

        int basketX = l.basketPos.GetX();
        int basketY = l.basketPos.GetY();


//        l.addDisc(drv);
//        l.addDisc(drv2);
//        l.addDisc(drv3);
//        l.addDisc(drv4);
        l.players.forEach(x->System.out.println(x.GetName()));
        l.players.forEach(x->x.ThrowDisc(x.currentDisc));

        printr.setStaticItems(l.display,l.treeGroves,l.pondHazards,l.players,l.basketPos,l.teePos);

        printr.printMap(l.display, l.basketPos, l.players);

        l.players.forEach(pp->{pp.ThrowDisc(pp.currentDisc); l.modifyPlayerLocation(pp);});
        printr.printMap(l.display, l.basketPos, l.players);

        l.players.forEach(pp->{pp.ThrowDisc(pp.currentDisc); l.modifyPlayerLocation(pp);});
        printr.printMap(l.display, l.basketPos, l.players);

        l.players.forEach(pp->{pp.ThrowDisc(pp.currentDisc); l.modifyPlayerLocation(pp);});
        printr.printMap(l.display, l.basketPos, l.players);

        l.players.forEach(pp->{pp.ThrowDisc(pp.currentDisc); l.modifyPlayerLocation(pp);});
        printr.printMap(l.display, l.basketPos, l.players);

//        l.players.forEach(pp->{pp.ThrowDisc(pp.currentDisc); l.modifyPlayerLocation(pp);});
//        printr.printMap(l.display, l.basketPos, l.players);



        //p.printMap(l.display, l.basketPos, l.discs);

        //drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
        //l.addDisc(drv);
        //p.TraceThrow(l.discs[0].lastPos,l.discs[0].GetPos(),l.display);
       // p.printMap(l.display, l.basketPos, l.discs);
//
//        drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
//        l.addDisc(drv);
//       // p.TraceThrow(l.discs[0].lastPos,l.discs[0].GetPos(),l.display);
//        p.printMap(l.display, l.basketPos, l.discs);
//
//        drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
//        l.addDisc(drv);
//       // p.TraceThrow(l.discs[0].lastPos,l.discs[0].GetPos(),l.display);
//        p.printMap(l.display, l.basketPos, l.discs);
//
//        drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
//        l.addDisc(drv);
//       // p.TraceThrow(l.discs[0].lastPos,l.discs[0].GetPos(),l.display);
//        p.printMap(l.display, l.basketPos, l.discs);


//        while(l.isPositionValid(l.discs[0].pos)&& l.discs[0].pos.isInPosition(l.basketPos.GetX(),l.basketPos.GetY())==false) {
//            l.printDisplay();
//
//            drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
//
//            if(l.isPositionValid(drv.GetPos())==false){
//                System.out.println("You are OB. +1 Stroke");
//                while(l.isPositionValid(drv.GetPos())==false){
//                    drv.ThrowDisc(l.basketPos.GetX(),l.basketPos.GetY());
//                }
//            }
//
//            l.addDisc(drv);
//            Thread.sleep(640);
//          //  l.TraceThrow(curDiscX,curDiscY,newDiscX,newDiscY);
//        }
        //p.printDisplay();
    }


}
