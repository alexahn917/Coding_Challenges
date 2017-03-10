package facebook;

public class numDecodings {
	// Hello, Will.
	// 123
	// Return all possibility of permutations of Letters A-Z
	// Where 1 -> A,... Z->26
	// input: 123, output: 3
	// ABC, LC, AW


	//Cases: 0 -> FALSE, 10 -> J, 20 -> Q

	public static void main(String[] args) {
	    System.out.println(numDecodings("12320"));
	}

	public static int numDecodings(String s) {
	    int[] N = new int[s.length()];
	    N[0] = 1;
	    for (int i=1; i < s.length(); i++) {
	        // add 1 if not '0'
	        if (s.charAt(i) != '0' && Integer.parseInt(s.substring(i-1, i+1)) <= 26) {
	            N[i] = N[i-1] + 1;            
	        }
	        else if (s.charAt(i-1) == '1' || s.charAt(i-2) == '2') {
	                    N[i] = N[i-1] + 1;
	        }
	        else {
	            N[i] = N[i-1];
	        }        
	    }
	    return N[s.length()-1];
	}

}
