package pkg;

public class App
{


    public static void main( String[] args ) throws InterruptedException {
        int sizeX = 12;
        int sizeY=120;

        landscape l = new landscape(sizeX,sizeY,true,true);
        printer p = new printer();

        l.setTeeAndBasket();

        l.addTrees(25,true);
        l.addHazWat(5,false);

        driver drv = new driver(l.teePos.GetX(),l.teePos.GetY(), "player1");

        driver drv2 = new driver(l.teePos.GetX(),l.teePos.GetY()+1, "player2");

        driver drv3 = new driver(l.teePos.GetX(),l.teePos.GetY()+2, "player3");

        driver drv4 = new driver(l.teePos.GetX(),l.teePos.GetY()+3, "player4");

        int basketX = l.basketPos.GetX();
        int basketY = l.basketPos.GetY();


        l.addDisc(drv);
        l.addDisc(drv2);
        l.addDisc(drv3);
        l.addDisc(drv4);
        l.discs.forEach(x->System.out.println(x.GetName()));
        l.discs.forEach(x->x.ThrowDisc(basketX,basketY));

        p.setStaticItems(l.display,l.treeGroves,l.pondHazards,l.discs,l.basketPos,l.teePos);

        p.printMap(l.display, l.basketPos, l.discs);

        l.discs.forEach(x->x.ThrowDisc(basketX,basketY));
        l.discs.forEach(dd->l.modifyDisc(dd));
        p.printMap(l.display, l.basketPos, l.discs);

        l.discs.forEach(x->x.ThrowDisc(basketX,basketY));
        l.discs.forEach(dd->l.modifyDisc(dd));
        p.printMap(l.display, l.basketPos, l.discs);


        l.discs.forEach(x->x.ThrowDisc(basketX,basketY));
        l.discs.forEach(dd->l.modifyDisc(dd));
        p.printMap(l.display, l.basketPos, l.discs);

        l.discs.forEach(x->x.ThrowDisc(basketX,basketY));
        l.discs.forEach(dd->l.modifyDisc(dd));
        p.printMap(l.display, l.basketPos, l.discs);

        l.discs.forEach(x->x.ThrowDisc(basketX,basketY));
        l.discs.forEach(dd->l.modifyDisc(dd));
        p.printMap(l.display, l.basketPos, l.discs);

        l.discs.forEach(x->x.ThrowDisc(basketX,basketY));
        l.discs.forEach(dd->l.modifyDisc(dd));
        p.printMap(l.display, l.basketPos, l.discs);
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
