package week1.three;
import java.util.Scanner;
public class BinaryVal {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary value: ");
        String binary = scanner.nextLine();

        int decimal = 0;
        int length = binary.length();

        for(int i = 0; i < length; i++){
            char bit = binary.charAt(length - 1 - i);

            if(bit == '1') {
                decimal += (int)Math.pow(2, i);
            }
            else if(bit != '0') {
                System.out.println("Only 0s and 1s are allowed!!!");
                scanner.close();
                return;
            }
        }

        System.out.println("Decimal: " + decimal);
        scanner.close();
    }
}