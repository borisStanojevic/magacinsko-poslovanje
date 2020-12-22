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

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.dto.PoslovniPartnerDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PoslovniPartnerToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.PoslovniPartnerService;

@RestController
@RequestMapping(value="/api/poslovni-partner")
public class PoslovniPartnerController {

	@Autowired
	PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	PoslovniPartnerToDTO poslovniPartnerToDTO;
	
	@GetMapping(value="/all") 
	public ResponseEntity<Set<PoslovniPartnerDTO>> getAll() {
		
		Page<PoslovniPartner> poslovniPartnerPage = poslovniPartnerService.getAll(new PageRequest(0, 1000));
		Set<PoslovniPartner> poslovniPartners = new HashSet<>(poslovniPartnerPage.getContent());
		Set<PoslovniPartnerDTO> poslovniPartnerDTOs = poslovniPartnerToDTO.convert(poslovniPartners);
		
		return new ResponseEntity<Set<PoslovniPartnerDTO>>(poslovniPartnerDTOs, HttpStatus.OK);
	}
}
