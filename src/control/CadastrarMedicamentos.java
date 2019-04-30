package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Medicamento;

public class CadastrarMedicamentos {
	private Medicamento medicamento = new Medicamento();
	
	public void cadastrarmedicamento(String formula, String nome, String validade,
			String cod, Connection conexao) {

		medicamento.setFormula(formula);
		medicamento.setNome(nome);
		medicamento.setValidade(validade);
		medicamento.setCod(cod);
		
		System.out.println("Fórmula: " + formula);
		System.out.println("Nome: " + nome);
		System.out.println("Validade: " + validade);
		System.out.println("Código: " + cod);
		
		try {
			PreparedStatement comando = conexao
					.prepareStatement("INSERT INTO MEDICAMENTO VALUES (?,?,?,?)");
			comando.setString(1, medicamento.getFormula());
			comando.setString(2, medicamento.getNome());
			comando.setString(3, medicamento.getValidade());
			comando.setString(4, medicamento.getCod());
			
			comando.executeUpdate();

			conexao.commit();
			
			comando.close();

		} catch (SQLException sqle) {
			System.out.println("Erro na inserção" + sqle.getMessage());
		}
	}

	public Medicamento getmedicamento() {
		return medicamento;
	}

	public void setmedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
}
