package br.com.fiap.tdsa.challenge.resource;

import br.com.fiap.tdsa.challenge.model.dto.EmpresaDTO;
import br.com.fiap.tdsa.challenge.repository.EmpresaRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/empresas")
public class EmpresaResource {

	private EmpresaRepository repository = new EmpresaRepository();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response criarEmpresa(EmpresaDTO dto) {
		repository.criarEmpresa(dto);
		return Response.created(null).build();

	}
}
