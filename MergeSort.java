
public class MergeSort implements SortAlgorithm
{
	public void sort(int[] array) {
		mergeSort(array, 0, array.length);
	}

	// Sort array from indices - start to end (non-inclusive)
	private void mergeSort(int[] array, int start, int end) {
		if(start > end)
			throw new RuntimeException("Invalid inputs!");
		if((end - start) <= 1)
			return;

		int mid = (start + end) / 2;
		mergeSort(array, start, mid);
		mergeSort(array, mid, end);

		merge(array, start, mid, end);
	}

	private void merge(int[] array, int start, int mid, int end) {
		int cur1 = start, cur2 = mid;
		int[] newarr = new int[end-start];
		int pos = 0;

		while(cur1<mid && cur2<end) {
			if(array[cur1] < array[cur2])
				newarr[pos++] = array[cur1++];
			else
				newarr[pos++] = array[cur2++];
		}

		while(cur1<mid)
			newarr[pos++] = array[cur1++];
		while(cur2<end)
			newarr[pos++] = array[cur2++];

		for(int i=start; i<end; i++)
			array[i] = newarr[i-start];
	}
}