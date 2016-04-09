import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bmoylan on 4/8/16.
 */
public class ExtremeMatchers {

    public static Pattern sumPattern = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)");
    public static Pattern plusPattern = Pattern.compile(".*what is (\\d+) plus (\\d+)");
    public static Pattern largestPattern = Pattern.compile(".*which of the following numbers is the largest: ([ (\\d+),?]+)");
    public static Pattern squareAndCube = Pattern.compile(".*which of the following numbers is both a square and a cube: ([ (\\d+),?]+)");
    public static Pattern multiplyPattern = Pattern.compile(".*what is (\\d+) multiplied by (\\d+)");
    public static Pattern fibbPattern = Pattern.compile(".*what is the (\\d+).. number in the Fibonacci sequence");

}
