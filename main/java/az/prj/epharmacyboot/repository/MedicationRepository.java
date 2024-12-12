package az.prj.epharmacyboot.repository;

import az.prj.epharmacyboot.entity.Customer;
import az.prj.epharmacyboot.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {
    List<Medication> findAllByCustomerAndActive(Customer customer, Integer active);

    Medication findMedicationByIdAndActive(Long medicationId, Integer active);
}
