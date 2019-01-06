package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;
import ftn.sit.pi.magacinskoposlovanje.repository.RadnikRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IRadnikService;

@Service
@Transactional
public class RadnikService implements IRadnikService {

	@Autowired
	private RadnikRepository radnikRepository;

	
	@Override
	@Transactional(readOnly = true)
	public Radnik getById(Integer idRadnika) {
		return radnikRepository.findByIdRadnika(idRadnika);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Radnik> getAll(Pageable pageable) {
		return radnikRepository.findAll(pageable);
	}

	@Override
	public Radnik add(Radnik radnik) {
		return radnikRepository.save(radnik);
	}

	@Override
	public Radnik update(Radnik radnik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Radnik radnik) {
		Radnik radnikToBeDeleted = radnikRepository.findByIdRadnika(radnik.getIdRadnika());
		radnikRepository.delete(radnikToBeDeleted);
	}

	@Override
	public void deleteById(Integer idRadnika) {
		radnikRepository.deleteByIdRadnika(idRadnika);
	}
	
}
