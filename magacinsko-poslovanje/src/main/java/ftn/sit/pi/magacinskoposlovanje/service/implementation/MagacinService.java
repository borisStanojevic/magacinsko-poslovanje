package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IMagacinService;

@Service
@Transactional
public class MagacinService implements IMagacinService {

	@Autowired
	private MagacinRepository magacinRepository;

	
	@Override
	@Transactional(readOnly = true)
	public Magacin getById(Integer sifraMagacina) {
		return magacinRepository.findBySifraMagacina(sifraMagacina);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Magacin> getAll(Pageable pageable) {
		return magacinRepository.findAll(pageable);
	}

	@Override
	public Magacin add(Magacin magacin) {
		return magacinRepository.save(magacin);
	}

	@Override
	public Magacin update(Magacin magacin) {
		Magacin magacinToBeUpdated = magacinRepository.findBySifraMagacina(magacin.getSifraMagacina());
		magacinToBeUpdated.setNazivMagacina(magacin.getNazivMagacina());
		return magacinRepository.save(magacinToBeUpdated);
	}

	@Override
	public void delete(Magacin magacin) {
		Magacin magacinToBeDeleted = magacinRepository.findBySifraMagacina(magacin.getSifraMagacina());
		magacinRepository.delete(magacinToBeDeleted);
	}

	@Override
	public void deleteById(Integer sifraMagacina) {
		magacinRepository.deleteById(sifraMagacina);
	}
	
}
