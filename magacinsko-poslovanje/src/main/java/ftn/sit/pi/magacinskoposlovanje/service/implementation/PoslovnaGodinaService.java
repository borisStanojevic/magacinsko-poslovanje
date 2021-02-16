package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.domain.Status;
import ftn.sit.pi.magacinskoposlovanje.domain.exception.ZakljucivanjePoslovneGodineException;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinskaKarticaRepository;
import ftn.sit.pi.magacinskoposlovanje.repository.PoslovnaGodinaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPoslovnaGodinaService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class PoslovnaGodinaService implements IPoslovnaGodinaService {

	@Autowired
	private PoslovnaGodinaRepository poslovnaGodinaRepository;
	
	@Autowired
	private MagacinskaKarticaRepository magacinskaKarticaRepository;

	
	@Override
	@Transactional(readOnly = true)
	public PoslovnaGodina getById(Integer idGodine) {
		return poslovnaGodinaRepository.findByIdGodine(idGodine);
	}
	
	@Override
	@Transactional(readOnly = true)
	public PoslovnaGodina getByZakljucena(Boolean isZakljucena) {
		return poslovnaGodinaRepository.findByZakljucena(isZakljucena);
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

		PoslovnaGodina poslovnaGodinaEdit = poslovnaGodinaRepository.findByIdGodine(poslovnaGodina.getIdGodine());
		poslovnaGodinaEdit.setZakljucena(poslovnaGodina.isZakljucena());
		return poslovnaGodinaRepository.save(poslovnaGodinaEdit);
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
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void zakljuciPoslovnuGodinu(int idTrenutnePoslovneGodine) throws ZakljucivanjePoslovneGodineException
	{
		PoslovnaGodina trenutnaPoslovnaGodina = poslovnaGodinaRepository.findByIdGodine(idTrenutnePoslovneGodine);
		
		for(PrometniDokument prometniDokument : trenutnaPoslovnaGodina.getPrometniDokumenti()) {
			if(prometniDokument.getStatus() == Status.U_FAZI_KNJIZENJA && prometniDokument.isDeleted() == false)
				throw new ZakljucivanjePoslovneGodineException("Poslovna godina sadrzi prometne dokumente koji su u fazi knjizenja ili su obrisani.");
		}
		
		Iterable<MagacinskaKartica> stareMagacinskeKartice = trenutnaPoslovnaGodina.getMagacinskeKartice();
		
		trenutnaPoslovnaGodina.setZakljucena(true);
		poslovnaGodinaRepository.save(trenutnaPoslovnaGodina);
		
		PoslovnaGodina novaPoslovnaGodina = new PoslovnaGodina();
		novaPoslovnaGodina.setGodina(new Date());
		
		PoslovnaGodina sacuvanaNovaPoslovnaGodina = poslovnaGodinaRepository.save(novaPoslovnaGodina);
		
		Set<MagacinskaKartica> noveMagacinskeKartice = new HashSet<MagacinskaKartica>();
		stareMagacinskeKartice.forEach((magacinskaKartica) -> {
			MagacinskaKartica novaMagacinkaKartica = new MagacinskaKartica();
			
			novaMagacinkaKartica.setArtikal(magacinskaKartica.getArtikal());
			novaMagacinkaKartica.setPoslovnaGodina(sacuvanaNovaPoslovnaGodina);
			novaMagacinkaKartica.setCena(magacinskaKartica.getCena());
			novaMagacinkaKartica.setDeleted(magacinskaKartica.isDeleted());
			novaMagacinkaKartica.setKolicinaIzlaza(magacinskaKartica.getKolicinaIzlaza());
			novaMagacinkaKartica.setKolicinaPocetnogStanja(magacinskaKartica.getKolicinaPocetnogStanja());
			novaMagacinkaKartica.setKolicinaUlaza(magacinskaKartica.getKolicinaUlaza());
			novaMagacinkaKartica.setUkupnaKolicina(magacinskaKartica.getUkupnaKolicina());
			novaMagacinkaKartica.setUkupnaVrednost(magacinskaKartica.getUkupnaVrednost());
			novaMagacinkaKartica.setMagacin(magacinskaKartica.getMagacin());
			novaMagacinkaKartica.setRedniBrMagacinskeKar(magacinskaKartica.getRedniBrMagacinskeKar());
			novaMagacinkaKartica.setVrednostIzlaza(magacinskaKartica.getVrednostIzlaza());
			novaMagacinkaKartica.setVrednostPocetnogStanja(magacinskaKartica.getVrednostPocetnogStanja());
			novaMagacinkaKartica.setVrednostUlaza(magacinskaKartica.getVrednostUlaza());
			
			noveMagacinskeKartice.add(novaMagacinkaKartica);
		});
		
		magacinskaKarticaRepository.saveAll(noveMagacinskeKartice);
	}
}
