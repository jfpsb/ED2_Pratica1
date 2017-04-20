package programa;

import java.util.Scanner;

import algoritmos.sort.insertion.InsertionSort;
import algoritmos.sort.selection.SelectionSort;
import auxiliar.GerarVetor;
import auxiliar.Imprimir;

public class AtividadePratica1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		GerarVetor gerarVetor = new GerarVetor();
		InsertionSort insercao;
		SelectionSort selecao;
		
		int vetorAOrdenar[];
		String consulta;
		String[] consultaRepartida;

		System.out.println("Informe a string de consulta: ");
		consulta = scan.next();		

		consultaRepartida = consulta.split(" ");

		switch (consultaRepartida[0]) {
		case "INSERTION":
			insercao = new InsertionSort();
			
			break;
		case "SELECTION":
			selecao = new SelectionSort();
			break;
		case "QUICK":
			break;
		case "HEAP":
			break;
		case "MERGE":
			break;
		case "COUNTING":
			break;
		default:
			System.out.println("Você digitou um algoritmo de ordenação inválido.");
			break;
		}
		
		scan.close();
	}

}
