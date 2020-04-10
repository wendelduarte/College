import java.util.Scanner;

public class Cliente {

	public static final int VALOR_X = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double termos0[] = { 4, 3, -8, -6, 0, 3, 4 };
		double termos1[] = { 0, 3, -8, -6, 0, 3, 4 };
		double termos2[] = { 9, 0, -4, 2, 6, 0, -1 };
		double termos3[] = { -2, 3, 0, 2, 1 };
		double termos4[] = { -1, 2, 0, 1 };
		double termos5[] = { 2, -5, 0, 1 };

		Polinomio polinomio0 = new Polinomio(termos0.length, termos0);
		Polinomio polinomio1 = new Polinomio(termos1.length, termos1);
		Polinomio polinomio2 = new Polinomio(termos2.length, termos2);
		Polinomio polinomio3 = new Polinomio(termos3.length, termos3);
		Polinomio polinomio4 = new Polinomio(termos4.length, termos4);
		Polinomio polinomio5 = new Polinomio(termos5.length, termos5);

		StringBuilder menu = new StringBuilder();
		menu.append("0 - Sair\n").append("1 - Mostrar polinomio\n")
				.append("2 - Calcular valor do polinomio para X = " + VALOR_X + "\n")
				.append("3 - Calcular soma do polinomio\n").append("4 - Calcular multiplcacao de dois polinomios\n")
				.append("Escolha sua opção: ");

		exit_loop: while (true) {
			System.out.print(menu.toString());
			switch (sc.nextInt()) {
			case 0:
				break exit_loop;
			case 1:
				System.out.println("---------------------------");
				polinomio0.mostra();
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.println("---------------------------");
				System.out.println("\nCalcula polinomio para X = " + VALOR_X);
				System.out.println("Polinomio: " + polinomio5);
				System.out.println("P(" + VALOR_X + ") = " + polinomio5.calculaPolinomio(VALOR_X));
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println("---------------------------");
				System.out.println("\nPolinomio que serão somados: ");
				System.out.print("Polinomio 1: ");
				polinomio1.mostra();
				System.out.print("Polinomio 2: ");
				polinomio2.mostra();

				System.out.println("\nA soma é: " + polinomio1.soma(polinomio2));
				System.out.println("---------------------------");
				break;
			case 4:
				System.out.println("---------------------------");
				System.out.println("\n\nPolinomios que serão multiplicados: ");
				System.out.println("Polinomio 1: ");
				polinomio3.mostra();
				System.out.println("Polinomio 2: ");
				polinomio4.mostra();

				System.out.println("\nA multiplicação é" + polinomio3.multiplica(polinomio4));
				System.out.println("---------------------------");
				break;
			}
		}
		sc.close();
	}

}
