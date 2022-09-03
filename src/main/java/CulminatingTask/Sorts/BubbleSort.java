package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import static CulminatingTask.LearnSorting.*;
import static CulminatingTask.LearnSorting.startButton;

/**
 * <p><i><b>Bubble Sort</b></i></p>
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the
 * list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated
 * until the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller or larger elements
 * "bubble" to the top of the list. (Wikipedia)
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class BubbleSort implements Runnable{
	
	private Integer[] toBeSorted;
	private LearnSorting panel;
	private boolean fast;

	/**
	 * Bubble Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
	 * @param toBeSorted The array that will be sorted
	 * @param panel The learnSorting panel for reference
	 * @param fast The speed of sorting
	 */
	public BubbleSort(Integer[] toBeSorted, LearnSorting panel, boolean fast) {
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
	 * Sort the array in the fast way. In this way, The cruisers will not be displayed.
     * The reason why reDrawArray method and Thread.sleep are outside the first loop is to make the sorting fast.
	 * @version 1.1
	 */
	public void sortFast() {
		int temp; // Temporary variable holder
		boolean swapped; // isSorted (If the algorithms no longer swaps, it means the array is sorted)

		// Go over every element of the array an compare to to the rest of the array:
		for(int i = 0; i<toBeSorted.length-1; i++){
			swapped = false;
			for(int j = 1; j<toBeSorted.length-i; j++){
				// If the left one is larger, swap it with the right one:
				if (toBeSorted[j-1]> toBeSorted[j]){
					temp = toBeSorted[j-1];
					toBeSorted[j-1] = toBeSorted[j];
					toBeSorted[j]= temp;
					swapped = true;
				}
			}

			// Re-draw the array with no cruiser:
			panel.reDrawArray(toBeSorted);

			// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				return; // If interrupted, return to the SortingVisualizer class
			}

			// If the array is sorted, break:
			if (!swapped) break;
		}
	}

	/**
	 * Sort the array in the normal way. In this way, The cruisers will be displayed.
     * The reason why reDrawArray method and Thread.sleep are inside the first for statement is to make the sorting speed normal.
	 *@version 1.3
	 */
	public void sortSlow() {
		int temp; // Temporary variable holder
		boolean swapped; // isSorted (If the algorithms no longer swaps, it means the array is sorted)

		// Go over every element of the array an compare to to the rest of the array:
		for(int i = 0; i<toBeSorted.length-1; i++){
			swapped = false;
			for(int j = 1; j<toBeSorted.length-i; j++){
				// If the left one is larger, swap it with the right one:
				if (toBeSorted[j-1]> toBeSorted[j]){
					temp = toBeSorted[j-1];
					toBeSorted[j-1] = toBeSorted[j];
					toBeSorted[j]= temp;
					swapped = true;
				}

				// Re-draw the array with j the working cruiser, and j+1 the comparing cruiser:
				panel.reDrawArray(toBeSorted, j, j+1);

				// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					return; // If interrupted, return to the SortingVisualizer class
				}
			}

			// If the array is sorted, break:
			if (!swapped) break;
		}
	}
}
