package week1.three;

import java.util.Scanner;
public class Table {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("\n\n\nHello Students Its Liinanmaki I am here to Assist to you Master the Math Tables 🤩");
        System.out.println("The rules are easy: score 10 points in 1 game and You Win yuuhooo😉 \nLets Start!!!!!!!!!\n");

        while(true){
            int score = 0;
//used for loop for 10 questions and while loop is used to keep the game running till player master the math tables.
            for(int i=0; i<10; i++){
                int tab = (int) (Math.random() * 10) + 1;
                int row = (int) (Math.random() * 10) + 1;

                System.out.print("Your points are: " + score + "                   Solve: " + row +" * "+ tab+ " = ");
                int Answer = scanner.nextInt();

                if(Answer == (row * tab)){
                    System.out.println("✅ 🎊");
                    score++;
                } else {
                    System.out.println("❌                                The correct answer is " + (row * tab)+ "\n");
                }
            }

            if(score == 10){
                System.out.println("\n🎉 Congratulations! You mastered the multiplication tables! 🎉");
                break;
                // exit game
            } else {
                System.out.println("\nYou scored " + score + "/10. 😅 Let's try again!\n");
            }
        }

        scanner.close();
    }
}
