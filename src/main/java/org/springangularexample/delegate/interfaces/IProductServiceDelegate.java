/**
 * 
 */
package org.springangularexample.delegate.interfaces;

import java.util.Collection;
import java.util.List;

import org.springangularexample.dto.GenericResponseDTO;
import org.springangularexample.dto.ProductDTO;
import org.springangularexample.entities.Product;

/**
 * <p>
 * {@code IProductServiceDelegate} Specifies interface to an object which acts
 * as a facade to the Underlying Business Services to the Controller Layer.
 * </p>
 * 
 * @author INST
 *
 */
public interface IProductServiceDelegate {

	/**
	 * <p>
	 * Delegate Method to Add the Specified Transient {@link Product}
	 * Represented by it's Corresponding {@link ProductDTO}
	 * </p>
	 * 
	 * @param tProductDTO
	 *            - the Transient {@link Product} to add.
	 */
	public GenericResponseDTO<ProductDTO> addProduct(final ProductDTO tProductDTO);

	/**
	 * <p>
	 * Delegate Method to Retrieve {@link Product} instance Represented by it's
	 * Corresponding {@link ProductDTO} from underlying Persistence Store given
	 * the Transient Equivalent of it.
	 * </p>
	 * 
	 * @param tProductDTO
	 *            - the Transient {@link Product} Represented by it's
	 *            Corresponding {@link ProductDTO} to be Retrieved.
	 * @return - The Persistent {@link Product} Represented by it's
	 *         Corresponding {@link ProductDTO} instance.
	 */
	public GenericResponseDTO<ProductDTO> retrieveProduct(final ProductDTO tProductDTO);

	public Collection<ProductDTO> retrieveAllProducts();

	/**
	 * <p>
	 * Delegate Method to Update the Specified {@link Product} instance
	 * Represented by it's Corresponding {@link ProductDTO} in the underlying
	 * Persistence Store.
	 * </p>
	 * 
	 * @param tProductDTO
	 *            - the Persistent {@link Product} Represented by it's
	 *            Corresponding {@link ProductDTO} to update.
	 */
	public GenericResponseDTO<ProductDTO> updateProduct(final ProductDTO tProductDTO);
}
