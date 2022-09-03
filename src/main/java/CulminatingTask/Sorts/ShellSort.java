package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import static CulminatingTask.LearnSorting.*;
import static CulminatingTask.LearnSorting.startButton;

/**
 * <p><b><i>Shell Sort</i></b></p>
 * <p>The method starts by sorting pairs of elements far apart from
 * each other, then progressively reducing the gap between elements
 * to be compared. By starting with far apart elements, it can move
 * some out-of-place elements into position faster than a simple nearest
 * neighbor exchange. (Wikipedia)</p>
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://en.wikipedia.org/wiki/Shellsort">Shell Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class ShellSort implements Runnable{

	private LearnSorting panel;

	/**
	 * Shell Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
	 * @param panel The learnSorting panel for reference
	 */
	public ShellSort(LearnSorting panel) {
		this.panel = panel;
	}

	@Override
	public void run() {
		Integer[] toBeSorted = SortingVisualizer.toBeSorted;
		sort(toBeSorted);

		// When sorting is done, reset the buttons and make them enable:
		SortingVisualizer.isSorting=false;
		steppedCheckBox.setEnabled(true);
		sizeSlider.setEnabled(true);
		selectionComboBox.setEnabled(true);
		startButton.setText("Start");
	}

	/**
	 * Sorts the array using the shell sort algorithm. This is similar to Insertion sort, but with the difference of
	 * inserting element by the distance of a gap.
	 * @version 1.1
	 */
	public void sort(Integer[] toBeSorted) {
		int temp; //Temporary item holder
		int j; // The selected item

		// Go over the array with a gap of toBeSorted.length/2 which decrease by half every time the array is fully traversed:
		for(int gap = toBeSorted.length/2; gap > 0; gap/=2){
			// Go over the elements of the array after each gap.
			for(int i = gap; i<toBeSorted.length; i++){
				temp = toBeSorted[i]; // Select the item to compare
				// Go over the previously processed items by each gap step, and replace the item with items bigger:
				for (j = i; j>=gap && temp<toBeSorted[j-gap]; j -= gap){
					toBeSorted[j] = toBeSorted[j-gap];

					// Re-draw the array with i the working cruiser, and j-gap the comparing cruiser:
					panel.reDrawArray(toBeSorted, i, j-gap);

					// Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
					try {
						Thread.sleep(SortingVisualizer.sleep);
					} catch (InterruptedException e) {
						return; // If interrupted, return to the SortingVisualizer class
					}
				}

				// Replace the item with it's new position (smaller items to the left and larger items to the right)
				toBeSorted[j] = temp;
			}
		}
	}
}
