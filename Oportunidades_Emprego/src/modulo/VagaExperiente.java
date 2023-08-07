package modulo;

/**
 * Classe que cria as vaga Experientes 
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see anosdeExp		Anos de Experiência que a vaga exige
 * @see prerequisito	Pré Requisito que a vaga exige
 */

public class VagaExperiente extends Vaga{
	private int anosdeExp;
    private String prerequisito;

    /**
     * Método que chama o contrutor da classe vaga
     */
    
    public VagaExperiente() {
        super();
    }

    /**
     * Método que cria a vaga experiente 
     * @param funcao		função da vaga experiente
     * @param carga			carga horária da vaga experiente
     * @param qtd			quantidade de vagas disponiveis
     * @param salario		salario da vaga 
     * @param anos			Anos de Experiência que a vaga exige
     * @param Prerequisito  Pré Requisito que a vaga exige
     */
    
    public VagaExperiente(String funcao, int carga, int qtd, double salario, int anos, String Prerequisito){
        this.funcao = funcao;
        this.qtd = qtd;
        this.carga = carga;
        this.salario = salario;
        anosdeExp = anos;
        prerequisito = Prerequisito;
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

    //get do carga horária da vaga
    public int getCarga() {
        return carga;
    }
    
    public void setCarga(int Carga) {
        carga = Carga;
    }

    //get do salário da vaga
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double Salario) {
        salario = Salario;
    }

    //get dos Anos de Experiência da vaga
    public int getAnosdeExp() {
        return anosdeExp;
    }
    
    public void setAnosdeExp(int Anos) {
        anosdeExp = Anos;
    }

    //get do Pré Requisito da vaga
    public String getPrerequisito() {
        return prerequisito;
    }
    
    public void setPrerequisito(String prereq) {
        prerequisito = prereq;
    }

    @Override
    public String toString() {
        return "Funcao: "+funcao+
                "\nQuantidade de vagas: "+qtd+
                "\nCarga Horaria: "+carga+" horas"+
                "\nSalario inicial: R$"+salario+
                "\nAnos de Experiancia na area: "+anosdeExp+
                "\nPrerequisitos: "+prerequisito;
    }
}
