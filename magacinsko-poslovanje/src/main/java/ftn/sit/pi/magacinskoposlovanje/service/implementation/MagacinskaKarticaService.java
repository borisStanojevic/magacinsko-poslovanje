package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinskaKarticaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IMagacinskaKarticaService;

@Service
@Transactional
public class MagacinskaKarticaService implements IMagacinskaKarticaService {

	@Autowired
	private MagacinskaKarticaRepository magacinskaKarticaRepository;

	@Override
	public MagacinskaKartica getById(Integer idMagacinskeKartice) {
		return magacinskaKarticaRepository.findByIdMagacinskeKartice(idMagacinskeKartice);
	}

	@Override
	public Page<MagacinskaKartica> getAll(Pageable pageable) {
		return magacinskaKarticaRepository.findAll(pageable);
	}

	@Override
	public MagacinskaKartica add(MagacinskaKartica magacinskaKartica) {
		return magacinskaKarticaRepository.save(magacinskaKartica);
	}

	@Override
	public MagacinskaKartica update(MagacinskaKartica magacinskaKartica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(MagacinskaKartica magacinskaKartica) {
		MagacinskaKartica magacinskaKarticaToBeDeleted = magacinskaKarticaRepository.findByIdMagacinskeKartice(magacinskaKartica.getIdMagacinskeKartice());
		magacinskaKarticaRepository.delete(magacinskaKarticaToBeDeleted);
	}

	@Override
	public void deleteById(Integer idMagacinskeKartice) {
		magacinskaKarticaRepository.deleteByIdMagacinskeKartice(idMagacinskeKartice);
	}
	
	
	
}
