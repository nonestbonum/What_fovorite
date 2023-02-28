package test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.models.Form;

public interface FormRepository extends JpaRepository<Form, Long> {
}
