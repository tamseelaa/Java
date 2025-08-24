package week1.three;
import java.util.Scanner;
public class PrimeGenerator {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n\n\n So Here We Will Know Prime Numbers Between The Starting Point And Ending Point Appointed By You");
        System.out.print("\nEnter the starting Number: ");
        int start=scanner.nextInt();
        System.out.print("Enter the ending Number: ");
        int end=scanner.nextInt();
        int counter=0;
        for(int i=(start+1);i<end;i++){
            int count=0;
            if(i>1){
                 for(int j=2; j<=Math.sqrt(i);j++){
                     if(i%j==0){
                     count++;
                     break;
                     }
                 }
                 if(count==0){
                     System.out.print(i+" ");
                     counter++;
                 }
            }
        }
        System.out.printf("\nThere were %d Prime numbers inside the appointed range", counter);
    }
}
