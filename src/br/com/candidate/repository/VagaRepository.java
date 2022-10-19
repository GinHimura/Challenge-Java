package br.com.candidate.repository;

import br.com.candidate.model.dto.VagaDTO;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static br.com.candidate.repository.Repository.closeConnection;
import static br.com.candidate.repository.Repository.getConnection;


@NoArgsConstructor
public class VagaRepository {


    public void criarVaga(VagaDTO dto) throws SQLException {

        String sql = "BEGIN INSERT INTO T_SCC_VAGA\n" +
                "(CD_VAGA, NM_VAGA, DS_DESCRICAO, DT_CRIACAO, ST_PRESENCIAL, ST_QUALIFICACAO,DS_SALARIO,DS_TIPO_VAGA)\n" +
                "VALUES(SQ_VAGA.NEXTVAL, ?, ?, ?, ?, ?,?,?); END ;\n";

        CallableStatement statement = null;
        try {
            statement = getConnection().prepareCall(sql);
            statement.setString(1, dto.getNome());
            statement.setString(2, dto.getDescricao());
            statement.setDate(3, new Date(new Date(System.currentTimeMillis()).getTime()));
            statement.setBoolean(4, dto.getPresencial());
            statement.setString(5, dto.getQualificacao());
            statement.setString(6, dto.getSalario());
            statement.setString(7, dto.getTipoVaga());
            statement.executeUpdate();
            statement.close();
            closeConnection();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                    closeConnection();
                }
            } catch (SQLException e) {
                throw new SQLException();
            }
        }


    }

    public List<VagaDTO> listarVagas() {
        String sql = "SELECT * FROM T_SCC_VAGA";

        List<VagaDTO> list = new ArrayList<>();
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    list.add(new VagaDTO(
                            rs.getString("NM_VAGA"),
                            rs.getString("DS_DESCRICAO"),
                            rs.getDate("DT_CRIACAO"),
                            rs.getBoolean("ST_PRESENCIAL"),
                            rs.getString("ST_QUALIFICACAO"),
                            rs.getString("DS_SALARIO"),
                            rs.getString("DS_TIPO_VAGA")
                    ));
                }
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                ps.close();
                closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
