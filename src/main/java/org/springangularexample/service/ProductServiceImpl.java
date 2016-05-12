/**
 * 
 */
package org.springangularexample.service;

import java.util.List;

import org.springangularexample.dao.interfaces.ProductDAO;
import org.springangularexample.entities.Product;
import org.springangularexample.service.interfaces.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * {@code ProductServiceImpl} is a State-less Implementation of
 * {@link ProductService} interface. This Implementation is wrapped in
 * Spring-Managed Hibernate Transactions using {@link Transactional} annotation.
 * </p>
 * 
 * @author INST
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	/**
	 * <p>
	 * Default Constructor
	 * </p>
	 */
	public ProductServiceImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product addProduct(final Product tProduct) {
		productDAO.addProduct(tProduct);
		return tProduct;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product retrieveProduct(final Product tProduct) {
		return productDAO.retrieveProduct(tProduct);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> retrieveAllProducts() {
		return productDAO.retrieveAllProducts();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product updateProduct(final Product tProduct) {
		final Product pProduct = productDAO.retrieveProduct(tProduct);
		BeanUtils.copyProperties(tProduct, pProduct);
		productDAO.updateProduct(pProduct);
		return pProduct;
	}

}
