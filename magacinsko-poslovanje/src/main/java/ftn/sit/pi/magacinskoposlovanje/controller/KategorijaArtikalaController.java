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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.dto.KategorijaArtikalaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.KategorijaArtikalaToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.KategorijaArtikalaService;

@RestController
@RequestMapping(value="/api/kategorija-artikala")
public class KategorijaArtikalaController {

	@Autowired
	KategorijaArtikalaService kategorijaArtikalaService;
	
	@Autowired
	KategorijaArtikalaToDTO kategorijaArtikalaToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<KategorijaArtikalaDTO>> getAll() {
		
		Page<KategorijaArtikala> kategorijaArtikalaPage = kategorijaArtikalaService.getAll(new PageRequest(0, 5));
		Set<KategorijaArtikala> kategorijaArtikala = new HashSet<>(kategorijaArtikalaPage.getContent());
		Set<KategorijaArtikalaDTO> dto = kategorijaArtikalaToDTO.convert(kategorijaArtikala);
		
		return new ResponseEntity<Set<KategorijaArtikalaDTO>>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createKategorijaArtikla(@RequestBody KategorijaArtikala kategorijaArtikala, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		KategorijaArtikala newKategorijaArtikala = kategorijaArtikalaService.add(kategorijaArtikala);
		return new ResponseEntity<>(newKategorijaArtikala, HttpStatus.OK);
	}
}
