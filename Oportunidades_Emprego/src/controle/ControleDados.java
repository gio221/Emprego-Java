package controle;

import modulo.*;

/**
 * Classe que Controla os dados
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 */

public class ControleDados {
	//Cria uma váriavel que armazena os dados da Controle Dados
    private Dados d = new Dados();

    /**
     * Método que chama os dados da classe dados
     */
    public ControleDados() {
        d.fillWithSomeData();
    }

    //get de dados
    public Dados getDados() {
        return d;
    }

    public void setDados(Dados dado) {
        d = dado;
    }

    //get do vetor empresa
    public Empresa[] getEmpresas() {
        return d.getEmpresas();
    }

    //get vetor empresa por posição
    public Empresa getEmpresa(int pos) {
        return d.getEmpresa(pos);
    }

    //get quantidade de empresas
    public int getQtdEmpresas() {
        return d.getQtdEmpresas();
    }
    
    //get do vetor vagas experientes
    public VagaExperiente[] getVagasExp() {
        return d.getVagasExp();
    }
    
    //get do vetor vagas experientes por posição
    public VagaExperiente[] getVagasExp(int pos) {
        return d.getVagasExp(pos);
    }

    //get do vetor vagas inexperientes 
    public VagaInexperiente[] getVagasInxp() {
        return d.getVagasInxp();
    }

    //get do vetor vagas inexperientes por posição 
    public VagaInexperiente[] getVagasInxp(int pos) {
        return d.getVagasInxp(pos);
    }

    //get de quantidade de vagas experientes por posição
    public int getQtdVagasExp(int pos) {
        return d.getEmpresa(pos).getQtdVagaExp();
    }

    //get de quantidade de vagas inexperientes por posição
    public int getQtdVagasInxp(int pos) {
        return d.getEmpresa(pos).getQtdVagaInxp();
    }

    //get quantidade de vagas
    public int getQtdVagas() {
        int qtdTotal = 0;
        for (int i = 0; i < d.getQtdEmpresas(); i++) {
            qtdTotal += d.getEmpresa(i).getQtdVagaExp() + d.getEmpresa(i).getQtdVagaInxp();
        }

        return qtdTotal;
    }
    
    //get quantidade de vagas experientes 
    public int getQtdExp() {
    	int qtdExp = 0;
        for (int i = 0; i < d.getQtdEmpresas(); i++) {
            qtdExp += d.getEmpresa(i).getQtdVagaExp() ;
        }
        return qtdExp;
    }
    
    //get quantidade de vagas inexperientes 
    public int getQtdInxp() {
    	int qtdInxp = 0;
        for (int i = 0; i < d.getQtdEmpresas(); i++) {
            qtdInxp += d.getEmpresa(i).getQtdVagaInxp() ;
        }
        return qtdInxp;
    }

    /**
     * Método de editar empresa
     * @param novosDados	novos dados adicionados
     * @return boolean
     */
    
    public boolean inserirEditarEmpresa(String[] novosDados) {
    	//retorna false se não for inseridos nenhum dado
    	
        if (!novosDados[1].matches("[0-9]+") || !novosDados[3].matches("[0-9]+") || !novosDados[4].matches("[0-9]+")) {
            return false;
        } else {
        	//retorna true se for inseridos novos dados
        	
            Telefone newTel = new Telefone(Integer.parseInt(novosDados[3]), Integer.parseInt(novosDados[4]));
            Empresa emp = new Empresa(Long.parseLong(novosDados[1]), novosDados[2], newTel, 0, 0);
            d.inserirEditarEmpresa(Integer.parseInt(novosDados[0]), emp);
            return true;
        }
    }

    /**
     * Método de editar vaga
     * @param novosDados	novos dados editados
     * @param posEmp		posição de empresa
     * @param op			posição da vaga
     * @return  boolean
     */
    
    public boolean inserirEditarVaga(String[] novosDados, int posEmp, int op) {
    	
	    double dbl;
	    try {
	    	dbl = Double.parseDouble(novosDados[4]);
	    } catch (NumberFormatException e){
	    	return false;
	    }
	    
	    if (op == 1) {
	    	//retorna false se não for inseridos nenhum dado
	    	
	    	if (!novosDados[2].matches("[0-9]+") || !novosDados[3].matches("[0-9]+") || !novosDados[5].matches("[0-9]+")) {
    			return false;
    		} else {
    			//retorna true se for inseridos novos dados
    			
    			VagaExperiente vg = new VagaExperiente(novosDados[1], Integer.parseInt(novosDados[2]), Integer.parseInt(novosDados[3]), dbl,
    					Integer.parseInt(novosDados[5]), novosDados[6]);
    			
    			d.inserirEditarVagaExp(Integer.parseInt(novosDados[0]), posEmp, vg);
    			
    			return true;
    		}
    		
	    } else {
	    	
	    	//retorna false se não for inseridos nenhum dado
	    	if (!novosDados[2].matches("[0-9]+") || !novosDados[3].matches("[0-9]+") || !(novosDados[8] == "true" || novosDados[8] == "false")) {
    			return false;
    		} else {
    			    //retorna true se for inseridos novos dados
    			
        			VagaInexperiente vg = new VagaInexperiente(novosDados[1], Integer.parseInt(novosDados[2]), Integer.parseInt(novosDados[3]), dbl,
        					Boolean.parseBoolean(novosDados[7]), Boolean.parseBoolean(novosDados[8]));
        			
        			d.inserirEditarVagaInxp(Integer.parseInt(novosDados[0]), posEmp, vg);
        			
        			return true;
    		}
	    	
	    }
	    	
    }
    
    /**
     * Método que remove uma empresa
     * @param pos	posição da empresa
     * @return boolean
     */
    
    public boolean removerEmpresa(int pos) {
    	Empresa emp = d.getEmpresa(pos);
    	
    	d.removerEmpresa(pos);
    	
    	if (emp.equals(d.getEmpresa(pos))) {
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * Método que remove uma vaga 
     * @param posEmp		posição da empresa
     * @param pos			posição da vaga 
     * @param tipoVg		Se a vaga é experiente ou inexperiente 
     * @return boolean
     */
    
    public boolean removerVaga(int posEmp, int pos, int tipoVg) {
    	
    	//Se a vaga é experiente
    	
    	if (tipoVg == 1) {
    		VagaExperiente vg = d.getEmpresa(posEmp).getVagaExp(pos);
    		
    		d.removerVaga(posEmp, pos, tipoVg);
    		
    		if (vg.equals(d.getEmpresa(posEmp).getVagaExp(pos)) && vg != null) {
    			return false;
    		} else return true;
    		
    	} else {
    		//se a vaga é inexperiente
    		
    		VagaInexperiente vg = d.getEmpresa(posEmp).getVagaInxp(pos);
    		
    		d.removerVaga(posEmp, pos, tipoVg);
    		
    		if (vg.equals(d.getEmpresa(posEmp).getVagaInxp(pos))) {
    			return false;
    		} else return true;
    		
    	}
    	
    }
    
}