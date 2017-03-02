package facebook;

public class add_str_ints {
	public static void main(String[] args) {
		String a = "123";
		String b = "30";
		System.out.println(add(a,b));
	}
	
	public static String add(String a, String b) {
		if (a.length() < 1) return b;
		if (b.length() < 1) return a;		
		
		StringBuilder sb = new StringBuilder();		
		char[] a_chars = a.toCharArray();
		char[] b_chars = b.toCharArray();
		int i=a.length()-1, j=b.length()-1;
		
		
		while (i>=0 || j>=0) {
			if (i>=0 && j>=0) {
				sb.append((Character.getNumericValue(a_chars[i]) + 
						Character.getNumericValue(b_chars[j])) + "");
			}
			
			else if (i>=0) {
				sb.append(a_chars[i]);
			}
			
			else {
				sb.append(b_chars[j]);
			}			
			i--;j--;
		}

		return sb.reverse().toString();
	} 
}
