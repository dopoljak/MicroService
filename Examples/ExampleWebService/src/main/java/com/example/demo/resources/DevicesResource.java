package com.example.demo.resources;

import com.example.demo.database.entities.Device;
import com.example.demo.database.repositories.DeviceRepository;
import com.example.demo.dto.DeviceDTO;
import com.ilirium.database.commons.PageRequest;
import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/devices")
@ApplicationScoped
@Transactional
public class DevicesResource {

    @Inject
    private Logger logger;

    @Inject
    private DeviceRepository deviceRepository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeviceDTO> doGet() {
        logger.info(">> doGet()");
        List<Device> devices = deviceRepository.findPagedOrdered(PageRequest.defaultIfWrongConf(null,null,null), null);
        List<DeviceDTO> deviceDTOS = map(devices);
        logger.info("<< doGet(devices = #{})", deviceDTOS.size());
        return deviceDTOS;
    }

    private List<DeviceDTO> map(List<Device> devices) {
        List<DeviceDTO> deviceDTOS = new ArrayList<>(devices.size());
        for (Device device : devices) {
            DeviceDTO deviceDTO = new DeviceDTO();
            deviceDTO.setId(device.getId());
            deviceDTO.setName(device.getName());
            deviceDTOS.add(deviceDTO);
        }
        return deviceDTOS;
    }
}
