package org.dao1;

import java.util.List;

import org.model.Product;

public interface ProductDao {
	public Product getOneProduct(Integer id);
	public Product getOneProduct(String id);
	public List getAll();
	public void save(Product product);
}
