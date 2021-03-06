package com.ilirium.webservice.resources;

import com.ilirium.webservice.commons.DateUtils;
import com.ilirium.webservice.commons.VersionUtils;
import com.ilirium.webservice.filters.LoggingFilter;

import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import org.wildfly.swarm.health.Health;
//import org.wildfly.swarm.health.HealthStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author dpoljak
 */
@Api(value = "/System", tags = "System")
@Path("/system")
@RequestScoped
@Transactional
public class CoreSystemResource {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CoreSystemResource.class);
    private static final long START_TIME = System.currentTimeMillis();

    //@Inject private AppConfiguration appConfiguration;

    @Context
    private ServletContext servletContext;

    @ApiOperation(value = "Get service status", response = Map.class)
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getDefault() {
        LOGGER.info(">> getDefault()");

        Map<String, Object> version = new HashMap<>();
        version.put(LoggingFilter.CORRELATION_ID, LoggingFilter.getCorrelationId());
        version.put("Start-Time", DateUtils.formatMillis(START_TIME));
        version.put("Up-Time", DateUtils.formatElapsedMillis(System.currentTimeMillis() - START_TIME));
        version.put("Manifest", VersionUtils.readWarManifest(servletContext));

        LOGGER.info("<< getDefault({})", version);
        return version;
    }


/*
    @ApiOperation(value = "Get service status", response = HealthStatus.class)
    @GET
    @Path("/diskspace")
    @Health
    public HealthStatus checkDiskspace() {
        File path = new File(System.getProperty("user.home"));
        long freeBytes = path.getFreeSpace();
        long threshold = 1024 * 1024 * 100; // 100mb
        return freeBytes > threshold ?
                HealthStatus.
                        named("diskspace")
                        .up()
                        .withAttribute("freebytes", freeBytes) :
                HealthStatus.
                        named("diskspace")
                        .down()
                        .withAttribute("freebytes", freeBytes);
    }

    @ApiOperation(value = "Get service time", response = HealthStatus.class)
    @GET
    @Path("/time")
    @Health
    public HealthStatus checkSomethingElse() {
        return HealthStatus
                .named("something-else")
                .up()
                .withAttribute("date", new Date().toString())
                .withAttribute("time", System.currentTimeMillis());
    }
*/
}
