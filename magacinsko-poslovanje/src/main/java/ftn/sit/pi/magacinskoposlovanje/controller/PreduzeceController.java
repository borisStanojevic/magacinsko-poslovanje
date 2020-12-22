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

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;
import ftn.sit.pi.magacinskoposlovanje.dto.PreduzeceDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PreduzeceToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.PreduzeceService;

@RestController
@RequestMapping(value="/api/preduzeca")
public class PreduzeceController {

	@Autowired
	PreduzeceService preduzeceService;
	
	@Autowired
	PreduzeceToDTO preduzeceToDTO;
	
	@GetMapping(value="/all") 
	public ResponseEntity<Set<PreduzeceDTO>> getAll() {
		
		Page<Preduzece> preduzecePage = preduzeceService.getAll(new PageRequest(0, 1000));
		Set<Preduzece> preduzeca = new HashSet<>(preduzecePage.getContent());
		Set<PreduzeceDTO> preduzeceDTO = preduzeceToDTO.convert(preduzeca);
		
		return new ResponseEntity<Set<PreduzeceDTO>>(preduzeceDTO, HttpStatus.OK);
	}
}
