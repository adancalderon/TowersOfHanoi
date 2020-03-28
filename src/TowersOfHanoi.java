/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t00555274
 */
import java.util.*;
public class TowersOfHanoi {
    public static Scanner scan = new Scanner(System.in);
    public static Stack<Integer> peg1 = new Stack<>();
    public static Stack<Integer> peg2 = new Stack<>();
    public static Stack<Integer> peg3 = new Stack<>();
    public static int ans =1;
    public static int to;
    public static int from;
    public static int nums =0;

    public static void main(String[] args) {

         for (int i = 5; i>=1; i-- ){
             peg1.push(i);
             nums++;
         }

        System.out.println("=[==[==[=[=================================]=]==]==]=\n" +
                "=[==[==[=[   Welcome to Towers Of Hanoin   ]=]==]==]=\n" +
                "=[==[==[=[=================================]=]==]==]=");

                System.out.println("Peg 1");
                displayPeg(peg1);
                System.out.println("Peg 2");
                displayPeg(peg2);
                System.out.println("Peg 3");
                displayPeg(peg3);

      
      while (ans != 3) {
            System.out.println("Choose...\n" +
                    "<<" +
                    "1. Move a Top Disk \n" +
                    "2. Display Pegs\n" +
                    "3. EXIT GAME (Loser's Way out) " +
                    ">> ");
                ans = scan.nextInt();
        
            if (ans == 1) {

                Scanner reader = new Scanner(System.in);
                Scanner read = new Scanner(System.in);
                System.out.println("Enter the number of the PEG you want to MOVE FROM (Peg1 = 1, Peg2 = 2, Peg3 = 3)");
                from = reader.nextInt();

                System.out.println("Enter the number of the PEG you want to MOVE TO (Peg1 = 1, Peg2 = 2, Peg3 = 3)");
                to = read.nextInt();
                
                if(from ==1 && to ==1){
                    move(peg1,peg1);
                }
                else if(from == 1 && to == 2){
                
                    move(peg1,peg2);
                }
                else if(from ==2 && to ==1){
                    move(peg2,peg1);
                }
                else if(from == 2 && to == 2){
                    move(peg2,peg2);
                }
                else if(from ==1 && to ==3){
                 move(peg1,peg3);
                }
                else if(from == 3 && to == 1){
                 move(peg3,peg1);
                }
                else if(from ==3 && to ==3){
                 move(peg3,peg3);
                }
                else if(from == 2 && to == 3){
                 move(peg2,peg3);
                }
                else if (from ==3 && to ==2){
                    move(peg3,peg2);
                }

                System.out.println("Peg 1");
                displayPeg(peg1);
                System.out.println("Peg 2");
                displayPeg(peg2);
                System.out.println("Peg 3");
                displayPeg(peg3);
  
            }
            else if (ans ==2){
                System.out.println("Peg 1");
                displayPeg(peg1);
                System.out.println("Peg 2");
                displayPeg(peg2);
                System.out.println("Peg 3");
                displayPeg(peg3);
            }

            if(checkwin(peg2) || checkwin(peg3)){
                System.out.println("WINNER WELL DONE");
                ans = 3;
                break;
            }
        }

        System.out.println("Thanks for playing");
    }
    
    public static void move(Stack from, Stack to ){

         if(from.isEmpty()){
            System.out.println("There is NOTHING IN HERE TO MOVE ");
        }
         else if(!from.empty() && to.empty() ){
             to.push(from.pop());

         }

        else if (to.empty()){
            to.push(from.pop());
        }

        else if((Integer)from.peek() < (Integer)to.peek()){   // we know it has Integers inside of it
            to.push(from.pop());
            System.out.println("Disk moved (valid move)");
        }

        else if(from == to){
            System.out.println("You can't move from " +from +" to " +to +"is redundant");
        }

        else if((Integer)from.peek() > (Integer)to.peek()){
            System.out.println("Invalid move you cannot move from a BIGGER DISK TO A LOWER ONE");
        }

    }
    
//    public static void displayDisk(int disk){
//
//        for (int i = 0; i < disk; i++) {
//            System.out.print("  *  ");
//        }
//    }
    
    public static void displayPeg(Stack peg){
        int index =0;
        int size = peg.size();
        int element = size -1;
        for (int i = 0; i < size; i++) {

            for (int k=0; k <((5/2)-i/2); k++)
            {
                System.out.print(" ");
            }

            for (int j = 0; j < ((Integer)peg.get(element-index)); j++) {
            System.out.print("*");
            }
           index++;
            System.out.println();
        }
           System.out.println(peg.toString());
    }

    public static boolean checkwin(Stack peg){
        int size = peg.size();
        int index = size-1;
        int count = 1;
        for(int i = 1 ; i<size; i++){
            if ((Integer)peg.get(index) == i){
                count++;
            }
            index--;
        }
        return nums == count;
    }
    

}













































































