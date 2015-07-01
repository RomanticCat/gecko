package nz.pe.gecko.template.orm.hr;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emp")
public class EmpJpaVO {
	
	/* GenerationType.IDENTITY -> mysql, GenerationType.SEQUENCE -> oracle) */ 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empno;
	
	private float comm;
	
	private int deptno;
	
	@Column(name="ename", nullable=false, length=10, unique=false)
	private String ename;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date hiredate;
	
	private String job;
	
	private float mgr;
	
	private float sal;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public float getComm() {
		return comm;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public float getMgr() {
		return mgr;
	}

	public void setMgr(float mgr) {
		this.mgr = mgr;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}
	
	/*
	private transient Boolean doesNotWantToUse;
	
	@Enumerated
	private contactList contacts;
	*/
	
	
	
	
}
