package nz.pe.gecko.template.jpa.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Emp_Jpa")
public class EmpJpa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empno")
	private Long empno;
	
	@Column(unique=true, nullable=false)
	private String ename;
	
	private String job;
	
	private Long mgr;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date hiredate;
	
	private Long sal;
	
	private Long comm;
	
	private Long deptno;
	
	@ManyToOne
	private DeptJpa dept;

	public Long getEmpno() {
		return empno;
	}

	public void setEmpno(Long empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getMgr() {
		return mgr;
	}

	public void setMgr(Long mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Long getSal() {
		return sal;
	}

	public void setSal(Long sal) {
		this.sal = sal;
	}

	public Long getComm() {
		return comm;
	}

	public void setComm(Long comm) {
		this.comm = comm;
	}

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public DeptJpa getDept() {
		return dept;
	}

	public void setDept(DeptJpa dept) {
		this.dept = dept;
	}

	
	
}
