package com.singlestone.contacts.dao;

import java.util.List;

public interface DaoIf {

	public Object saveEntity(Object dto);
	
	public Object getEntityById(Long id);
	
	public List<? extends Object> getAll();
	
	public void deleteById(Long id);

}
