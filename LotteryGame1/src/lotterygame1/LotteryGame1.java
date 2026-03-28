/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotterygame1;
import java.util.Random;

/**
 *
 * @author administrator
 */
public class LotteryGame1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Lottery Game Example");
        int selectionCount = 18;
        int lotterySelection[] = new int[selectionCount];
        int selectionBound = 64;
        Random seed = new Random();
        Random rv1 = new Random(selectionBound);
        Random bonus = new Random(selectionBound);
        int take_3 = 1000;
        int take_4 = 10000;
        int take_5 = 100000;
                
        //rv1.setSeed(seed.nextInt(100000));
        for(int i = 0; i < selectionCount; i++) {
            boolean found = true;
           while (found ) {
             int num = rv1.nextInt(selectionBound) + 1;
             found = false;
           
             for (int j = 0; j < 1; j++){
               if (lotterySelection[j]== num) {
                   found = true;
                   break;
               }
             }
               if (!found) {
                 lotterySelection[i] = num;
               }
             }
               
             System.out.print(lotterySelection[i] + " ");
            }
             System.out.println();
 
        
        int take3[] = new int[3];
        int take4[] = new int[4];
        int take5[] = new int[5];
        
        
        
      
        
        for(int i = 0; i < 3; i++) {
           boolean found = true;
           while (found ) {
             int num = rv1.nextInt(selectionBound) + 1;
             found = false;
           
             for (int j = 0; j < 1; j++){
               if (lotterySelection[j]== num) {
                   found = true;
                   break;
               }
             }
               if (!found) {
                 lotterySelection[i] = num;
               }
             }
               
             System.out.print(lotterySelection[i] + " ");
            }
        System.out.println();
        
    
        rv1.setSeed(seed.nextInt(100000));
        for(int i = 0; i < 4; i++) {
            boolean found = true;
           while (found ) {
             int num = rv1.nextInt(selectionBound) + 1;
             found = false;
           
             for (int j = 0; j < 1; j++){
               if (lotterySelection[j]== num) {
                   found = true;
                   break;
               }
             }
               if (!found) {
                 lotterySelection[i] = num;
               }
             }
               
             System.out.print(lotterySelection[i] + " ");
            }
        
        System.out.println();
        
        
        for(int i = 0; i < 5; i++) {
           boolean found = true;
           while (found ) {
             int num = rv1.nextInt(selectionBound) + 1;
             found = false;
           
             for (int j = 0; j < 1; j++){
               if (lotterySelection[j]== num) {
                   found = true;
                   break;
               }
             }
               if (!found) {
                 lotterySelection[i] = num;
               }
             }
               
             System.out.print(lotterySelection[i] + " ");
            }
        System.out.println();
        
        int matches = 0;
        for(int i = 0; i < take_3.length; i++) {
            for (int j = 0; j < lotterySelection.length; j++) {
                if (take_3[i] == lotterySelection[j]) {
               matches++;
               break;
           }
          }
        } if(matches == 3) {
            prize = take_3;
            if (bonus =  ) {
               prize *= 10;
            }  
            System.out.println("Congrats you matched " + matches + " and you won " + take_3);
            
        } else 
         System.out.println("Sorry you lost");
      }
    
        
       
             
    }
    

