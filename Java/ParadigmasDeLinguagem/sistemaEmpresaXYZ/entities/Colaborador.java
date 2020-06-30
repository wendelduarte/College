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

/**
 * Classe abstrata de um colaborador da empresa
 */
public abstract class Colaborador {
	
	//Protected para somente suas subclasses serem capazes de acessar diretamente
	protected int id;
	protected String nome;
	protected int departamento;
	protected double salario;
	protected double previdencia; // Desconto fixo de um sistema de previdência da empresa
	
	//Construtor para colaboradores que possuem previdencia
	public Colaborador (int id, String nome, int departamento, double salario, double previdencia) {
		this.id = id;
		this.nome = nome;
		this.departamento = departamento;
		this.salario = salario;
		this.previdencia = previdencia;
	}
	
	//Construtor para colaboradores que não possuem previdencia
	public Colaborador (int id, String nome, int departamento, double salario) {
		this.id = id;
		this.nome = nome;
		this.departamento = departamento;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getDepartamento() {
		return departamento;
	}

	public double getSalario() {
		return salario;
	}

	public double getPrevidencia() {
		return previdencia;
	}
	
	/**
	 * Verifica se o colaborador possui adicional
	 * 
	 * @return true caso tenha e false caso não
	 */
	public abstract boolean hasAdicional();
	
	/**
	 * Para os usuários que possuem o adcional calcula o aumento do adicional
	 * @param novoPercentual
	 */
	public abstract void setAdicional(double novoPercentual);
	
	/**
	 * calcula o pagamento do colaborador
	 * @return retorna o salario + benefícios
	 */
	public abstract double pagamento();
	
	@Override
	public String toString() {
		return "Id: " + id + " - Nome: "+ nome + " - Salário: " + pagamento();
	}
}
