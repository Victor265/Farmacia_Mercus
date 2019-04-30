package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Medicamento;


public class AlterarMedicamento {
	Medicamento Medicamento = new Medicamento();

	public void alteraMedicamento(String formula, String nome, String validade,
			String cod, Connection conexao) {

	    Medicamento.setFormula(formula);
		Medicamento.setNome(nome);
		Medicamento.setValidade(validade);
		Medicamento.setCod(cod);
		
		
		System.out.println("Formula: " + formula);
		System.out.println("Nome: " + nome);
		System.out.println("Validade: " + validade);
		System.out.println("Código: " + cod);
		
		try {

			PreparedStatement comando = conexao
					.prepareStatement("UPDATE Medicamento SET FORMULA=?, NOME=?, VALIDADE=? WHERE COD=?");
			comando.setString(1, Medicamento.getFormula());
			comando.setString(2, Medicamento.getNome());
			comando.setString(3, Medicamento.getValidade());
			comando.setString(4, Medicamento.getCod());
			
			comando.executeUpdate();

			conexao.commit();

			comando.close();
			
			JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso");

		} catch (SQLException sqle) {
			System.out.println("Erro na Alteração" + sqle.getMessage());
		}
	}

	public Medicamento getMedicamento() {
		return Medicamento;
	}

	public void setMedicamento(Medicamento Medicamento) {
		this.Medicamento = Medicamento;
	}
}
