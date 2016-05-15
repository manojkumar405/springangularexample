/**
 * 
 */
package org.springangularexample.converters;

import org.springangularexample.converters.support.AbstractConverter;
import org.springangularexample.dto.ProductDTO;
import org.springangularexample.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author INST
 *
 */
@Component
public class ProductConverter extends AbstractConverter<ProductDTO, Product> {

	/**
	 * <p>
	 * Default Constructor
	 * </p>
	 */
	public ProductConverter() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductDTO convertEntity(final Product entity) {
		final ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(entity, productDTO);
		return productDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product convertDTO(final ProductDTO dto) {
		final Product product = new Product();
		BeanUtils.copyProperties(dto, product);
		return product;
	}

}
