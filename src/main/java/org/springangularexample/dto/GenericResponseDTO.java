/**
 * 
 */
package org.springangularexample.dto;

/**
 * <p>
 * {@code GenericResponseDTO} holds the Response Payload.
 * </p>
 * 
 * @author INST
 *
 */
public class GenericResponseDTO<T> {

	private T data;

	private String message;

	/**
	 * <p>
	 * Default Constructor
	 * </p>
	 */
	public GenericResponseDTO() {
		super();
	}

	public GenericResponseDTO(final T payLoad) {
		this(payLoad, null);
	}

	public GenericResponseDTO(final T payLoad, final String message) {
		this.data = payLoad;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
