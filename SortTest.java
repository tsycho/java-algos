
public class SortTest
{
	public static int[] createArray(int size, int max) {
		int[] newarr = new int[size];
		for (int i=0; i<size; i++) {
			newarr[i] = (int)(Math.random() * max);
		}

		return newarr;
	}

	public static boolean testSorted(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			if(array[i] > array[i+1])
				return false;
		}
		return true;
	}

	public static void printArray(int[] array) {
		System.out.print("[ ");
		for(int i=0; i<array.length-1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length-1] + " ]");
	}


	public static void main(String[] args) {
		testMultipleArrays(10000, 1000);
	}

	private static void testSingleArray() {
		SortAlgorithm algo = new HeapSort();
		int[] array = createArray(10, 100);

		printArray(array);
		algo.sort(array);
		printArray(array);

		if(!testSorted(array))
			System.out.println("Array not sorted...");		
		else
			System.out.println("Array sorted successfully...");
	}

	private static void testMultipleArrays(int size, int count) {
		SortAlgorithm algo = new MergeSort();
		int errors = 0;

		for(int i=0; i<count; i++) {
			int[] array = createArray(size, 100);
			algo.sort(array);
			if(!testSorted(array))
				errors++;
		}

		System.out.println(errors + " errors found!");
	}
}