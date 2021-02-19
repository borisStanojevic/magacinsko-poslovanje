package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.dto.MagacinskaKarticaDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.MagacinskaKarticaToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MagacinskaKarticaService;

@RestController
@RequestMapping(value="/api/magacinska-kartica")
public class MagacinskaKarticaController {
	
	@Autowired
	MagacinskaKarticaService magacinskaKarticaService;
	
	@Autowired
	MagacinskaKarticaToDTO magacinskaKarticaToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<MagacinskaKarticaDTO>> getAll(@RequestParam("sifraMagacina") Integer sifraMagacina, 
			@RequestParam("idGodine") Integer idGodine) {
		
		Page<MagacinskaKartica> magacinskaKarticaPage = magacinskaKarticaService.getAll(sifraMagacina, idGodine, new PageRequest(0, 1000));
		Set<MagacinskaKartica> magacinskeKartice = new HashSet<>(magacinskaKarticaPage.getContent());
		Set<MagacinskaKarticaDTO> magacinskaKarticaDTO = magacinskaKarticaToDTO.convert(magacinskeKartice);
		return new ResponseEntity<Set<MagacinskaKarticaDTO>>(magacinskaKarticaDTO, HttpStatus.OK);
	}

	@GetMapping(value="/get-by-id/{idMagacinskeKartice}")
	public ResponseEntity<MagacinskaKarticaDTO> getByIdMagKart(@PathVariable("idMagacinskeKartice") Integer idMagacinskeKartice) {
		
		MagacinskaKartica magagacinskaKarticaPage = magacinskaKarticaService.getById(idMagacinskeKartice);
		MagacinskaKarticaDTO magacinskaKarticaDTO = magacinskaKarticaToDTO.convert(magagacinskaKarticaPage);
		return new ResponseEntity<MagacinskaKarticaDTO>(magacinskaKarticaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-by-sifra-artikla/{sifraArtikla}")
	public ResponseEntity<MagacinskaKarticaDTO> getBySifraArtikla(@PathVariable("sifraArtikla") Integer sifraArtikla) {
		
		MagacinskaKartica magagacinskaKartica = magacinskaKarticaService.getBySifraArtikla(sifraArtikla);
		MagacinskaKarticaDTO magacinskaKarticaDTO = magacinskaKarticaToDTO.convert(magagacinskaKartica);
		return new ResponseEntity<MagacinskaKarticaDTO>(magacinskaKarticaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-last")
	public ResponseEntity<MagacinskaKarticaDTO> getLast() {
		MagacinskaKartica magacinskaKartica = magacinskaKarticaService.findTopByOrderByIdDesc();
		MagacinskaKarticaDTO magacinskaKarticaDTO = magacinskaKarticaToDTO.convert(magacinskaKartica);
		return new ResponseEntity<MagacinskaKarticaDTO>(magacinskaKarticaDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createMagacinskaKartica(@RequestBody MagacinskaKartica magacinskaKartica, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		MagacinskaKartica newMagacinskaKartica = magacinskaKarticaService.add(magacinskaKartica);
		return new ResponseEntity<>(newMagacinskaKartica, HttpStatus.OK);
	}
	
	@PutMapping(value="/delete")
	public ResponseEntity<?> deleteMagacinskaKartica(@RequestParam("idMagacinskeKartice") Integer idMagacinskeKartice) {
		if(idMagacinskeKartice == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		MagacinskaKartica magacinskaKartica = magacinskaKarticaService.getById(idMagacinskeKartice);
		magacinskaKartica.setDeleted(true);
		magacinskaKarticaService.update(magacinskaKartica);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
