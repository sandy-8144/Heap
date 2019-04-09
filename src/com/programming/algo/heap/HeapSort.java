package com.programming.algo.heap;

public class HeapSort {

	// Same procedure as deletion. downwards. TC O(n)
	public void heapify(int [] arr) {
		
		int half = (arr.length/2)-1;
		
		while(half >=0) {
			heapifyDown(half ,  arr );			
			half--;
		}
		
	}
	
	
	
	private void heapifyDown(int k ,  int [] a ) {
		int element = a[k];
		while(k <= a.length/2) {
			int child = k*2+1;
			int rightChild = child+1;
			
			int l = a[child];
			
						
			// comparing left and right child. if left is bigger then choose right
			
			if(rightChild < a.length && l > a[rightChild]) {
								
				l= a[rightChild];
				child=rightChild;
				
			}
						
			// compare above result with element e
			
			if(element  <= l)
				break;
			a[k]=l;
			k=child;
		
			
		}
		
		a[k]=element;
		
	}
	
	public static void main(String [] args) {
		
		
		int elements [] =  {8,10,3,34,11,15,7};
		HeapSort hs = new HeapSort();
		hs.heapify(elements); // build heap using same array.
		
		for(int e : elements)
			System.out.print(e+" ");
		
	}
}
