package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Medicamento;

public class ExcluirMedicamentos {
	Medicamento Medicamento = new Medicamento();
	
	public void excluiMedicamento(String cod, Connection conexao) {
		Medicamento.setCod(cod);

		try {
			PreparedStatement comando = conexao
					.prepareStatement("DELETE FROM MEDICAMENTO WHERE COD=?");
			comando.setString(1, Medicamento.getCod());

			comando.executeUpdate();

			conexao.commit();
			
			comando.close();
			
			JOptionPane.showMessageDialog(null,"Medicamento Excluido com sucesso");

		} catch (SQLException sqle) {
			System.out.println("Erro na exclusão" + sqle.getMessage());
		}
	}
}