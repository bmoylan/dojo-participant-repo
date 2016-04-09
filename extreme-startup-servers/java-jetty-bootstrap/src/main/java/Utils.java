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
