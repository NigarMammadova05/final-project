package az.prj.epharmacyboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EPharmacybootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EPharmacybootApplication.class, args);
    }

}
