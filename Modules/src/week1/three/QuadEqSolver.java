package week1.three;

import java.util.Scanner;
public class QuadEqSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quadratic Equation:      Ax^2 + Bx + C = 0");
        System.out.print("Enter The Value for *A* coefficient in the equation");
        double A = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the Value for *B* coefficient in the equation");
        double B = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the Value for *C* coefficient in the equation");
        double C = Double.parseDouble(scanner.nextLine());

        double Value = (B*B) - (4*A*C);

        if (Value>0){
            double x1 = (-B + Math.sqrt(Value))/(2*A);
            double x2 = (-B - Math.sqrt(Value))/(2*A);
            System.out.printf("The roots are x1: %.2f and x2: %.2f%n", x1,x2);
        }
        else if(Value==0){
            double x= -B/(2*A);
            System.out.printf("The roots were same and real: %.2f%n",x);
        }
        else{
            System.out.println("There is No Real Root for the equation");
        }
        scanner.close();

    }
}
