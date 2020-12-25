package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;
import ftn.sit.pi.magacinskoposlovanje.dto.ArtikalDTO;

@Component
public class DTOToArtikal implements Converter<ArtikalDTO, Artikal> {

	@Autowired
	DTOToJedinicaMere dtoToJedinicaMere;
	
	@Autowired
	DTOToKategorijaArtikala dtoToKategorijaArtikala;
	
	@Override
	public Artikal convert(ArtikalDTO source) {
		if(source == null) {
			return null;
		}
		Artikal artikal = new Artikal();
		artikal.setSifraArtikla(source.getSifraArtikla());
		artikal.setNazivArtikla(source.getNazivArtikla());
		artikal.setJedinicaMere(dtoToJedinicaMere.convert(source.getJedinicaMere()));
		artikal.setKategorijaArtikala(dtoToKategorijaArtikala.convert(source.getKategorijaArtikala()));
		return artikal;
		
	}
}
