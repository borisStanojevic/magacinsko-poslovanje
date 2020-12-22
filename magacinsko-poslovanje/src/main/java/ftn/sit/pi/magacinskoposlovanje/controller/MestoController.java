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

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;
import ftn.sit.pi.magacinskoposlovanje.dto.MestoDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.MestoToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MestoService;

@RestController
@RequestMapping(value="/api/mesto")
public class MestoController {

	@Autowired
	MestoService mestoService;
	
	@Autowired
	MestoToDTO mestoToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<MestoDTO>> getAll() {
		
		Page<Mesto> mestoPage = mestoService.getAll(new PageRequest(0, 1000));
		Set<Mesto> mesta = new HashSet<>(mestoPage.getContent());
		Set<MestoDTO> mestaDTO = mestoToDTO.convert(mesta);
		
		return new ResponseEntity<Set<MestoDTO>>(mestaDTO, HttpStatus.OK);
	}
}
