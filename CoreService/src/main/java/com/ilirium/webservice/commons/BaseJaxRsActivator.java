package com.ilirium.webservice.commons;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationPath("/api")
public abstract class BaseJaxRsActivator /*extends Application*/ {

    /*
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BaseJaxRsActivator.class);

    public BaseJaxRsActivator() {
        LOGGER.info(">> JaxRsActivator()");
        LOGGER.info("Service activator : @ApplicationPath('/api') ...");
        LOGGER.info("<< JaxRsActivator()");
    }


    //private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BaseJaxRsActivator.class);

    /*
    @Inject
    private AppConfiguration appConfiguration;

    //@Inject private BackgroundJobs backgroundJobs;

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CoreSystemResource.class);
        classes.add(CORSFilter.class);
        classes.add(ObjectMapperContextResolver.class);
        classes.add(JaxRSExceptionProvider.class);
        // add swagger classes
        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        Set<Class<?>> additionalResources = getResources();
        LOGGER.info("Additional Resources = {}", additionalResources);
        classes.addAll(additionalResources);
        return classes;
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info(">> BaseJaxRsActivator:postConstruct()");

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("uService");
        beanConfig.setVersion("2.0");
        //beanConfig.setSchemes(new String[]{"http", "https"});
        beanConfig.setSchemes(new String[]{"https"});
        beanConfig.setHost(appConfiguration.getSwaggerHost());
        beanConfig.setBasePath(appConfiguration.getSwaggerBasePath());
        //beanConfig.setResourcePackage("com.ilirium.webservice.resources;" + getResourcePackage());
        beanConfig.setResourcePackage(getResourcePackage());
        beanConfig.setScan(false);

        LOGGER.info("SwaggerHost     = {}", appConfiguration.getSwaggerHost());
        LOGGER.info("SwaggerBasePath = {}", appConfiguration.getSwaggerBasePath());

        LOGGER.info("<< BaseJaxRsActivator:postConstruct()");
    }

    public abstract String getResourcePackage();

    public abstract Set<Class<?>> getResources();
    */
}
