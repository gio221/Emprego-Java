package Testes;

import modulo.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

/**
 * Classe que testa métodos
 */

public class Testes {
	
	//verifica se o CNPJ existe
	@Test
	public void testCheckCNPJ() {
		String cnpjcerto = "12345678000190";
	    assertTrue(Empresa.isValidoCNPJ(cnpjcerto));
	    String cnpjerrado = "12345678904";
        assertFalse(Empresa.isValidoCNPJ(cnpjerrado));
	}
	
	
	//verifica se o Telfone é válido ou inválido
	@Test
	public void testCheckTel () {
		String valorTelCorreto = "123" ;
		assertTrue ((Telefone.checkTel(valorTelCorreto)));
		String valorTelErrado = "xxx" ;
		assertFalse ((Telefone.checkTel(valorTelErrado)));
	}
	
	//verifica se a vaga tem sálario ou não
	@Test
	public void testeSalarioValido() {
		String valorSalario ="123";
		assertTrue((VagaInexperiente.salario(valorSalario)));
		String valorSalarioNao ="xxx1";
		assertFalse((VagaInexperiente.salario(valorSalarioNao)));
	}
	

	
}

