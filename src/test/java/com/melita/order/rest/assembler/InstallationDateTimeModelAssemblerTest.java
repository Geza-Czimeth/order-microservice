package com.melita.order.rest.assembler;

import com.melita.order.dto.InstallationDateTimeDTO;
import com.melita.order.model.InstallationDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.melita.order.OrderServiceTestConstants.TIMESLOT_1;
import static com.melita.order.OrderServiceTestConstants.TIMESLOT_2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstallationDateTimeModelAssemblerTest {

    private InstallationDateTimeModelAssembler installationDateTimeModelAssembler;

    @BeforeEach
    public void setup() {
        installationDateTimeModelAssembler = new InstallationDateTimeModelAssembler();
    }

    @Test
    void installationDateTimeDTOAssembledToInstallationDateTime() {
        List<LocalDateTime> timeSlots = List.of(TIMESLOT_1, TIMESLOT_2);
        InstallationDateTimeDTO installationDateTimeDTO = new InstallationDateTimeDTO(timeSlots);
        InstallationDateTime actualInstallationDateTime = installationDateTimeModelAssembler.assemble(installationDateTimeDTO);
        assertEquals(new InstallationDateTime(timeSlots), actualInstallationDateTime);
    }
}
