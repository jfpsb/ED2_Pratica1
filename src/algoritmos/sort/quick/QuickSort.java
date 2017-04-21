package algoritmos.sort.quick;

public class QuickSort {
	private int[] numbers;
	private int number;

	public void sort(int[] values, char pivo, boolean asc) {
		// check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1, pivo, asc);
	}

	private void quicksort(int low, int high, char pivo, boolean asc) {
		int i = low, j = high, pivot;

		if (pivo == 'P') {
			pivot = numbers[low];
		} else if (pivo == 'U') {
			pivot = numbers[high];
		} else {
			pivot = numbers[low + (high - low) / 2];
		}

		// Divide into two lists
		while (i <= j) {
			if (asc) {
				while (numbers[i] < pivot) {
					i++;
				}

				while (numbers[j] > pivot) {
					j--;
				}
			} else {
				while (numbers[i] > pivot) {
					i++;
				}

				while (numbers[j] < pivot) {
					j--;
				}
			}

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j, pivo, asc);
		if (i < high)
			quicksort(i, high, pivo, asc);
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}