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

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;
import ftn.sit.pi.magacinskoposlovanje.dto.JedinicaMereDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.JedinicaMereToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.JedinicaMereService;

@RestController
@RequestMapping(value="/api/jedinica-mere")
public class JedinicaMereController {

	@Autowired
	JedinicaMereService jedinicaMereService;
	
	@Autowired
	JedinicaMereToDTO jedinicaMereToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<JedinicaMereDTO>> returnAll() {
		
		Page<JedinicaMere> jediniceMerePage = jedinicaMereService.getAll(new PageRequest(0, 5));
		Set<JedinicaMere> jediniceMere = new HashSet<>(jediniceMerePage.getContent());
		Set<JedinicaMereDTO> dto = jedinicaMereToDTO.convert(jediniceMere);
		
		return new ResponseEntity<Set<JedinicaMereDTO>>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createJedinicaMere(@RequestBody JedinicaMere jedinicaMere, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		JedinicaMere newJedinicaMere = jedinicaMereService.add(jedinicaMere);
		return new ResponseEntity<>(newJedinicaMere, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}", consumes="application/json")
	public ResponseEntity<?> updateJedinicaMere(@RequestBody JedinicaMere jedinicaMere, @PathVariable("id") Integer id) {
		JedinicaMere jedinicaMereUpdated = jedinicaMereService.update(jedinicaMere);
		return new ResponseEntity<>(jedinicaMereUpdated, HttpStatus.OK);
	}
}
