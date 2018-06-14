package history.algorithms;

import java.util.Arrays;
/*
 * sort an array with max heap in decreasing order
 */
public class HeapSort {
	private static int[] sortDifferentLevel(int[] arr){
		int i=1;
		while((int)Math.pow(2, i)<=arr.length){
			int start=(int)Math.pow(2, i)-1;
			//int count=(int)Math.pow(2, i);
			int count=start+1;
			int end=start+count-1;
			if(end+1>=arr.length){
				//end=arr.length-1;
				break;
			}
			if(arr[end]<arr[end+1]){
				int tmp=arr[end];				
				arr[end]=arr[end+1];
				arr[end+1]=tmp;
				sortEachLevel(arr,end+1,2*(end+1));
			}
			i++;
		}
		return arr;
	}
	
	
//	private static int getLevel(int index,int arrLength){
//		int i=0;
//		while((int)Math.pow(2, i)<=arrLength){
//			int start=(int)Math.pow(2, i)-1;
//			//int count=(int)Math.pow(2, i);
//			int count=start+1;
//			int end=start+count-1;
//			if(end+1>=arrLength){
//				end=arrLength-1;
//			}
//			if(index>=start&&index<=end){
//				return i;
//			}
//			i++;
//			
//		}
//		return i;
//	}
	private static int[] sortAllLevels(int[] arr){
		//the first element in the array must be the largest, we don't need sort it;
		int i=1;
		 
		while((int)Math.pow(2, i)<=arr.length){
			int start=(int)Math.pow(2, i)-1;
			//int count=(int)Math.pow(2, i);
			int count=start+1;
			int end=start+count-1;
			if(end+1>=arr.length){
				end=arr.length-1;
			}
			arr=sortEachLevel(arr,start,end);
			i++;
			
		}
		return arr;
	}
	
	private static int[] sortEachLevel(int[] arr,int start, int end){
		if (end>arr.length){
			end=arr.length-1;
		}
		int[] subArr = Arrays.copyOfRange(arr, start, end+1);
		Arrays.sort(subArr);
		
		for(int i=start;i<=end;i++){
			arr[i]=subArr[end-i];
		}
		return arr;
	}
	
	private static void print(int[] arr){
		for (int anArr : arr) {
			System.out.print(anArr + ",");
		}
	}
	
	
	public static void main(String[] args){
		int[] arr={20,12,18,10,4,13,14,5,8,2};
		arr=sortAllLevels(arr);
		arr=sortDifferentLevel(arr);
		print(arr);
	}

}
