package org.dao1;

import java.util.List;

import org.model.ProductOut;

public interface ProductOutDao {
	public ProductOut getOneProductOut(Integer id);
	public ProductOut getOneProductOutByProd_id(String prod_id, Integer id);
	public List getAll();
	public List getOnShipping();
}
