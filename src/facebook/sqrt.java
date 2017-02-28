package facebook;

public class sqrt {

	public static void main(String[] args) {
		int x = 100;
		double y = 100.1;
		System.out.println(get_sqrt_dummy(x));
		System.out.println(get_sqrt_bs(x));
		System.out.println(get_sqrt_bs_double(y));
	}

	
	public static int get_sqrt_dummy(int x) {
		for (int i = x; x >= 0; i--) {
			if (i*i == x)
				return i;
		}
		return -1;
	}

	public static int get_sqrt_bs(int x) {
		int lo = 0;
		int hi = x;
		int mid = 0;
		while(lo < hi) {
			mid = (lo+hi)/2;
			if (mid*mid == x) return mid;
			else if (mid*mid < x) {
				lo = mid;
			}
			// mid*mid > x
			else {
				hi = mid;
			}
		}		
		return -1;
	}

	public static double get_sqrt_bs_double(double x) {
		double lo = 0.0;
		double hi = x;
		double mid = 0;		
		double threshold = 0.0001;
		int iter = 0;
		
		while(lo < hi && iter <= 100000) {
			mid = (lo+hi)/2.0;
			if (Math.abs(mid*mid - x) <= threshold) return mid;
			else if (mid*mid < x) {
				lo = mid;
			}
			// mid*mid > x
			else {
				hi = mid;
			}
			iter++;
		}			
		return mid;
	}	
	

}
