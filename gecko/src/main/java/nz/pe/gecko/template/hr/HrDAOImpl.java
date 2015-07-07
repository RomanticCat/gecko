package nz.pe.gecko.template.hr;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HrDAOImpl implements HrDAO {


	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<EmpVO> getEmployees() {
		ArrayList<EmpVO> results = new ArrayList<EmpVO>();
		HrDAO dao = sqlSession.getMapper(HrDAO.class);
		results = dao.getEmployees();
		return results;
	}

	@Override
	public int getEmployeeCount() {
		return sqlSession.getMapper(HrDAO.class).getEmployeeCount();
	}

	@Override
	public void insertEmployee(EmpVO emp) {
		HrDAO dao = sqlSession.getMapper(HrDAO.class);
		dao.insertEmployee(emp);
		
	}

	@Override
	public EmpVO getEmployeeDetail(EmpVO emp) {
		HrDAO dao = sqlSession.getMapper(HrDAO.class);
		return dao.getEmployeeDetail(emp);
	}

	@Override
	public void updateEmployee(EmpVO emp) {
		HrDAO dao = sqlSession.getMapper(HrDAO.class);
		dao.updateEmployee(emp);
	}

	@Override
	public int deleteEmployee(int empno) {
		HrDAO dao = sqlSession.getMapper(HrDAO.class);
		return dao.deleteEmployee(empno);
	}
	
	
	

}
