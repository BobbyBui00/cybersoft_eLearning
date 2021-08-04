package cybersoft.group6.finalProject.eLearning.commonData1;

import java.util.List;
import java.util.Optional;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;

public interface GenericService<T extends AbstractEntity,ID> {

	List<T> findAll();
	Optional<T> findById(ID id);
	T save(T entity);
	T update(T entity);
	void deleteById(ID id);
}
