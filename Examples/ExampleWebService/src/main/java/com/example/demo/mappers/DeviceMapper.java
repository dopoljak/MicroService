package com.example.demo.mappers;

import com.example.demo.client.dto.DeviceDTO;
import com.example.demo.database.entities.Device;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DeviceMapper {

    public List<DeviceDTO> map(List<Device> devices) {
        List<DeviceDTO> deviceDTOS = new ArrayList<>(devices.size());
        for (Device device : devices) {
            deviceDTOS.add(map(device));
        }
        return deviceDTOS;
    }

    public DeviceDTO map(Device device) {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(device.getId());
        deviceDTO.setName(device.getName());
        return deviceDTO;
    }
}
