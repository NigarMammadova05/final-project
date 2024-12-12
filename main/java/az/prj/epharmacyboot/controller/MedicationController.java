package az.prj.epharmacyboot.controller;

import az.prj.epharmacyboot.dto.request.ReqMedication;
import az.prj.epharmacyboot.dto.response.RespMedication;
import az.prj.epharmacyboot.dto.response.Response;
import az.prj.epharmacyboot.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medication")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @GetMapping("/GetMedicationListByCustomerId/{customerId}")
    public Response<List<RespMedication>> getMedicationListByCustomerId(@PathVariable Long customerId){
        return medicationService.getMedicationListByCustomerId(customerId);
    }
    @PostMapping("/AddMedication")
    public Response addMedication(@RequestBody ReqMedication reqMedication){
        return medicationService.addMedication(reqMedication);
    }

}
