/**
 * 
 */
package org.springangularexample.dto;

import org.springangularexample.dto.support.BaseDTO;
import org.springangularexample.entities.Product;
import org.springangularexample.entities.Status;

/**
 * @author INST
 *
 */
public class ProductDTO implements BaseDTO<Product> {
	/**
	 * Default Serial Version
	 */
	private static final long serialVersionUID = 1L;

	private Integer productId;

	private String name;

	private String description;

	private Integer quantity;

	private Double price;

	private Status status;

	/**
	 * <p>
	 * Default Constructor
	 * </p>
	 */
	public ProductDTO() {
		super();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
