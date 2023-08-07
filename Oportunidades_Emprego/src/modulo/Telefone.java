package modulo;

/**
 * Classe que monta o telefone de uma empresa
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see DDD			inteiro do ddd do telefone
 * @see numero 		numero do telefone
 */

public class Telefone {
	private int DDD;
    private long numero;

    /**
     * Método que junta o ddd e o numero formando o telefone.
     * @param DDD		ddd do telefone
     * @param numero	numero do telefone
     */
    
    public Telefone(int DDD, long numero) {
        this.DDD = DDD;
        this.numero = numero;
    }
    
    //retorna o DDD do telefone
    public int getDDD() {
        return DDD;
    }
    
    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    //retorna o numero do telefone
    public long getNumero() {
        return numero;
    }
    
    public void setNumero(long numero) {
        this.numero = numero;
    }

   
    /**
     * Método que verifica o telefone
     * @param valor		Váriavel que contem o valor digitado
     * @return boolean
     */
    
    public static boolean checkTel (String valor) {
    	if (valor.matches("[0 -9]+")) {
    		return true ;
    	}
    	
    	else {
    		return false ;
        }
    }
    
    
    @Override
    public String toString() {
        return "DDD: "+DDD+"\nNumero: "+numero;
    }
}
