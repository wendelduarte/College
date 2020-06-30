/*

Entrega de trabalho - Sistema Empresa XYZ

Nós,

Wendel Sergio Duarte Junior

Roger Thencera Rojas

declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos à equipe e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/
package sistemaEmpresaXYZ;

import java.util.Locale;
import java.util.Scanner;

import sistemaEmpresaXYZ.entities.Empresa;
import sistemaEmpresaXYZ.entities.Estagiario;
import sistemaEmpresaXYZ.entities.Funcionario;
import sistemaEmpresaXYZ.entities.Presidente;

public class Program {
	
	public static void clearScreen() {
		System.out.flush();
	}

	public static void main(String[] args) {	
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Empresa empresa = new Empresa();
		
		StringBuilder menu = new StringBuilder();
		menu.append("0 - Sair\n").append("1 - Adicionar colaborador\n")
				.append("2 - Calcular pagamento de um colaborador\n")
				.append("3 - Aumentar o adicional de todos os colaboradores que tem direito\n").append("4 - Gerar relatório dos colaboradores\n")
				.append("Escolha sua opção: ");

		exit_loop: while (true) {
			System.out.print(menu.toString());
			switch (sc.nextInt()) {
			case 0:
				break exit_loop;
			case 1:
				sc.nextLine();
				System.out.println();
				boolean resultado = false;
				System.out.print("Digite o tipo de colaborador que deseja adicionar a empresa (E/F/P): ");
				String tipoColaborador = sc.nextLine().toUpperCase();
				
				System.out.print("Digite o id do colaborador: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Digite o nome do colaborador: ");
				String nome = sc.nextLine();
				
				System.out.print(("Digite o departamento do colaborador: "));
				int departamento = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Digite o salário do colaborador: ");
				double salario = sc.nextDouble();
				
				if(tipoColaborador.equals("E")) {
					System.out.print("Digite o vale coxinha do estagiário: ");
					double valeCoxinha = sc.nextDouble();
					resultado = empresa.addColaboradores(new Estagiario(id, nome, departamento, salario, valeCoxinha));
				
				} else if(tipoColaborador.equals("F")) {
					System.out.print("Digite o adicional do funcionário: ");
					double adicional = sc.nextDouble();
					resultado = empresa.addColaboradores(new Funcionario(id, nome, departamento, salario, adicional/100));
				
				} else if(tipoColaborador.equals("P")) {
					resultado = empresa.addColaboradores(new Presidente(id, nome, departamento, salario));
				} else {
					System.out.println("Tipo de usuário inválido, retornando para o menu.");
				}
				
				if(resultado) {
					System.out.println("\nColaborador adicionado com sucesso!");
				} else {
					System.out.println("\nFalha ao adicionar novo colaborador! Tente denovo.");
				}
				
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.println();
				System.out.print("Digite o nome id do colaborador que deseja verificar o pagamento: ");
				int idParaConsulta = sc.nextInt();
				sc.nextLine();
				
				double pagamento = empresa.calculaPagamentoColaborador(idParaConsulta);
				if(pagamento > 0.0) {
					System.out.println("O pagamento do usuário consultado é: " + pagamento);
				} else {
					System.out.println("Erro ao calcular o pagamento do funcionário");
				}
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println();
				System.out.print("Digite a percentegem de aumento do adicional para os colaboradores: ");
				int percentualAumento = sc.nextInt();
				sc.nextLine();
				
				boolean resultadoAumento = false;
				
				resultadoAumento = empresa.aumentaAdicional(percentualAumento);
				
				if(resultadoAumento) {
					System.out.println("Adicional foi aumentado com sucesso!");
				} else {
					System.out.println("Falha em aumentar o adicional dos usuários.");
				}
				System.out.println("---------------------------");
				break;
			case 4:
				System.out.println();
				System.out.println(empresa);
				System.out.println("---------------------------");
				break;
			}
		}
		sc.close();
	}
}
