package nz.pe.gecko.template.orm.hr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRJpaRepository extends JpaRepository<EmpJpaVO, Integer> {

}
