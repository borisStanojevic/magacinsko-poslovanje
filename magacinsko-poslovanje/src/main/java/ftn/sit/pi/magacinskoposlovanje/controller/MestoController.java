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

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;
import ftn.sit.pi.magacinskoposlovanje.dto.MestoDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.MestoToDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.to.entity.DTOToMesto;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MestoService;

@RestController
@RequestMapping(value="/api/mesto")
public class MestoController {

	@Autowired
	MestoService mestoService;
	
	@Autowired
	MestoToDTO mestoToDTO;
	
	@Autowired
	DTOToMesto dtoToMesto;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<MestoDTO>> getAll() {
		
		Page<Mesto> mestoPage = mestoService.getAll(new PageRequest(0, 1000));
		Set<Mesto> mesta = new HashSet<>(mestoPage.getContent());
		Set<MestoDTO> mestaDTO = mestoToDTO.convert(mesta);		
		return new ResponseEntity<Set<MestoDTO>>(mestaDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create", consumes="application/json")
	public ResponseEntity<?> createMesto(@RequestBody MestoDTO mestoDTO) {
		Mesto newMesto = dtoToMesto.convert(mestoDTO);
		mestoService.add(newMesto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{postanskiBroj}", consumes="application/json")
	public ResponseEntity<?> updateMesto(@RequestBody Mesto mesto, @PathVariable("postanskiBroj") Integer postanskiBroj) {
		Mesto mestoForUpdate = mestoService.update(mesto);
		return new ResponseEntity<>(mestoForUpdate, HttpStatus.OK);
	}
	
	@PutMapping(value="/delete")
	public ResponseEntity<?> deleteMesto(@RequestParam("postanskiBroj") String postanskiBroj) {
		if(postanskiBroj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Mesto mesto = mestoService.getById(postanskiBroj);
		mesto.setDeleted(true);
		mestoService.update(mesto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
