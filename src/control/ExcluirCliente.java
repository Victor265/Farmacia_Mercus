package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Cliente;
import view.JanelaExcluirCliente;

public class ExcluirCliente {
	Cliente cliente = new Cliente();
	
	public void excluiCliente(String cpf, Connection conexao) {
		cliente.setCpf(cpf);

		try {
			PreparedStatement comando = conexao
					.prepareStatement("DELETE FROM CLIENTE WHERE CPF=?");
			comando.setString(1, cliente.getCpf());

			comando.executeUpdate();

			conexao.commit();
			
			comando.close();
			
			JOptionPane.showMessageDialog(null,"Clente Excluído com sucesso");

		} catch (SQLException sqle) {
			System.out.println("Erro na exclusão" + sqle.getMessage());
		}
	}
}