import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter angle x (in radians): ");
        double x = s.nextDouble();

        int numOfTerms = 5;

        double pi = Math.PI;
        double twoPi = 2*pi;

        //sin(100 % 2p)
        x = x%twoPi;

        if (x < 0) {
            x+=twoPi;
        }
        int sign=1;

        //sin(x)=−sin(x−p)
        if (x > pi) {
            x = x - pi;
            sign = -1;
        }

        //sin(x)=sin(p−x)
        if (x > pi /2) {
            x = pi - x;
        }

        double sum = 0.0;

        for (int i = 0; i < numOfTerms; i++) {
            int exponent = 2 * i + 1;

            double power = 1.0;
            for (int j = 0; j < exponent; j++) {
                power *= x;
            }

            double factorial = 1.0;
            for (int j = 1; j <= exponent; j++) {
                factorial*= j;
            }

            double term = power/factorial;

            if (i % 2 == 0) {
                sum += term;
            } else {
                sum -= term;
            }
        }

        sum*=sign;

        System.out.println("sin = " + sum);
    }
}