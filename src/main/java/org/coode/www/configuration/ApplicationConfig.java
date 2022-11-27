package org.coode.www.configuration;

import org.coode.www.model.ApplicationInfo;
import org.coode.www.model.ReasonerMomento;
import org.coode.www.service.ReasonerFactoryService;
import org.semanticweb.owlapi.util.OntologyIRIShortFormProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan({"org.coode.www.service", "org.coode.www.repository", "org.coode.www.controller"})
public class ApplicationConfig {

    @Bean
    public ApplicationInfo applicationInfo(@Value("${application.name}") String applicationName,
                                           @Value("${application.version}") String applicationVersion,
                                           @Value("${application.url}") String applicationUrl) {
        return new ApplicationInfo(applicationName, applicationVersion, applicationUrl);
    }

    @Bean
    public OntologyIRIShortFormProvider ontologyIRIShortFormProvider() {
        return new OntologyIRIShortFormProvider();
    }

    @Value("${reasoner.structural.label}")
    private String structuralLabel;

    @Value("${reasoner.openllet.label}")
    private String openlletLabel;

    @Bean
    public ReasonerMomento structural(@Value("${reasoner.structural.cls}") String cls) {
        return new ReasonerMomento(structuralLabel, cls);
    }

    @Bean
    public ReasonerMomento openllet(@Value("${reasoner.openllet.cls}") String cls) {
        return new ReasonerMomento(openlletLabel, cls);
    }

    @Bean
    public ReasonerMomento jfact(@Value("${reasoner.jfact.cls}") String cls,
                                 @Value("${reasoner.jfact.label}") String label) {
        return new ReasonerMomento(label, cls);
    }

    @Bean
    public ReasonerMomento hermit(@Value("${reasoner.hermit.cls}") String cls,
                                  @Value("${reasoner.hermit.label}") String label) {
        return new ReasonerMomento(label, cls);
    }

    @Bean
    public ReasonerMomento owlLink(@Value("${reasoner.owllink.cls}") String cls,
                                   @Value("${reasoner.owllink.label}") String label) {
        return new ReasonerMomento(label, cls);
    }

    @Bean
    public ReasonerMomento factpp(@Value("${reasoner.factpp.cls}") String cls,
                                  @Value("${reasoner.factpp.label}") String label) {
        return new ReasonerMomento(label, cls);
    }

    @Bean
    public ReasonerMomento pellet(@Value("${reasoner.pellet.cls}") String cls,
                                  @Value("${reasoner.pellet.label}") String label) {
        return new ReasonerMomento(label, cls);
    }

    @Bean
    @Autowired
    public ReasonerFactoryService reasonerFactoryService(List<ReasonerMomento> reasoners) {
        return new ReasonerFactoryService(reasoners, openlletLabel, structuralLabel);
    }
}