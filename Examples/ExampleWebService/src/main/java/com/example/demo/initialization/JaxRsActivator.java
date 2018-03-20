package com.example.demo.initialization;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.annotation.PostConstruct;

//import io.swagger.jaxrs.config.BeanConfig;



//
// TODO: iz nekoga razloga ne želi ucitati ovo iz CoreService package-a!
// provijeriti zašto! - mislim da je bolje da sve klase isto imaju, možda eventualno da apstract naslijeđujemo
//
@ApplicationPath("/api")
public class JaxRsActivator extends Application {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JaxRsActivator.class);

    public JaxRsActivator() {
        LOGGER.info(">> JaxRsActivator()");
        LOGGER.info("Service activator : @ApplicationPath('/api') ...");
        LOGGER.info("<< JaxRsActivator()");
    }

    /*
    @PostConstruct
    public void postConstruct() {
        LOGGER.info(">> JaxRsActivator:postConstruct()");

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("uService");
        beanConfig.setVersion("2.0");
        //beanConfig.setSchemes(new String[]{"http", "https"});
        //beanConfig.setSchemes(new String[]{"https"});
        //beanConfig.setHost(appConfiguration.getSwaggerHost());
        //beanConfig.setBasePath(appConfiguration.getSwaggerBasePath());
        //beanConfig.setResourcePackage("com.ilirium.webservice.resources;" + getResourcePackage());
        beanConfig.setResourcePackage("com.example.demo.resources");
        beanConfig.setScan(false);

        //LOGGER.info("SwaggerHost     = {}", appConfiguration.getSwaggerHost());
        //LOGGER.info("SwaggerBasePath = {}", appConfiguration.getSwaggerBasePath());

        LOGGER.info("<< JaxRsActivator:postConstruct()");
    }*/
}
