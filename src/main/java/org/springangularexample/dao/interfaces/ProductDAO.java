/**
 * 
 */
package org.springangularexample.dao.interfaces;

import org.springangularexample.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author INST
 *
 */
@Repository
public interface ProductDAO extends JpaRepository<Product, String> {

}
