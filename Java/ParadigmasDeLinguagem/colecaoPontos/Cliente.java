package colecaoPontos;

import java.util.Scanner;

/*
Entrega da prova 1 - Paradigmas de Linguagens de Programação – 05N

Nós,
Roger Thencera Rojas, 31849571
Wendel Sergio Duarte Junior, 31811957

declaramos que todas as respostas são fruto de nosso próprio trabalho, 
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar
outros.
*/

public class Cliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder menu = new StringBuilder();
		menu.append("0 - Sair\n").append("1 - Adicionar um elemento no final da coleção\n")
				.append("2 - Adicionar um elemento em uma posição da coleção\n")
				.append("3 - Retornar o indíce da primeira ocorrência de um elemento especificado na coleção\n")
				.append("4 - Remover um elemento em uma posição na coleção\n")
				.append("5 - Calcular a distância dos dois pontos mais distantes na coleção\n")
				.append("6 - Retornar uma coleção de pontos contido em uma circunferência\n")
				.append("Escolha sua opção: ");

		System.out.print("Digite o tamanho da coleção de pontos: ");
		int tamanhoListaPonto = sc.nextInt();

		ListaPonto listaPonto = new ListaPonto(tamanhoListaPonto);
		int x = 0;
		int y = 0;
		int indice = 0;
		double raio = 0;
		Ponto ponto = null;

		exit_loop: while (true) {
			try {
				System.out.print(menu.toString());

				switch (sc.nextInt()) {
				case 0:
					break exit_loop;
				case 1:
					System.out.println();
					System.out.print("Digite o valor de X do ponto a ser adicionado: ");
					x = sc.nextInt();
					System.out.print("Digite o valor de Y do ponto a ser adicionado: ");
					y = sc.nextInt();
					ponto = new Ponto(x, y);
					listaPonto.addFinal(ponto);
					System.out.println();
					listaPonto.imprimeLista();
					System.out.println();
					break;
				case 2:
					System.out.println();
					System.out.print("Digite o valor de X do ponto a ser adicionado: ");
					x = sc.nextInt();
					System.out.print("Digite o valor de Y do ponto a ser adicionado: ");
					y = sc.nextInt();
					System.out.print("Digite o índice em que o ponto deve ser adicionado: ");
					indice = sc.nextInt();
					ponto = new Ponto(x, y);
					int posicaoAdicionada = listaPonto.addPosicaoEspecifica(ponto, indice);
					System.out.println("Elemento adicionado na posicao: " + posicaoAdicionada);
					System.out.println();
					listaPonto.imprimeLista();
					System.out.println();
					break;
				case 3:
					System.out.println();
					System.out.print("Digite o valor de X do ponto que irá buscar: ");
					x = sc.nextInt();
					System.out.print("Digite o valor de Y do ponto que irá buscar: ");
					y = sc.nextInt();
					ponto = new Ponto(x, y);
					int posicaoIndice = listaPonto.retornaIndiceOcorrencia(ponto);
					if (posicaoIndice >= 0) {
						System.out.println("O elemento está na posicao: " + posicaoIndice);
					} else {
						System.out.println("O elemento não está na coleção.");
					}
					System.out.println();
					break;
				case 4:
					System.out.print("Digite o indice da posição a ser removida: ");
					indice = sc.nextInt();
					listaPonto.remove(indice);
					System.out.println();
					System.out.println("Ponto removido com sucesso.");
					System.out.println();
					break;
				case 5:
					System.out.println();
					System.out.println("A distancia entre os pontos mais distantes é: " + listaPonto.calculaDistancia());
					System.out.println();
					break;
				case 6:
					System.out.print("Digite o valor de X do ponto: ");
					x = sc.nextInt();
					System.out.print("Digite o valor de Y do ponto: ");
					y = sc.nextInt();
					System.out.print("Digite o valor do raio: ");
					raio = sc.nextInt();
					ponto = new Ponto(x, y);
					ListaPonto pontosNaCircunferencia = listaPonto.pontoContidoCircunferencia(raio, ponto);
					System.out.println("Os pontos que estão dentro da circunferência são: ");
					System.out.println();
					pontosNaCircunferencia.imprimeLista();
					System.out.println();
					System.out.println();
					break;
				}
			} catch (Exception e) {
				System.out.println();
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
				System.out.println();
			}
		}

		sc.close();
	}
}
