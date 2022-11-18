package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       greeting();
       System.out.println("***************");
        travelTimeBudget();
        System.out.println("****************");
        timeDifference();
        System.out.println("*****************");
        countryArea();
        System.out.println("*******************");
        nextDistination();

    }

    public static void greeting() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name: ");

        String aa = s.nextLine();
        String bb = "Nice to meet you " + aa + ", where are you traveling to? ";
        System.out.print(bb);

        String t = s.nextLine();
        String tt = "Great! " + t + " sounds like a great trip";
        System.out.println(tt);
    }

    public static void travelTimeBudget() {
        long US;
        Scanner in = new Scanner(System.in);
        String p1 = "How many days are you going to spend traveling? ";
        System.out.print(p1);
        int days = in.nextInt();
        long hour = days * 24;
        long min = days * 24 * 60;//или hour*60;
        long sec = min * 60;

        String p2 = "How much money, in USD, are you planning to send on your trip: ";
        System.out.print(p2);

        US = in.nextLong();
        String p3 = "What is the three letter currency symbol for your travel destination? ";
        System.out.print(p3);

        String vname = in.next();
        String p4 = "How many " + vname + " are there in 1 USD? ";
        System.out.print(p4);
        String doub = in.next();
        double ot = Double.parseDouble(doub);
        System.out.println();

        String p5 = "If you are traveling for " + days + " days that is same as " + hour + " hours or " + min + " minutes or " + sec + " seconds.";
        System.out.println(p5);

        double day1 = (double) US / days;
        float otv = okryglenie(day1);

        String p6 = "If you are going to spend $" + US + " USD that means per day you can spend up to $" + otv + " USD.";
        System.out.println(p6);

        double mestnValute = US * ot;
        float a2 = okryglenie(mestnValute);
        double moneyonedayValute = mestnValute / days;
        float a3 = okryglenie(moneyonedayValute);
        System.out.println("Your total budget in EUR is " + a2 + " " + vname + ", which per day is " + a3 + " " + vname);
    }

    public static void timeDifference(){
        Scanner in = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int dif = in.nextInt();
        int mid = midnightTime(dif);

        int noon = noontime(dif);
        System.out.println("What means that when it is midnight at home it will be " + mid+":00 in your travel destination and when it's noon at home it will be " + noon +":00");
    }
    public static void countryArea(){
        Scanner in = new Scanner(System.in);
        System.out.print("What is square area of your destination country in km2? ");
        long km2 = in.nextLong();
        double mil = km2*0.38610215854245;;

        float okr = okryglenie(mil);
        String a = "In miles that is " + okr;
        System.out.println(a);
    }
    public static void nextDistination(){
        Scanner in = new Scanner(System.in);
        System.out.print("How many places you traveled to: ");
        int pl = in.nextInt();
        String[] treveled = new String[pl];

        String[] strany = {"Italy", "England", "Netherlands", "Germany", "France"};

        int i = 0;
        while (i<pl){
            System.out.print("Enter the name: ");
            treveled[i] = in.next();
            i++;
        }

        System.out.println();
        System.out.println("Next place you want to travel to: ");

        for (int j = 0; j < 5; j++) {
            String a = j+ ": " + strany[j];
            System.out.println(a);
        }
        int v = in.nextInt();
        String nextLoc = strany[v-1];
        System.out.println("Thank you, Your next location is: " + nextLoc);
    }



    public static float okryglenie(double d){
        float c;
        double a = d*100;
        int b = (int)Math.floor(a);
        c = (float)b/100;
        return c;
    }
    public static int midnightTime(int dif){
        return ((dif%24)+24)%24;
    }
    public static int noontime(int dif) {
        return ((dif+12)+24)%24;
    }
}
