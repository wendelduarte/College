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
package sistemaEmpresaXYZ.entities;

public class Estagiario extends Colaborador{

	private double valeCoxinha;

	public Estagiario(int id, String nome, int departamento, double salario, double valecoxinha) {
		super(id, nome, departamento, salario);
		this.valeCoxinha = valecoxinha;
	}

	@Override
	public boolean hasAdicional() {
		return false;
	}
	
	@Override
	public void setAdicional(double novoPercentual) {
		System.out.println("Este tipo de colaborador não tem direito ao adicional"); //Como usuário não tem acesso à nenhum adicional apenas printa essa msg caso alguém tente utilizar o método		
	}
	
	@Override
	public double pagamento() {
		// Calcula o salário líquido
		return (salario + this.valeCoxinha);
	}
}