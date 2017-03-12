package facebook;

public class fibonacci {
	public static void main(String[] args) {
		System.out.println(fib_rec(10)); 
		System.out.println(fib(10)); 
	}

	public static int fib(int n) {
		if (n<=2) return 1;
		int prevprev = 1;
		int prev = 1;
		
		for (int i=2; i<n; i++) {
			prev = prev + prevprev;
			prevprev = prev - prevprev;
		}

		return prev + prevprev;
	}

	public static int fib_rec(int n) {
		return (n<=1) ? 1 : fib_rec(n-1) + fib_rec(n-2);
	}
}
