package org.dao1;

import java.util.List;

import org.model.ProductIn;

public interface ProductInDao {
	public ProductIn getOneProductIn(Integer id);
	public List getAll();
  
//	public void update(ProductIn prodIn);
	public void update(ProductIn productIn);
}
