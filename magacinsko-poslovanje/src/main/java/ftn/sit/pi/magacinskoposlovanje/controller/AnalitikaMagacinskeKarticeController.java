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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.dto.AnalitikaMagacinskeKarticeDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.AnalitikaMagacinskeKarticeToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.AnalitikaMagacinskeKarticeService;

@RestController
@RequestMapping(value="/api/analitika-magacinske")
public class AnalitikaMagacinskeKarticeController {

	@Autowired
	AnalitikaMagacinskeKarticeService analitikaMagKarService;
	
	@Autowired
	AnalitikaMagacinskeKarticeToDTO analitikaMagKarToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<AnalitikaMagacinskeKarticeDTO>> getAll() {
		
		Page<AnalitikaMagacinskeKartice> analitikaMagKarPage = analitikaMagKarService.getAll(new PageRequest(0, 1000));
		Set<AnalitikaMagacinskeKartice> analitikeMagKar = new HashSet<>(analitikaMagKarPage.getContent());
		Set<AnalitikaMagacinskeKarticeDTO> analitikeMagKarDTO = analitikaMagKarToDTO.convert(analitikeMagKar);
		return new ResponseEntity<Set<AnalitikaMagacinskeKarticeDTO>>(analitikeMagKarDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-by-id/{idAnalitike}")
	public ResponseEntity<AnalitikaMagacinskeKarticeDTO> getById(@PathVariable("idAnalitike") Integer idAnalitike) {
		
		AnalitikaMagacinskeKartice analitikaMagKar = analitikaMagKarService.getById(idAnalitike);
		AnalitikaMagacinskeKarticeDTO analitikaMagKarDTO = analitikaMagKarToDTO.convert(analitikaMagKar);
		return new ResponseEntity<AnalitikaMagacinskeKarticeDTO>(analitikaMagKarDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createAnalitikaMagKar(@RequestBody AnalitikaMagacinskeKartice analitikaMagacinskeKartice, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
		}
		AnalitikaMagacinskeKartice newAnalitikaMagKar = analitikaMagKarService.add(analitikaMagacinskeKartice);
		return new ResponseEntity<>(newAnalitikaMagKar, HttpStatus.OK);
	}
}
