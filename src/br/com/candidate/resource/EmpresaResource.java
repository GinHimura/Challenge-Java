package br.com.candidate.resource;


import br.com.candidate.model.dto.EmpresaDTO;
import br.com.candidate.repository.EmpresaRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/empresas")
public class EmpresaResource {

    private EmpresaRepository repository = new EmpresaRepository();

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response criarEmpresa(EmpresaDTO dto) {
        repository.criarEmpresa(dto);
        return Response.created(null).build();

    }
}
