package com.algodomain.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algodomain.assignment.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	final String BY_NAME = "SELECT * FROM product WHERE product_name = ?1";

	final String BY_NAME_FOR_SELLER = "SELECT * FROM product WHERE product_name = ?1 and seller_id=?2";

	final String BY_CATEGORY = "SELECT * FROM product WHERE product_category = ?1";

	final String BY_CATEGORY_FOR_SELLER = "SELECT * FROM product WHERE product_category = ?1 and seller_id=?2";

	final String BY_TYPE = "SELECT * FROM product WHERE product_type = ?1";

	final String BY_TYPE_FOR_SELLER = "SELECT * FROM product WHERE product_type = ?1 and seller_id=?2";

	final String BY_RANGE = "SELECT * FROM product WHERE product_price between ?1 and ?2";

	final String BY_RANGE_FOR_SELLER = "SELECT * FROM product WHERE product_price between ?1 and ?2 and seller_id=?3";

	@Query(value = BY_NAME, nativeQuery = true)
	public List<Product> getProductsByName(String name);

	@Query(value = BY_NAME_FOR_SELLER, nativeQuery = true)
	public List<Product> getProductsByName(String name, int seller_id);

	@Query(value = BY_CATEGORY, nativeQuery = true)
	public List<Product> getProductsByCatgeory(String cat);

	@Query(value = BY_CATEGORY_FOR_SELLER, nativeQuery = true)
	public List<Product> getProductsByCatgeory(String name, int seller_id);

	@Query(value = BY_TYPE, nativeQuery = true)
	public List<Product> getProductsByType(String type);

	@Query(value = BY_TYPE_FOR_SELLER, nativeQuery = true)
	public List<Product> getProductsByType(String type, int seller_id);

	@Query(value = BY_RANGE, nativeQuery = true)
	public List<Product> getProductsByRange(float min, float max);

	@Query(value = BY_RANGE_FOR_SELLER, nativeQuery = true)
	public List<Product> getProductsByRange(float min, float max, int seller_id);
}
