package com.example.demo.resources;

import com.example.demo.client.dto.DeviceDTO;
import com.example.demo.database.entities.Device;
import com.example.demo.database.repositories.DeviceRepository;
import com.example.demo.mappers.DeviceMapper;
import com.ilirium.database.commons.PageRequest;
import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/devices", description = "Devices resource", tags = "device")
@Path("/devices")
@ApplicationScoped
@Transactional
public class DevicesResource {

    @Inject
    private Logger logger;

    @Inject
    private DeviceRepository deviceRepository;

    @Inject
    private DeviceMapper deviceMapper;

    @ApiOperation(value = "Get the list of Devices", response = DeviceDTO.class, responseContainer = "List")
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeviceDTO> doGet() {
        logger.info(">> doGet()");
        List<Device> devices = deviceRepository.findPagedOrdered(PageRequest.defaultIfWrongConf(null, null, null), null);
        List<DeviceDTO> deviceDTOS = deviceMapper.map(devices);
        logger.info("<< doGet(devices = #{})", deviceDTOS.size());
        return deviceDTOS;
    }
}
