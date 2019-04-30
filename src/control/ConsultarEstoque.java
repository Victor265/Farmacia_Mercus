package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;
import model.Medicamento;
import view.JanelaConsultaEstoque;
import view.JanelaConsultarEstoque;

public class ConsultarEstoque {
    Medicamento Medicamento = new Medicamento();
	JanelaConsultaEstoque jcc = new JanelaConsultaEstoque("Consulta");
	
	public void consultaEstoque(String cod, Connection conexao) {
		Medicamento.setCod(cod);
			
	try {
			PreparedStatement comando =  conexao.prepareStatement ("SELECT * FROM MEDICAMENTO WHERE COD=?");
			comando.setString(1,Medicamento.getCod());
			
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				System.out.println("Fórmula:"+rs.getString(1));
				System.out.println("Nome:"+rs.getString(2));
				System.out.println("Validade:"+rs.getString(3));
				System.out.println("Código:"+rs.getString(4));
				
				jcc.jtFormula.setText(rs.getString(1));
				jcc.jtNome.setText(rs.getString(2));
				jcc.jtValidade.setText(rs.getString(3));
				jcc.jtCodigo.setText(rs.getString(4));
				
			}
			
			rs.close();
			
			comando.close();
						
		}
		catch(SQLException sqle) {
			System.out.println("Erro na consulta"+sqle.getMessage());
		}
	}
	
	public Medicamento getMedicamento() {
		return Medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.Medicamento = medicamento;
	}
}

