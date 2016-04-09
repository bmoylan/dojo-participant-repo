import static sun.jvm.hotspot.HelloWorld.fib;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtremeStartup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("q");

        System.out.println("A request has arrived:");
        System.out.println(parameter);

        resp.getWriter().write(answer(parameter));
    }

    String answer(String parameter) {
        if (parameter == null)
            return "Don't Care";

        Matcher sumMatcher = ExtremeMatchers.sumPattern.matcher(parameter);
        if (sumMatcher.matches()) {
            return String.valueOf(Integer.parseInt(sumMatcher.group(1))
                    + Integer.parseInt(sumMatcher.group(2)));
        }
        Matcher plusMatcher = ExtremeMatchers.plusPattern.matcher(parameter);
        if (plusMatcher.matches()) {
            return String.valueOf(Integer.parseInt(plusMatcher.group(1))
                    + Integer.parseInt(plusMatcher.group(2)));
        }
        Matcher plusPlusMatcher = ExtremeMatchers.plusPlusPattern.matcher(parameter);
        if (plusPlusMatcher.matches()) {
            return String.valueOf(Integer.parseInt(plusPlusMatcher.group(1))
                    + Integer.parseInt(plusPlusMatcher.group(2))
                    + Integer.parseInt(plusPlusMatcher.group(3)));
        }
        Matcher minusMatcher = ExtremeMatchers.minusPattern.matcher(parameter);
        if (minusMatcher.matches()) {
            return String.valueOf(Integer.parseInt(minusMatcher.group(1))
                    - Integer.parseInt(minusMatcher.group(2)));
        }
        Matcher powerMatcher = ExtremeMatchers.powerPattern.matcher(parameter);
        if (powerMatcher.matches()) {
            int a = Integer.parseInt(powerMatcher.group(1));
            int b = Integer.parseInt(powerMatcher.group(2));
            return String.valueOf((int) Math.pow(a, b));
        }
        Matcher largestMatcher = ExtremeMatchers.largestPattern.matcher(parameter);
        if (largestMatcher.matches()) {
            return Arrays.stream(largestMatcher.group(1).split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .reduce(Integer::max).get()
                    .toString();
        }
        Matcher squarecubeMatcher = ExtremeMatchers.squareAndCube.matcher(parameter);
        if (squarecubeMatcher.matches()) {
            String answer = Arrays.toString(Arrays.stream(squarecubeMatcher.group(1).split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .filter((val) -> {
                        double sqrt = Math.sqrt(val);
                        return (sqrt % 1) == 0;
                    })
                    .filter((val) -> {
                        double cuberoot = Math.pow(val, -3);
                        return (cuberoot % 1) == 0;
                    }).toArray());
            return answer.substring(1, answer.length()-1);
        }
        Matcher multMatcher = ExtremeMatchers.multiplyPattern.matcher(parameter);
        if (multMatcher.matches()) {
            return String.valueOf(Integer.parseInt(multMatcher.group(1))
                    * Integer.parseInt(multMatcher.group(2)));
        }
        Matcher fibbMatcher = ExtremeMatchers.fibbPattern.matcher(parameter);
        if (fibbMatcher.matches()) {
            return String.valueOf(fib(Integer.parseInt(fibbMatcher.group(1)) - 1));
        }
        Matcher primeMatcher = ExtremeMatchers.primePattern.matcher(parameter);
        if (primeMatcher.matches()) {
            String asnwer = Arrays.toString(Arrays.stream(primeMatcher.group(1).split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .filter(Utils::isPrime)
                    .toArray());
            return asnwer.substring(1, asnwer.length()-1);
        }

        if (parameter.matches(".*which city is the Eiffel tower in")) return "Paris";
        if (parameter.matches(".*who played James Bond in the film Dr No")) return "Sean Connery";
        if (parameter.matches(".*who is the Prime Minister of Great Britain")) return "David Cameron";
        if (parameter.matches(".*what colour is a banana")) return "Yellow";

        return "didn't find a match";
    }



}
