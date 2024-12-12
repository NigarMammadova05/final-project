package az.prj.epharmacyboot.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RespMedication {
    private Long id;
    private String medication_name;
    private Double medication_cost;
    private Date manufactured_date;
    private Date expired_date;
    private RespCustomer respCustomer;
}
