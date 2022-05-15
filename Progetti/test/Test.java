package test;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		
		ArrayList<Integer> arr=new ArrayList<>();
		
		System.out.print("Indica la grandezza del tuo array: ");
		int a,grandezzaArr=sc.nextInt();
		System.out.println("Ecco il tuo array!");
		
		for(int x=0;x<grandezzaArr;x++) {
			a=random.nextInt(51);
			arr.add(a);
		}
		
		System.out.println("\n"+arr);
		System.out.print("\nIndica di quale numero vorresti ricavarne l'index: ");
		
		int num=sc.nextInt();
		
		//indexOf manuale
		
		/*for(int x=0;x<grandezzaArr;x++) { 
			if(arr.get(x)==num) {
				b=x;
				break;
			}
		}*/
		
		System.out.println("Il numero "+num+" si trova all'index "+arr.indexOf(num)+"!");
		sc.close();
		
	}

}
