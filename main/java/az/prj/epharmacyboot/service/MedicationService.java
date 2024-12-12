package az.prj.epharmacyboot.service;

import az.prj.epharmacyboot.dto.request.ReqMedication;
import az.prj.epharmacyboot.dto.response.RespMedication;
import az.prj.epharmacyboot.dto.response.Response;

import java.util.List;

public interface MedicationService {
    Response<List<RespMedication>> getMedicationListByCustomerId(Long customerId);

    Response addMedication(ReqMedication reqMedication);
}
