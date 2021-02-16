package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;
import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.ArtikalToDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToArtikal;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToJedinicaMere;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToKategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.repository.ArtikalRepository;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinRepository;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinskaKarticaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IArtikalService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ArtikalService implements IArtikalService {
	
	@Autowired
	private ArtikalRepository artikalRepository;
	
	@Autowired
	private MagacinskaKarticaRepository magacinskaKarticaRepository;
	
	@Autowired
	ArtikalToDTO artikalToDTO;
	
	@Autowired

	DTOToArtikal dtoToArtikal;
	
	@Autowired
	DTOToJedinicaMere dtoToJedinicaMere;
	
	@Autowired
	DTOToKategorijaArtikala dtoToKategorijaArtikala;

	@Autowired
	KategorijaArtikalaService kategorijaService;
	
	@Autowired
	MagacinService magacinService;
	
	@Autowired
	PoslovnaGodinaService poslovnaGodinaService;
	
	
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
		Artikal newArtikal = new Artikal();
		newArtikal.setNazivArtikla(artikal.getNazivArtikla());
		newArtikal.setJedinicaMere(artikal.getJedinicaMere());
		newArtikal.setKategorijaArtikala(artikal.getKategorijaArtikala());		
		artikalRepository.save(newArtikal);
		
		MagacinskaKartica magacinskaKartica = new MagacinskaKartica();
		Magacin magacin = magacinService.getById(200);
		magacinskaKartica.setArtikal(newArtikal);
		magacinskaKartica.setMagacin(magacin);
		magacinskaKartica.setPoslovnaGodina(poslovnaGodinaService.getByZakljucena(false));
		magacinskaKarticaRepository.save(magacinskaKartica);
		
		return newArtikal;		
	}
	
	@Override
	public Artikal update(Artikal artikal) {
		Artikal artikalToBeUpdate = getById(artikal.getSifraArtikla());
		artikalToBeUpdate.setNazivArtikla(artikal.getNazivArtikla());
		artikalToBeUpdate.setJedinicaMere(artikal.getJedinicaMere());
		artikalToBeUpdate.setKategorijaArtikala(artikal.getKategorijaArtikala());
		artikalRepository.save(artikalToBeUpdate);
				
		return artikalToBeUpdate;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Artikal delete(Integer sifraArtikla) {
		Artikal artikalToBeDeleted = artikalRepository.findBySifraArtikla(sifraArtikla);
		artikalToBeDeleted.setDeleted(true);
		return artikalRepository.save(artikalToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer sifraArtikla) {
		artikalRepository.deleteById(sifraArtikla);
	}

	@Override
	public Artikal update(Integer sifraArtikla) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
