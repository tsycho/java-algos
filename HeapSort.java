
public class HeapSort implements SortAlgorithm
{
	public void sort(int[] array) {
		for(int i=array.length/2; i>=0; i--)
			maxHeapify(array, i, array.length);

		int size = array.length;
		while(size > 1) {
			swap(array, 0, size-1);
			maxHeapify(array, 0, --size);
		}
	}

	// Assumes the children array[2*i] and array[2*i+1] are valid max-heaps, but array[i] might be invalid
	// Heapify down the tree
	private void maxHeapify(int[] array, int i, int size) {
		if(2*i >= size) return; // No children, no problem			
		if(2*i+1 == size) { // has only one child
			if(array[i] < array[2*i])
				swap(array, i, 2*i); // No need to maxHeapify down since it's the last element				
			return;
		}	

		if( (array[i] >= array[2*i]) && (array[i] >= array[2*i+1]) )
			return;	// Nothing to do

		// array[i] is smaller than atleast one of its children
		// find the larger child, swap and maxHeapify down
		int max = (array[2*i] > array[2*i+1]) ? 2*i : 2*i+1;
		swap(array, i, max);
		maxHeapify(array, max, size);
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}