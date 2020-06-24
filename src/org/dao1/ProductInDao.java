package org.dao1;

import java.util.List;

import org.model.ProductIn;

public interface ProductInDao {
	public ProductIn getOneProductIn(Integer id);
	public ProductIn getOneProductInByProd_id(String prod_id, Integer id);
	public List getAll();
	public List getOnShipping();
	
	public void update(ProductIn productIn);
}
