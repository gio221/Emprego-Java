package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controle.*;

/**
 * Classe da Tela Informações de Vaga
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see funcao	   		 função das vagas
 * @see cargaHoraria	 Carga horária da vaga
 * @see qtd		   		 quantidade de vagas
 * @see salario	   		 Salario de uma vaga 
 * @see anosdeExp		 Anos de Experiência que a vaga pede
 * @see preRequisitos	 Pré Requisito da vaga
 * @see remunerado		 Se a vaga é remunerada ou não
 * @see estagio			 Se a vaga é estágio ou não
 */

public class TelaInfoVaga implements ActionListener {
	private JFrame janela = new JFrame("Informacao da Vaga");
	private JLabel empresa = new JLabel();
	private JLabel labelFuncao = new JLabel("Funcao: ");
	private JTextField funcao = new JTextField();
	private JLabel labelCargahoraria = new JLabel("Carga Horaria: ");
	private JTextField cargaHoraria = new JTextField();
	private JLabel labelQuantidade = new JLabel("Quantidade: ");
	private JTextField quantidade = new JTextField();
	private JLabel labelSalario = new JLabel("Salario: ");
	private JTextField salario = new JTextField();
	private JLabel labelAnosdeExp = new JLabel("Anos de Experiencia: ");
	private JTextField anosdeExp = new JTextField();
	private JLabel labelPreRequisitos = new JLabel("Pre-Requisitos: ");
	private JTextField preRequisitos = new JTextField();
	private JLabel labelRemunerado = new JLabel("Remunerado: ");
	private JRadioButton remunerado1 = new JRadioButton("Sim");
	private JRadioButton remunerado2 = new JRadioButton("Nao");
	private JLabel labelEstagio = new JLabel("Estagio: ");
	private JRadioButton estagio1 = new JRadioButton("Sim");
	private JRadioButton estagio2 = new JRadioButton("Nao");
	private JRadioButton exp = new JRadioButton("Experiente");
	private JRadioButton inxp = new JRadioButton("Inexperiente");
	private JLabel tipoVg = new JLabel("Tipo de Vaga a ser cadastrada:");
	private JButton botaoContinuar = new JButton("Continuar");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoExcluir = new JButton("Excluir Vaga");
	private ButtonGroup grupo1 = new ButtonGroup();
	private ButtonGroup grupo2 = new ButtonGroup();	
	private ButtonGroup grupo3 = new ButtonGroup();
	private String[] novosDados = new String[9];
	private static ControleDados dados;
	private int posi; 
	private int posEmp;
	private int  opc;
	
	/**
	 * Método que monstra a tela Info Vaga 
	 * @param opc		de que tela o usuário está vindo
	 * @param d			dados da Controle Dados
	 * @param posEmp	posição da empresa
	 * @param posi		posição da vaga
	 */
	
	public void mostrarInfoVaga(int opc, ControleDados d , int posEmp, int posi) {
		
		dados = d;
		this.posi = posi;
		this.posEmp = posEmp;
		this.opc = opc;
		
		if (posEmp == -1) {
			
			ControleVagas vgs = new ControleVagas(dados);
			this.posEmp = vgs.getPosEmp(dados, posi);
			this.posi = vgs.getPosVg(dados, this.posEmp, this.posi);
			
			if (posi < vgs.getQtdExp()) {
				this.opc = 1;
			} else this.opc = 2;
			
		}
		
		switch(this.opc) {
		
			//Vaga experiente
			case 1 : 
				janela.setSize(500, 350);
				janela.setLayout(null);
				
				empresa.setBounds(220, 20, 150, 20);
				empresa.setText(dados.getEmpresa(this.posEmp).getNome());
				
				labelFuncao.setBounds(100, 50, 150, 20);
				labelCargahoraria.setBounds(100, 80, 150, 20);
				labelQuantidade.setBounds(100, 110, 150, 20);
				labelSalario.setBounds(100, 140, 150, 20);
				labelAnosdeExp.setBounds(100, 170, 200, 20);
				labelPreRequisitos.setBounds(100,200 ,200 , 20);
				
				funcao.setBounds(240, 50, 150, 20);
				cargaHoraria.setBounds(240, 80, 150, 20);
				quantidade.setBounds(240, 110, 150, 20);
				salario.setBounds(240,140 , 150, 20);
				anosdeExp.setBounds(240, 170, 150, 20);
				preRequisitos.setBounds(240, 200, 150, 20);
				
				
				if (this.posi < dados.getEmpresa(this.posEmp).getQtdVagaExp()) {
					
					funcao.setText(dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getFuncao());
					cargaHoraria.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getCarga())));
					quantidade.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getQtd())));
					salario.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getSalario())));
					anosdeExp.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getAnosdeExp())));
					preRequisitos.setText(dados.getEmpresa(this.posEmp).getVagaExp(this.posi).getPrerequisito());
					
					botaoSalvar.setBounds(250, 230, 130, 30);
					botaoExcluir.setBounds(110, 230, 130, 30);
					
					janela.add(botaoExcluir);
					
				} else {
					
					botaoSalvar.setBounds(190, 230, 130, 30);
					
				}
				
				janela.add(empresa);
				janela.add(labelFuncao);
				janela.add(labelCargahoraria);
				janela.add(labelQuantidade);
				janela.add(labelSalario);
				janela.add(labelAnosdeExp);
				janela.add(labelPreRequisitos);
				janela.add(funcao);
				janela.add(cargaHoraria);
				janela.add(quantidade);
				janela.add(salario);
				janela.add(anosdeExp);
				janela.add(preRequisitos);
				janela.add(botaoSalvar);
				
				
				
				janela.setVisible(true);
				
				botaoSalvar.addActionListener(this);
				botaoExcluir.addActionListener(this);
				
				break;
				
			//Vaga inexperiente
			case 2:
				
				janela.setSize(500, 350);
				janela.setLayout(null);
				
				empresa.setBounds(220, 20, 150, 20);
				empresa.setText(dados.getEmpresa(this.posEmp).getNome());
				
				labelFuncao.setBounds(100, 50, 150, 20);
				labelCargahoraria.setBounds(100, 80, 150, 20);
				labelQuantidade.setBounds(100, 110, 150, 20);
				labelSalario.setBounds(100, 140, 150, 20);
				labelRemunerado.setBounds(100, 170, 200, 20);
				labelEstagio.setBounds(100,200 ,200 , 20);
				
				salario.setBounds(240,140 , 150, 20);
				quantidade.setBounds(240, 110, 150, 20);
				cargaHoraria.setBounds(240, 80, 150, 20);
				funcao.setBounds(240, 50, 150, 20);
				
				remunerado1.setBounds(240, 170, 60, 20);
				remunerado2.setBounds(310, 170, 60, 20);
				
				grupo1.add(remunerado1);
				grupo1.add(remunerado2);
				
				estagio1.setBounds(240, 200, 60, 20);
				estagio2.setBounds(310, 200, 60, 20);
				
				grupo2.add(estagio1);
				grupo2.add(estagio2);
				
			    if (this.posi < dados.getEmpresa(this.posEmp).getQtdVagaInxp()) {
			    	
			    	if (dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getRemunerado()) {
				    	
				    	remunerado1.setSelected(true);
				    	
				    } else {
				    	
				    	remunerado2.setSelected(true);
				    	
				    }
				    
					 if(dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getEstagio()) {
						 
					    	estagio1.setSelected(true);
					    	
					    } else {
					    	
					    	estagio2.setSelected(true);
					    	
					    }
					 
					funcao.setText(dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getFuncao());
					cargaHoraria.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getCarga())));
					quantidade.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getQtd())));
					salario.setText(String.valueOf((dados.getEmpresa(this.posEmp).getVagaInxp(this.posi).getSalario())));
					
					botaoSalvar.setBounds(250, 230, 130, 30);
					botaoExcluir.setBounds(110, 230, 130, 30);
					
					janela.add(botaoExcluir);
			    	
			    } else {
			    	
			    	botaoSalvar.setBounds(190, 230, 130, 30);
			    	
			    }
				
			    janela.add(empresa);
				janela.add(labelFuncao);
				janela.add(labelCargahoraria);
				janela.add(labelQuantidade);
				janela.add(labelSalario);
				janela.add(labelRemunerado);
				janela.add(labelEstagio);
				janela.add(funcao);
				janela.add(cargaHoraria);
				janela.add(quantidade);
				janela.add(salario);
				janela.add(remunerado1);
				janela.add(remunerado2);
				janela.add(estagio1);
				janela.add(estagio2);
				janela.add(botaoSalvar);
				
				janela.setVisible(true);
				
				botaoSalvar.addActionListener(this);
				botaoExcluir.addActionListener(this);
				
				break;
				
			default: 
				JOptionPane.showMessageDialog(null,"Opcao nao encontrada!", null, 
						JOptionPane.ERROR_MESSAGE);
		
		}
	}
	
	/**
	 * Método de Cadastro da vaga
	 * @param d			Chama os dados da Controle Dados
	 * @param posEmp	Posição da Empresa
	 */
	
	public void tipoVagaCadastro(ControleDados d, int posEmp) {
		
		dados = d;
		this.posEmp = posEmp;
		
		janela.setSize(300, 200);
		janela.setLayout(null);
		
		tipoVg.setBounds(50, 10, 200, 30);
		exp.setBounds(90, 40, 100, 20);
		inxp.setBounds(90, 70, 100, 20);
		botaoContinuar.setBounds(90, 110, 100, 30);
		
		grupo3.add(exp);
		grupo3.add(inxp);
		
		janela.add(tipoVg);
		janela.add(exp);
		janela.add(inxp);
		janela.add(botaoContinuar);
		
		janela.setVisible(true);
		
		botaoContinuar.addActionListener(this);
		
	}

	/**
	 * Método que monstra em que o usuário clicou e determina o que vai acontecer na tela 
	 */
		
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//botão que salva novos dados
		if (src == botaoSalvar) {

			boolean save;
			
			novosDados[0] = Integer.toString(posi);
			novosDados[1] = funcao.getText();
			novosDados[2] = cargaHoraria.getText();
			novosDados[3] = quantidade.getText();
			novosDados[4] = salario.getText();
				
			if (opc == 1) {
					
				novosDados[5] = anosdeExp.getText();
				novosDados[6] = preRequisitos.getText();
					
			} else {
					
				if (remunerado1.isSelected() && (remunerado1.isSelected() || remunerado2.isSelected())) {
						
					novosDados[7] = "true";
						
				} else novosDados[7] = "false";
					
				if (estagio1.isSelected() && (estagio1.isSelected() || estagio2.isSelected())) {
						
					novosDados[8] = "true";
						
				} else novosDados[8] = "false";
					
			}
				
			save = dados.inserirEditarVaga(novosDados, posEmp, opc);
			
			if (save) {
					
				mensagemSucessoCadastro();
				janela.dispose();
				
			} else {
				
				mensagemErroCadastro();
				
			}
			
		}
		
		//botão que continua
		if (src == botaoContinuar) {
			
			if (exp.isSelected()) {
				
				janela.dispose();
				new TelaInfoVaga().mostrarInfoVaga(1, dados, posEmp, dados.getEmpresa(posEmp).getQtdVagaTotal());
				
			} else if (inxp.isSelected()) {
				
				janela.dispose();
				new TelaInfoVaga().mostrarInfoVaga(2, dados, posEmp, dados.getEmpresa(posEmp).getQtdVagaTotal());
				
			} else {
				
				JOptionPane.showMessageDialog(null, "E necessario selecionar um tipo de Vaga!", null, JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		
		//botão que exclui
		if (src == botaoExcluir) {
			
			boolean exc;
			
			exc = dados.removerVaga(posEmp, posi, opc);
			
			if (exc) {
				
				mensagemSucessoExclusao();
				
			} else {
				
				mensagemErroExclusao();
				
			}
		}
	}
	
	/**
	 * Método que monstra uma mensagem de Suceesso se os dados forem salvos 
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Método que monstra uma mensagem de Erro se der erro no cadastro
	 */
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!\n"
				+ "Pode ter ocorrido um ou mais erros a seguir:\n"
				+ "1. Nem todos os campos foram preenchidos\n"
				+ "2. Os campos da Carga Horaria, Quantidade,"
				+ " Salario ou Anos de Experiencia nao sao compostos apenas por numeros\n", null,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Método que monstra uma mensagem de Sucesso se a empresa for excluida
	 */
	
	public void mensagemSucessoExclusao() {
		
		JOptionPane.showMessageDialog(null, "Vaga excluida com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
		
	}
	
	/**
	 * Método que monstra uma mensagem caso ocorra erro de exclusão
	 */
	
	public void mensagemErroExclusao() {
		
		JOptionPane.showMessageDialog(null, "Erro ao excluir a Vaga!", null, JOptionPane.INFORMATION_MESSAGE);
		
	}
	

}
