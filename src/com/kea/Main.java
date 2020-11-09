package com.kea;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //
        Wash wash = new Wash();
        ArrayList<Integer> array = new ArrayList<>();
        WashCard washCard = new WashCard();
        ArrayList<WashCard> statList = new ArrayList<>();
        washprogram:
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to SuperShine Carwash!");
            System.out.println("");
            System.out.println("Press 1: Select wash program");
            System.out.println("Press 2: Check wash-card balance");
            System.out.println("Press 3: Refill wash-card balance");
            System.out.println("Press 4: See statistics");
            System.out.print(": ");
            int scan = input.nextInt();
            switch (scan)
            {
                case 1:
                    wash.chooseWash(input,washCard,array);
                    break;
                case 2:

                    System.out.println("Your balance is: " + washCard.getBalance());
                    System.out.println("");
                    break;
                case 3:
                    //washCard = new WashCard();
                    System.out.println("Choose the amount you want to add to your wash-card: ");
                    System.out.println("Press 1: 200 kr.");
                    System.out.println("Press 2: 500 kr.");
                    System.out.println("Press 3: 1000 kr.");
                    System.out.println("Press 4: Back");
                    scan = input.nextInt();
                    if(scan==1){
                        washCard.addToBalance(200);
                    }
                    else if(scan==2){
                        washCard.addToBalance(500);
                    }
                    else if(scan==3){
                        washCard.addToBalance(1000);
                    }
                    else if (scan==4){
                        break;
                    }
                    else{
                        System.out.println("Wrong input, please try again");
                        System.out.println("");
                        continue;
                    }
                    System.out.println("Your balance is: " + washCard.getBalance());
                    System.out.println("");
                    break;
                case 4:
                    //Admin password for the owner is 123
                    System.out.println("Enter Admin password: ");
                    scan = input.nextInt();
                    if (scan==123) {
                        wash.printStatistics(array);
                        break;
                    }
                    else
                        System.out.println("");
                    System.out.println("Wrong password!");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Wrong input, please try again");
                    System.out.println("");
            }
        }
    }
}

