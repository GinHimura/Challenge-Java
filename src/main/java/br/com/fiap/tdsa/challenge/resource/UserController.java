package br.com.fiap.tdsa.challenge.resource;

import br.com.fiap.tdsa.challenge.model.dto.CandidateLoggedDTO;
import br.com.fiap.tdsa.challenge.model.dto.LoginDTO;
import br.com.fiap.tdsa.challenge.repository.UserRepository;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/login")
public class UserController {

	private UserRepository userRepository = new UserRepository();

	@POST
	@Produces({ jakarta.ws.rs.core.MediaType.APPLICATION_JSON })
	public jakarta.ws.rs.core.Response login(LoginDTO loginDTO) {
		CandidateLoggedDTO resp = userRepository.login(loginDTO);
		jakarta.ws.rs.core.Response.ResponseBuilder res = jakarta.ws.rs.core.Response.ok(resp);
		return res.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
}
