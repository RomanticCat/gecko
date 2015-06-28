package nz.pe.gecko.template.hr;

import java.util.ArrayList;


public interface HrDAO {

	/* method name of DAO interface should be same with id attribute in mapper xml */
	public ArrayList<EmpVO> getEmployees();	
	public int getEmployeeCount();
	public void insertEmployee(EmpVO emp);
	public EmpVO getEmployeeDetail(EmpVO emp);
	
	
	
}
