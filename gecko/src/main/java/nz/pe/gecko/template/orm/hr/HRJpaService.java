package nz.pe.gecko.template.orm.hr;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HRJpaService {
	
	@Autowired
	HRJpaRepository repository;
	
	@Transactional
	public void addEmpJpa() {
		
		EmpJpaVO emp1 = new EmpJpaVO();
		//emp1.setEmpno(7369);
		emp1.setEname("SMITH333");
		emp1.setHiredate(new java.util.Date());
		emp1.setJob("CLERK");
		emp1.setMgr(7902);
		emp1.setSal(800);
		emp1.setComm(0);
		emp1.setDeptno(20);
		
		repository.save(emp1);		
	}

}
