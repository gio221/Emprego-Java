package controle;
import modulo.*;

/**
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see empresa				empresa da vaga
 * @see vagaExperiente		vagas experientes da empresa
 * @see vagaInexperiente	vagas inexperientes da empresa
 * @see qtdexp				quantidade de vagas experientes na empresa
 * @see qtdinexp			quantidade de vagas inexperientes na empresa
 * @see qtdVagas			quantidade totais de vagas na empresa
 */

public class ControleVagas {
    private Empresa emp;
    private VagaExperiente[] exp;
    private VagaInexperiente[] inexp;
    private int qtdexp;
    private int qtdinexp;
    private int qtdVagas;
    
    /**
     * Método que Controla as Vagas
     * @param d    pegam os dados da Controle Dados
     */
    
	public ControleVagas(ControleDados d) {
		exp = d.getVagasExp();
		inexp = d.getVagasInxp();
		qtdexp = d.getQtdExp();
		qtdinexp = d.getQtdInxp();
		qtdVagas = d.getQtdVagas();
	}
	
	/**
	 * Método que Controla as Vagas pela sua posição
	 * @param d			dados do Controle Dados
	 * @param posi		posição das vagas
	 */
	
	public ControleVagas(ControleDados d,int posi) {
		emp = d.getEmpresa(posi);
		exp = d.getVagasExp(posi);
		inexp = d.getVagasInxp(posi);
		qtdexp = d.getQtdVagasExp(posi);
		qtdinexp = d.getQtdVagasInxp(posi);
		qtdVagas = d.getEmpresa(posi).getQtdVagaTotal();
	}
	
	//get vaga experientes
	public VagaExperiente[] getVagasExperientes() {
		return exp;
	}
	
	//get vagas inexperientes
	public VagaInexperiente[] getVagasInexperientes() {
		return inexp;
	}
	
	//get quantidade de vagas experientes  
	public int getQtdExp() {
		return qtdexp;
	}
	
	//quantidade de vagas inexperientes 
	public int getQtdInexp() {
		return qtdinexp;
	}
	
	//get nome da empresa
	public String getNomeEmp() {
		return emp.getNome();
	}
	
	//get função da vaga
	public String[] getFuncVagas(){
		String[] a = new String[qtdVagas];
		int x = 0;
		
		for(int i = 0; i < qtdexp;i++) {
			a[x] = exp[i].getFuncao();
			x++;
		}
		
		for(int i = 0; i < qtdinexp; i++) {
			a[x] = inexp[i].getFuncao();
			x++;
		}
		
		return a;
	}
	
	//get empresa da vaga  
	public Empresa getEmpresaVaga(int pos) {
		
		if(pos<qtdexp) {
			return exp[pos].getEmpresa();
		}
		else {
			return inexp[pos-qtdexp].getEmpresa();
		}
		
	}
	
	//get posição da empresa
	public int getPosEmp(ControleDados d, int pos) {
		Empresa emp = getEmpresaVaga(pos);
		
		for(int i = 0; i < d.getQtdEmpresas(); i++) {
			if(emp.equals(d.getEmpresa(i))) return i;
		}
		
		return -1;
	}
	
	//get posição da vaga
	public int getPosVg(ControleDados d, int posEmp, int posVgTotal) {
		
		if (posVgTotal < qtdexp) {
			
			for (int i = 0; i < d.getEmpresa(posEmp).getQtdVagaExp(); i++) {
				if (exp[posVgTotal].equals(d.getEmpresa(posEmp).getVagaExp(i))) return i;
			}
			
		} else {
			
			for (int i = 0; i < d.getEmpresa(posEmp).getQtdVagaInxp(); i++) {
				if (inexp[posVgTotal-qtdexp].equals(d.getEmpresa(posEmp).getVagaInxp(i))) return i;
			}
			
		}
		
		return -1;
	}
	
	/**
	 * Método que busca as vagas 
	 * @param funcao	função é a vaga que o usuário pesquisou
	 * @return String
	 */
	
	public String[] buscaVaga(String funcao) {
		//vetor que vai receber as vagas experiente pesquisadas
		
        String [] a = new String[qtdVagas];
        int x = 0;
        
        for (int i = 0; i < qtdexp; i++) {	
        	
        		//verifica se a vaga é igual a vaga experiente pesquisada 
               if (exp[i].getFuncao().equals(funcao)) {
                   a[x] = funcao;
                   x++;
               }
               
            }
          
      //vetor que vai receber as vagas inexperiente pesquisadas
        for (int i = 0; i < qtdinexp; i++) {
        	
        		//verifica se a vaga é igual a vaga inexperiente pesquisada 
                if(inexp[i].getFuncao().equals(funcao)) {
                    a[x] = funcao;
                    x++;
                }
                
            }
           
        return a;
    }
	
	/**
	 * Método que busca vaga por posição
	 * @param funcao 	função é a vaga que o usuário pesquisou
	 * @return
	 */
	
	public int[] buscaPosVg(String funcao) {
		int[] pos = new int[qtdVagas+1];
		pos[0] = 0;
		int x = 1;
		
		 for (int i = 0; i < qtdexp; i++) {	
	        	
             if (exp[i].getFuncao().equals(funcao)) {
                 pos[x] = i;
                 pos[0]++;
                 x++;
             }
             
          }
        
      for (int i = 0; i < qtdinexp; i++) {
      	
              if(inexp[i].getFuncao().equals(funcao)) {
                  pos[x] = i + qtdexp;
                  x++;
              }
              
          }
      
      return pos;
	}
	
}
