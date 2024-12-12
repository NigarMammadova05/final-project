package az.prj.epharmacyboot.controller;

import az.prj.epharmacyboot.dto.request.ReqCustomer;
import az.prj.epharmacyboot.dto.response.RespCustomer;
import az.prj.epharmacyboot.dto.response.Response;
import az.prj.epharmacyboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping("/GetCustomerList")
    public Response<List<RespCustomer>> getCustomerList() {
        return customerService.getCustomerList();
    }
    @PostMapping("/GetCustomerById/{customerId}")
    public Response<RespCustomer> getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @PostMapping("/AddCustomer")
    public Response addCustomer(@RequestBody ReqCustomer reqCustomer){
        return customerService.addCustomer(reqCustomer);
    }
    @PutMapping("/UpdateCustomer")
    public Response updateCustomer(@RequestBody ReqCustomer reqCustomer){
        return customerService.updateCustomer(reqCustomer);
    }
    @PutMapping("/DeleteCustomer/{customerId}")
    public Response deleteCustomer(@PathVariable Long customerId){
        return customerService.deleteCustomer(customerId);
    }
}
