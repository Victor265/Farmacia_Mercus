package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cliente;

public class CadastraCliente {
	private Cliente cliente = new Cliente();
	
	public void cadastrarCliente(String cpf, String rg, String nome,
			String bairro, String cidade, String cep, 
			String logradouro, String numero, String complemento,
			String tel1, String tel2, Connection conexao) {

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
		System.out.println("Bairro: " + bairro);
		System.out.println("Cidade: " + cidade);
		System.out.println("Cep: " + cep);
		System.out.println("Logradouro: " + logradouro);
		System.out.println("Número: " + numero);
		System.out.println("Complemento: " + complemento);
		System.out.println("Telefone Residencial: " + tel1);
		System.out.println("Telefone Celular/Comercial: " + tel2);
		

		try {
			PreparedStatement comando = conexao
					.prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			comando.setString(1, cliente.getCpf());
			comando.setString(2, cliente.getRg());
			comando.setString(3, cliente.getNome());
			comando.setString(4, cliente.getBairro());
			comando.setString(5, cliente.getCidade());
			comando.setString(6, cliente.getCep());
			comando.setString(7, cliente.getLogradouro());
			comando.setString(8, cliente.getNumero());
			comando.setString(9, cliente.getComplemento());
			comando.setString(10, cliente.getTel1());
			comando.setString(11, cliente.getTel2());

			comando.executeUpdate();

			conexao.commit();
			
			comando.close();

		} catch (SQLException sqle) {
			System.out.println("Erro na inserção" + sqle.getMessage());
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
