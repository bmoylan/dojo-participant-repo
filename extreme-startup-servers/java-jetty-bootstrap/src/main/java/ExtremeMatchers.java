import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bmoylan on 4/8/16.
 */
public class ExtremeMatchers {

    public static Pattern sumPattern = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)");
    public static Pattern plusPattern = Pattern.compile(".*what is (\\d+) plus (\\d+)");
    public static Pattern minusPattern = Pattern.compile(".*what is (\\d+) minus (\\d+)");
    public static Pattern largestPattern = Pattern.compile(".*which of the following numbers is the largest: ([ (\\d+),?]+)");
    public static Pattern squareAndCube = Pattern.compile(".*which of the following numbers is both a square and a cube: ([ (\\d+),?]+)");
    public static Pattern multiplyPattern = Pattern.compile(".*what is (\\d+) multiplied by (\\d+)");
    public static Pattern primePattern = Pattern.compile(".*which of the following numbers are primes: ([ (\\d+),?]+)");

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
