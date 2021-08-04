package cybersoft.group6.finalProject.eLearning.commonData1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;

public class GenericServiceImpl<T extends AbstractEntity,ID> implements GenericService<T, ID> {

	@Autowired
	private JpaRepository<T, ID> repository;
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(ID id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
