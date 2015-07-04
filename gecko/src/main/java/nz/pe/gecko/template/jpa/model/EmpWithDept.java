package nz.pe.gecko.template.jpa.model;


public class EmpWithDept {
	
	private String deptname;
	private Long deptno;
	private Long empno;
	private String ename;
	
	/* for the purpose of 'Project', constructor is mandatory */
	public EmpWithDept(Long empno, String ename, Long deptno, String deptname) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.deptname = deptname;
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
	
	

}