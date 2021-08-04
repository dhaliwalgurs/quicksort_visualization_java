/* Name:       Gursimran Dhaliwal
 * Email:      gdhal233@mtroyal.ca
*  Course:     COMP 2631
*  Instructor: Jason Heard
*/
class QuickSort {
    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        Main.setPivot(high);   // SET PIVOT COLOUR
        int index = (low - 1);

        for (int j = low; j < high; j++) {
            Main.compareElementsVisual(j, high); // YELLOW TAG for COMPARISON
            if (arr[j] < pivot) {
                index++;
                // swap small value with larger value
                int temp = arr[index];
                arr[index] = arr[j];
                arr[j] = temp;
                Main.updateGraphic(index, j); // SWAP AND UPDATE THE VISUAL (GREEN TAG)
            }
        }

        int temp = arr[index + 1];
        arr[index + 1] = arr[high];
        arr[high] = temp;
        Main.updateGraphic(index + 1, high);  // SWAP AND UPDATE THE VISUAL

        return index + 1;
    }
}