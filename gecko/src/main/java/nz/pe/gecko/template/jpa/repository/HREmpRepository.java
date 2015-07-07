package nz.pe.gecko.template.jpa.repository;

import java.util.List;

import nz.pe.gecko.template.jpa.model.EmpJpa;
import nz.pe.gecko.template.jpa.model.EmpWithDeptJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("HREmpRepository")
public interface HREmpRepository extends JpaRepository<EmpJpa, Long> {
	
	@Query("Select new nz.pe.gecko.template.jpa.model.EmpWithDeptJpa(e.empno, e.ename, d.deptno, d.dname, "
						+ "e.hiredate, e.job, e.mgr, e.sal, e.comm) "
             			+ "from EmpJpa e, DeptJpa d where e.deptno = d.deptno ")
	List<EmpWithDeptJpa> findEmpListWithDept();
	
	@Query("Select new nz.pe.gecko.template.jpa.model.EmpWithDeptJpa(e.empno, e.ename, d.deptno, d.dname, "
			+ "e.hiredate, e.job, e.mgr, e.sal, e.comm) "
			+ "from EmpJpa e, DeptJpa d "
			+ "where e.deptno = d.deptno and e.empno = ?1")
	List<EmpWithDeptJpa> getEmpByEmpNoJSONJpa(Long empno);

}
