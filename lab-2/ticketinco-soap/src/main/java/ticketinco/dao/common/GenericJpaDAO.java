package ticketinco.dao.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.io.Serializable;

public class GenericJpaDAO<T, PK extends Serializable> implements IGenericJpaDAO<T, PK> {
  protected EntityManager em;

  protected Class<T> entityClass;

  public GenericJpaDAO(EntityManager em, Class<T> entityClass) {
    this.em = em;
    this.entityClass = entityClass;
  }

  public T create(T t) {
    em.persist(t);
    em.flush();

    return t;
  }

  public T read(PK id) {
    return em.find(this.entityClass, id);
  }

  public T update(T t) {
    T entity = em.merge(t);
    em.flush();

    return entity;
  }
  
  public void delete(T t) {
    em.remove(t);
  }
}
