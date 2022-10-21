package br.com.fiap.tdsa.challenge.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tdsa.challenge.model.dto.VagaDTO;
import br.com.fiap.tdsa.challenge.repository.VagaRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/vagas")
public class VagaResource {

	private VagaRepository vagaRepository = new VagaRepository();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response criarVaga(VagaDTO vagaDTO) throws SQLException {
		vagaRepository.criarVaga(vagaDTO);
		return Response.created(null).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response buscarVagas() {
		List<VagaDTO> resp = vagaRepository.listarVagas();
		Response.ResponseBuilder res = Response.ok(resp);

		res.entity(resp);
		return res.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
}
