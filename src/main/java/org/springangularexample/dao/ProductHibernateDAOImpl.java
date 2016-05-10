/**
 * 
 */
package org.springangularexample.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springangularexample.dao.interfaces.ProductDAO;
import org.springangularexample.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author INST
 *
 */
@Repository
public class ProductHibernateDAOImpl implements ProductDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public ProductHibernateDAOImpl(final SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Product tProduct) {
		getCurrentSession().save(tProduct);

	}

	@Override
	public Product retrieveProduct(Product tProduct) {
		return getCurrentSession().byId(Product.class).getReference(tProduct.getProductId());
	}

	@Override
	public void updateProduct(Product pProduct) {
		getCurrentSession().update(pProduct);
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
