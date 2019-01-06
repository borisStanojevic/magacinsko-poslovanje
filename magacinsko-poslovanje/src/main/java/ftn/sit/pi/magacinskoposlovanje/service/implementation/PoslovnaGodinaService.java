package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.repository.PoslovnaGodinaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPoslovnaGodinaService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class PoslovnaGodinaService implements IPoslovnaGodinaService {

	@Autowired
	private PoslovnaGodinaRepository poslovnaGodinaRepository;

	
	@Override
	@Transactional(readOnly = true)
	public PoslovnaGodina getById(Integer idGodine) {
		return poslovnaGodinaRepository.findByIdGodine(idGodine);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PoslovnaGodina> getAll(Pageable pageable) {
		return poslovnaGodinaRepository.findAll(pageable);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PoslovnaGodina add(PoslovnaGodina poslovnaGodina) {
		return poslovnaGodinaRepository.save(poslovnaGodina);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PoslovnaGodina update(PoslovnaGodina poslovnaGodina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(PoslovnaGodina poslovnaGodina) {
		PoslovnaGodina poslovnaGodinaToBeDeleted = poslovnaGodinaRepository.findByIdGodine(poslovnaGodina.getIdGodine());
		poslovnaGodinaRepository.delete(poslovnaGodinaToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idGodine) {
		poslovnaGodinaRepository.deleteByIdGodine(idGodine);
	}
	
	
	
}
