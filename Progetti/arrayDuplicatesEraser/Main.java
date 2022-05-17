package arrayDuplicatesEraser;
import java.util.*;

public class Main {

	public static ArrayList<Integer> duplicatesEraser(int[] arr) {
		ArrayList<Integer> list=new ArrayList<>();
		int a=arr[0];
		list.add(a);
		for(int x=1;x<arr.length;x++) {
			if(a!=arr[x]) {
				a=arr[x];
				list.add(a);
			}
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Prima");
		int[] arr= {1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7};
		System.out.println(Arrays.toString(arr));
		
		ArrayList<Integer> list=new ArrayList<>();
		
		list=duplicatesEraser(arr);
		System.out.println("\nDopo");
		System.out.println(list);
		
	}

}
