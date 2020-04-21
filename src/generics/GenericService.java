package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericService<T, ID extends Serializable, FK> implements IGenericService<T, ID, FK> {

	@Override
	public void save(T entity) {
		getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().delete(id);
	}

	@Override
	public T get(ID id) {
		return getDao().get(id);
	}

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().getAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}
	public List<T> getAllForaneKey(FK fkey){
		List<T> returnList = new ArrayList<>();
		getDao().getAllForaneKey(fkey).forEach(obj -> returnList.add(obj));
		return returnList;
	}
	
	public abstract IGenericDao<T, ID, FK> getDao();

}
