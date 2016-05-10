/**
 * 
 */
package org.springangularexample.delegate.interfaces;

import org.springangularexample.entities.Product;

/**
 * @author INST
 *
 */
public interface IProductServiceDelegate {

	/**
	 * <p>
	 * Delegate Method to Add the Specified Transient {@link Product}
	 * </p>
	 * 
	 * @param tProduct
	 *            - the Transient {@link Product} to add.
	 */
	public void addProduct(final Product tProduct);

	/**
	 * <p>
	 * Delegate Method to Retrieve {@link Product} instance from underlying
	 * Persistence Store given the Transient Equivalent of it.
	 * </p>
	 * 
	 * @param tProduct
	 *            - the Transient {@link Product} to be Retrieved.
	 * @return - The Persistent {@link Product} instance.
	 */
	public Product retrieveProduct(final Product tProduct);

	/**
	 * <p>
	 * Delegate Method to Update the Specified Persistent {@link Product}
	 * instance in the underlying Persistence Store.
	 * </p>
	 * 
	 * @param pProduct
	 *            - the Persistent {@link Product} to update.
	 */
	public void updateProduct(final Product pProduct);
}
