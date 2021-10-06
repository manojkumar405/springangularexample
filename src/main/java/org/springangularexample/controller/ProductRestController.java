/**
 * 
 */
package org.springangularexample.controller;

import java.util.Collection;

import org.springangularexample.delegate.interfaces.IProductServiceDelegate;
import org.springangularexample.dto.GenericResponseDTO;
import org.springangularexample.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author INST
 *
 */
@RestController
@RequestMapping(path = "/api/products", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ProductRestController {

	@Autowired
	private IProductServiceDelegate delegate;

	/**
	 * 
	 */
	public ProductRestController() {
		super();
	}

	@RequestMapping(method = RequestMethod.POST)
	public GenericResponseDTO<ProductDTO> addProduct(@RequestBody final ProductDTO tProductDTO) {
		return this.delegate.addProduct(tProductDTO);
	}

	@RequestMapping(path = "/{productId}", method = RequestMethod.GET)
	public GenericResponseDTO<ProductDTO> retrieveProduct(@PathVariable("productId") final String productId) {
		final ProductDTO tProductDTO = new ProductDTO();
		tProductDTO.setProductId(productId);
		return this.delegate.retrieveProduct(tProductDTO);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public GenericResponseDTO<ProductDTO> updateProduct(@RequestBody final ProductDTO tProductDTO) {
		return this.delegate.updateProduct(tProductDTO);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<ProductDTO> retrieveAllProducts() {
		return this.delegate.retrieveAllProducts();
	}
}
