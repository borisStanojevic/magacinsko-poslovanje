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
	
	@GetMapping(value="/get-by-sifra/{sifraArtikla}")
	public ResponseEntity<ArtikalDTO> getBySifraArtikla(@PathVariable("sifraArtikla") Integer sifraArtikla) {
		
		Artikal artikal = artikalService.getById(sifraArtikla);
		ArtikalDTO artikalDTO = artikalToDTO.convert(artikal);
		return new ResponseEntity<ArtikalDTO>(artikalDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createArtikal(@RequestBody Artikal artikal, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		Artikal newArtikal = artikalService.add(artikal);
		return new ResponseEntity<>(newArtikal, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{sifraArtikla}", consumes="application/json")
	public ResponseEntity<?> updateArtikal(@RequestBody Artikal artikal, @PathVariable("sifraArtikla") Integer sifraArtikla) {
		Artikal artikalUpdated = artikalService.update(artikal);
		return new ResponseEntity<>(artikalUpdated, HttpStatus.OK);
	}
	
	@PutMapping(value="/delete") 
	public ResponseEntity<?> deleteArtikal(@RequestParam("sifraArtikla") Integer sifraArtikla) {
		if(sifraArtikla == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Artikal artikal = artikalService.getById(sifraArtikla);
		artikal.setDeleted(true);
		artikalService.update(artikal);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
