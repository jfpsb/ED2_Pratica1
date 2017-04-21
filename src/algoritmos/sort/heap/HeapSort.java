package algoritmos.sort.heap;

import algoritmos.dados.OrdenacaoDados;
import auxiliar.Imprimir;

/* Class HeapSort */
public class HeapSort {
	private static int N;
	private static long numeroComparacoes = 0;
	private static long numeroAtribuicoes = 0;

	public void ChamaHeapSort(int[] array, OrdenacaoDados ordenacao) {
		long tempoInicial = System.currentTimeMillis();
		int[] vetorAOrdenar = new int[array.length];
		
		System.arraycopy(array, 0, vetorAOrdenar, 0, array.length);

		if (ordenacao.getOrdem() == 'c') {
			SortAsc(vetorAOrdenar);
		} else {
			SortDesc(vetorAOrdenar);
		}

		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		ordenacao.setNumeroAtribuicoes(numeroAtribuicoes);
		ordenacao.setNumeroComparacoes(numeroComparacoes);

		Imprimir.ImprimeResultado(Long.valueOf(tempoFinal).doubleValue(), vetorAOrdenar, ordenacao);
	}

	/* Sort Function */
	public static void SortAsc(int arr[]) {
		System.out.println("Ordenando vetor. Aguarde.");
		maxHeapify(arr);
		for (int i = N; i > 0; i--) {
			numeroComparacoes++;
			swap(arr, 0, i);
			N = N - 1;
			maxheap(arr, 0);
		}

		numeroComparacoes++;
	}

	public static void SortDesc(int arr[]) {
		System.out.println("Ordenando vetor. Aguarde.");
		minHeapify(arr);
		for (int i = N; i > 0; i--) {
			numeroComparacoes++;
			swap(arr, 0, i);
			N = N - 1;
			minheap(arr, 0);
		}

		numeroComparacoes++;
	}

	/* Function to build a heap */
	public static void maxHeapify(int arr[]) {
		N = arr.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			numeroComparacoes++;
			maxheap(arr, i);
		}

		numeroComparacoes++;
	}

	public static void minHeapify(int arr[]) {
		N = arr.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			numeroComparacoes++;
			minheap(arr, i);
		}

		numeroComparacoes++;
	}

	/* Function to swap largest element in heap */
	public static void maxheap(int arr[], int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;

		numeroAtribuicoes += 3;

		if (left <= N && arr[left] > arr[i]) {
			max = left;
			numeroAtribuicoes++;
			numeroComparacoes += 2;
		}
		if (right <= N && arr[right] > arr[max]) {
			max = right;
			numeroAtribuicoes++;
			numeroComparacoes += 2;
		}

		if (max != i) {
			swap(arr, i, max);
			maxheap(arr, max);
		}
	}

	public static void minheap(int arr[], int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int min = i;

		numeroAtribuicoes += 3;

		if (left <= N && arr[left] < arr[i]) {
			min = left;
			numeroAtribuicoes++;
			numeroComparacoes += 2;
		}
		if (right <= N && arr[right] < arr[min]) {
			min = right;
			numeroAtribuicoes++;
			numeroComparacoes += 2;
		}

		if (min != i) {
			numeroComparacoes++;
			swap(arr, i, min);
			minheap(arr, min);
		}
	}

	/* Function to swap two numbers in an array */
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

		numeroAtribuicoes += 3;
	}
}