package auxiliar;

public class Imprimir {
	public void ImprimirVetor(int[] vetor) {
		System.out.print("Vetor resposta: ");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}
