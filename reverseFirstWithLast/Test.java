package reverseFirstWithLast;


public class Test {
	
	public static void reverseFirstWithLast(int[] arr) {
		
		int[] arr2=new int[arr.length];
		
		int primo=arr[0];
		int ultimo=arr[arr.length-1];
		
		arr2[0]=ultimo;
		arr2[arr.length-1]=primo;
		
		for(int x=1;x<arr.length-1;x++) {
			arr2[x]=arr[x];
		}
		
		for(int a:arr2) {
			System.out.println(a);
		}
		
	}

	public static void main(String[] args) {
		
			int[] arr={20, 30, 40, 50, 60, 70, 80, 90, 100};
			
			reverseFirstWithLast(arr);
        
	}

}
