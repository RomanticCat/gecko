package nz.pe.gecko.template.jpa.repository;

import java.util.List;

import nz.pe.gecko.template.jpa.model.Emp;
import nz.pe.gecko.template.jpa.model.EmpWithDept;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("HREmpRepository")
public interface HREmpRepository extends JpaRepository<Emp, Long> {
	
	@Query("Select new nz.pe.gecko.template.jpa.model.EmpWithDept(e.empno, e.ename, d.deptno, d.dname) " 
             			+ "from Emp e, Dept d where e.deptno = d.deptno ")
	List<EmpWithDept> findEmpListWithDept();
	
	@Query("Select new nz.pe.gecko.template.jpa.model.EmpWithDept(e.empno, e.ename, d.deptno, d.dname) " 
 			+ "from Emp e, Dept d where e.deptno = d.deptno and e.ename LIKE ?1")
	List<EmpWithDept> findEmpListWithDept(String ename);

}
