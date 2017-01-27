//The complete code
public interface Expression { 
	public Set<Character> getChars(String in);
	public boolean eval(Map <Character, Integer> c); 
}

public class ExpressVerify implements Expression{
	
	Map<Character, Integer> maps=new HashMap<Character,Integer>();
	String operand1;
	String operand2;
	String result;
	public Set<Character> getChars(String in)
	{
		Set<Character> vs=new LinkedHashSet<Character>();
		for(int i=0;i<in.length();i++)
			vs.add(in.charAt(i));		
		return vs;
	}
	
	int get_addition(int val1,int val2)
	{
		return val1+val2;
	}
	int getValue(String in1, Map<Character,Integer> maps)
	{
		Set<Character> v= new LinkedHashSet<Character>();
		v= getChars(in1);
		Iterator<Character> it=v.iterator();
		int j=v.size()-1;
		int sum=0;
		while(it.hasNext())
		{
			Character a=it.next();
			System.out.print(a);
			if (maps.containsKey(a)){
				int val= maps.get(a);
				sum+=val*Math.pow(10.0, (double)j);
			}
			else
				sum+=0;
			j--;
		}
		System.out.println(sum);
		return sum;
	}
	public boolean eval(Map <Character, Integer> c)
	{
		int res=get_addition(getValue(operand1,c),getValue(operand2,c));
		
		if (res==getValue(result,c))
			return true;
		else 
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressVerify ev= new ExpressVerify(); 
		
		ev.maps.put('O', 2);
		ev.maps.put('N', 3);
		ev.maps.put('E', 1);
		ev.maps.put('T', 4);
		ev.maps.put('W', 6);
		ev.operand1="ONE";
		ev.operand2="ONE";
		ev.result="TWO";
		System.out.println(ev.eval(ev.maps));
		System.out.println(ev.maps.values());
	}

}