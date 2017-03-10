package Array;

public class perm_integer_just_before {
	public static void main(String[] args) {
		System.out.println(justSmaller(1432));
	}
	
	public static int justSmaller(int num) {
		char[] str_num = (num + "").toCharArray();
		int len = str_num.length;
		int last = Character.getNumericValue(str_num[len-1]);
		int curr = 0;
		for (int i=str_num.length-2; i>0; i--) {
			curr = Character.getNumericValue(str_num[i]);
			if (curr > last) {
				str_num[len-1] = (char)(curr + '0');
				str_num[i] = (char)(last + '0');
				break;
			}
		}
		return Integer.parseInt(new String(str_num));
	}
}
