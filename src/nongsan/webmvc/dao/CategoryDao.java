package nongsan.webmvc.dao;

import java.util.ArrayList;
import java.util.List;

import nongsan.webmvc.model.Catalog;
import nongsan.webmvc.model.Product;

public interface CategoryDao {
	void insert(Catalog category);

	void edit(Catalog category);

	void delete(String id);

	Catalog get(int id);
	
	Catalog get(String name);

	ArrayList<Catalog> getAll();
	
	ArrayList<Catalog> getCateByProduct(int id);

}
