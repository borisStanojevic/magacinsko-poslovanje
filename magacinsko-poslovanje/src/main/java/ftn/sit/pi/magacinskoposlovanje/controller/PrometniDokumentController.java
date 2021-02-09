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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.domain.Smer;
import ftn.sit.pi.magacinskoposlovanje.domain.Status;
import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometa;
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
import ftn.sit.pi.magacinskoposlovanje.service.implementation.AnalitikaMagacinskeKarticeService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MagacinskaKarticaService;
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
	MagacinskaKarticaService magacinskaKarticaService;
	
	@Autowired
	AnalitikaMagacinskeKarticeService analitikaMagacinskeKarticeService;
	
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
	
	@GetMapping(value="/otpremnice")
	public ResponseEntity<Set<PrometniDokumentDTO>> getAllOtpremnice() {
		
		Page<PrometniDokument> prometniDokumentPage = prometniDokumentService.getByOtpremnica(new PageRequest(0, 1000));
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
	public ResponseEntity<?> createPrijemnica(@RequestBody PrijemnicaDTO prijemnica) {
		
		PrometniDokument prometniDokumentFromDB = prometniDokumentService.add(prijemnica);
		PrometniDokumentDTO dto = prometniDokumentToDTO.convert(prometniDokumentFromDB);		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value="/proknjizi-prijemnicu/{idPrometnogDokumenta}", consumes="application/json")
	public ResponseEntity<?> proknjiziPrijemnicu(@PathVariable("idPrometnogDokumenta") Integer idPrometnogDokumenta) {
						
		PrometniDokument prometniDokumentFromDB = prometniDokumentService.add(idPrometnogDokumenta);
		PrometniDokumentDTO dto = prometniDokumentToDTO.convert(prometniDokumentFromDB);	
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value="/otkazi-prijemnicu/{idPrometnogDokumenta}", consumes="application/json")
	public ResponseEntity<?> otkaziPrijemnicu(@PathVariable("idPrometnogDokumenta") Integer idPrometnogDokumenta) {
		PrometniDokument prometniDokument = prometniDokumentService.getById(idPrometnogDokumenta);
		prometniDokument.setDeleted(true);
		
		PrometniDokument prometniDokumentFromDB = prometniDokumentService.add(prometniDokument);
		
		Page<StavkaPrometnogDokumenta> pageStavkaPrometnogDokumenta = stavkaPromDokService.getAll(idPrometnogDokumenta, new PageRequest(0, 1000));
		Set<StavkaPrometnogDokumenta> setStavke = new HashSet<>(pageStavkaPrometnogDokumenta.getContent());
		for(StavkaPrometnogDokumenta stavka : setStavke) {
			stavka.setDeleted(true);
			stavkaPromDokService.add(stavka);			
		}
		PrometniDokumentDTO dto = prometniDokumentToDTO.convert(prometniDokumentFromDB);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping(value="/create-otpremnica", consumes="application/json")
	public ResponseEntity<?> createOtpremnica(@RequestBody PrijemnicaDTO prijemnica) {
	
		PrometniDokument prometniDokumentFromDB = prometniDokumentService.addOtpremnica(prijemnica);
		PrometniDokumentDTO dto = prometniDokumentToDTO.convert(prometniDokumentFromDB);		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value="/proknjizi-otpremnicu/{idPrometnogDokumenta}", consumes="application/json")
	public ResponseEntity<?> proknjiziOtpremnicu(@PathVariable("idPrometnogDokumenta") Integer idPrometnogDokumenta) {
		
		PrometniDokument prometniDokumentFromDB = prometniDokumentService.addOtpremnicaKnjizenje(idPrometnogDokumenta);
		PrometniDokumentDTO dto = prometniDokumentToDTO.convert(prometniDokumentFromDB);	
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value="/otkazi-otpremnicu/{idPrometnogDokumenta}", consumes="application/json")
	public ResponseEntity<?> otkaziOtpremnicu(@PathVariable("idPrometnogDokumenta") Integer idPrometnogDokumenta) {
		PrometniDokument prometniDokument = prometniDokumentService.getById(idPrometnogDokumenta);
		prometniDokument.setDeleted(true);
		
		prometniDokumentService.add(prometniDokument);
		
		Page<StavkaPrometnogDokumenta> pageStavkaPrometnogDokumenta = stavkaPromDokService.getAll(idPrometnogDokumenta, new PageRequest(0, 1000));
		Set<StavkaPrometnogDokumenta> setStavke = new HashSet<>(pageStavkaPrometnogDokumenta.getContent());
		for(StavkaPrometnogDokumenta stavka : setStavke) {
			stavka.setDeleted(true);
			stavkaPromDokService.add(stavka);			
		}
		
		return new ResponseEntity<>(prometniDokument, HttpStatus.OK);
	}
	
	
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
