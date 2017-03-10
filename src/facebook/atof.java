package facebook;
import java.util.*;

public class atof {
	public static void main(String[] args) {
		String input = "345.44E-10";  
		float value = a2f(input);
		System.out.print(value);
	}

	public static float a2f(String str) {
		StringBuilder one = new StringBuilder();
		StringBuilder two = new StringBuilder();
		int power = 0;
		int i=0;

		while(str.charAt(i) != '.') {
			one.append(str.charAt(i) + "");
			i++;      
		}

		i++;
		while(str.charAt(i) != 'E') {
			two.append(str.charAt(i) + "");
			i++;
		}

		float before = first(one.toString());
		float after = second(two.toString());
		power = Integer.parseInt(str.substring(i+1));

		System.out.println(before +", " + after + "," + power);

		return (before+after) * (float)Math.pow(10,power);
	}


	public static float first(String val) {
		float answer = 0;
		float power = (float)1.0;
		for (int i=val.length()-1; i>=0; i--) {
			answer += (val.charAt(i) - '0') * power;
			power *= 10;
		}
		return answer;
	}

	public static float second(String val) {
		float answer = 0;
		float power = (float)1/10;
		for (int i=0; i< val.length(); i++) {
			answer += (float)(val.charAt(i) - '0') * power;
			power /= 10;
		}
		return answer;

	}
}
