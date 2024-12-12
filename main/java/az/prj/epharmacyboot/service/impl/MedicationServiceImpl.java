package az.prj.epharmacyboot.service.impl;

import az.prj.epharmacyboot.dto.request.ReqMedication;
import az.prj.epharmacyboot.dto.response.RespCustomer;
import az.prj.epharmacyboot.dto.response.RespMedication;
import az.prj.epharmacyboot.dto.response.RespStatus;
import az.prj.epharmacyboot.dto.response.Response;
import az.prj.epharmacyboot.entity.Customer;
import az.prj.epharmacyboot.entity.Medication;
import az.prj.epharmacyboot.enums.EnumAvailableStatus;
import az.prj.epharmacyboot.exception.ExceptionConstants;
import az.prj.epharmacyboot.exception.MyException;
import az.prj.epharmacyboot.repository.CustomerRepository;
import az.prj.epharmacyboot.repository.MedicationRepository;
import az.prj.epharmacyboot.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Response<List<RespMedication>> getMedicationListByCustomerId(Long customerId) {
        Response<List<RespMedication>> response = new Response<>();
        try {
            if (customerId == null) {
                throw new MyException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid Request Data");
            }
            Customer customer = customerRepository.findCustomerByIdAndActive(customerId, EnumAvailableStatus.ACTIVE.value);
            if (customer == null) {
                throw new MyException(ExceptionConstants.CUSTOMER_NOT_FOUND, "Customer not found");
            }
            List<Medication> medicationList = medicationRepository.findAllByCustomerAndActive(customer, EnumAvailableStatus.ACTIVE.value);
            if (medicationList.isEmpty()) {
                throw new MyException(ExceptionConstants.MEDICATION_NOT_FOUND, "Medication not found");
            }
            List<RespMedication> respMedicationList = medicationList.stream().map(this::mapping).collect(Collectors.toList());
            response.setT(respMedicationList);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (MyException ex) {
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
            ex.printStackTrace();
        } catch (Exception ex) {
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public Response addMedication(ReqMedication reqMedication) {
        Response response = new Response();
        try {
            String name = reqMedication.getMedication_name();
            Double cost = reqMedication.getMedication_cost();
            Date manDate = reqMedication.getManufactured_date();
            Date expDate = reqMedication.getExpired_date();
            Long customerId = reqMedication.getCustomerId();
            if (name == null || cost == null || manDate == null || expDate == null || customerId == null) {
                throw new MyException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Customer customer = customerRepository.findCustomerByIdAndActive(customerId, EnumAvailableStatus.ACTIVE.value);
            if (customer == null) {
                throw new MyException(ExceptionConstants.CUSTOMER_NOT_FOUND, "Customer not found");
            }
            Medication medication = Medication.builder()
                    .medication_name(name)
                    .medication_cost(cost)
                    .manufactured_date(manDate)
                    .expired_date(expDate)
                    .customer(customer)
                    .build();
            medicationRepository.save(medication);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (MyException ex) {
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
            ex.printStackTrace();
        } catch (Exception ex) {
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
            ex.printStackTrace();
        }
        return response;
    }

    private RespMedication mapping(Medication medication) {
        RespCustomer respCustomer = RespCustomer.builder()
                .name(medication.getCustomer().getName())
                .surname(medication.getCustomer().getSurname())
                .build();
        RespMedication respMedication = RespMedication.builder()
                .id(medication.getId())
                .medication_name(medication.getMedication_name())
                .medication_cost(medication.getMedication_cost())
                .manufactured_date(medication.getManufactured_date())
                .expired_date(medication.getExpired_date())
                .respCustomer(respCustomer)
                .build();
        return respMedication;
    }
}
