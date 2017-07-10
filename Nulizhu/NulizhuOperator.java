package Nulizhu;

import java.util.Random;

public class NulizhuOperator {
    int minionnum = 0;
    String end = "Hero live";

    public void hitroute(Nulizhusource[] mylist){
        //Recurse 15 hits
        for (int i=0;i<15;i++){

            //Random Generate Hit Index from 0 to 7
            int hitindex = randInt(0,7);

            //If hit an empty slot then skip
            if (mylist[hitindex].type.equals("Empty")){
                i--;
            }
            if (mylist[hitindex].type.equals("Dead_Minion")){
                i--;
            }

            //If hit an Hero then heath --1 and check if hero die
            if (mylist[hitindex].type.equals("Hero")){
                mylist[hitindex].gethit();
                if(checkdie(mylist[hitindex])){
                    end = "Hero die!";
                    break;
                }
            }

            //If hit an Minion then heath --1 and check if board full then add one more
            if(mylist[hitindex].type.equals("Minion")){
                mylist[hitindex].gethit();
                boolean checkloopover = false;
                while (!checkloopover) {
                    int fillindex = randInt(0, 7);
                    if (mylist[fillindex].type.equals("Empty")&& minionnum<7) {
                        //System.out.println("Nuli add!");
                        mylist[fillindex] = new Nulizhusource("Minion");
                        minionnum += 1;
                        checkloopover = true;
                    }
                    if (minionnum == 7){
                        break;
                    }
                }
                if(checkdie(mylist[hitindex])){
                    //Patron die but remain at board so minionnum remains
                    mylist[hitindex].type = "Dead_Minion";
                }
            }
        }
    }

    //Initialize starting board
    public void initialize_board(Nulizhusource[] mylist){
        minionnum = 1;
        mylist[0]=new Nulizhusource("Hero");

        //Set hero health
        mylist[0].health=7;
        //****

        mylist[1]=new Nulizhusource("Minion");
        for(int i=2;i<mylist.length;i++){
            mylist[i] = new Nulizhusource("Empty");
        }
    }

    //Check if dead
    public boolean checkdie(Nulizhusource e){
        return (e.health<=0);
    }

    //Random num generator
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    //Print final board
    public void print_board(Nulizhusource[] mylist){
        for (int i=0;i<8;i++){
            System.out.println(mylist[i].type);
        }
    }



}
