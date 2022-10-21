package br.com.fiap.tdsa.challenge.repository;

import static br.com.fiap.tdsa.challenge.repository.Repository.closeConnection;
import static br.com.fiap.tdsa.challenge.repository.Repository.getConnection;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import br.com.fiap.tdsa.challenge.model.dto.CandidatoDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CandidatoRepository {

	public void criarCandidato(CandidatoDTO dto) {
		String sql = "BEGIN INSERT INTO T_SCC_CANDIDATO\n"
				+ "(CD_CANDIDATO, DS_EMAIL, NM_COMPLETO, DS_SENHA, NR_TELEFONE, DT_CADASTRO, ST_ESTUDANTE, DT_NASCIMENTO, DS_GENERO)\n"
				+ "VALUES(SQ_CANDIDATO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?); END;";

		CallableStatement statement = null;
		try {
			statement = getConnection().prepareCall(sql);
			statement.setString(1, dto.getEmail());
			statement.setString(2, dto.getNome());
			statement.setString(3, dto.getSenha());
			statement.setString(4, dto.getNrTelefone());
			statement.setDate(5, new Date(new Date(System.currentTimeMillis()).getTime()));
			statement.setBoolean(6, dto.getStEstudante());
			statement.setDate(7, new Date(dto.getDataNascimento().getTime()));
			statement.setString(8, dto.getGenero());

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
