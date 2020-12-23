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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.dto.StavkaPrometnogDokumentaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.StavkaPrometnogDokumentaToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.StavkaPrometnogDokumentaService;

@RestController
@RequestMapping(value="/api/stavka-prometnog-dokumenta")
public class StavkaPrometnogDokumentaController {

	@Autowired
	StavkaPrometnogDokumentaService stavkaPromDokService;
	
	@Autowired
	StavkaPrometnogDokumentaToDTO stavkaPromDokToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<StavkaPrometnogDokumentaDTO>> getAll() {
		
		Page<StavkaPrometnogDokumenta> stavkaPromDokPage = stavkaPromDokService.getAll(new PageRequest(0, 1000));
		Set<StavkaPrometnogDokumenta> stavkePromDok = new HashSet<>(stavkaPromDokPage.getContent());
		Set<StavkaPrometnogDokumentaDTO> stavkePromDokDTO = stavkaPromDokToDTO.convert(stavkePromDok);
		return new ResponseEntity<Set<StavkaPrometnogDokumentaDTO>>(stavkePromDokDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-by-id-prometnog-dokumenta")
	public ResponseEntity<Set<StavkaPrometnogDokumentaDTO>> getAll(@RequestParam("idPrometnogDokumenta") Integer idPrometnogDokumenta) {
		
		Page<StavkaPrometnogDokumenta> stavkaPromDokPage = stavkaPromDokService.getAll(idPrometnogDokumenta, new PageRequest(0, 1000));
		Set<StavkaPrometnogDokumenta> stavkePromDok = new HashSet<>(stavkaPromDokPage.getContent());
		Set<StavkaPrometnogDokumentaDTO> stavkePromDokDTO = stavkaPromDokToDTO.convert(stavkePromDok);
		return new ResponseEntity<Set<StavkaPrometnogDokumentaDTO>>(stavkePromDokDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createStavkaPromDok(@RequestBody StavkaPrometnogDokumenta stavkaPrometnogDokumenta, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		StavkaPrometnogDokumenta newStavkaPromDok = stavkaPromDokService.add(stavkaPrometnogDokumenta);
		return new ResponseEntity<>(newStavkaPromDok, HttpStatus.OK);
	}
}
