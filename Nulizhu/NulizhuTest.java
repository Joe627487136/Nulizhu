package Nulizhu;

/**
 * Created by zhouxuexuan on 10/7/17.
 */

public class NulizhuTest {
    //Loop to check ratio
    public static void main(String[] args) {
        int numofdie = 0;
        for (int i = 0; i < 99; i++){
            Nulizhusource[] mylist = new Nulizhusource[8];
            NulizhuOperator operator = new NulizhuOperator();
            operator.initialize_board(mylist);
            operator.hitroute(mylist);
            if(operator.end.equals("Hero die!")){
                numofdie+=1;
            }
            //operator.print_board(mylist);
        }
        System.out.println(numofdie+"%");
    }
}
