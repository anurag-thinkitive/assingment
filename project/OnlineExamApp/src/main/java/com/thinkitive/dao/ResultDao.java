package com.thinkitive.dao;

import java.util.List;


import com.thinkitive.model.Result;

public interface ResultDao {
	public List<Result> getallresult();
	
	public List<Result> getresult(int id);
	public void saveresult(Result r);
	
	

}
