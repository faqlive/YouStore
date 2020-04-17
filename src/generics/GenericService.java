package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericService<T, ID extends Serializable> implements IGenericService<T, ID> {

	@Override
	public void save(T entity) {
		getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().delete(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(ID id) {
		return (T) getDao().get(id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().getAll().forEach(obj -> returnList.add((T) obj));
		return returnList;
	}
	
	public abstract IGenericDao<T, ID> getDao();

}
