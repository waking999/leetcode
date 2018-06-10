package other;

import leetcode.success.comm.Util;

public class HeapSort {
	public int[] sort(int[] array) {
		buildMaxHeap(array);
		
		int arrayLen=array.length;
		for(int i=arrayLen-1;i>=0;i--) {
			swap(array, 0,i);
			maxHeapify(array,0,i);
		}
		return array;
	}
	
	private void buildMaxHeap(int[] array) {
		
		int arrayLen=array.length;
		int iParent=arrayLen/2-1;
		for(int i=iParent;i>=0;i--) {
			maxHeapify(array, i, arrayLen);
		}
	}
	
	private void maxHeapify(int[] array, int index, int heapSize) {
		while(true) {
			int iMax=index;
			int iLeft=2*index+1;
			int iRight=2*(index+1);
			if(iLeft<heapSize&&array[index]<array[iLeft]) {
				iMax=iLeft;
			}
			
			if(iRight<heapSize&&array[iMax]<array[iRight]) {
				iMax=iRight;
			}
			if(iMax!=index) {
				swap(array,iMax,index);
				index=iMax;
			}else {
				break;
			}
		}
	}
	
	private void swap(int[] array, int i,int j) {
		int tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	
	public static void main(String[] args) {
		
		HeapSort s=new HeapSort();
		
		int[] array;
		int[] expect;
		int[] output;
		
		array=new int[] {4,1,3,2,16,9,10,14,8,7};
		expect=new int[] {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
		output=s.sort(array);
		Util.verifyUnsort(expect, output, 1);
		
		
		array=new int[] {4,1,3,2,16,9,14,10,8,7};
		expect=new int[] {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
		output=s.sort(array);
		Util.verifyUnsort(expect, output, 2);
		
	}

}
