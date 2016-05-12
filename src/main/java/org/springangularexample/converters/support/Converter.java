/**
 * 
 */
package org.springangularexample.converters.support;

import java.util.Collection;

import org.springangularexample.dto.support.BaseDTO;
import org.springangularexample.entities.support.BaseEntity;

/**
 * <p>
 * {@code Converter} defines interface for the conversion operations between a
 * {@BaseDTO} and its {@link BaseEntity}. Converters basically help in
 * maintaining the Business Delegate classes remain clean.
 * </p>
 * 
 * @author INST
 *
 */
public interface Converter<D extends BaseDTO<E>, E extends BaseEntity> {

	/**
	 * <p>
	 * Converts an {@link BaseEntity} into it's Corresponding {@link BaseDTO}
	 * </p>
	 * 
	 * @param entity
	 *            - the {@link BaseEntity} to be converted to DTO.
	 * @return - the {@link BaseDTO} of the given Entity.
	 */
	public D convertEntity(final E entity);

	/**
	 * <p>
	 * Converts an {@link BaseDTO} into it's Corresponding {@link BaseDTO}
	 * </p>
	 * 
	 * @param entity
	 *            - the {@link BaseDTO} to be converted to Entity.
	 * @return - the {@link BaseEntity} of the given Entity.
	 */
	public E convertDTO(final D dto);

	/**
	 * <p>
	 * Converts a {@link Collection} of {@link BaseEntity} into it's
	 * Corresponding {@link Collection} of {@link BaseDTO}
	 * </p>
	 * 
	 * @param entity
	 *            - the Collection of {@link BaseEntity} to be converted to DTO.
	 * @return - the Collection {@link BaseDTO} of the given Entity.
	 */
	public Collection<D> convertEntityCollection(final Collection<E> entityCollection);

	/**
	 * <p>
	 * Converts a {@link Collection} of {@link BaseDTO} into it's Corresponding
	 * {@link Collection} of {@link BaseDTO}
	 * </p>
	 * 
	 * @param entity
	 *            - the Collection of {@link BaseDTO} to be converted to Entity.
	 * @return - the Collection {@link BaseEntity} of the given Entity.
	 */
	public Collection<E> convertDTOCollection(final Collection<D> dtoCollection);
}
