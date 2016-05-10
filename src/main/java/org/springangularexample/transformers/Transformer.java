/**
 * 
 */
package org.springangularexample.transformers;

import org.springangularexample.dto.support.BaseDTO;
import org.springangularexample.entities.support.BaseEntity;

/**
 * @author INST
 *
 */
public interface Transformer<D extends BaseDTO<E>, E extends BaseEntity> {

	public D getDTOFromEntity(final E entity);

	public E getEntityFromDTO(final D dto);
}
