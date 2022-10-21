package br.com.fiap.tdsa.challenge.repository;

import static br.com.fiap.tdsa.challenge.repository.Repository.closeConnection;
import static br.com.fiap.tdsa.challenge.repository.Repository.getConnection;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import br.com.fiap.tdsa.challenge.model.dto.EmpresaDTO;

public class EmpresaRepository {

	public EmpresaRepository() {
	}

	public void criarEmpresa(EmpresaDTO usuarioEmpresa) {
		String sql = "BEGIN INSERT INTO T_SCC_EMPRESA (CD_EMPRESA, DS_EMAIL, NM_EMPRESA, DS_SENHA, NR_TELEFONE, DS_SITE, DT_CADASTRO,DS_EMPRESA)\n"
				+ "VALUES (SQ_EMPRESA.NEXTVAL,?,?,?,?,?,?,?); END;";

		CallableStatement statement = null;
		try {
			statement = getConnection().prepareCall(sql);
			statement.setString(1, usuarioEmpresa.getEmail());
			statement.setString(2, usuarioEmpresa.getNome());
			statement.setString(3, usuarioEmpresa.getSenha());
			statement.setString(4, usuarioEmpresa.getTelefone());
			statement.setString(5, usuarioEmpresa.getWebSite());
			statement.setDate(6, new Date(new Date(System.currentTimeMillis()).getTime()));
			statement.setString(7, usuarioEmpresa.getDescricao());
			statement.executeUpdate();
			statement.close();
			closeConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (statement != null)
					statement.close();
				closeConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
