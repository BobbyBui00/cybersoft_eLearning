package cybersoft.group6.finalProject.eLearning.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.role.model.Role;
import cybersoft.group6.finalProject.eLearning.role.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	public RoleRepository repository;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Role save(Role entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public Role update(Role entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
