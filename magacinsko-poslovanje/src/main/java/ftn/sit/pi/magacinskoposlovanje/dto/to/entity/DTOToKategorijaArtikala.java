package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.dto.KategorijaArtikalaDTO;

@Component
public class DTOToKategorijaArtikala implements Converter<KategorijaArtikalaDTO, KategorijaArtikala> {

	@Override
	public KategorijaArtikala convert(KategorijaArtikalaDTO source) {
		if(source == null) {
			return null;
		}
		KategorijaArtikala kategorijaArtikala = new KategorijaArtikala();
		kategorijaArtikala.setIdKategorije(source.getIdKategorije());
		kategorijaArtikala.setNazivKategorije(source.getNazivKategorije());
		return kategorijaArtikala;
	}
}
