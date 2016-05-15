/**
 * 
 */
package org.springangularexample.converters.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springangularexample.dto.support.BaseDTO;
import org.springangularexample.entities.support.BaseEntity;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * {@code AbstractConverter} is an implementation of {@link Converter} interface
 * implementing the common methods which convert a collection of dto to entity &
 * vice-versa.
 * </p>
 * 
 * @author INST
 *
 */
public abstract class AbstractConverter<D extends BaseDTO<E>, E extends BaseEntity> implements Converter<D, E> {

	/**
	 * <p>
	 * Default Constructor
	 * </p>
	 */
	public AbstractConverter() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<D> convertEntityCollection(Collection<E> entityCollection) {
		Collection<D> dtoCollection = Collections.emptyList();
		if (!CollectionUtils.isEmpty(entityCollection)) {
			dtoCollection = new ArrayList<D>(entityCollection.size());
			for (final E entity : entityCollection) {
				final D dto = this.convertEntity(entity);
				dtoCollection.add(dto);
			}
		}
		return dtoCollection;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<E> convertDTOCollection(Collection<D> dtoCollection) {
		Collection<E> entityCollection = Collections.emptyList();
		if (!CollectionUtils.isEmpty(dtoCollection)) {
			entityCollection = new ArrayList<E>(dtoCollection.size());
			for (final D dto : dtoCollection) {
				final E entity = this.convertDTO(dto);
				entityCollection.add(entity);
			}
		}
		return entityCollection;
	}

}
