package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;
import view.JanelaConsultarClientes;

public class ConsultarCliente {
	Cliente cliente = new Cliente();
	JanelaConsultarClientes jcc = new JanelaConsultarClientes("Consulta");
	
	public void consultaCliente(String cpf, Connection conexao) {
		cliente.setCpf(cpf);
			
	try {
			PreparedStatement comando =  conexao.prepareStatement ("SELECT * FROM CLIENTE WHERE CPF=?");
			comando.setString(1,cliente.getCpf());
			
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				System.out.println("CPF:"+rs.getString(1));
				System.out.println("RG:"+rs.getString(2));
				System.out.println("Nome:"+rs.getString(3));
				System.out.println("Bairro:"+rs.getString(4));
				System.out.println("Cidade:"+rs.getString(5));
				System.out.println("CEP:"+rs.getString(6));
				System.out.println("Logradouro:"+rs.getString(7));
				System.out.println("Número:"+rs.getString(8));
				System.out.println("Complemento:"+rs.getString(9));
				System.out.println("Telefone Residencial:"+rs.getString(10));
				System.out.println("Telefone Comercial:"+rs.getString(11));
				
				jcc.jtCpf.setText(rs.getString(1));
				jcc.jtRg.setText(rs.getString(2));
				jcc.jtNome.setText(rs.getString(3));
				jcc.jtBairro.setText(rs.getString(4));
				jcc.jtCidade.setText(rs.getString(5));
				jcc.jtCep.setText(rs.getString(6));
				jcc.jtLogradouro.setText(rs.getString(7));
				jcc.jtNumero.setText(rs.getString(8));
				jcc.jtComplemento.setText(rs.getString(9));
				jcc.jtTelefone1.setText(rs.getString(10));
				jcc.jtTelefone2.setText(rs.getString(11));
			}
			
			rs.close();
			
			comando.close();
						
		}
		catch(SQLException sqle) {
			System.out.println("Erro na consulta"+sqle.getMessage());
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

