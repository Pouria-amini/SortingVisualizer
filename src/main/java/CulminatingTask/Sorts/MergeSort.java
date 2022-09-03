package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import static CulminatingTask.LearnSorting.*;

/**
 * <p><b><i>Merge Sort</i></b></p>
 * <p>First divide the list into the smallest unit (1 element),
 * then compare each element with the adjacent list to sort and
 * merge the two adjacent lists. Finally all the elements are sorted
 * and merged. (Wikipedia)</p>
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class MergeSort implements Runnable{

    private LearnSorting panel;
    private boolean stop = false; // To stop sorting if interrupted by the user.

    /**
     * Merge Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
     * @param panel The learnSorting panel for reference
     */
    public MergeSort(LearnSorting panel) {
        this.panel = panel;
    }

    @Override
	public void run() {
		Integer[] toBeSorted = SortingVisualizer.toBeSorted; // The array to be sorted
		inPlaceSort(toBeSorted); // Sort the array

        // When sorting is done, reset the buttons and make them enable:
        SortingVisualizer.isSorting=false;
        steppedCheckBox.setEnabled(true);
        sizeSlider.setEnabled(true);
        selectionComboBox.setEnabled(true);
        startButton.setText("Start");
	}

    /**
     * Initializes sorting the shuffled array.
     * @param x The array to be sorted
     */
	public void inPlaceSort ( Integer[] x ) {
        inPlaceSort (x, 0, x.length-1);
    }

    /**
     * Recursively sort each section of the array using merge sort algorithm.
     * @param x The array to be sorted
     * @param first The beginning of the section to be sorted
     * @param last The end of the section to be sorted
     * @version 1.5
     */
    private void inPlaceSort ( Integer[] x, int first, int last ) {
      int mid, lt, rt; // Holder of the middle, left side and the right side of the section
      int tmp; // Temporary element holder

      // If the beginning of the section passed the end of the section or sorting is interrupted by the user, return:
      if ( first >= last || stop) return;

      mid = (first + last) / 2;

      inPlaceSort (x, first, mid);// Sort from the fist elements of the section to the middle
      inPlaceSort (x, mid+1, last); // Sort from the middle elements of the section to the end

      lt = first;  rt = mid+1; // Set the values for left element and right element

      // One extra check:  can we SKIP the merge?
      if ( x[mid] <= x[rt]) return;

      // While in range and while the user did not interrupt the sorting:
      while (lt <= mid && rt <= last && !stop) {

         if ( x[lt] <= x[rt])// Select from left:  no change, just advance lt
            lt++;
         else {// Select from right:  rotate [lt..rt] and correct
            tmp = x[rt];     // Will move to [lt]
            for (int i = rt-lt;i>0; i--)
            	x[lt+i] = x[lt+i-1];
            x[lt] = tmp;
            // EVERYTHING has moved up by one
            lt++;  mid++;  rt++;
         }

          // Re-draw the array with mid the working cruiser, rt the comparing cruiser and lt the reading cruiser:
         panel.reDrawArray(x, mid, rt, lt);

          // Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
          try {
              Thread.sleep(SortingVisualizer.sleep);
          } catch (InterruptedException e) {
              stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
          }
      }
      // Whatever remains in [rt..last] is in place
   }
}

