package br.com.candidate.resource;

import br.com.candidate.model.dto.CandidatoDTO;
import br.com.candidate.repository.CandidatoRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/candidatos")
public class CandidatoResource {
    private CandidatoRepository repository = new CandidatoRepository();

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response criarEmpresa(CandidatoDTO dto) {
        repository.criarCandidato(dto);
        return Response.created(null)
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

    }


}
