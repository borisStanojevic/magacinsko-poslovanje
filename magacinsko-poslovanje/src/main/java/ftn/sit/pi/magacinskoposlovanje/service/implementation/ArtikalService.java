package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;
import ftn.sit.pi.magacinskoposlovanje.repository.ArtikalRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IArtikalService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ArtikalService implements IArtikalService {
	
	@Autowired
	private ArtikalRepository artikalRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Artikal getById(Integer sifraArtikla) {
		return artikalRepository.findBySifraArtikla(sifraArtikla);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Artikal> getAll(Pageable pageable) {

		return artikalRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Artikal> getAll(@Param("idKategorije") Integer idKategorije, Pageable pageable) {
		// Samo proslijedjujem pageable, ne radim konkretnu implementaciju
		// jer postoji opcija da kontroler podesimo da iz url-a izvuce
		// sve potrebno za paginaciju (i sortiranje), kreira Pageable i samo ga proslijedi servisu
		return artikalRepository.findAll(idKategorije, pageable);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Artikal add(Artikal artikal) {
		return artikalRepository.save(artikal);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Artikal update(Artikal artikal) {
		Artikal artikalToBeUpdated = artikalRepository.findBySifraArtikla(artikal.getSifraArtikla());
		artikalToBeUpdated.setNazivArtikla(artikal.getNazivArtikla());
		return artikalRepository.save(artikalToBeUpdated);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Artikal artikal) {
		Artikal artikalToBeDeleted = artikalRepository.findBySifraArtikla(artikal.getSifraArtikla());
		artikalRepository.delete(artikalToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer sifraArtikla) {
		artikalRepository.deleteById(sifraArtikla);
	}

}
