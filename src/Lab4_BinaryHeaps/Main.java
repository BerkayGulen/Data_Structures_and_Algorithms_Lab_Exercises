package Lab4_BinaryHeaps;

public class Main
{

	public static void main(String[] args)
	{
		Heap heap = new Heap(10);

		// Instantiate a heap
		// ...

		// Build the heap with using insert method for some numbers like 52, 25, 40, 2, 10, etc.
		 heap.insert(52);
		heap.insert(25);
		heap.insert(40);
		heap.insert(2);
		heap.insert(10);
		System.out.println("Before Delete");
		heap.printHeap();
		heap.deleteMin();
		System.out.println("After Delete");
		heap.printHeap();

		// .	.
		// .	.
		// .	.

		// Print the heap that you have created
		// ...

		// Get min value of the heap that you have created
		System.out.println("Min value: "+heap.getMinValue());
		// ...

		// Get height of the heap that you have created
		System.out.println("Height: "+heap.getHeight());
		// ...

		int[] arrayC = {15, 170, 5, 28, 92, 84, 38, 203, 37, 70, 40};
		// Use arrayC[] for building the heap again with buildHeap() method this time and print it
		for (int i=0;i<arrayC.length;i++){

		}
		heap.buildHeap(arrayC);
		System.out.println("After Using Build Heap");
		heap.printHeap();
		// ...

		// Use deleteMin() method to delete root of the heap and print the new heap
		// ...
		heap.deleteMin();
		System.out.println("After Using Delete min");

		heap.printHeap();

	}

}