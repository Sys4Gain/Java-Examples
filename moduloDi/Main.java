package moduloDi;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> div3=new ArrayList<Integer>();
		ArrayList<Integer> div5=new ArrayList<Integer>();
		ArrayList<Integer> div35=new ArrayList<Integer>();
        
		for(int x=1;x<=100;x++) {
        if(x%3==0) 
        	div3.add(x);
        else if(x%5==0)
        	div5.add(x);
		}
		
		for(int x=1;x<=100;x++) {
			if(x%3==0 && x%5==0)
	        	div35.add(x);
		}
		
		System.out.println("Divided by 3: ");
		for(int a:div3) {
			System.out.print(a+", ");
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Divided by 5: ");
		for(int a:div5) {
			System.out.print(a+", ");
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Divided by 3 & 5: ");
		for(int a:div35) {
			System.out.print(a+", ");
		}

	}
}
