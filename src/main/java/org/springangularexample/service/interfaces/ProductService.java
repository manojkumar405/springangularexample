/**
 * 
 */
package org.springangularexample.service.interfaces;

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
	 */
	public void addProduct(final Product tProduct);

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

	/**
	 * <p>
	 * Service to Update the Specified Persistent {@link Product} instance in
	 * the underlying Persistence Store.
	 * </p>
	 * 
	 * @param pProduct
	 *            - the Persistent {@link Product} to update.
	 */
	public void updateProduct(final Product pProduct);
}
