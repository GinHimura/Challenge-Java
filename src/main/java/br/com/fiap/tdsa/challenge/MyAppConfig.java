package br.com.fiap.tdsa.challenge;

import org.glassfish.jersey.server.ResourceConfig;

import br.com.fiap.tdsa.challenge.resource.CORSResponseFilter;

public class MyAppConfig extends ResourceConfig {
	public MyAppConfig() {
		register(CORSResponseFilter.class);
	}
}
