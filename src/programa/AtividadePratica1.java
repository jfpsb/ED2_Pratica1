package programa;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import algoritmos.sort.counting.CountingSort;
import algoritmos.sort.heap.HeapSort;
import algoritmos.sort.insertion.InsertionSort;
import algoritmos.sort.merge.MergeSort;
import algoritmos.sort.quick.QuickSort;
import algoritmos.sort.selection.SelectionSort;
import auxiliar.GerarVetor;

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

		String nomeSort;
		String pivo;
		int quantEl;
		char inicioOuFim;
		int porcentagem;
		char ordem;

		int vetorAOrdenar[] = null;
		String consulta;
		String[] consultaTokens;
		boolean repetirMenu = true;
		char repetirFlag;
		String escolhaVetor;

		while (repetirMenu) {
			System.out.println("Informe a string de consulta: ");
			consulta = scan.nextLine();

			consultaTokens = consulta.split("\\s+");

			nomeSort = consultaTokens[0].toLowerCase();
			
			if(consultaTokens.length != 4 && consultaTokens.length != 5)
				nomeSort = "error";

			switch (nomeSort) {
			case "insertion":
				quantEl = Integer.parseInt(consultaTokens[1]);
				inicioOuFim = consultaTokens[2].toLowerCase().charAt(0);
				porcentagem = Integer.parseInt(consultaTokens[3]);
				ordem = consultaTokens[4].toLowerCase().charAt(0);

				insercao = new InsertionSort();

				vetorAOrdenar = gerarVetor.gerarVetorAleatorio(quantEl, inicioOuFim, porcentagem);

				insercao.ChamaInsertionSort(vetorAOrdenar, inicioOuFim, porcentagem, ordem);

				break;
			case "selection":
				selecao = new SelectionSort();
				break;
			case "quick":
				break;
			case "heap":
				break;
			case "merge":
				break;
			case "counting":
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
