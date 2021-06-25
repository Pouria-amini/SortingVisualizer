package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import static CulminatingTask.LearnSorting.*;
import static CulminatingTask.LearnSorting.startButton;

/**
 * <p><b><i>Insertion Sort</i></b></p>
 * <p>Insertion sort iterates, consuming one input element each repetition, and
 * grows a sorted output list. At each iteration, insertion sort removes one element
 * from the input data, finds the location it belongs within the sorted list, and
 * inserts it there. It repeats until no input elements remain. (Wikipedia)</p>
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class InsertionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private LearnSorting panel;
	private boolean fast;

	/**
	 * Insertion Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
	 * @param toBeSorted The array that will be sorted
	 * @param panel The learnSorting panel for reference
	 * @param fast The speed of sorting
	 */
	public InsertionSort(Integer[] toBeSorted, LearnSorting panel, boolean fast) {
		this.toBeSorted = toBeSorted;
		this.panel = panel;
		this.fast = fast;
	}

	@Override
	public void run() {
		if (fast) {
			sortFast();
		} else {
			sortSlow();
		}

		// When sorting is done, reset the buttons and make them enable:
		SortingVisualizer.isSorting=false;
		steppedCheckBox.setEnabled(true);
		sizeSlider.setEnabled(true);
		selectionComboBox.setEnabled(true);
		startButton.setText("Start");
	}

	/**
	 * Sort the array in the fast way. In this way, the cruisers will not be displayed.
	 * The reason why reDrawArray method and Thread.sleep are outside the first loop is to make the sorting fast.
	 * @version 1.1
	 */
	public void sortFast() {
		int temp; // Temporary variable holder
		int insert; // Keep track of where the item should be inserted

		/*
		Go over each element of the array and go to the beginning of the array.
		If the item (inset) is smaller any of the previously processed items, inset
		the item before that elements. Else, break.
		 */
		for(int i = 1; i<toBeSorted.length; i++){
			insert = i;
			for(int j = i-1; j>=0; j--){
				if (toBeSorted[i] < toBeSorted[j]){
					insert = j;
					if (j == 0)
						break;
				}else
					break;
			}
			temp = toBeSorted[i];
			// Inset the item when it suppose to be:
			for (int j = i; j>insert; j--)
				toBeSorted[j] = toBeSorted[j-1];
			toBeSorted[insert] = temp;

			// Re-draw the array with one cruiser:
			panel.reDrawArray(toBeSorted, i);

			// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				return; // If interrupted, return to the SortingVisualizer class
			}
		}
	}

	/**
	 * Sort the array in the normal way. In this way, the cruisers will be displayed.
	 * The reason why reDrawArray method and Thread.sleep are inside the first for statement is to make the sorting speed normal.
	 * @version 1.4
	 */
	public void sortSlow() {
		int temp; // Temporary variable holder
		int insert; // Keep track of where the item should be inserted

		/*
		Go over each element of the array and go to the beginning of the array.
		If the item (inset) is smaller any of the previously processed items, inset
		the item before that elements. Else, break.
		 */
		for(int i = 1; i<toBeSorted.length; i++){
			insert = i;
			for(int j = i-1; j>=0; j--){
				if (toBeSorted[i] < toBeSorted[j]){
					insert = j;
					if (j == 0)
						break;
				}else
					break;

				// Re-draw the array with i the working cruiser, and inset the comparing cruiser:
				panel.reDrawArray(toBeSorted, i, insert);

				// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					return; // If interrupted, return to the SortingVisualizer class
				}
			}

			// Inset the item when it suppose to be:
			temp = toBeSorted[i];
			for (int j = i; j>insert; j--)
				toBeSorted[j] = toBeSorted[j-1];
			toBeSorted[insert] = temp;
		}

		// Re-draw the array for setting up a layout:
		panel.reDrawArray(toBeSorted);
	}
}
