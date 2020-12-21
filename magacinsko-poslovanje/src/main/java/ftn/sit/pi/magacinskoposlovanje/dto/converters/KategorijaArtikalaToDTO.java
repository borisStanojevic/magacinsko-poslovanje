package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.dto.KategorijaArtikalaDTO;

@Component
public class KategorijaArtikalaToDTO implements Converter<KategorijaArtikala, KategorijaArtikalaDTO> {

	@Autowired
	ArtikalToDTO artikalToDTO;
	
	@Autowired
	PreduzeceToDTO preduzeceToDTO;
	
	public KategorijaArtikalaDTO convert(KategorijaArtikala source) {
		
		if(source == null) {
			return null;
		}
		KategorijaArtikalaDTO kategorijaArtikalaDTO = new KategorijaArtikalaDTO();
		kategorijaArtikalaDTO.setIdKategorije(source.getIdKategorije());
		kategorijaArtikalaDTO.setNazivKategorije(source.getNazivKategorije());
		kategorijaArtikalaDTO.setArtikli(artikalToDTO.convert(source.getArtikli()));
		kategorijaArtikalaDTO.setPreduzece(preduzeceToDTO.convert(source.getPreduzece()));
	
		return kategorijaArtikalaDTO;
	}
	
	public Set<KategorijaArtikalaDTO> convert(Set<KategorijaArtikala> source) {
		Set<KategorijaArtikalaDTO> kategorije = new HashSet<KategorijaArtikalaDTO>();
		for(KategorijaArtikala ka : source) {
			kategorije.add(convert(ka));
		}
		return kategorije;
	}
}
