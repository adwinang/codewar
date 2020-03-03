package codewar.java;

// The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.

// Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

// Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?

// Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.

// Examples:

// Line.Tickets(new int[] {25, 25, 50}) // => YES 
// Line.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
// Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)


public class ClerkChange {
    
    public static void main(String[] args) {
        System.out.println(mySolution(new int[] {25, 25, 25, 25, 50, 100, 50}));
    }

    public static String mySolution(int[] peopleInLine) {
        int bill25 = 0;
        int bill50 = 0;
        for (int i : peopleInLine) {
            if (i == 25) {
                bill25 += 1;
            } 
            if(i == 50) {
                if (bill25 >= 1) {
                    bill25 -= 1;
                    bill50 += 1;
                } else {
                    return "NO";
                }
            }
            if(i == 100) {
                if (bill25 >= 1 && bill50 >= 1) {
                    bill25 -= 1;
                    bill50 -= 1;
                } else if (bill25 >= 3) {
                    bill25 -= 3;
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    //Use If Else, this prevents unnecessary checking
    //Use ++ and -- for increments or decrements of 1
    //For similar return conditions, try to merge them into one chunk of code
    public static String idealSolution(int[] peopleInLine){
        int bill25 = 0, bill50 = 0;
        for (int payment : peopleInLine){
            if(payment==25){
                bill25++;
            } else if(payment==50){
                bill25--;
                bill50++;
            } else if(payment==100){
                if(bill50>0){
                    bill50--;
                    bill25--;
                } else{
                    bill25-=3;
                }
            }
            if(bill25<0 || bill50 <0){
                return "NO";
            }
        }
        return "YES";
    }

}