package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
