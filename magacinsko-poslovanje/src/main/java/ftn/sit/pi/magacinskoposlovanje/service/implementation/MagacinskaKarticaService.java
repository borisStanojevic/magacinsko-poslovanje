package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinskaKarticaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IMagacinskaKarticaService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MagacinskaKarticaService implements IMagacinskaKarticaService {

	@Autowired
	private MagacinskaKarticaRepository magacinskaKarticaRepository;

	
	@Override
	@Transactional(readOnly = true)
	public MagacinskaKartica getById(Integer idMagacinskeKartice) {
		return magacinskaKarticaRepository.findByIdMagacinskeKartice(idMagacinskeKartice);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<MagacinskaKartica> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine, Pageable pageable) {
		return magacinskaKarticaRepository.findAll(sifraMagacina, idGodine, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public MagacinskaKartica getBySifraArtikla(Integer sifraArtikla) {
		return magacinskaKarticaRepository.getBySifraArtikla(sifraArtikla);
	}
	
	@Override
	@Transactional(readOnly = true)
	public MagacinskaKartica getBySifraArtiklaAndIdGodine(Integer sifraArtikla, Integer idGodine) {
		return magacinskaKarticaRepository.getBySifraArtiklaAndIdGodine(sifraArtikla, idGodine);
	}
	
	@Override
	@Transactional(readOnly = true)
	public MagacinskaKartica findTopByOrderByIdDesc() {
		return magacinskaKarticaRepository.findTopByOrderByIdMagacinskeKarticeDesc();
	}
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MagacinskaKartica add(MagacinskaKartica magacinskaKartica) {
		return magacinskaKarticaRepository.save(magacinskaKartica);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MagacinskaKartica update(MagacinskaKartica magacinskaKartica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(MagacinskaKartica magacinskaKartica) {
		MagacinskaKartica magacinskaKarticaToBeDeleted = magacinskaKarticaRepository.findByIdMagacinskeKartice(magacinskaKartica.getIdMagacinskeKartice());
		magacinskaKarticaRepository.delete(magacinskaKarticaToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idMagacinskeKartice) {
		magacinskaKarticaRepository.deleteByIdMagacinskeKartice(idMagacinskeKartice);
	}
	
}
