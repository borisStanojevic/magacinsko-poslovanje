package ftn.sit.pi.magacinskoposlovanje.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.domain.Status;
import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.dto.MagacinDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.PoslovniPartnerDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.PrijemnicaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.PrometniDokumentDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.StavkaPrometnogDokumentaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PrometniDokumentToDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToMagacin;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToPoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToStavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.repository.PrometniDokumentRepository;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.PoslovnaGodinaService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.PrometniDokumentService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.StavkaPrometnogDokumentaService;

@RestController
@RequestMapping(value="/api/prometni-dokument")
public class PrometniDokumentController {

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
	StavkaPrometnogDokumentaService stavkaPromDokService;
	
	@Autowired
	DTOToStavkaPrometnogDokumenta dtoToStavkaPrometnogDokumenta;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<PrometniDokumentDTO>> getAll(@RequestParam("sifraMagacina") Integer sifraMagacina,
			@RequestParam("idGodine") Integer idGodine) {
		
		Page<PrometniDokument> prometniDokumentPage = prometniDokumentService.getAll(sifraMagacina, idGodine, new PageRequest(0, 1000));
		Set<PrometniDokument> prometniDokumenti = new HashSet<>(prometniDokumentPage.getContent());
		Set<PrometniDokumentDTO> prometniDokumentDTO = prometniDokumentToDTO.convert(prometniDokumenti);
		return new ResponseEntity<Set<PrometniDokumentDTO>>(prometniDokumentDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/prijemnice")
	public ResponseEntity<Set<PrometniDokumentDTO>> getAll() {
		
		Page<PrometniDokument> prometniDokumentPage = prometniDokumentService.getByPrijemnica(new PageRequest(0, 1000));
		Set<PrometniDokument> prometniDokumenti = new HashSet<>(prometniDokumentPage.getContent());
		Set<PrometniDokumentDTO> prometniDokumentDTO = prometniDokumentToDTO.convert(prometniDokumenti);
		return new ResponseEntity<Set<PrometniDokumentDTO>>(prometniDokumentDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-for-poslovni-partner")
	public ResponseEntity<Set<PrometniDokumentDTO>> getAll(@RequestParam("sifraMagacina") Integer sifraMagacina,
			@RequestParam("idGodine") Integer idGodine, @RequestParam("sifraPartnera") Integer sifraPartnera) {
		
		Page<PrometniDokument> prometniDokumentPage = prometniDokumentService.getAll(sifraMagacina, idGodine, sifraPartnera, new PageRequest(0, 1000));
		Set<PrometniDokument> prometniDokumenti = new HashSet<>(prometniDokumentPage.getContent());
		Set<PrometniDokumentDTO> prometniDokumentDTO = prometniDokumentToDTO.convert(prometniDokumenti);
		return new ResponseEntity<Set<PrometniDokumentDTO>>(prometniDokumentDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create-prijemnica", consumes="application/json")
	public ResponseEntity<?> create(@RequestBody PrijemnicaDTO prijemnica) {
	
	//public ResponseEntity<?> create(@RequestBody MagacinDTO magacin, @RequestBody PoslovniPartnerDTO poslovniPartner, 
		//@RequestParam("datumKreiranja") String datumKreiranja, @RequestBody List<StavkaPrometnogDokumentaDTO> stavkePrometnogDokumenta, Errors errors) {
		
		/*if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}*/
		PrometniDokument newPrometniDokument = new PrometniDokument();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//Date date = (Date) formatter.parse(prijemnica.getDatumKreiranja());
	 
		newPrometniDokument.setDatumKnjizenja(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		newPrometniDokument.setStatus(Status.U_FAZI_KNJIZENJA);
		newPrometniDokument.setTipPrometnogDokumenta(TipPrometnogDokumenta.PRIJEMNICA);
		newPrometniDokument.setMagacin(dtoToMagacin.convert(prijemnica.getMagacin()));
		newPrometniDokument.setPoslovniPartner(dtoToPoslovniPartner.convert(prijemnica.getPoslovniPartner()));
		newPrometniDokument.setPoslovnaGodina(poslovnaGodinaService.getByZakljucena(false));
		
		PrometniDokument prometniDokumentFromDB = prometniDokumentService.add(newPrometniDokument);
		
		for(StavkaPrometnogDokumentaDTO stavkaDTO : prijemnica.getStavkePrometnogDokumenta()) {
			StavkaPrometnogDokumenta stavkaPrometnogDokumenta = dtoToStavkaPrometnogDokumenta.convert(stavkaDTO);
			stavkaPrometnogDokumenta.setPrometniDokument(prometniDokumentFromDB);
			stavkaPromDokService.add(stavkaPrometnogDokumenta);
		}
			
		
		PrometniDokumentDTO dto = prometniDokumentToDTO.convert(prometniDokumentFromDB);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
/*	
	@PostMapping(value="/create-prijemnica", consumes="application/json")
	public ResponseEntity<?> createPrijemnica(@RequestBody MagacinDTO magacin, @RequestBody PoslovniPartnerDTO poslovniPartner, 
			@RequestBody List<StavkaPrometnogDokumenta> stavkePrometnogDokumenta, @RequestParam("ukupnaCena") Integer ukupnaCena,
			@RequestParam("cenaSaRabatom") Integer cenaSaRabatom, @RequestParam("cenaSaPDV") Integer cenaSaPDV, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		PrometniDokument newPrometniDokument = new PrometniDokument();
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		newPrometniDokument.setDatumFormiranja(date);
		newPrometniDokument.setStatus(Status.U_FAZI_KNJIZENJA);
		newPrometniDokument.setTipPrometnogDokumenta(TipPrometnogDokumenta.PRIJEMNICA);
		newPrometniDokument.setMagacin(dtoToMagacin.convert(magacin));
		PoslovnaGodina poslovnaGodina = poslovnaGodinaService.getByZakljucena(false);
		newPrometniDokument.setPoslovnaGodina(poslovnaGodina);
		newPrometniDokument.setPoslovniPartner(dtoToPoslovniPartner.convert(poslovniPartner));
		for(StavkaPrometnogDokumenta stavkaPromDok : stavkePrometnogDokumenta) {
			newPrometniDokument.addStavkaPrometnogDokumenta(stavkaPromDok);
		}
		prometniDokumentService.add(newPrometniDokument);
		
		//add stavke prometnog dokumenta
		for(StavkaPrometnogDokumenta stavkaPromDok : stavkePrometnogDokumenta) {
			stavkaPromDokService.add(stavkaPromDok);
		}
				
		
		
		return new ResponseEntity<>(newPrometniDokument, HttpStatus.OK);
	}*/
	
	@PutMapping(value="/delete")
	public ResponseEntity<?> deletePrometniDokument(@RequestParam("idPrometnogDokumenta") Integer idPrometnogDokumenta) {
		if(idPrometnogDokumenta == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		PrometniDokument prometniDokument = prometniDokumentService.getById(idPrometnogDokumenta);
		prometniDokument.setDeleted(true);
		prometniDokumentService.update(prometniDokument);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
