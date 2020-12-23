package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.dto.PrometniDokumentDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PrometniDokumentToDTO;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.PrometniDokumentService;

@RestController
@RequestMapping(value="/api/prometni-dokument")
public class PrometniDokumentController {

	@Autowired
	PrometniDokumentService prometniDokumentService;
	
	@Autowired
	PrometniDokumentToDTO prometniDokumentToDTO;
	
	@GetMapping(value="/all")
	public ResponseEntity<Set<PrometniDokumentDTO>> getAll(@RequestParam("sifraMagacina") Integer sifraMagacina,
			@RequestParam("idGodine") Integer idGodine) {
		
		Page<PrometniDokument> prometniDokumentPage = prometniDokumentService.getAll(sifraMagacina, idGodine, new PageRequest(0, 1000));
		Set<PrometniDokument> prometniDokumenti = new HashSet<>(prometniDokumentPage.getContent());
		Set<PrometniDokumentDTO> prometniDokumentDTO = prometniDokumentToDTO.convert(prometniDokumenti);
		return new ResponseEntity<Set<PrometniDokumentDTO>>(prometniDokumentDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-for-poslovni-partner")
	public ResponseEntity<Set<PrometniDokumentDTO>> getAll(@RequestParam("sifraMagacina") Integer sifraMagacina,
			@RequestParam("idGodine") Integer idGodine, @RequestParam("sifraPartnera") Integer sifraPartnera) {
		
		Page<PrometniDokument> prometniDokumentPage = prometniDokumentService.getAll(sifraMagacina, idGodine, sifraPartnera, new PageRequest(0, 1000));
		Set<PrometniDokument> prometniDokumenti = new HashSet<>(prometniDokumentPage.getContent());
		Set<PrometniDokumentDTO> prometniDokumentDTO = prometniDokumentToDTO.convert(prometniDokumenti);
		return new ResponseEntity<Set<PrometniDokumentDTO>>(prometniDokumentDTO, HttpStatus.OK);
	}
}
