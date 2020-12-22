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

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;
import ftn.sit.pi.magacinskoposlovanje.dto.ArtikalDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.ArtikalToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.ArtikalService;

@RestController
@RequestMapping(value="/api/artikal")
public class ArtikalController {

	@Autowired
	ArtikalService artikalService;
	
	@Autowired
	ArtikalToDTO artikalToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<ArtikalDTO>> getAll() {
		
		Page<Artikal> artikalPage = artikalService.getAll(new PageRequest(0, 1000));
		Set<Artikal> artikli = new HashSet<>(artikalPage.getContent());
		Set<ArtikalDTO> artikalDTOs = artikalToDTO.convert(artikli);
		
		return new ResponseEntity<Set<ArtikalDTO>>(artikalDTOs, HttpStatus.OK);
	}
	
}
