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

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;
import ftn.sit.pi.magacinskoposlovanje.dto.RadnikDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.RadnikToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.RadnikService;

@RestController
@RequestMapping(value="/api/radnik")
public class RadnikController {

	@Autowired
	RadnikService radnikService;
	
	@Autowired
	RadnikToDTO radnikToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<RadnikDTO>> getAll() {
		
		Page<Radnik> radnikPage = radnikService.getAll(new PageRequest(0, 1000));
		Set<Radnik> radnici = new HashSet<>(radnikPage.getContent());
		Set<RadnikDTO> radnikDTO = radnikToDTO.convert(radnici);
		return new ResponseEntity<Set<RadnikDTO>>(radnikDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-by-id/{idRadnika}")
	public ResponseEntity<RadnikDTO> getById(@PathVariable("idRadnika") Integer idRadnika) {
		
		Radnik radnik = radnikService.getById(idRadnika);
		RadnikDTO radnikDTO = radnikToDTO.convert(radnik);
		return new ResponseEntity<RadnikDTO>(radnikDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json") 
	public ResponseEntity<?> createRadnik(@RequestBody Radnik radnik, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		Radnik newRadnik = radnikService.add(radnik);
		return new ResponseEntity<>(newRadnik, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{idRadnika}", consumes="application/json")
	public ResponseEntity<?> updateRadnik(@RequestBody Radnik radnik, @PathVariable("idRadnika") Integer idRadnika) {
		Radnik radnikUpdated = radnikService.update(radnik);
		return new ResponseEntity<>(radnikUpdated, HttpStatus.OK);
	}
	
}
