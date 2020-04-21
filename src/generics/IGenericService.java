package generics;

import java.io.Serializable;
import java.util.List;

public interface IGenericService <T, ID extends Serializable, FK> {
	void save(T entity);
	void delete(ID id);
	T get (ID id);
	List<T> getAll();
	List<T> getAllForaneKey(FK fkey);
	
}
