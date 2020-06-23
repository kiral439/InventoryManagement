package org.dao1;

import java.util.List;

import org.model.Product;
import org.model.ProductIn;

public interface ProductDao {
	public Product getOneProduct(Integer id);
	public Product getOneProduct(String prod_id);
	public List getAll();
	public List getAllForHomePage();
	public void save(Product product);
}
