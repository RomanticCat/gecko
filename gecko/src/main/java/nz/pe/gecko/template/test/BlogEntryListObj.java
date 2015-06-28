package nz.pe.gecko.template.test;

import java.util.ArrayList;

public class BlogEntryListObj {
	private boolean success;
	private ArrayList<BlogEntry> list;
	private int total_count;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<BlogEntry> getList() {
		return list;
	}
	public void setList(ArrayList<BlogEntry> list) {
		this.list = list;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	
	

}
