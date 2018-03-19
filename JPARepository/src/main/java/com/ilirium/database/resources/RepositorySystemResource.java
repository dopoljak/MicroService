package com.ilirium.database.resources;

import com.ilirium.database.flyway.SchemaVersion;
import com.ilirium.database.flyway.SchemaVersionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "/", tags = "System")
@Path("/system")
@RequestScoped
@Transactional
public class RepositorySystemResource {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RepositorySystemResource.class);

    @Inject
    private SchemaVersionRepository schemaVersionRepository;

    @ApiOperation(
            value = "Get schema_version",
            notes = "Get schema_version",
            response = SchemaVersion.class
    )
    @GET
    @Path("/schema_version")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SchemaVersion> getDatabaseSchemaVersions() {
        LOGGER.info(">> getDatabaseSchemaVersions()");

        final List<SchemaVersion> response = schemaVersionRepository.getSchemaVersions();

        LOGGER.info("<< getDatabaseSchemaVersions({})", response);
        return (response);
    }

}
