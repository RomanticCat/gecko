package nz.pe.gecko.template.jpa.repository;

import nz.pe.gecko.template.jpa.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("HRDeptRepository")
public interface HRDeptRepository  extends JpaRepository<DeptJpa, Long>{

}
