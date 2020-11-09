package com.kea;
import com.sun.source.util.SourcePositions;

import java.text.SimpleDateFormat;
import java.util.*;

public class Wash{

    public void chooseWash (Scanner input,WashCard washCard,ArrayList<Integer> array){
        System.out.println("Press 1: Economy wash - 50 kr. (early bird 20% discount)");
        System.out.println("Press 2: Standard wash - 80 kr. (early bird 20% discount)");
        System.out.println("Press 3: DeLuxe wash - 120 kr.");
        System.out.println("Press 4: Back");
        System.out.print(": ");
        int scan = input.nextInt();
        if (scan == 1) {
            //washCard = new WashCard();
            double price = timeCheck(50);
            price = fdmCheck(input, price);
            System.out.println("Wash Price: "+price);

            if (washCard.getBalance() < price){
                System.out.println("");
                System.out.println("Washcard balance too low! Please refill balance.");
                return;
            }

            washCard.deductFromBalance(price);
            System.out.println("");
            printReceipt(input, washCard);
            array.add(1);

        }
        else if (scan == 2) {
            //washCard = new WashCard();
            double price = timeCheck(80);
            price = fdmCheck(input, price);
            System.out.println("Wash Price: "+price);
            if (washCard.getBalance() < price){
                System.out.println("");
                System.out.println("Washcard balance too low! Please refill balance.");
                return;
            }
            washCard.deductFromBalance(price);
            System.out.println("");
            printReceipt(input, washCard);
            array.add(2);

        }
        else if (scan == 3) {
            //washCard = new WashCard();
            double price = fdmCheck(input, 120);
            System.out.println("Wash Price: " + price);
            if (washCard.getBalance() < price){
                System.out.println("");
                System.out.println("Washcard balance too low! Please refill balance.");
                return;
            }
            washCard.deductFromBalance(price);
            System.out.println("");
            printReceipt(input, washCard);
            array.add(3);
        }
        else if (scan==4){

        }
    }


    //this part enforces the earlybird discount if eligible
    public double timeCheck (double price){

        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        Date date = new Date();
        int currentTime = Integer.parseInt(formatter.format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day > 1 && day < 7 && currentTime < 14)
        {
            price =+ price * 0.8;
        }
        return price;
    }
    //FDM code is 1234 in our example.
    public double fdmCheck(Scanner input, double price){

        System.out.println("Are you a member of FDM?");
        System.out.println("Press 1: Yes");
        System.out.println("Press 2: No ");
        System.out.println("");
        int scan = input.nextInt();
        if (scan==1) {
            System.out.println("Enter 4 digit FDM number: ");
            scan = input.nextInt();
            if (scan==1234)
                price =+ price * 0.8;
            else
                System.out.println("Wrong password!");
        }
        return price;
    }
    public void printReceipt(Scanner input,WashCard washCard){
        System.out.println("");
        System.out.println("Print receipt?");
        System.out.println("Press 1: Yes");
        System.out.println("Press 2: No");
        System.out.print(": ");
        int scan = input.nextInt();
        if (scan == 1)
            System.out.println("Amount left: " + washCard.getBalance());
        System.out.println("");
    }
    public void printStatistics(ArrayList<Integer> statistics){
        int economy = 0;
        int standard = 0;
        int deluxe = 0;
        for (int i=0; i < statistics.size(); i++){
            switch (statistics.get(i)) {
                case 1:
                    ++economy;
                    break;
                case 2:
                    ++standard;
                    break;
                case 3:
                    ++deluxe;
                    break;

            }
        }
        System.out.println("\nNumber of Ecomony washes: " + economy);
        System.out.println("Number of Standard washes: " + standard);
        System.out.println("Number of DeLuxe washes: " + deluxe);
        System.out.println("");
    }
}