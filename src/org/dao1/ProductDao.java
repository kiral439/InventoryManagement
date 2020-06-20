package org.dao1;

import java.util.List;

import org.model.Product;

public interface ProductDao {
	public Product getOneProduct(Integer id);
	public List getAll();
}
