package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
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
public class KategorijaArtikalaDTO implements Serializable {

	private Integer idKategorije;
	private String nazivKategorije;
	private Set<ArtikalDTO> artikli;
	//private PreduzeceDTO preduzece;

	public static Set<KategorijaArtikalaDTO> convert(Set<KategorijaArtikala> kategorijaArtikalaEntitySet) {
		Set<KategorijaArtikalaDTO> kategorijaArtikalaDTOSet = new HashSet<>();
		Iterator<KategorijaArtikala> iterator = kategorijaArtikalaEntitySet.iterator();
		while (iterator.hasNext()) {
			KategorijaArtikala kategorijaArtikala = (KategorijaArtikala) iterator.next();
			KategorijaArtikalaDTO kategorijaArtikalaDTO = new KategorijaArtikalaDTO(kategorijaArtikala);
			kategorijaArtikalaDTOSet.add(kategorijaArtikalaDTO);
		}
		return kategorijaArtikalaDTOSet;
	}

	public KategorijaArtikalaDTO(KategorijaArtikala kategorijaArtikala) {
		this(kategorijaArtikala.getIdKategorije(), kategorijaArtikala.getNazivKategorije(),
				ArtikalDTO.convert(kategorijaArtikala.getArtikli()));
	}

}
