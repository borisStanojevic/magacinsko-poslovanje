package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;
import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.domain.Smer;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArtikalDTO implements Serializable {

	private Integer sifraArtikla;
	private String nazivArtikla;
	private JedinicaMereDTO jedinicaMere;
	private KategorijaArtikalaDTO kategorijaArtikala;
	private Set<MagacinskaKarticaDTO> magacinskeKartice;
	//private Set<StavkaPrometnogDokumentaDTO> stavkePrometnogDokumenta;

	public static Set<ArtikalDTO> convert(Set<Artikal> artikalEntitySet) {
		Set<ArtikalDTO> artikalDTOSet = new HashSet<>();
		Iterator<Artikal> iterator = artikalEntitySet.iterator();
		while (iterator.hasNext()) {
			Artikal artikal = (Artikal) iterator.next();
			ArtikalDTO artikalDTO = new ArtikalDTO(artikal);
			artikalDTOSet.add(artikalDTO);
		}
		return artikalDTOSet;
	}

	public ArtikalDTO(Artikal artikal) {
		this(artikal.getSifraArtikla(), artikal.getNazivArtikla(), new JedinicaMereDTO(artikal.getJedinicaMere()),
				new KategorijaArtikalaDTO(artikal.getKategorijaArtikala()),
				MagacinskaKarticaDTO.convert(artikal.getMagacinskeKartice()));
	}

}
