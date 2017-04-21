package algoritmos.sort.counting;

public class CountingSort {
	public void ChamaCountingSort(int[] array, boolean asc) {
		long tempoInicial = System.currentTimeMillis();
		
		sort(array, asc);
		
		long tempoFinal = System.currentTimeMillis() - tempoInicial;
	}

	public static int[] sort(int[] array, boolean asc) {
		int[] aux = new int[array.length];

		// find the smallest and the largest value
		int min = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			} else if (array[i] > max) {
				max = array[i];
			}
		}

		// init array of frequencies
		int[] counts = new int[max - min + 1];

		// init the frequencies
		for (int i = 0; i < array.length; i++) {
			counts[array[i] - min]++;
		}

		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i - 1];
		}

		// Ordem crescente
		if (asc) {
			for (int i = 0; i < array.length; i++) {
				int temp = counts[array[i] - min] - 1;
				aux[temp] = array[i];
				counts[array[i] - min]--;
			}
		} else {
			// Ordem decrescente
			for (int i = 0; i < array.length; i++) {
				int temp = Math.abs(counts[array[i] - min] - array.length);
				aux[temp] = array[i];
				counts[array[i] - min]--;
			}
		}

		return aux;
	}
}
