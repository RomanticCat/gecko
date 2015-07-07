package nz.pe.gecko.template.jpa.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Dept_Jpa")
public class DeptJpa {
	
	/* annotation for columns 
	 * columnDefinition, insertable, length, name, nullable, precision, scale, table, unique, updatable
	 */
	
	/* GenerationType.IDENTITY -> mysql, GenerationType.SEQUENCE -> oracle) */ 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deptno")
	private Long deptno;
	
	@Column(unique=true)
	private String dname;
	
	private String loc;
	
	@OneToMany(mappedBy="dept", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<EmpJpa> empList = new ArrayList<EmpJpa>();
	

	public List<EmpJpa> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmpJpa> empList) {
		this.empList = empList;
	}

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}