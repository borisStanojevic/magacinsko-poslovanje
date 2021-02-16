package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.domain.exception.ZakljucivanjePoslovneGodineException;
import ftn.sit.pi.magacinskoposlovanje.dto.PoslovnaGodinaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PoslovnaGodinaToDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PoslovniPartnerToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.PoslovnaGodinaService;

@RestController
@RequestMapping(value="/api/poslovna-godina")
public class PoslovnaGodinaController {

	@Autowired
	PoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	PoslovnaGodinaToDTO poslovnaGodinaToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<PoslovnaGodinaDTO>> getAll() {
		
		Page<PoslovnaGodina> poslovnaGodinaPage = poslovnaGodinaService.getAll(new PageRequest(0, 1000));
		Set<PoslovnaGodina> poslovneGodine = new HashSet<>(poslovnaGodinaPage.getContent());
		Set<PoslovnaGodinaDTO> poslovnaGodinaDTO = poslovnaGodinaToDTO.convert(poslovneGodine);
		return new ResponseEntity<Set<PoslovnaGodinaDTO>>(poslovnaGodinaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-by-id/{idGodine}")
	public ResponseEntity<PoslovnaGodinaDTO> getById(@PathVariable("idGodine") Integer idGodine) {
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaService.getById(idGodine);
		PoslovnaGodinaDTO poslovnaGodinaDTO = poslovnaGodinaToDTO.convert(poslovnaGodina);
		return new ResponseEntity<PoslovnaGodinaDTO>(poslovnaGodinaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-active")
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createPoslovnaGodina(@RequestBody PoslovnaGodina poslovnaGodina, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		PoslovnaGodina newPoslovnaGodina = poslovnaGodinaService.add(poslovnaGodina);
		return new ResponseEntity<>(newPoslovnaGodina, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{idGodine}", consumes="application/json")
	public ResponseEntity<?> updatePoslovnaGodina(@RequestBody PoslovnaGodina poslovnaGodina,
			@PathVariable("idGodine") Integer idGodine) {
		
		PoslovnaGodina poslovnaGodinaUpdated = poslovnaGodinaService.update(poslovnaGodina);
		return new ResponseEntity<>(poslovnaGodinaUpdated, HttpStatus.OK);
	}
	
	@GetMapping(value="/{idGodine}/zakljuci")
	public ResponseEntity<?> zakljuciPoslovnuGodinu(@PathVariable("idGodine") Integer idGodine) {
		
		try {
			poslovnaGodinaService.zakljuciPoslovnuGodinu(idGodine);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ZakljucivanjePoslovneGodineException zakljucivanjePoslovneGodineException) {
			zakljucivanjePoslovneGodineException.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
}
