package other;

import java.util.Scanner;

/*****************************************************************************
 Compilation:  javac Accumulator.java
 Execution:    java Accumulator < input.txt
 Dependencies: StdOut.java StdIn.java

 Mutable data type that calculates the mean, sample standard
 deviation, and sample variance of a stream of real numbers
 use a stable, one-pass algorithm.

 */


/**
 *  The {@code Accumulator} class is a data type for computing the running
 *  mean, sample standard deviation, and sample variance of a stream of real
 *  numbers. It provides an example of a mutable data type and a streaming
 *  algorithm.
 *  <p>
 *  This implementation uses a one-pass algorithm that is less susceptible
 *  to floating-point round off error than the more straightforward
 *  implementation based on saving the sum of the squares of the numbers.
 *  This technique is due to
 *  <a href = "https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Online_algorithm">B. P. Welford</a>.
 *  Each operation takes constant time in the worst case.
 *  The amount of memory is constant - the data values are not stored.
 *  <p>
 *  For additional documentation, 
 *  see <a href="http://algs4.cs.princeton.edu/12oop">Section 1.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Accumulator {
    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)
    private double mu = 0.0;    // sample mean

    /**
     * Initializes an accumulator.
     */
    public Accumulator() {
    }

    /**
     * Adds the specified data value to the accumulator.
     * @param  x the data value
     */
    public void addDataValue(double x) {
        n++;
        double delta = x - mu;
        mu  += delta / n;
        sum += (double) (n - 1) / n * delta * delta;
    }

    /**
     * Returns the mean of the data values.
     * @return the mean of the data values
     */
    public double mean() {
        return mu;
    }

    /**
     * Returns the sample variance of the data values.
     * @return the sample variance of the data values
     */
    public double var() {
        if (n <= 1) return Double.NaN;
        return sum / (n - 1);
    }

    /**
     * Returns the sample standard deviation of the data values.
     * @return the sample standard deviation of the data values
     */
    public double stddev() {
        return Math.sqrt(this.var());
    }

    /**
     * Returns the number of data values.
     * @return the number of data values
     */
    public int count() {
        return n;
    }

    /**
     * Unit tests the {@code Accumulator} data type.
     * Reads in a stream of real number from standard input;
     * adds them to the accumulator; and prints the mean,
     * sample standard deviation, and sample variance to standard
     * output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Accumulator stats = new Accumulator();
        
        System.out.println("Enter your nums: ");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String s1 = scanner.next();
            if(s1.equals("exit")) {
                break;
            }
            double x = Double.parseDouble(s1);
            stats.addDataValue(x);
        }
        
        scanner.close();
        
        System.out.printf("n      = %d\n",   stats.count());
        System.out.printf("mean   = %.5f\n", stats.mean());
        System.out.printf("stddev = %.5f\n", stats.stddev());
        System.out.printf("var    = %.5f\n", stats.var());
    }
}

