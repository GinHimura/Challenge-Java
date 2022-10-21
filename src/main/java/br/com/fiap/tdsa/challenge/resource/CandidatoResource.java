package br.com.fiap.tdsa.challenge.resource;

import br.com.fiap.tdsa.challenge.model.dto.CandidatoDTO;
import br.com.fiap.tdsa.challenge.repository.CandidatoRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/candidatos")
public class CandidatoResource {
	private CandidatoRepository repository = new CandidatoRepository();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response criarEmpresa(CandidatoDTO dto) {
		repository.criarCandidato(dto);
		return Response.created(null).header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}

}
