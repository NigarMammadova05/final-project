package az.prj.epharmacyboot.service;

import az.prj.epharmacyboot.dto.request.ReqOrder;
import az.prj.epharmacyboot.dto.response.RespOrder;
import az.prj.epharmacyboot.dto.response.Response;

import java.util.List;

public interface OrderService {
    Response<List<RespOrder>> getOrderList(Long medicationId);

    Response createOrder(ReqOrder reqOrder);
}
