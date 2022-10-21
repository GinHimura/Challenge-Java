package br.com.fiap.tdsa.challenge.resource;

import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(-1)
public class CORSResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext creq, ContainerResponseContext cres) {
		cres.getHeaders().add("Access-Control-Allow-Origin", "*");
		cres.getHeaders().add("Access-Control-Allow-Headers", "*");
		cres.getHeaders().add("Access-Control-Allow-Credentials", "*");
		cres.getHeaders().add("Access-Control-Allow-Methods", "*");
		cres.getHeaders().add("Access-Control-Max-Age", "*");
		creq.getHeaders().add("Access-Control-Allow-Origin", "*");
		creq.getHeaders().add("Access-Control-Allow-Headers", "*");
		creq.getHeaders().add("Access-Control-Allow-Credentials", "*");
		creq.getHeaders().add("Access-Control-Allow-Methods", "*");
		creq.getHeaders().add("Access-Control-Max-Age", "*");
	}

}