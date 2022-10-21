package br.com.fiap.tdsa.challenge.repository;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tdsa.challenge.confing.ConnectionFactory;

public class Repository {

	protected static Connection connection;

	public Repository() {
		super();
		getConnection();
	}

	public static Connection getConnection() {
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			return connection;
		} catch (Exception e) {
			System.out.println("Erro nos parâmetros da conexão com o banco de dados :" + e.getMessage());
		}
		return null;
	}

	public static void closeConnection() {

		try {
			// se a conexão não estiver fechada, feche-a
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao encerrar conex�o:" + " \n" + ex.getMessage());
		}
	}

}