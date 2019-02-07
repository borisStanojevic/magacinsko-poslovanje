package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;
import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.ArtikalService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.JedinicaMereService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.KategorijaArtikalaService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MagacinService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MagacinskaKarticaService;

@RestController
@RequestMapping(value="/test")
public class TestController{
	
	@Autowired MagacinService magacinService;
	@Autowired KategorijaArtikalaService kategorijaArtikalaService;
	@Autowired ArtikalService artikalService;
	@Autowired MagacinskaKarticaService mkService;
	
	@GetMapping(value="/magacini")
	public Integer testMagaciniQuery()
	{
		Page<Magacin> magaciniPage = magacinService.getAll(new PageRequest(0, 5));
		return magaciniPage.getNumberOfElements();
	}
	
	@GetMapping(value="/kategorije")
	public Integer testKategorijeQuery()
	{
		Page<KategorijaArtikala> kategorijePage = kategorijaArtikalaService.getAll(new PageRequest(0, 5));
		return kategorijePage.getNumberOfElements();
	}
	
	@GetMapping(value="/artikli")
	public List<String> testArtikliQuery()
	{
		Page<Artikal> artikliPage = artikalService.getAll(new PageRequest(0, 5));
		ArrayList<String> artikli = new ArrayList<>();
		for(Artikal a : artikliPage.getContent())
		{
			artikli.add(a.getNazivArtikla());
		}
		return artikli;
	}
	
//	@GetMapping(value="/magacini/{sifraMagacina}/magacinske-kartice")
//	public List<Integer> testMkQuery(@PathVariable("sifraMagacina") Integer sifraMagacina, Pageable pageable)
//	{
//		Page<MagacinskaKartica> mkPage = mkService.getAll(sifraMagacina, pageable);
//		
//		List<Integer> mks = new ArrayList<>();
//		for(MagacinskaKartica mk : mkPage.getContent())
//		{
//			mks.add(mk.getIdMagacinskeKartice());
//		}
//		return mks;
//	}
	
//	@GetMapping(value="/magacini/{sifraMagacina}/magacinske-kartice/{idGodine}")
//	public List<Integer> testMkQuery(@PathVariable("sifraMagacina") Integer sifraMagacina, @PathVariable("idGodine") Integer idGodine, Pageable pageable)
//	{
//		Page<MagacinskaKartica> mkPage = mkService.getAllForPoslovnaGodina(sifraMagacina, idGodine, pageable);
//
//		List<Integer> mks = new ArrayList<>();
//		for(MagacinskaKartica mk : mkPage.getContent())
//		{
//			mks.add(mk.getIdMagacinskeKartice());
//		}
//		return mks;
//	}

}
