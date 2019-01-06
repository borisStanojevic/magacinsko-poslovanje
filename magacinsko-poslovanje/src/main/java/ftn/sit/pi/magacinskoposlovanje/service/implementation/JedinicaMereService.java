package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;
import ftn.sit.pi.magacinskoposlovanje.repository.JedinicaMereRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IJedinicaMereService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class JedinicaMereService implements IJedinicaMereService {
	
	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;

	
	@Override
	@Transactional(readOnly = true)
	public JedinicaMere getById(Integer idJedMere) {
		return jedinicaMereRepository.findByIdJedMere(idJedMere);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<JedinicaMere> getAll(Pageable pageable) {
		return jedinicaMereRepository.findAll(pageable);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public JedinicaMere add(JedinicaMere jedinicaMere) {
		return jedinicaMereRepository.save(jedinicaMere);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public JedinicaMere update(JedinicaMere jedinicaMere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(JedinicaMere jedinicaMere) {
		JedinicaMere jedinicaMereToBeDeleted = jedinicaMereRepository.findByIdJedMere(jedinicaMere.getIdJedMere());
		jedinicaMereRepository.delete(jedinicaMereToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idJedMere) {
		jedinicaMereRepository.deleteByIdJedMere(idJedMere);
		
	}
	
	

}
