package facebook;

public class main {
	public static void main(String[] args) {
		Tree tr = new Tree();
		tr.insert(1);
		tr.insert(2);
		tr.insert(6);
		tr.insert(1);
		tr.insert(0);
		tr.insert(8);		
		System.out.println(tr);
		System.out.println(tr.getHeight());		
	}
}