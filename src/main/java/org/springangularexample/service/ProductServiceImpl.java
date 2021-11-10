/**
 * 
 */
package org.springangularexample.service;

import java.util.List;
import java.util.Optional;

import org.springangularexample.dao.interfaces.ProductDAO;
import org.springangularexample.entities.Product;
import org.springangularexample.service.interfaces.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Product addProduct(final Product tProduct) {
		return productDAO.save(tProduct);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Product updateProduct(final Product tProduct) {
		final Optional<Product> pProductOptional = productDAO.findById(tProduct.getProductId());
		final Product pProduct = pProductOptional.orElseThrow(() -> new RuntimeException(
				String.format("Invalid Product with Id %s was requested for update.", tProduct.getProductId())));
		BeanUtils.copyProperties(tProduct, pProduct);
		return pProduct;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Product retrieveProduct(final Product tProduct) {
		return productDAO.findById(tProduct.getProductId()).orElseThrow(() -> new RuntimeException(
				String.format("Invalid Product with Id %s was requested for update.", tProduct.getProductId())));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	@Cacheable("default")
	public List<Product> retrieveAllProducts() {
		return productDAO.findAll();
	}
}
