package arrayDuplicatesCounter;
import java.util.*;

public class Main {
	
	public static int duplicatesCounter(int[] arr,int index) {
		int a=arr[index];
		int counter=0;
		for(int x=0;x<arr.length;x++) {
			if(a==arr[x]) {
				counter++;
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		
		int[] arr= {10, 20, 10, 20, 30, 40, 40, 30, 50};
		System.out.println(Arrays.toString(arr));
		ArrayList<Integer> arr2=new ArrayList<>();
		
		int counter;
		for(int x=0;x<arr.length;x++) {
			counter=duplicatesCounter(arr,x);
			if(counter==1) {
				arr2.add(arr[x]);
			}
		}
		
		System.out.print("\nI seguenti numeri appaiono solo una volta nell'array: "+arr2);
		
		
	}
}

