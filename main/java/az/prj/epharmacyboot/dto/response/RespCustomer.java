package az.prj.epharmacyboot.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RespCustomer {
    private Long id;
    private String name;
    private String surname;
    private String gender;
    private Date dob;
    private String phone;
}
