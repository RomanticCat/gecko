package nz.pe.gecko.template.jpa.model;

import java.util.Date;

public class EmpWithDeptJpa {

	private Long comm;
	private String deptname;
	private Long deptno;
	private Long empno;
	private String ename;
	private Date hiredate;
	private String job;
	private Long mgr;
	private Long sal;

	/* for the purpose of 'Project', constructor is mandatory */
	public EmpWithDeptJpa(Long empno, String ename, Long deptno,
			String deptname, Date hiredate, String job, Long mgr, Long sal,
			Long comm) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.deptname = deptname;
		this.hiredate = hiredate;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
	}

	public Long getComm() {
		return comm;
	}

	public String getDeptname() {
		return deptname;
	}

	public Long getDeptno() {
		return deptno;
	}

	public Long getEmpno() {
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

	public Long getMgr() {
		return mgr;
	}

	public Long getSal() {
		return sal;
	}

	public void setComm(Long comm) {
		this.comm = comm;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public void setEmpno(Long empno) {
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

	public void setMgr(Long mgr) {
		this.mgr = mgr;
	}

	public void setSal(Long sal) {
		this.sal = sal;
	}

}