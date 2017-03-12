package facebook;

public class perms_subs {
	
	public static void main(String[] args) {
		String str = "abc";
		gen_perms("",str);
		System.out.println();
		gen_subs("",str,0);
	}
	
	public static void gen_perms(String prefix, String str) {
		if (str.length() < 1) {
			System.out.print(prefix + ", ");
		}
		for (int i=0; i < str.length(); i++) {
			gen_perms(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
		}
	}
	
	public static void gen_subs(String prefix, String str, int index) {
		for (int i = index; i < str.length(); i++) {
			System.out.print(prefix + str.charAt(i) + ", ");
			gen_subs(prefix + str.charAt(i), str, i+1);
		}
	} 
	
}
