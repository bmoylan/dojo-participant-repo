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
        Matcher largestMatcher = ExtremeMatchers.largestPattern.matcher(parameter);
        if (largestMatcher.matches()) {
            return Arrays.stream(largestMatcher.group(1).split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .reduce(Integer::max).get()
                    .toString();
        }

        return "Don't Care";
    }

}
