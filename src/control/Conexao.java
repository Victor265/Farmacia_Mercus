package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	Connection conexao;

	public Conexao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/mercus", "root", "root");
			conexao.setAutoCommit(false);


			System.out.println("Conexão estabelecida!!");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Não tem o driver JDBC-ODBC:"
					+ cnfe.getMessage());
		} catch (SQLException sqle) {
			System.out.println("Erro na conexão: " + sqle.getMessage());
		}
	}

	public Connection getConexao() {
		return conexao;
	}
}
