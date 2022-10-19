package br.com.candidate.resource;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


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