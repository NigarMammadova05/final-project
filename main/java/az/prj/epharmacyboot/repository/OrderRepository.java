package az.prj.epharmacyboot.repository;

import az.prj.epharmacyboot.entity.Medication;
import az.prj.epharmacyboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByMedicationAndActive(Medication medication, Integer active);
}
