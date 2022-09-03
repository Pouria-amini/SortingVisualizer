package CulminatingTask;

import CulminatingTask.Sorts.*;

import java.util.ArrayList;
import java.util.Collections;

import static CulminatingTask.LearnSorting.*;

/**
 * <p><i><b>Sorting Visualization Helper</b></i></p>
 * <p>This class is a helper class for {@link LearnSorting} in which the sorting will initialise according to the user's
 * choice of algorithm. This class will also generate random values to be sorted, using the static method {@link #resetArray()}.</p>
 * @see LearnSorting
 */
public class SortingVisualizer {

	private static Thread sortingThread; // The time between each step of sorting

	public static LearnSorting panel;
	public static Integer[] toBeSorted;
	public static boolean isSorting = false;
	public static int sortDataCount = 100; // The default size of the unsorted array
	public static int sleep = 20; // The default speed of sorting
	public static int blockWidth; // The size of each panel representing the unsorted array values
	// Stepped depicts whether the values are incremental or random. True is incremental:
	public static boolean stepped = false;

	public SortingVisualizer(LearnSorting panel) {
		SortingVisualizer.panel = panel;
	}

	/**
	 * Regenerates a shuffled array of stepped or non stepped values and draws a sketch of the array using
	 * {@link LearnSorting#preDrawArray(Integer[]) preDrawArray}.
	 * @version 1.2
	 */
	public static void resetArray(){
		// If we are currently in a sorting method, then isSorting should be true
		// We do not want to reinitialize/reset the array mid sorting.
		if (isSorting) return;
		toBeSorted = new Integer[sortDataCount];
		blockWidth = (int) Math.max(Math.floor(500/sortDataCount), 1);
		for(int i = 0; i<toBeSorted.length; i++){
			if (stepped) {
				toBeSorted[i] = i;
			} else {
				toBeSorted[i] = (int) (sortDataCount*Math.random());
			}
		}
		// If we're using incremental values, they are already sorted. This shuffles it.
		if (stepped) {
			ArrayList<Integer> shuffleThis = new ArrayList<>();
			Collections.addAll(shuffleThis, toBeSorted);
			Collections.shuffle(shuffleThis);
			toBeSorted = shuffleThis.toArray(toBeSorted);
		}
		panel.preDrawArray(toBeSorted);
	}

	/**
	 * Starts sorting according to the user's choice. The chosen sorting algorithm will start a new thread which will be run
	 * Using the start method of Thread.
	 * This method makes the sizeSlider, steppedCheckBox and selectionComboBox until sorting is finished and also the user
	 * can stop sorting by pressing the "Reset" button.
	 * @param type The sorting algorithm chosen by the user.
	 * @see BubbleSort
	 * @see SelectionSort
	 * @see InsertionSort
	 * @see GnomeSort
	 * @see MergeSort
	 * @see RadixSort
	 * @see ShellSort
	 * @see QuickSort
	 * @version 1.4
	 */
	public static void startSort(String type){

		// If no sorting algorithm is running, start sorting:
		if (sortingThread == null || !isSorting){

			resetArray(); // Generate a new array of shuffled values

			steppedCheckBox.setEnabled(false);
			sizeSlider.setEnabled(false);
			selectionComboBox.setEnabled(false);
			startButton.setText("Reset");

			isSorting = true;

			switch (type) {
				case "Bubble" -> sortingThread = new Thread(new BubbleSort(toBeSorted, panel, false));
				case "Selection" -> sortingThread = new Thread(new SelectionSort(toBeSorted, panel, false));
				case "Insertion" -> sortingThread = new Thread(new InsertionSort(toBeSorted, panel, false));
				case "Gnome" -> sortingThread = new Thread(new GnomeSort(toBeSorted, panel, false));
				case "Merge" -> sortingThread = new Thread(new MergeSort(panel));
				case "Radix LSD" -> sortingThread = new Thread(new RadixSort(toBeSorted, panel, true));
				case "Radix MSD" -> sortingThread = new Thread(new RadixSort(toBeSorted, panel, false));
				case "Shell" -> sortingThread = new Thread(new ShellSort(panel));
				case "Bubble(fast)" -> sortingThread = new Thread(new BubbleSort(toBeSorted, panel, true));
				case "Selection(fast)" -> sortingThread = new Thread(new SelectionSort(toBeSorted, panel, true));
				case "Insertion(fast)" -> sortingThread = new Thread(new InsertionSort(toBeSorted, panel, true));
				case "Gnome(fast)" -> sortingThread = new Thread(new GnomeSort(toBeSorted, panel, true));
				case "Quick" -> sortingThread = new Thread(new QuickSort(panel));
				default -> {
					isSorting = false;
					return;
				}
			}
			sortingThread.start();
		}
	}

	/**
	 * Stops sorting and makes sizeSlider, steppedCheckBox and selectionComboBox editable.
	 * It also gives some time to fully stop sorting. Interrupting the thread would throw an error which will stop the
	 * running sorting algorithm from continuing.
	 * @version 1.2
	 */
	public static void stopSort() {
	    if (isSorting)
		    sortingThread.interrupt(); // Interrupts the time between each step of sorting
		isSorting = false;
		steppedCheckBox.setEnabled(true);
		sizeSlider.setEnabled(true);
		selectionComboBox.setEnabled(true);
		startButton.setText("Start");
		//Give the thread time to fully stop:
		try {
			Thread.sleep(5);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}
}
