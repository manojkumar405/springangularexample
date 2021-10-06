/**
 * 
 */
package org.springangularexample.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springangularexample.entities.support.BaseEntity;

/**
 * <p>
 * {@code Product} models the PRODUCT Table in the Database.
 * </p>
 * 
 * @author INST
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements BaseEntity {

	/**
	 * Default Serial Version
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid.hex")
	@GenericGenerator(name = "uuid.hex", strategy = "uuid.hex")
	@Column(name = "PRODUCT_ID")
	private String productId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "QUANTITY")
	private Long quantity;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "STATUS")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	/**
	 * <p>
	 * Default Constructor
	 * </p>
	 */
	public Product() {
		super();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
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
