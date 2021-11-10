/**
 * 
 */
package org.springangularexample.delegate;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.springangularexample.converters.support.Converter;
import org.springangularexample.delegate.interfaces.IProductServiceDelegate;
import org.springangularexample.dto.GenericResponseDTO;
import org.springangularexample.dto.ProductDTO;
import org.springangularexample.entities.Product;
import org.springangularexample.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * <p>
 * {@code ProductServiceDelegateImpl} is the State-less Implementation of the
 * {@link IProductServiceDelegate}.
 * </p>
 * 
 * @author INST
 *
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductServiceDelegateImpl implements IProductServiceDelegate {

	private static AtomicInteger counter = new AtomicInteger();
	
	@Autowired
	private Converter<ProductDTO, Product> productConverter;

	@Autowired
	private ProductService productService;

	@Autowired
	private MessageSource messageSource;

	/**
	 * <p>
	 * Default Constructor.
	 * </p>
	 */
	public ProductServiceDelegateImpl() {
		super();
		System.out.println("No of instances of Delegate: " + counter.incrementAndGet());
	}

	@Override
	public GenericResponseDTO<ProductDTO> addProduct(final ProductDTO tProductDTO) {
		final Product tProduct = this.productConverter.convertDTO(tProductDTO);
		final Product pProduct = this.productService.addProduct(tProduct);
		final ProductDTO pProductDTO = this.productConverter.convertEntity(pProduct);
		final String successMessage = this.formatMessage("product.added", pProductDTO.getName());
		return new GenericResponseDTO<ProductDTO>(pProductDTO, successMessage);
	}

	@Override
	public GenericResponseDTO<ProductDTO> retrieveProduct(final ProductDTO tProductDTO) {
		final Product tProduct = this.productConverter.convertDTO(tProductDTO);
		final Product pProduct = productService.retrieveProduct(tProduct);
		final ProductDTO pProductDTO = this.productConverter.convertEntity(pProduct);
		return new GenericResponseDTO<ProductDTO>(pProductDTO);
	}

	@Override
	public GenericResponseDTO<ProductDTO> updateProduct(final ProductDTO tProductDTO) {
		final Product tProduct = this.productConverter.convertDTO(tProductDTO);
		final Product pProduct = this.productService.updateProduct(tProduct);
		final ProductDTO pProductDTO = this.productConverter.convertEntity(pProduct);
		final String successMessage = formatMessage("product.updated", pProductDTO.getName());
		return new GenericResponseDTO<ProductDTO>(pProductDTO, successMessage);
	}

	@Override
	public Collection<ProductDTO> retrieveAllProducts() {
		final Collection<Product> products = this.productService.retrieveAllProducts();
		return this.productConverter.convertEntityCollection(products);
	}

	private String formatMessage(final String messageKey, final Object... args) {
		return messageSource.getMessage(messageKey, args, null, null);
	}
}
