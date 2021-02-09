package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.domain.Smer;
import ftn.sit.pi.magacinskoposlovanje.domain.Status;
import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometa;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.dto.PrijemnicaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.PrometniDokumentDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.StavkaPrometnogDokumentaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PrometniDokumentToDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToMagacin;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToPoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToStavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.repository.PrometniDokumentRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPrometniDokumentService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class PrometniDokumentService implements IPrometniDokumentService {

	@Autowired
	private PrometniDokumentRepository prometniDokumentRepository;
	
	@Autowired
	PrometniDokumentService prometniDokumentService;
	
	@Autowired
	PrometniDokumentToDTO prometniDokumentToDTO;
	
	@Autowired
	DTOToPoslovniPartner dtoToPoslovniPartner;
	
	@Autowired
	DTOToMagacin dtoToMagacin;
	
	@Autowired
	PoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	MagacinskaKarticaService magacinskaKarticaService;
	
	@Autowired
	AnalitikaMagacinskeKarticeService analitikaMagacinskeKarticeService;
	
	@Autowired
	StavkaPrometnogDokumentaService stavkaPromDokService;
	
	@Autowired
	DTOToStavkaPrometnogDokumenta dtoToStavkaPrometnogDokumenta;

	
	@Override
	@Transactional(readOnly = true)
	public PrometniDokument getById(Integer idPrometnogDokumenta) {
		return prometniDokumentRepository.findByIdPrometnogDokumenta(idPrometnogDokumenta);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PrometniDokument> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine,Pageable pageable)
	{
		return prometniDokumentRepository.findAll(sifraMagacina, idGodine, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<PrometniDokument> getByPrijemnica(Pageable pageable) {
		return prometniDokumentRepository.findByPrijemnica(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<PrometniDokument> getByOtpremnica(Pageable pageable) {
		return prometniDokumentRepository.findByOtpremnica(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<PrometniDokument> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine, @Param("sifraPartnera") Integer sifraPartnera,Pageable pageable)
	{
		return prometniDokumentRepository.findAll(sifraMagacina, idGodine, sifraPartnera, pageable);
	}

	//kreiranje prijemnice
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrometniDokument add(PrijemnicaDTO prijemnica) {
		
		PrometniDokument newPrometniDokument = new PrometniDokument();
		newPrometniDokument.setDatumFormiranja(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		newPrometniDokument.setStatus(Status.U_FAZI_KNJIZENJA);
		newPrometniDokument.setTipPrometnogDokumenta(TipPrometnogDokumenta.PRIJEMNICA);
		newPrometniDokument.setMagacin(dtoToMagacin.convert(prijemnica.getMagacin()));
		newPrometniDokument.setPoslovniPartner(dtoToPoslovniPartner.convert(prijemnica.getPoslovniPartner()));
		newPrometniDokument.setPoslovnaGodina(poslovnaGodinaService.getByZakljucena(false));
		PrometniDokument prometniDokumentFromDB = prometniDokumentRepository.save(newPrometniDokument);
		
		for(StavkaPrometnogDokumentaDTO stavkaDTO : prijemnica.getStavkePrometnogDokumenta()) {
			StavkaPrometnogDokumenta stavkaPrometnogDokumenta = dtoToStavkaPrometnogDokumenta.convert(stavkaDTO);
			stavkaPrometnogDokumenta.setPrometniDokument(prometniDokumentFromDB);
			stavkaPromDokService.add(stavkaPrometnogDokumenta);
		}			
		return prometniDokumentFromDB;
	}
	
	//knjizenje prijemnice
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrometniDokument add(Integer idPrometnogDokumenta) {
		
		PrometniDokument prometniDokument = prometniDokumentService.getById(idPrometnogDokumenta);
		prometniDokument.setStatus(Status.PROKNJIZENO);
		
		PrometniDokument prometniDokumentFromDB = prometniDokumentRepository.save(prometniDokument);
		
		Page<StavkaPrometnogDokumenta> pageStavkaPrometnogDokumenta = stavkaPromDokService.getAll(idPrometnogDokumenta, new PageRequest(0, 1000));
		Set<StavkaPrometnogDokumenta> setStavke = new HashSet<>(pageStavkaPrometnogDokumenta.getContent());
		for(StavkaPrometnogDokumenta stavka : setStavke) {
			Integer sifraArtikla = stavka.getArtikal().getSifraArtikla();
			MagacinskaKartica magacinskaKartica = magacinskaKarticaService.getBySifraArtikla(sifraArtikla);
			Double kolicinaUlaza = magacinskaKartica.getKolicinaUlaza();
			Double vrednostUlaza = magacinskaKartica.getVrednostUlaza();
			
			Double ukupnaKolicina = magacinskaKartica.getUkupnaKolicina();
			Double ukupnaVrednost = magacinskaKartica.getUkupnaVrednost();
			
			magacinskaKartica.setKolicinaUlaza(kolicinaUlaza + stavka.getKolicina());
			magacinskaKartica.setVrednostUlaza(vrednostUlaza + stavka.getVrednost());
			
			magacinskaKartica.setUkupnaKolicina(ukupnaKolicina + stavka.getKolicina());
			magacinskaKartica.setUkupnaVrednost(ukupnaVrednost + stavka.getVrednost());			
			
			AnalitikaMagacinskeKartice analitikaMagacinskeKartice = new AnalitikaMagacinskeKartice();
			analitikaMagacinskeKartice.setDatumNastanka(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			analitikaMagacinskeKartice.setCena(stavka.getCena());
			analitikaMagacinskeKartice.setKolicina(stavka.getKolicina());
			analitikaMagacinskeKartice.setSmer(Smer.ULAZ);
			analitikaMagacinskeKartice.setTipPrometa(TipPrometa.DOBAVLJENO);
			analitikaMagacinskeKartice.setVrednost(stavka.getVrednost());
			analitikaMagacinskeKartice.setMagacinskaKartica(magacinskaKartica);
			analitikaMagacinskeKarticeService.add(analitikaMagacinskeKartice);			
			
			magacinskaKarticaService.add(magacinskaKartica);			
		}
		return prometniDokumentFromDB;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrometniDokument update(PrometniDokument prometniDokument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(PrometniDokument prometniDokument) {
		PrometniDokument prometniDokumentToBeDeleted = prometniDokumentRepository.findByIdPrometnogDokumenta(prometniDokument.getIdPrometnogDokumenta());
		prometniDokumentRepository.delete(prometniDokumentToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idPrometnogDokumenta) {
		prometniDokumentRepository.deleteByIdPrometnogDokumenta(idPrometnogDokumenta);
	}

	@Override
	public PrometniDokument add(PrometniDokument prometniDokument) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
