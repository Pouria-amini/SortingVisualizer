package CulminatingTask.Sorts;

import CulminatingTask.LearnSorting;
import CulminatingTask.SortingVisualizer;

import static CulminatingTask.LearnSorting.*;

/**
 *<p><b><i>Quick Sort</i></b></p>
 * <p>Quicksort is a divide-and-conquer algorithm. It works by selecting a
 * 'pivot' element from the array and partitioning the other elements into
 * two sub-arrays, according to whether they are less than or greater than
 * the pivot. For this reason, it is sometimes called partition-exchange sort.
 * The sub-arrays are then sorted recursively. This can be done in-place,
 * requiring small additional amounts of memory to perform the sorting. (Wikipedia)</p>
 * <p>The class implements Runnable to start a new thread and sort the array in that thread. This separates the sorting
 * from the rest of the application's process.</p>
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Quick Sort (Wikipedia)</a>
 * @see SortingVisualizer
 */
public class QuickSort implements Runnable{

    private LearnSorting panel;
    private boolean stop = false; // To stop sorting if interrupted by the user.

    /**
     * Quick Sorting a shuffled array. This class is created for {@link SortingVisualizer}.
     * @param panel The learnSorting panel for reference
     */
    public QuickSort(LearnSorting panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        Integer[] toBeSorted = SortingVisualizer.toBeSorted; // The array to be sorted
        sort(toBeSorted); // Sort the array

        // When sorting is done, reset the buttons and make them enable:
        SortingVisualizer.isSorting=false;
        steppedCheckBox.setEnabled(true);
        sizeSlider.setEnabled(true);
        selectionComboBox.setEnabled(true);
        startButton.setText("Start");
    }

    /**
     * Initializes sorting the shuffled array.
     * @param arr The array to be sorted
     */
    public void sort(Integer[] arr)
    {
        sort(arr, 0, arr.length-1);
    }

    /**
     * Recursively sort each sections of the array using Quick Sort algorithm.
     * @param arr The array to be sorted
     * @param lo The beginning of the section to be sorted
     * @param hi The end of the section to be sorted
     * @version 1.3
     */
    public void sort(Integer[] arr, int lo, int hi)
    {
        if (lo >= hi || stop) return; // If low passed hi or the user interrupted the sorting, return.
        int j = partition(arr, lo, hi); // Partition each section of the arr
        sort(arr, lo, j-1); // Recursively sort from the beginning to the pivot of the array
        sort(arr, j+1, hi);// Recursively sort from the pivot to the end of the array
    }

    /**
     * Sorts the section of the array using merge sort algorithm. First, it assign the pivot to the first element
     * of the section. Next, it figures out if the elements are less or greater than the pivot. Exchanges the elements
     * according to the rules of the algorithm and places pivot where it should be (between smaller elements and larger ones.
     * @param arr The array to be sorted
     * @param init The beginning of the section to be sorted
     * @param end The end of the section to be sorted
     * @return The position of the pivot
     * @version 1.4
     */
    public int partition(Integer[] arr, int init, int end)
    {
        int i = init, j = end+1;
        Integer pivot = arr[init]; // Assigning the pivot as the first element
        // While not interrupted by th user or not break:
        while (!stop)
        {
            while (less(arr[++i], pivot)) if(i == end) break; // Goes from the beginning until is finds an element bigger than pivot or reaches the end
            while (less(pivot, arr[--j])) if(j == init) break; // Goes from the end until is finds an element smaller than pivot or reaches the end
            if(i >= j) break; // If i passed j
            exchange(arr, i, j); // Exchange the element larger than pivot from the beginning with the element smaller than pivot from the end

            // Re-draw the array with i the working cruiser, j the comparing cruiser and init the reading cruiser:
            panel.reDrawArray(arr, i, j, init);

            // Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
            try {
                Thread.sleep(SortingVisualizer.sleep);
            } catch (InterruptedException e) {
                stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
            }
        }
        exchange(arr, init, j); // Set pivot between the larger one and the smaller ones of the section

        // Re-draw the array with init the working cruiser, i the comparing cruiser and j the reading cruiser:
        panel.reDrawArray(arr, init, i, j);

        // Set the speed of sorting according to the user's input (from the speedSlider in LearnSorting class)
        try {
            Thread.sleep(SortingVisualizer.sleep);
        } catch (InterruptedException e) {
            stop = true; // If interrupted, set stop to true to return to the SortingVisualizer class
        }
        return j; // Return pivot
    }

    /**
     * This methode is for {@link #partition}
     * @param i element i
     * @param j element j
     * @return true if i is smaller than j
     * @version 1.1
     */
    public boolean less(Comparable i, Comparable j)
    {
        return i.compareTo(j) < 0;
    }

    /**
     * Exchanges element i with element j within the array. This methode is for {@link #partition}
     * @param arr Exchange element i and j within this array
     * @param i element i
     * @param j element j
     * @version 1.1
     */
    public void exchange(Comparable[] arr, int i, int j)
    {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
