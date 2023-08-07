package controle;
import modulo.*;

/**
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see empresa		vetor empresas
 * @see qtdEmp		quantidade de empresas
 */

public class ControleEmpresa {
	// vetor da Empresa
	
	private Empresa[] empresas ;
	
	//inteiro da quantidade de empresa
	private int qtdEmp ;
	
	/**
	 * Método que controla a empresa
	 * @param d		dados da Controle Dados
	 */
	
	public ControleEmpresa(ControleDados d) {
		empresas = d.getEmpresas();
		qtdEmp = d.getQtdEmpresas();
	}
	
	//get de empresa
	public Empresa[] getempresa() {
		return empresas;
	}
	
	//get quantidade de empresa
    public int getqtdEmp() {
    	return qtdEmp;
    }
    
    //get nome de empresas
    public String[] getNomeEmpresas() {
    	String[] b = new String[qtdEmp];
    	for(int i =0; i<qtdEmp;i++) {
    		b[i]=empresas[i].getNome();
    	}
    	return b;
    }
    
    //get posição de empresa
    public int getPosEmp(Empresa emp) {
    	for (int i = 0; i < qtdEmp; i++) {
    		if (empresas[i].equals(emp)) return i;
    	}
    	return -1;
    }
    /**
	 * Método que busca as empresas
	 * @param funcao	função é a empresa que o usuário pesquisou
	 * @return String
	 */
	public String[] buscaEmpresa(String funcao) {
		//vetor que vai receber as Empresas pesquisadas
		
        String [] a = new String[qtdEmp];
        int x = 0;
        for (int i = 0; i < qtdEmp; i++) {	
        	
        		//verifica se o nome da empresa é igual o nome pesquisado
               if (empresas[i].getNome().equals(funcao)) {
                   a[x] = funcao;
                   x++;
               }
               
            }
       
        return a;
    }
    
}
