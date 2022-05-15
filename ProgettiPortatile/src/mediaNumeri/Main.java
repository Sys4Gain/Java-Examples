package mediaNumeri;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> evennums = new ArrayList<Integer>();
        
        System.out.println("Inserire 3 numeri: ");
        
        while(evennums.size()<3){
            int num = scanner.nextInt();
            evennums.add(num);
            
            
        }
        
        int a = 0;
        
        for(int x=0;x<=2;x++) {
        	a += evennums.get(x);
        	
        }
        
        System.out.println(a/evennums.size());

	}

}
