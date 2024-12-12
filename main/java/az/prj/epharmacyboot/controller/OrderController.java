package az.prj.epharmacyboot.controller;

import az.prj.epharmacyboot.dto.request.ReqOrder;
import az.prj.epharmacyboot.dto.response.RespOrder;
import az.prj.epharmacyboot.dto.response.Response;
import az.prj.epharmacyboot.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/GetOrderList/{medicationId}")
    public Response<List<RespOrder>> getOrderList(@PathVariable Long medicationId) {
        return orderService.getOrderList(medicationId);
    }

    @PostMapping("/CreateOrder")
    public Response createOrder(@RequestBody ReqOrder reqOrder) {
        return orderService.createOrder(reqOrder);
    }
}
