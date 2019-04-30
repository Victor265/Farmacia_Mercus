package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Cliente;
import view.JanelaAlteraCliente;

public class AlterarCliente {
	Cliente cliente = new Cliente();

	public void alteraCliente(String cpf, String rg, String nome,
			String bairro, String cidade, String cep, 
			String logradouro, String numero, String complemento,
			 String tel1, String tel2,Connection conexao) {

	    cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setNome(nome);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setCep(cep);
		cliente.setLogradouro(logradouro);
		cliente.setNumero(numero);
		cliente.setComplemento(complemento);
		cliente.setTel1(tel1);
		cliente.setTel2(tel2);
		
		System.out.println("CPF: " + cpf);
		System.out.println("RG: " + rg);
		System.out.println("Nome: " + nome);
		System.out.println("Logrdouro: " + logradouro);
		System.out.println("Número: " + numero);
		System.out.println("Complemento: " + complemento);
		System.out.println("Bairro: " + bairro);
		System.out.println("Cidade: " + cidade);
		System.out.println("Cep: " + cep);
		System.out.println("Telefone Residencial: " + tel1);
		System.out.println("Telefone Celular/Comercial: " + tel2);

		try {

			PreparedStatement comando = conexao
					.prepareStatement("UPDATE CLIENTE SET RG=?, NOME=?, BAIRRO=?, CIDADE=?,CEP=?,"
							+ "LOGRADOURO=?, NUMERO=?, COMPLEMENTO=?,"
							+ " TEL1=?, TEL2=? WHERE CPF=?");
			comando.setString(1, cliente.getRg());
			comando.setString(2, cliente.getNome());
			comando.setString(3, cliente.getBairro());
			comando.setString(4, cliente.getCidade());
			comando.setString(5, cliente.getCep());
			comando.setString(6, cliente.getLogradouro());
			comando.setString(7, cliente.getNumero());
			comando.setString(8, cliente.getComplemento());
			comando.setString(9, cliente.getTel1());
			comando.setString(10, cliente.getTel2());
			comando.setString(11, cliente.getCpf());

			comando.executeUpdate();

			conexao.commit();

			comando.close();
			
			JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso");

		} catch (SQLException sqle) {
			System.out.println("Erro na Alteração" + sqle.getMessage());
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
