package ticketinco.dao.common;

public interface IGenericJpaDAO<T, PK> {
  T create(T t);

  T read(PK id);

  T update(T t);

  void delete(T t);
}
