package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.repository.PoslovnaGodinaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPoslovnaGodinaService;

@Service
@Transactional
public class PoslovnaGodinaService implements IPoslovnaGodinaService {

	@Autowired
	private PoslovnaGodinaRepository poslovnaGodinaRepository;

	@Override
	public PoslovnaGodina getById(Integer idGodine) {
		return poslovnaGodinaRepository.findByIdGodine(idGodine);
	}

	@Override
	public Page<PoslovnaGodina> getAll(Pageable pageable) {
		return poslovnaGodinaRepository.findAll(pageable);
	}

	@Override
	public PoslovnaGodina add(PoslovnaGodina poslovnaGodina) {
		return poslovnaGodinaRepository.save(poslovnaGodina);
	}

	@Override
	public PoslovnaGodina update(PoslovnaGodina poslovnaGodina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PoslovnaGodina poslovnaGodina) {
		PoslovnaGodina poslovnaGodinaToBeDeleted = poslovnaGodinaRepository.findByIdGodine(poslovnaGodina.getIdGodine());
		poslovnaGodinaRepository.delete(poslovnaGodinaToBeDeleted);
	}

	@Override
	public void deleteById(Integer idGodine) {
		poslovnaGodinaRepository.deleteByIdGodine(idGodine);
	}
	
	
	
}
