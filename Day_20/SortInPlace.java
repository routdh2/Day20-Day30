package coding_interview;

public class SortInPlace {
	//runs in O(n) time
	public static void sort(int[] arr) {
		int left=0,right=arr.length-1;
		int i=0;
		while(i<=right) {
			if(arr[i]==0) {
				swap(arr,i,left);
				i++;
				left++;
			}
			else if(arr[i]==1)
				i++;
			else if(arr[i]==2) {
				swap(arr,i,right);
				right--;
			}
		}
		for(int item:arr)
			System.out.print(item+" ");
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

	public static void main(String[] args) {
		sort(new int[] {1,0,2,1,0});

	}

}
