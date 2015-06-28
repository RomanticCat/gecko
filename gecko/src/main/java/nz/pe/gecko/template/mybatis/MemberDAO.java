package nz.pe.gecko.template.mybatis;

import java.util.ArrayList;



public interface MemberDAO {

	/* method name of DAO interface should be same with id attribute in mapper xml */
	public ArrayList<MemberVO> getMembers();
	public MemberVO getMemberDetail(int regno);
	public void insertMember(MemberVO member);
	public void updateMember(String name);
	public int deleteMember(int regno);
	public Integer countMembers();

}

