package nz.pe.gecko.template.hr;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmpVO {
	private float comm;
	private int deptno;
	private int empno;
	private String ename;
	private Date hiredate;
	private String job;
	private float mgr;
	private float sal;
	
	
	public float getComm() {
		return comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public String getJob() {
		return job;
	}
	public float getMgr() {
		return mgr;
	}
	public float getSal() {
		return sal;
	}
	public void setComm(float comm) {
		this.comm = comm;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setMgr(float mgr) {
		this.mgr = mgr;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	
	

}
