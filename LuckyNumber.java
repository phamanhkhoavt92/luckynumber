/*
 * Project: lucky number
 *
 * Version: 02
 *
 * Date: 13 Aug 2021
 */

import java.util.Scanner;
public class LuckyNumber {

    public static int lucky (){ // tao so lucky
       int lucky = (int) (Math.random()*100);
        return lucky;
    }

    public static int guess (){ // nhap so doan chu
        Scanner input = new Scanner(System.in);
        System.out.print ("Your guess? ");
        int number = input.nextInt();
        return number;
    }

    public static int play (int number, int lucky) { // so sanh

        int landoan =1;

        do {
            if (number > lucky) {
                System.out.println("It's slower.");
                number = guess();
            } else if (number < lucky) {
                System.out.println("It's higher.");
                number = guess();
            }
            landoan++;
            }
            while (number != lucky );
            System.out.println ("You got it right in " + landoan);
            return  landoan;
        }

    public static void result (int solanchoi, int solandoan, int bestgame ) { // ket qua
        System.out.println ("Overall games results:");
        System.out.println ("Total game: " + solanchoi);
        System.out.println ("Total guess: " + solandoan);
        System.out.println ("Guesses/game: " + solandoan/solanchoi);
        System.out.println ("Best game: " + bestgame);

    }


    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("I'm thinking of number between 0 and 100.... ");
        int luckynumber = lucky();
        int number = guess();
        int solandoan = play(number, luckynumber);
        System.out.print("do you want to play again Y/N? ");
        String traloi = input.next();
        int solanchoi = 1;
        int bestgame = solandoan; // bestgame la so lan doan it nhat de co ket qua dung
        if ( traloi.equals("Y") || traloi.equals("Yes") || traloi .equals("Co") || traloi .equals("YES") ||
                traloi .equals("CO") || traloi .equals("y") ||traloi .equals("yes")||traloi .equals("co")) {
            do {
                System.out.println("I'm thinking of number between 0 and 100.... ");
                luckynumber = lucky();
                number = guess();
                int solandoankhac = play(number, luckynumber);
                System.out.print("do you want to play again Y/N? ");
                traloi = input.next(); // khi tra loi N se thay doi vong lap
                solanchoi++;
                solandoan = solandoan + solandoankhac;
                if (bestgame > solandoankhac) {
                    bestgame = solandoankhac; // gan bestgame cho so lan doan nho nhat
                }

            } while (traloi.equals("Y") || traloi.equals("Yes") || traloi .equals("Co") || traloi .equals("YES") ||
                    traloi .equals("CO") || traloi .equals("y")|| traloi .equals("yes")|traloi .equals("co"));
            result(solanchoi, solandoan, bestgame);
        }
         else if (traloi.equals("No") || traloi.equals("NO") || traloi .equals("ko") || traloi .equals("KHONG") ||
                traloi .equals("n") || traloi .equals("KO") || traloi .equals("N")) {
            result(solanchoi, solandoan, bestgame);
        }

        else {
            System.out.println ("Please re-key Yes or no only! Exit game!");
            result(solanchoi, solandoan, bestgame);
        }
    }



}
