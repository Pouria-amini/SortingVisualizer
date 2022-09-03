package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import static CulminatingTask.LearnSorting.*;
import static CulminatingTask.LearnSorting.startButton;

/**
 *<p><b><i>Gnome Sort</i></b></p>
 * <p>The gnome sort is a sorting algorithm which is similar to insertion sort in that it works
 * with one item at a time but gets the item to the proper place by a series of swaps, similar
 * to a bubble sort. It is conceptually simple. The average running
 * time is O(n2) but tends towards O(n) if the list is initially almost sorted. (Wikipedia)</p>
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://en.wikipedia.org/wiki/Gnome_sort">Gnome Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class GnomeSort implements Runnable{
	
	private Integer[] toBeSorted;
	private LearnSorting panel;
	private boolean fast;

	/**
	 * Gnome Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
	 * @param toBeSorted The array that will be sorted
	 * @param panel The learnSorting panel for reference
	 * @param fast The speed of sorting
	 */
	public GnomeSort(Integer[] toBeSorted, LearnSorting panel, boolean fast) {
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

		// When sorting is done, Reset the buttons and make them enable:
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

		// Go over each elements of the array and compare it to the next elements. If larger, switch the two. Else break from the first for loop.
		for(int i = 0; i<toBeSorted.length-1; i++){
			for(int j = i+1; j>0; j--){
				if (toBeSorted[j] < toBeSorted[j-1]){
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[j-1];
					toBeSorted[j-1] = temp;
				}else{
					break;
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
		}
	}

	/**
	 * Sort the array in the normal way. In this way, The cruisers will be displayed.
	 * The reason why reDrawArray method and Thread.sleep are inside the if statement is to make the sorting speed normal.
	 *@version 1.2
	 */
	public void sortSlow() {
		int temp; // Temporary variable holder

		// Go over each elements of the array and compare it to the next elements. If larger, switch the two. Else break from the first for loop.
		for(int i = 0; i<toBeSorted.length-1; i++){
			for(int j = i+1; j>0; j--){
				if (toBeSorted[j] < toBeSorted[j-1]){
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[j-1];
					toBeSorted[j-1] = temp;

					// Re-draw the array with j the working cruiser, and j-1 the comparing cruiser:
					panel.reDrawArray(toBeSorted, j, j-1);

					// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
					try {
						Thread.sleep(SortingVisualizer.sleep);
					} catch (InterruptedException e) {
						return; // If interrupted, return to the SortingVisualizer class
					}
				}else{
					break;
				}
			}
		}
	}
}
