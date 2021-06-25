package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import java.util.ArrayList;

import static CulminatingTask.LearnSorting.*;
import static CulminatingTask.LearnSorting.startButton;

/**
 * <p><i><b>Radix Sort</b></i></p>
 * <p>In computer science, radix sort is a non-comparative sorting algorithm.
 * It avoids comparison by creating and distributing elements into buckets
 * according to their radix. For elements with more than one significant digit,
 * this bucketing process is repeated for each digit, while preserving the ordering
 * of the prior step, until all digits have been considered.</p>
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://https://en.wikipedia.org/wiki/Radix_sort">Radix Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class RadixSort implements Runnable{
	
	private Integer[] toBeSorted;
	private LearnSorting panel;
	private boolean lsd;
	private boolean stop = false; // To stop sorting if interrupted by the user.

	/**
	 * Radix Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
	 * @param toBeSorted The array that will be sorted
	 * @param panel The learnSorting panel for reference
	 * @param lsd Is sorting lsd or msd?
	 */
	public RadixSort(Integer[] toBeSorted, LearnSorting panel, boolean lsd) {
		this.toBeSorted = toBeSorted;
		this.panel = panel;
		this.lsd = lsd;
	}

	@Override
	public void run() {
		if (lsd)
			radixlsd(toBeSorted, 1);
		else
			radixmsd(toBeSorted, findDigit(toBeSorted));

		// When sorting is done, reset the buttons and make them enable:
		SortingVisualizer.isSorting =false;
		steppedCheckBox.setEnabled(true);
		sizeSlider.setEnabled(true);
		selectionComboBox.setEnabled(true);
		startButton.setText("Start");
	}

	/**
	 * <p>LSD radix sorts typically use the following sorting order: short keys come before
	 * longer keys, and then keys of the same length are sorted lexicographically.
	 * This coincides with the normal order of integer representations, like the sequence
	 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]. LSD sorts are generally stable sorts.</p>
	 * @param arr The array to be sorted
	 * @param digit The number of digits to compare from the elements of the array.
	 * @version 1.7 (optimised)
	 */
	private void radixlsd(Integer[] arr, int digit){

		// Create the buckets:
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i<10; i++)
			buckets[i] = new ArrayList<>();

		int theDig;
		int maxI = 0;
		// Go over the each item of the array:
		for(int i = 0; i<arr.length; i++){
			theDig = (int) (arr[i]%Math.pow(10, digit)); // Find the nth first digits of the item (n is "digit" variable)
			for(int t = 0; t<digit-1; t++) // Find the first digit
				theDig/=10;

			// Find the maximum element of the array
			if (arr[i] > maxI) maxI = arr[i];

			// Re-draw the array with i the reading cruiser:
			panel.reDrawArray(arr, -1, -1, i);

			// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
				return;
			}

			// Add theDig (fist digit of the ith element of arr) to the position of theDig in the buckets array
			buckets[theDig].add(arr[i]);
		}

		// Create a new arrayList to hold the partially sorted items:
		ArrayList<Integer> finalList = new ArrayList<>();
		for(int i = 0; i<10; i++)
			finalList.addAll(buckets[i]);

		Integer[] y = finalList.toArray(new Integer[0]); // Turn the finalList to array of integers

		// Re-draw the array with no cruiser:
		panel.reDrawArray(y);

		// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
		try {
			Thread.sleep(SortingVisualizer.sleep);
		} catch (InterruptedException e) {
			stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
			return;
		}

		// If the number of digits of maxI is less than 10^digit or user interrupted sorting, return
		if (maxI < Math.pow(10, digit) || stop) return;

		radixlsd(y, digit+1); // Recursively call radixlsd until the array is fully sorted
		
	}

	/**
	 * <p>MSD radix sorts are most suitable for sorting strings or fixed-length
	 * integer representations. A sequence like [b, c, e, d, f, g, ba] would be
	 * sorted as [b, ba, c, d, e, f, g]. If lexicographic ordering is used to sort
	 * variable-length integers in base 10, then numbers from 1 to 10 would be output
	 * as [1, 10, 2, 3, 4, 5, 6, 7, 8, 9], as if the shorter keys were left-justified
	 * and padded on the right with blank characters to make the shorter keys as long
	 * as the longest key. MSD sorts are not necessarily stable if the original
	 * ordering of duplicate keys must always be maintained.</p>
	 * @param arr The array to be sorted
	 * @param digit The number of digits of the maximum number of the array
	 * @version 1.4
	 */
	private void radixmsd(Integer[] arr, int digit){

		// Create the buckets:
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i<10; i++)
			buckets[i] = new ArrayList<>();

		int theDig;
		// Go over the each item of the array:
		for(int i = 0; i<arr.length; i++){
			theDig = (int) (arr[i]%Math.pow(10, digit)); // Find the nth first digits of the item (n is "digit" variable)
			for(int t = 0; t<digit-1; t++) // Find the first digit
				theDig/=10;

			// Re-draw the array with i the reading cruiser:
			panel.reDrawArray(arr, -1, -1, i);

			// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
				return;
			}

			// Add theDig (fist digit of the ith element of arr) to the position of theDig in the buckets array
			buckets[theDig].add(arr[i]);
		}

		// Create a new arrayList to hold the partially sorted items:
		ArrayList<Integer> finalList = new ArrayList<>();
		for(int i = 0; i<10; i++)
			finalList.addAll(buckets[i]);

		Integer[] y = finalList.toArray(new Integer[0]); // Turn the finalList to array of integers

		// Re-draw the array with no cruiser:
		panel.reDrawArray(y);

		// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
		try {
			Thread.sleep(SortingVisualizer.sleep);
		} catch (InterruptedException e) {
			stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
			return;
		}

		// If digit reached 1 or user interrupted sorting, return:
		if (digit == 1  || stop) return;


		int beginning = 0;
		for (int i = 0; i < 10; i++) {
			y = radixmsd(y, digit-1, beginning, beginning + buckets[i].size());
			beginning += buckets[i].size();
		}
	}

	/**
	 * The recursive call of radixmsd.
	 * @param arr The array to be sorted
	 * @param digit The number of digits
	 * @param begin The beginning of the section to be sorted
	 * @param end The end of the section to be sorted
	 * @return The sorted section
	 */
	private Integer[]  radixmsd(Integer[] arr, int digit, int begin, int end){

		// Create the buckets:
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i<10; i++)
			buckets[i] = new ArrayList<>();

		int theDig;
		// Go over the each item of the array:
		for(int i = begin; i<end; i++){
			theDig = (int) (arr[i]%Math.pow(10, digit)); // Find the nth first digits of the item (n is "digit" variable)
			for(int t = 0; t<digit-1; t++) // Find the first digit
				theDig/=10;

			// Re-draw the array with i the reading cruiser:
			panel.reDrawArray(arr, -1, -1, i);

			// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
			}

			// Add theDig (fist digit of the ith element of arr) to the position of theDig in the buckets array
			buckets[theDig].add(arr[i]);
		}

		// Create a new arrayList to hold the partially sorted items:
		ArrayList<Integer> finalList = new ArrayList<>();
		for (int i = 0; i < begin; i++)
			finalList.add(arr[i]);

		for(int i = 0; i<10; i++)
			finalList.addAll(buckets[i]);

		for (int i = end; i < arr.length; i++)
			finalList.add(arr[i]);
		
		Integer[] y = finalList.toArray(new Integer[0]); // Turn the finalList to array of integers

		// Re-draw the array with no cruiser:
		panel.reDrawArray(y);

		// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
		try {
			Thread.sleep(SortingVisualizer.sleep);
		} catch (InterruptedException e) {
			stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
		}

		// If digit reached 1 or user interrupted sorting, return:
		if (digit == 1  || stop) return y;
		
		int beginning = begin;
		for (int i = 0; i < 10; i++) {
			y = radixmsd(y, digit-1, beginning, beginning + buckets[i].size());
			beginning += buckets[i].size();
		}
		
		return y;
	}

	/**
	 * Finds the number of digits of the maximum number within the array.<br>
	 * This method is created for {@link #run()}.
	 * @param arr The array to be sorted
	 * @return returns the number of digits of the maximum number
	 */
	private int findDigit(Integer[] arr) {
		//Find the maximum integer:
		int max = Integer.MIN_VALUE;
		int digit = 1;
		for (int i : arr)
			if (i > max)
				max = i;

		// Find the number of digits of the maximum number:
		while (max > 10) {
			max = max/10;
			digit++;
		}

		return digit;
	}
}
