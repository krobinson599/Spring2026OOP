/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;
import java.util.Random;

public class midterm {

    public static void main(String[] args) {

        System.out.println("Lottery Game Example");
     
        int selectionCount = 18; //Total number of winning picks to generate
        int selectionBound = 64; //numbers are between 1 and 64
        Random rv1 = new Random();
        int lotterySelection[] = new int[selectionCount];

        int take_3 = 1000;
        int take_4 = 10000;
        int take_5 = 100000;
       //Generating 18 unique numbers between 1 and 64
        System.out.println("Winning Picks");
        for(int i = 0; i < selectionCount; i++) {
            boolean found = true;
           //Generate until we find a number not already in the array
            while(found) {
                int num = rv1.nextInt(selectionBound) + 1;
                found = false;
                 //checking stored numbers for duplicates
                for(int j = 0; j < i; j++) {
                    if (lotterySelection[j] == num) {
                        found = true;
                        break;
                    }
                }
                if(!found) { //store number if duplicate isn't found
                    lotterySelection[i] = num;
                }
            }

            System.out.print(lotterySelection[i] + " ");
        }

        System.out.println("\n");

       //Declaring array to store each ticket number and one bonus
        int take3tickArr[] = new int[4];
        int take4tickArr[] = new int[5];
        int take5tickArr[] = new int[6];
       
       //Generating and printing each ticket
        System.out.println("Take 3:");
        generateTicket(take3tickArr, 3, lotterySelection, rv1);
        printArray(take3tickArr);

        System.out.println("Take 4:");
        generateTicket(take4tickArr, 4, lotterySelection, rv1);
        printArray(take4tickArr);

        System.out.println("Take 5:");
        generateTicket(take5tickArr, 5, lotterySelection, rv1);
        printArray(take5tickArr);

        checkWin(take3tickArr, 3, lotterySelection, take_3, "Take 3");
        checkWin(take4tickArr, 4, lotterySelection, take_4, "Take 4");
        checkWin(take5tickArr, 5, lotterySelection, take_5, "Take 5");
    }

    public static void generateTicket(int[] ticket, int mainCount, int[] lottery, Random rv1) {
        //Generate each main number one at a time
        for(int i = 0; i < mainCount; i++) {
            boolean found = true;

            while(found) { // looping until we get a number not already in the ticket
                int num = rv1.nextInt(64) + 1;
                found = false;

                for(int j = 0; j < i; j++) {
                    if (ticket[j] == num) {   
                        found = true;
                        break;
                    }
                }

                if(!found) {
                    ticket[i] = num;   // number is unique so store in ticket
                }
            }
        }
     //Bonus must come from the winnng pool and not match any main ticket number
        boolean validBonus = false;

        while(!validBonus) {
            int bonus = lottery[rv1.nextInt(lottery.length)];
            validBonus = true;

            for (int i = 0; i < mainCount; i++) {
                if (ticket[i] == bonus) {
                    validBonus = false;
                    break;
                }
            }

            if (validBonus) {
                ticket[mainCount] = bonus;
            }
        }
    }
     //print all numbers in array to the console and treating the last number as the bonus
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                System.out.print("|Bonus: " + arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println("\n");
    }

    public static void checkWin(int[] ticket, int mainCount, int[] lottery, int basePrize, String label) {

        int matches = 0;

        for (int i = 0; i < mainCount; i++) {
            for (int j = 0; j < lottery.length; j++) {
                if(ticket[i] == lottery[j]) {
                    matches++;
                    break;
                }
            }
        }

        int prize = 0;

        if (matches == mainCount) {
            prize = basePrize;
            int bonus = ticket[mainCount];
            boolean hasBonus = false;
          //Checking if bonus number is in the winning pool
            for (int i = 0; i < lottery.length; i++) {
                if(lottery[i] == bonus) {
                    hasBonus = true;
                    break;
                }
            }

            if (hasBonus) {
                prize *= 10; // bonus matched so multiply prize by 10
            }

            System.out.println(label + ": WIN! Matched " + matches + " Prize: $" + prize);
        } else {
            System.out.println(label + ": LOST (Matched " + matches + ")"); //Not all matched no prize
        }
    }
}