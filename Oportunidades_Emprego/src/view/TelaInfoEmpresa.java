package view;
import controle.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Classe da Tela Informações de Empresa
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.1
 * @see CNPJ			CNPJ da empresa
 * @see nome			Nome da empresa
 * @see ddd				ddd da empresa
 * @see numero			numero da empresa
 * @see qtdVagas		quantidade de vagas da empresa
 */

public class TelaInfoEmpresa implements ActionListener {
	private JFrame janela = new JFrame("Informacao da Empresa");
	private JLabel labelCNPJ = new JLabel("CNPJ: ");
	private JTextField cnpj = new JTextField();
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField nome = new JTextField();
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField ddd = new JTextField();
	private JTextField numero = new JTextField();
	private JLabel labelQtdVagas = new JLabel("Quantidade de Vagas: ");
	private JLabel qtdVagas = new JLabel();
	private JButton botaoVagas = new JButton("Vagas");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoExcluir = new JButton("Excluir Empresa");
	private String[] novosDados = new String[6];
	private static ControleDados dados;
	private int posi;
	
	/**
	 * Método que monstra a tela Info Empresa
	 * @param d		os dados da Controle Dados
	 * @param posi  posição da empresa
	 */
	
	public void mostrarInfoEmpresa(ControleDados d , int posi) {
		dados = d;
		this.posi = posi;
		
		//determina o tamanho da janela
		janela.setSize(500, 350);
		janela.setLayout(null);
		
		//determina o tamanho de cada texto na janela
		labelCNPJ.setBounds(100, 50, 50, 20);
		cnpj.setBounds(240, 50, 150, 20);
		labelNome.setBounds(100, 80, 150, 20);
		nome.setBounds(240, 80, 150, 20);
		labelTelefone.setBounds(100, 110, 150, 20);
		ddd.setBounds(240, 110, 40, 20);
		numero.setBounds(285, 110, 105, 20);
		labelQtdVagas.setBounds(100, 140, 200, 20);
		qtdVagas.setBounds(240,140 , 150, 20);	
		
		//determina as informações da empresa
		if (posi < dados.getQtdEmpresas()) {
			
			cnpj.setText(String.valueOf(dados.getEmpresa(posi).getCNPJ()));
			nome.setText(dados.getEmpresa(posi).getNome());
			ddd.setText(String.valueOf(dados.getEmpresa(posi).getTelefone().getDDD()));
			numero.setText(String.valueOf(dados.getEmpresa(posi).getTelefone().getNumero()));
			qtdVagas.setText(String.valueOf(dados.getEmpresa(posi).getQtdVagaExp()+dados.getEmpresa(posi).getQtdVagaInxp()));
			
			botaoVagas.setBounds(250, 200, 130, 30);
			botaoExcluir.setBounds(180, 240, 130, 30);
			botaoSalvar.setBounds(110, 200, 130, 30);
			
			janela.add(botaoExcluir);
			janela.add(botaoVagas);
			
		} else {
			
			labelQtdVagas.setVisible(false);
			botaoSalvar.setBounds(180, 160, 130, 30);
		
		}
		
		//adiciona todos textos na janela
		janela.add(labelCNPJ);
		janela.add(labelNome);
		janela.add(labelTelefone);
		janela.add(labelQtdVagas);
		janela.add(cnpj);
		janela.add(nome);
		janela.add(ddd);
		janela.add(numero);
		janela.add(qtdVagas);
		janela.add(botaoSalvar);
		
		janela.setVisible(true);
		
		//adiciona o botão editar e Vagas na janela
		botaoSalvar.addActionListener(this);
		botaoVagas.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}
		
	/**
	 * Método que monstra em que o usuário clicou e determina o que vai acontecer na tela 
	 */
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		boolean save;
		
		//Oque acontece quando o usuário clica no botão salvar
		
		if (src == botaoSalvar){
			
			novosDados[0] = String.valueOf(posi);
			novosDados[1] = cnpj.getText();
			novosDados[2] = nome.getText();
			novosDados[3] = ddd.getText();
			novosDados[4] = numero.getText();
			novosDados[5] = qtdVagas.getText();
			
			//chama a função inserir e editar empresa
			
			save = dados.inserirEditarEmpresa(novosDados);
			
			if (save) mensagemSucessoCadastro();
			
		}
		
		//Oque acontece quando o usuário clica no botão vagas
		
		if (src == botaoVagas){
			
			janela.dispose();
			new TelaListaVagas().mostrarVagas(dados, 1, posi);
			
		}
		
		//Oque acontece quando o usuário clica no botão excluir
		
		if (src == botaoExcluir) {
			
			save = false;
			
			save = dados.removerEmpresa(posi);
			
			if (save) {
				
				mensagemSucessoExclusao();
				
			} else {
				
				
				
			}
			
		}
	}
		
	/**
	 * Método que monstra uma mensagem de Sucesso se os dados forem cadastrados
	 */
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram Cadastrados com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Método que monstra uma mensagem de Sucesso se a empresa for excluida
	 */
	
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "A Empresa foi excluida com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Método que monstra uma mensagem de Erro se der erro no cadastro
	 */
	
	public void mensagemErroCadastro() {
		
		JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!\n"
				+ "Pode ter ocorrido um ou mais erros a seguir:\n"
				+ "1. Nem todos os campos foram preenchidos\n"
				+ "2. Os campos do CPF e telefone nao possuem somente numeros\n", null,
				JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	/**
	 * Método que monstra uma mensagem caso ocorra erro de exclusão
	 */
	
	public void mensagemErroExclusao() {
		
		JOptionPane.showMessageDialog(null, "Ocorreu um erro ao exlcuir a Empresa!", null, JOptionPane.INFORMATION_MESSAGE);
		
	}
}
