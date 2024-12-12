package az.prj.epharmacyboot.service;

import az.prj.epharmacyboot.dto.request.ReqCustomer;
import az.prj.epharmacyboot.dto.response.RespCustomer;
import az.prj.epharmacyboot.dto.response.Response;

import java.util.List;

public interface CustomerService {
    Response<List<RespCustomer>> getCustomerList();

    Response<RespCustomer> getCustomerById(Long customerId);

    Response addCustomer(ReqCustomer reqCustomer);

    Response updateCustomer(ReqCustomer reqCustomer);

    Response deleteCustomer(Long customerId);

}
