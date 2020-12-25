package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.dto.MagacinDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.MagacinToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MagacinService;

@RestController
@RequestMapping(value="/api/magacin")
public class MagacinController {
	
	@Autowired
	MagacinService magacinService;
	
	@Autowired
	MagacinToDTO magacinToDTO;	
	
	@SuppressWarnings("deprecation")
	@GetMapping(value="/all")
	public ResponseEntity<Set<MagacinDTO>> returnAll(){
		
		Page<Magacin> magacini = magacinService.getAll(new PageRequest(0, 5));
		Set<Magacin> magacs = new HashSet<>(magacini.getContent());
		Set<MagacinDTO> dto = magacinToDTO.convert(magacs);
		System.out.println(magacini);
		return new ResponseEntity<Set<MagacinDTO>>(dto,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/get-by-id/{id}")
	public ResponseEntity<MagacinDTO> getById(@PathVariable Integer id) {
				
		Magacin magacin = magacinService.getById(id);
		MagacinDTO magacinDTO = magacinToDTO.convert(magacin);
		
		return new ResponseEntity<MagacinDTO>(magacinDTO, HttpStatus.OK);
	}

	@DeleteMapping(value="/delete")
	public ResponseEntity<?> deleteMagacin(@RequestParam("sifraMagacina") Integer sifraMagacina) {
		if(sifraMagacina == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		magacinService.deleteById(sifraMagacina);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
