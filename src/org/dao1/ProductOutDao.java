package org.dao1;

import java.util.List;

import org.model.ProductOut;

public interface ProductOutDao {
	public ProductOut getOneProductOut(Integer id);
	public List getAll();
}
