package com.melita.order.rest.assembler;

import com.melita.order.dto.InstallationDateTimeDTO;
import com.melita.order.model.InstallationDateTime;

public class InstallationDateTimeModelAssembler implements ModelAssembler<InstallationDateTimeDTO, InstallationDateTime> {
    @Override
    public InstallationDateTime assemble(InstallationDateTimeDTO installationDateTimeDTO) {
        return new InstallationDateTime(installationDateTimeDTO.availableTimeSlots());
    }
}
