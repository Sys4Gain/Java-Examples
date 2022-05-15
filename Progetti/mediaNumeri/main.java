package mediaNumeri;
import java.util.Scanner;

class main{
	
	public static void main(String[] args) {
    	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Indica la quantità di numeri da immettere: ");
		
		int grandezza=sc.nextInt();
		
		int[] num=new int[grandezza];
		int totale=0;
		int a;
		
		System.out.println("Indica i "+grandezza+" numeri:");
		
		for(int x=0;x<num.length;x++) {
			a=sc.nextInt();
			num[x]=a;
		}
		
		for(int numero:num) {
			totale+=numero;
		}
		
		int risultato=totale/grandezza;
		
		System.out.println(risultato);
		
	}
}

