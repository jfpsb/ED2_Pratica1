package auxiliar;

import algoritmos.dados.OrdenacaoDados;

public class Imprimir {
	public static void ImprimirVetor(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}

	public static void ImprimeResultado(double tempoTotal, int vetor[], OrdenacaoDados ordenacao) {
		System.out.println("Algoritmo executado: " + ordenacao.getNome());
		System.out.println("Quantidade de elementos em vetor: " + vetor.length);
		if(ordenacao.getPivo() != 0) {
			System.out.println("O piv� utilizado foi o elemento do(a): " + pivoString(ordenacao.getPivo()));
		}
		System.out.println("Ordena��o " + ((ordenacao.getOrdem() == 'c') ? "ascendente" : "descendente"));
		System.out.println(
				ordenacao.getPorcentagem() + "% " + ((ordenacao.getInicioFimOrdenados() == 'i') ? "iniciais" : "finais") + " do vetor j� ordenados");
		System.out.println("A ordena��o durou um tempo total de: " + (tempoTotal / 1000) + " segundo(s)");
		System.out.println("O n�mero de compara��es executadas foi: " + ordenacao.getNumeroComparacoes());
		System.out.println("O n�mero de atribui��es foi: " + ordenacao.getNumeroAtribuicoes());
	}
	
	private static String pivoString(char pivo) {
		if(pivo == 'p') {
			return "esquerda";
		} else if(pivo == 'm'){
			return "meio";
		}
		
		return "direita";
	}
}
