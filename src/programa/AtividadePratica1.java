package programa;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import algoritmos.dados.OrdenacaoDados;
import algoritmos.sort.counting.CountingSort;
import algoritmos.sort.heap.HeapSort;
import algoritmos.sort.insertion.InsertionSort;
import algoritmos.sort.merge.MergeSort;
import algoritmos.sort.quick.QuickSort;
import algoritmos.sort.selection.SelectionSort;
import auxiliar.GerarVetor;
import auxiliar.Imprimir;

public class AtividadePratica1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		GerarVetor gerarVetor = new GerarVetor();

		InsertionSort insercao;
		SelectionSort selecao;
		MergeSort merge;
		CountingSort counting;
		HeapSort heap;
		QuickSort quick;

		OrdenacaoDados ordenacaoDados;

		String nomeSort, consulta;
		char gerarNovoVetor = 0;

		int vetorAOrdenar[] = null;
		String[] consultaTokens;
		boolean repetirMenu = true;
		char repetirFlag;

		while (repetirMenu) {
			if (vetorAOrdenar != null && vetorAOrdenar.length > 0) {
				System.out.print("Deseja gerar outro vetor? y - sim; n - não: ");
				gerarNovoVetor = scan.next().charAt(0);
				scan.nextLine();
			}

			System.out.println("Informe a string de consulta: ");
			consulta = scan.nextLine();

			consultaTokens = consulta.split("\\s+");

			nomeSort = consultaTokens[0].toLowerCase();

			if (consultaTokens.length != 5 && consultaTokens.length != 6)
				nomeSort = "error";

			switch (nomeSort) {
			case "insertion":
				ordenacaoDados = new OrdenacaoDados("Selection Sort");
				insercao = new InsertionSort();

				ordenacaoDados.setElementos(Integer.parseInt(consultaTokens[1]));
				ordenacaoDados.setInicioFimOrdenados(consultaTokens[2].toLowerCase().charAt(0));
				ordenacaoDados.setPorcentagem(Integer.parseInt(consultaTokens[3]));
				ordenacaoDados.setOrdem(consultaTokens[4].toLowerCase().charAt(0));

				if (gerarNovoVetor != 'n')
					vetorAOrdenar = gerarVetor.gerarVetorAleatorio(ordenacaoDados);

				insercao.ChamaInsertionSort(vetorAOrdenar, ordenacaoDados);
				break;
			case "selection":
				ordenacaoDados = new OrdenacaoDados("Selection Sort");
				selecao = new SelectionSort();

				ordenacaoDados.setElementos(Integer.parseInt(consultaTokens[1]));
				ordenacaoDados.setInicioFimOrdenados(consultaTokens[2].toLowerCase().charAt(0));
				ordenacaoDados.setPorcentagem(Integer.parseInt(consultaTokens[3]));
				ordenacaoDados.setOrdem(consultaTokens[4].toLowerCase().charAt(0));

				if (gerarNovoVetor != 'n')
					vetorAOrdenar = gerarVetor.gerarVetorAleatorio(ordenacaoDados);

				selecao.chamaSelectionSort(vetorAOrdenar, ordenacaoDados);
				break;
			case "quick":
				ordenacaoDados = new OrdenacaoDados("Quick Sort");
				quick = new QuickSort();

				ordenacaoDados.setPivo(consultaTokens[1].toLowerCase().charAt(0));
				ordenacaoDados.setElementos(Integer.parseInt(consultaTokens[2]));
				ordenacaoDados.setInicioFimOrdenados(consultaTokens[3].toLowerCase().charAt(0));
				ordenacaoDados.setPorcentagem(Integer.parseInt(consultaTokens[4]));
				ordenacaoDados.setOrdem(consultaTokens[5].toLowerCase().charAt(0));

				if (gerarNovoVetor != 'n')
					vetorAOrdenar = gerarVetor.gerarVetorAleatorio(ordenacaoDados);

				quick.chamaQuickSort(vetorAOrdenar, ordenacaoDados);
				break;
			case "heap":
				ordenacaoDados = new OrdenacaoDados("Heap Sort");
				heap = new HeapSort();

				ordenacaoDados.setElementos(Integer.parseInt(consultaTokens[1]));
				ordenacaoDados.setInicioFimOrdenados(consultaTokens[2].toLowerCase().charAt(0));
				ordenacaoDados.setPorcentagem(Integer.parseInt(consultaTokens[3]));
				ordenacaoDados.setOrdem(consultaTokens[4].toLowerCase().charAt(0));

				if (gerarNovoVetor != 'n')
					vetorAOrdenar = gerarVetor.gerarVetorAleatorio(ordenacaoDados);

				heap.ChamaHeapSort(vetorAOrdenar, ordenacaoDados);
				break;
			case "merge":
				ordenacaoDados = new OrdenacaoDados("Merge Sort");
				merge = new MergeSort();

				ordenacaoDados.setElementos(Integer.parseInt(consultaTokens[1]));
				ordenacaoDados.setInicioFimOrdenados(consultaTokens[2].toLowerCase().charAt(0));
				ordenacaoDados.setPorcentagem(Integer.parseInt(consultaTokens[3]));
				ordenacaoDados.setOrdem(consultaTokens[4].toLowerCase().charAt(0));

				if (gerarNovoVetor != 'n')
					vetorAOrdenar = gerarVetor.gerarVetorAleatorio(ordenacaoDados);

				merge.chamaMergeSort(vetorAOrdenar, ordenacaoDados);
				break;
			case "counting":
				ordenacaoDados = new OrdenacaoDados("Counting Sort");
				counting = new CountingSort();

				ordenacaoDados.setElementos(Integer.parseInt(consultaTokens[1]));
				ordenacaoDados.setInicioFimOrdenados(consultaTokens[2].toLowerCase().charAt(0));
				ordenacaoDados.setPorcentagem(Integer.parseInt(consultaTokens[3]));
				ordenacaoDados.setOrdem(consultaTokens[4].toLowerCase().charAt(0));

				if (gerarNovoVetor != 'n')
					vetorAOrdenar = gerarVetor.gerarVetorAleatorio(ordenacaoDados);

				counting.ChamaCountingSort(vetorAOrdenar, ordenacaoDados);
				break;
			default:
				System.out.println("Você digitou um algoritmo de ordenação inválido.");
				break;
			}

			System.out.println("Deseja repetir? Digite Y para sim, qualquer outro para não: ");
			repetirFlag = scan.next().charAt(0);

			scan.nextLine();

			if (repetirFlag != 'y' && repetirFlag != 'Y')
				repetirMenu = false;
		}

		scan.close();
	}
}
