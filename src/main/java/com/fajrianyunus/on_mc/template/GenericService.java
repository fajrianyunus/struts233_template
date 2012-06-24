package com.fajrianyunus.on_mc.template;

import java.io.Serializable;
import java.util.List;

public interface GenericService<className, idType> {

	public List<className> getAll();
	
	public void saveOrUpdate(className entity);
	
	public Serializable save(className entity);
	
	public void update(className entity);
	
	public void deleteById(idType id);
	
	public className getById(idType id);
	
	public Long countAll();
}
