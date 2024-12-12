package az.prj.epharmacyboot.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespOrder {
    private Long id;
    private Double amount;
    private Integer discount;
    private String status;
    private Integer quantity_ordered;
    private RespMedication medication;
}
