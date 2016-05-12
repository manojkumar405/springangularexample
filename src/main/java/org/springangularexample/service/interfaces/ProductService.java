/**
 * 
 */
package org.springangularexample.service.interfaces;

import java.util.List;

import org.springangularexample.entities.Product;

/**
 * @author INST
 *
 */
public interface ProductService {

	/**
	 * <p>
	 * Service to Add the Specified Transient {@link Product} to underlying
	 * Persistence Store.
	 * </p>
	 * 
	 * @param tProduct
	 *            - the Transient {@link Product} to add.
	 * @return 
	 */
	public Product addProduct(final Product tProduct);

	/**
	 * <p>
	 * Service to Retrieve {@link Product} instance from underlying Persistence
	 * Store given the Transient Equivalent of it.
	 * </p>
	 * 
	 * @param tProduct
	 *            - the Transient {@link Product} to be Retrieved.
	 * @return - The Persistent {@link Product} instance.
	 */
	public Product retrieveProduct(final Product tProduct);
	
	public List<Product> retrieveAllProducts();

	/**
	 * <p>
	 * Service to Update the Specified Persistent {@link Product} instance in
	 * the underlying Persistence Store.
	 * </p>
	 * 
	 * @param pProduct
	 *            - the Persistent {@link Product} to update.
	 */
	public Product updateProduct(final Product pProduct);
}
