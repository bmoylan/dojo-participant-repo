/**
 * Created by psomasundar on 4/8/16.
 */
public class Utils {
	private static int fib(int n) {
		int a = 0;
		int b = 1;

		for (int i = 2; i <= n; i++) {
			int temp = a;
			a = a + b;
			b = temp;
		}
		return a;
	}
}
