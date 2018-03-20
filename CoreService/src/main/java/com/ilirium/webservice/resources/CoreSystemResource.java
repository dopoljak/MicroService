package com.ilirium.webservice.resources;

import com.ilirium.webservice.commons.AppConfiguration;
import com.ilirium.webservice.commons.DateUtils;
import com.ilirium.webservice.commons.VersionUtils;
import com.ilirium.webservice.filters.LoggingFilter;
import io.swagger.annotations.Api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dpoljak
 */
@Api(value = "/", tags = "System")
@Path("/system")
@RequestScoped
@Transactional
public class CoreSystemResource {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CoreSystemResource.class);
    private static final long START_TIME = System.currentTimeMillis();


    @Inject
    private AppConfiguration appConfiguration;

    @Context
    private ServletContext servletContext;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getDefault() {
        LOGGER.info(">> getDefault()");

        final Map<String, Object> response = getVersionMap();

        LOGGER.info("<< getDefault({})", response);
        return (response);
    }

    private Map<String, Object> getVersionMap() {
        Map<String, Object> version = new HashMap<>();
        version.put(LoggingFilter.CORRELATION_ID, LoggingFilter.getCorrelationId());
        version.put("Start-Time", DateUtils.formatMillis(START_TIME));
        version.put("Up-Time", DateUtils.formatElapsedMillis(System.currentTimeMillis() - START_TIME));
        version.put("Manifest", VersionUtils.readWarManifest(servletContext));
        return version;
    }

}
