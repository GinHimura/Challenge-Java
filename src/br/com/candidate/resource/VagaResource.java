package br.com.candidate.resource;


import br.com.candidate.model.dto.VagaDTO;
import br.com.candidate.repository.VagaRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/vagas")
public class VagaResource {

    private VagaRepository vagaRepository = new VagaRepository();

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response criarVaga(VagaDTO vagaDTO) throws SQLException {
        vagaRepository.criarVaga(vagaDTO);
        return Response.created(null).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscarVagas() {
        List<VagaDTO> resp = vagaRepository.listarVagas();
        Response.ResponseBuilder res = Response.ok(resp);

        res.entity(resp);
        return res
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
    }
}
