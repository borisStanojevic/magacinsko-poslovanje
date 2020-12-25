package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.HashSet;
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

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.dto.PoslovniPartnerDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PoslovniPartnerToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.PoslovniPartnerService;

@RestController
@RequestMapping(value="/api/poslovni-partner")
public class PoslovniPartnerController {

	@Autowired
	PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	PoslovniPartnerToDTO poslovniPartnerToDTO;
	
	@GetMapping(value="/all") 
	public ResponseEntity<Set<PoslovniPartnerDTO>> getAll() {
		
		Page<PoslovniPartner> poslovniPartnerPage = poslovniPartnerService.getAll(new PageRequest(0, 1000));
		Set<PoslovniPartner> poslovniPartners = new HashSet<>(poslovniPartnerPage.getContent());
		Set<PoslovniPartnerDTO> poslovniPartnerDTOs = poslovniPartnerToDTO.convert(poslovniPartners);
		
		return new ResponseEntity<Set<PoslovniPartnerDTO>>(poslovniPartnerDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="/dobavljaci")
	public ResponseEntity<Set<PoslovniPartnerDTO>> getDobavljaci() {
		
		Page<PoslovniPartner> poslovniPartnerPage = poslovniPartnerService.getByDobavljaci(new PageRequest(0, 1000));
		Set<PoslovniPartner> poslovniPartneri = new HashSet<>(poslovniPartnerPage.getContent());
		Set<PoslovniPartnerDTO> poslovniPartnerDTO = poslovniPartnerToDTO.convert(poslovniPartneri);
		
		return new ResponseEntity<Set<PoslovniPartnerDTO>>(poslovniPartnerDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/kupci")
	public ResponseEntity<Set<PoslovniPartnerDTO>> getKupci() {
		
		Page<PoslovniPartner> poslovniPartnerPage = poslovniPartnerService.getByKupci(new PageRequest(0, 1000));
		Set<PoslovniPartner> poslovniPartneri = new HashSet<>(poslovniPartnerPage.getContent());
		Set<PoslovniPartnerDTO> poslovniPartnerDTO = poslovniPartnerToDTO.convert(poslovniPartneri);
		
		return new ResponseEntity<Set<PoslovniPartnerDTO>>(poslovniPartnerDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createPoslovniPartner(@RequestBody PoslovniPartner poslovniPartner, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		PoslovniPartner newPoslovniPartner = poslovniPartnerService.add(poslovniPartner);
		return new ResponseEntity<>(newPoslovniPartner, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{sifraPartnera}")
	public ResponseEntity<?> updatePoslovniPartner(@RequestBody PoslovniPartner poslovniPartner, 
			@PathVariable("sifraPartnera") Integer sifraPartnera) {
		PoslovniPartner poslovniPartnerForUpdate = poslovniPartnerService.update(poslovniPartner);
		return new ResponseEntity<>(poslovniPartnerForUpdate, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete") 
	public ResponseEntity<?> deletePoslovniPartner(@RequestParam("sifraPartnera") Integer sifraPartnera) {
		if(sifraPartnera == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		poslovniPartnerService.deleteById(sifraPartnera);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
