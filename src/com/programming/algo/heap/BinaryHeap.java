package com.programming.algo.heap;

import java.util.Comparator;

public class BinaryHeap<E> {

	private Object[] queue;
	private int size=0;
	private Comparator<? super E> comparator=null;
	
	
	
	public BinaryHeap(int capacity, Comparator <E> comparator) {
		
		queue = new Object[capacity];
		this.comparator=comparator;
	}
	
	public void printHeap() {
		
		for(Object e : queue)
			System.out.print(e+" ");
		
		
	}
	
	
public BinaryHeap(int capacity) {
		
		queue = new Object[capacity];
		
	}

/*
 * TC: O(nlogn) to insert n element. To insert 1 element TC O(logn)
 * 
 * 
 */
	public void insert(E e) {
		
		int i = size;
		size=i+1;
		if(i==0)
			queue[0]=e;
		heapifyUp(i,e);
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void heapifyUp(int k , E e ) {
		Comparable<? super E> key = (Comparable<? super E>)e;
		while(k > 0) {
			int parent = (k-1)/2;
			Object p = queue[parent];
			
			if(key.compareTo((E)p) >=0) {
				break;
			}
			queue[k]=p;
			k = parent;
		}
		
		queue[k]=e;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void heapifyDown(int k , E e ) {
		Comparable<? super E> key = (Comparable<? super E>)e;
		int half = size/2;
		while(k < half) {
			int child = k*2+1;
			int rightChild = child+1;
			
			Comparable<? super E> c = (Comparable<? super E>) queue[child];
						
			// comparing left and right child. if left is bigger then choose right
			
			if(rightChild<size && c.compareTo((E)queue[rightChild]) > 0) {
				
				
				c= (Comparable<? super E>)queue[rightChild];
				child=rightChild;
				
			}
						
			// compare above result with element e
			
			if(key.compareTo((E)c ) <= 0)
				break;
			queue[k]=c;
			k=child;
		
			
		}
		
		queue[k]=e;
		
	}
	
	@SuppressWarnings("unchecked")
	public E extractMin() {
		if(size <=0)
		     return null ;
		
		int i = --size;
		 
		 E result = (E)queue[0];
		 E x = (E)queue[i];
		 queue[i]=null;
		 
		 if(i!=0)
			 heapifyDown(0,x);
		 
		 return result;
				
	}
	
	public void heapSort() {
		
	for(int i=queue.length-1;i>=0;i--)
	{
		E e = extractMin();
		queue[i]=e;
		
		
	}
	
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public E getMin() {
		if(size <=0)
		     return null ;		
		return (E)queue[0];
	}
	
	
	public static void main (String [] args) {
		
		BinaryHeap<Integer> minHeap = new BinaryHeap<Integer>(5);
		minHeap.insert(5);
		minHeap.insert(20);
		minHeap.insert(18);
		minHeap.insert(19);
		minHeap.insert(4);
		
		minHeap.printHeap();
		
		int elements [] =  {4,10,3,34,11,15};
		
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>(elements.length);
		
		for(int e : elements)
			heap.insert(e);
		
		System.out.println();
		heap.printHeap();
		heap.heapSort();
		System.out.println();
		heap.printHeap();
		
		
		
		
		
	}
}
