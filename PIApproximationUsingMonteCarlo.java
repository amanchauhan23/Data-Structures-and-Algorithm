// https://academo.org/demos/estimating-pi-monte-carlo/
import java.util.Scanner;

class MonteCarloPI {

    public static double pi_calculate(int n) {
        double insideCircle = 0;
        double insideSquare = 0;

        while (n-- != 0) {
            double randX = Math.random();
            double randY = Math.random();
            if (Math.sqrt(randX * randX + randY * randY) < 1)
                insideCircle++;
            insideSquare++;
        }

        return (4.0 * insideCircle) / insideSquare;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter N: ");
        System.out.println("PI approximation using Monte Carlo Algo is: " + pi_calculate(in.nextInt()));
        in.close();
    }
}
