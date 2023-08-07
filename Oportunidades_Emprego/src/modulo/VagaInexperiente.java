package modulo;

/**
 * Classe que cria as vagas inexperientes
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see estagio
 * @see remunerado
 */

public class VagaInexperiente extends Vaga{
	private boolean estagio;
    private boolean remunerado;

    /**
     * Método que chama o contrutor da classe vaga
     */
    
    public VagaInexperiente() {
        super();
    }

    /**
     * Método que cria a vaga inexperiente
     * @param funcao		função da vaga experiente
     * @param carga			carga horária da vaga experiente
     * @param qtd			quantidade de vagas disponiveis
     * @param salario		salario da vaga 
     * @param remunerado	Se a vaga é remunerada ou não
     * @param estagio       Se a vaga é estágio ou não
     */
    
    public VagaInexperiente(String funcao, int carga, int qtd, double salario, boolean remunerado, boolean estagio){
        this.funcao = funcao;
        this.qtd = qtd;
        this.carga = carga;
        this.salario = salario;
        this.estagio = estagio;
        this.remunerado = remunerado;
    }

     //get da função da vaga
    public String getFuncao() {
        return funcao;
    }
    
    public void setFuncao(String Funcao) {
        funcao = Funcao;
    }

    //get da quantidade de vaga
    public int getQtd() {
        return qtd;
    }
    
    public void setQtd(int Qtd) {
        qtd = Qtd;
    }

    //get qual carga horária da vaga
    public int getCarga() {
        return carga;
    }
    
    public void setCarga(int Carga) {
        carga = Carga;
    }

    //get salario da vaga
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double Salario) {
        salario = Salario;
    }

    //get se é estagio ou não a vaga
    public boolean getEstagio() {
        return estagio;
    }
    
    public void setEstagio(boolean est) {
        estagio = est;
    }
    
    //get se é remunerado ou não a vaga
    public boolean getRemunerado() {
        return remunerado;
    }
    
    public void setRemunerado(boolean rem) {
        remunerado = rem;
    }
    
    /**
     * Método que verifica se a vaga tem salario
     * @param valor		variavel teste
     * @return boolean
     */
    
    public static boolean salario(String valor) {
    	if(valor.matches("[0 -9]+")){
    		return true;
    	}else {
    		return false;
    	}
    }
    
    @Override
    public String toString() {
        return "Funcao: "+funcao+
                "\nQuantidade de vagas: "+qtd+
                "\nCarga Horaria: "+carga+" horas"+
                "\nSalario inicial: R$"+salario+
                "\nEstagio: "+estagio+
                "\nRemunerado: "+remunerado;
    }
}
