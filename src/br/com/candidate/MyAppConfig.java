package br.com.candidate;

import br.com.candidate.resource.CORSResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;


public class MyAppConfig extends ResourceConfig {
    public MyAppConfig() {
        register(CORSResponseFilter.class);
    }
}
