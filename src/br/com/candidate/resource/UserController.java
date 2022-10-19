package br.com.candidate.resource;


import br.com.candidate.model.dto.CandidateLoggedDTO;
import br.com.candidate.model.dto.LoginDTO;
import br.com.candidate.repository.UserRepository;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class UserController {

    private UserRepository userRepository = new UserRepository();

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response login(LoginDTO loginDTO) {
        CandidateLoggedDTO resp = userRepository.login(loginDTO);
        Response.ResponseBuilder res = Response.ok(resp);
        return res
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
    }
}
