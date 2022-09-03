package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import static CulminatingTask.LearnSorting.*;

/**
 * <p><b><i>Selection Sort</i></b></p>
 * <p>The algorithm divides the input list into two parts: a sorted sublist
 * of items which is built up from left to right at the front (left) of the
 * list and a sublist of the remaining unsorted items that occupy the rest
 * of the list. Initially, the sorted sublist is empty and the unsorted sublist
 * is the entire input list. The algorithm proceeds by finding the smallest
 * (or largest, depending on sorting order) element in the unsorted sublist,
 * exchanging (swapping) it with the leftmost unsorted element
 * (putting it in sorted order), and moving the sublist boundaries
 * one element to the right. (Wikipedia)</p>
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class SelectionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private LearnSorting panel;
	private boolean fast;

	/**
	 * Selection Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
	 * @param toBeSorted The array that will be sorted
	 * @param panel The learnSorting panel for reference
	 * @param fast The speed of sorting
	 */
	public SelectionSort(Integer[] toBeSorted, LearnSorting panel, boolean fast) {
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
	public void sortFast(){
		int temp; // Temporary item holder
		int selected; // The position of the selected item

		// Go over each element of the array and and find the smallest element. Then bring it to the beginning of the array:
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				if (toBeSorted[j] <= toBeSorted[selected])
					selected = j;
			}

			// Re-draw the array with one cruiser:
			panel.reDrawArray(toBeSorted);

			// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				return;
			}

			// Bring the selected item to the beginning of the array:
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
	}

	/**
	 * Sort the array in the normal way. In this way, the cruisers will be displayed.
	 * The reason why reDrawArray method and Thread.sleep are inside the first for statement is to make the sorting speed normal.
	 * @version 1.4
	 */
	public void sortSlow() {
		int temp; // Temporary item holder
		int selected; // The position of the selected item

		// Go over each element of the array and and find the smallest element. Then bring it to the beginning of the array:
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				if (toBeSorted[j] <= toBeSorted[selected])
					selected = j;

				// Re-draw the array with selected the working cruiser, and j-1 the comparing cruiser:
				panel.reDrawArray(toBeSorted, selected, j-1);

				// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					return; // If interrupted, return to the SortingVisualizer class
				}				
			}

			// Bring the selected item to the beginning of the array:
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
		// Re-draw the array after bring the selected item to the beginning of the array:
		panel.reDrawArray(toBeSorted);
	}
}
