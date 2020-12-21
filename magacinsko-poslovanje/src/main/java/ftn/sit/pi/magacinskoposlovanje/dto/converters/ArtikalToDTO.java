package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;
import ftn.sit.pi.magacinskoposlovanje.dto.ArtikalDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.KategorijaArtikalaDTO;

@Component
public class ArtikalToDTO implements Converter<Artikal, ArtikalDTO> {

	@Autowired
	JedinicaMereToDTO jedinicaMereToDTO;
	
	@Autowired
	KategorijaArtikalaToDTO kategorijaArtikalaToDTO;
	
	@Autowired
	MagacinskaKarticaToDTO magKartToDTO;
	
	@Autowired
	StavkaPrometnogDokumentaToDTO stavkaPromDokToDTO;
	
	@Override
	public ArtikalDTO convert(Artikal source) {
		
		if(source == null) {
			return null;
		}
		ArtikalDTO artikalDTO = new ArtikalDTO();
		artikalDTO.setSifraArtikla(source.getSifraArtikla());
		artikalDTO.setNazivArtikla(source.getNazivArtikla());
		artikalDTO.setJedinicaMere(jedinicaMereToDTO.convert(source.getJedinicaMere()));
		artikalDTO.setKategorijaArtikala(kategorijaArtikalaToDTO.convert(source.getKategorijaArtikala()));
		artikalDTO.setMagacinskeKartice(magKartToDTO.convert(source.getMagacinskeKartice()));
		artikalDTO.setStavkePrometnogDokumenta(stavkaPromDokToDTO.convert(source.getStavkePrometnogDokumenta()));
	
		return artikalDTO;
	}
	
	public Set<ArtikalDTO> convert(Set<Artikal> source) {
		Set<ArtikalDTO> artikli = new HashSet<ArtikalDTO>();
		for(Artikal a : source) {
			artikli.add(convert(a));
		}
		return artikli;
	}
	
}
