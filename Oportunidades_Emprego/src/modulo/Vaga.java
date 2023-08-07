package modulo;

/**
 * Classe que cria as vagas 
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see funcao	   função das vagas
 * @see qtd		   quantidade de vagas
 * @see carga	   Carga horária da vaga
 * @see salario	   Salario de uma vaga 
 * @see emp		   empresa da vaga
 *
 */

public abstract class Vaga {
	protected String funcao;
    protected int qtd;
    protected int carga;
    protected double salario;
    protected Empresa emp;

    //get da função
    public String getFuncao() {
        return funcao;
    }
    
    public void setFuncao(String Funcao) {
        funcao = Funcao;
    }

    // get da quantidade de vagas
    public int getQtd() {
        return qtd;
    }
    
    public void setQtd(int Qtd) {
        qtd = Qtd;
    }

    //get do carga horária da função
    public int getCarga() {
        return carga;
    }
    		
    public void setCarga(int Carga) {
        carga = Carga;
    }

    //get do salario da vaga
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double Salario) {
        salario = Salario;
    }
    
    //get da Empresa da vaga
    public Empresa getEmpresa() {
    	return emp;
    }
    
    public void setEmpresa(Empresa emp) {
    	this.emp=emp;
    }
    
   
    /**
     * Método que verifica se tem uma vaga, retorna true se tiver uma vaga e false se não tiver.
     * @return boolean
     */
    
    public boolean equals(Object vg) {
    	if (vg != null && this.funcao == ((Vaga) vg).getFuncao() && this.qtd == ((Vaga) vg).getQtd()  && this.carga == ((Vaga) vg).getCarga() &&
    			this.salario == ((Vaga) vg).getSalario() && this.emp == ((Vaga) vg).getEmpresa()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
