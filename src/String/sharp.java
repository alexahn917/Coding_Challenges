package String;

public class sharp {
	public static void StairCase(int n) {
        int ws = n-1;
        while (ws > -1) {
            for (int i=0; i < ws; i++){
                System.out.print(" ");
            }
            for (int j=0; j < n-ws; j++){
                System.out.print("#");
            }
            System.out.println();
            ws--;
        }
    }
	
	public static void main(String[] args) {
		StairCase(6);		
	}
}
