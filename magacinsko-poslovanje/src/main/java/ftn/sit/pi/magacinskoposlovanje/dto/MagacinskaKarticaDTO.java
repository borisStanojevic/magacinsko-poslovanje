package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
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
public class MagacinskaKarticaDTO implements Serializable {

	private Integer idMagacinskeKartice;
	private BigDecimal cena;
	private BigDecimal kolicinaIzlaza;
	private BigDecimal kolicinaPocetnogStanja;
	private BigDecimal kolicinaUlaza;
	private Integer redniBrMagacinskeKar;
	private BigDecimal ukupnaKolicina;
	private BigDecimal ukupnaVrednost;
	private BigDecimal vrednostIzlaza;
	private BigDecimal vrednostPocetnogStanja;
	private BigDecimal vrednostUlaza;
	private Set<AnalitikaMagacinskeKarticeDTO> analitikeMagacinskeKartice;
	private ArtikalDTO artikal;
	private MagacinDTO magacin;
	private PoslovnaGodinaDTO poslovnaGodina;

	public static Set<MagacinskaKarticaDTO> convert(Set<MagacinskaKartica> magacinskaKarticaEntitySet) {
		Set<MagacinskaKarticaDTO> magacinskaKarticaDTOSet = new HashSet<>();
		Iterator<MagacinskaKartica> iterator = magacinskaKarticaEntitySet.iterator();
		while (iterator.hasNext()) {
			MagacinskaKartica magacinskaKartica = (MagacinskaKartica) iterator.next();
			MagacinskaKarticaDTO magacinskaKarticaDTO = new MagacinskaKarticaDTO(magacinskaKartica);
			magacinskaKarticaDTOSet.add(magacinskaKarticaDTO);
		}
		return magacinskaKarticaDTOSet;
	}

	public MagacinskaKarticaDTO(MagacinskaKartica magacinskaKartica) {
		this(magacinskaKartica.getIdMagacinskeKartice(), magacinskaKartica.getCena(),
				magacinskaKartica.getKolicinaIzlaza(), magacinskaKartica.getKolicinaPocetnogStanja(),
				magacinskaKartica.getKolicinaUlaza(), magacinskaKartica.getRedniBrMagacinskeKar(),
				magacinskaKartica.getUkupnaKolicina(), magacinskaKartica.getUkupnaVrednost(),
				magacinskaKartica.getVrednostIzlaza(), magacinskaKartica.getVrednostPocetnogStanja(),
				magacinskaKartica.getVrednostUlaza(),
				AnalitikaMagacinskeKarticeDTO.convert(magacinskaKartica.getAnalitikeMagacinskeKartice()),
				new ArtikalDTO(magacinskaKartica.getArtikal()), new MagacinDTO(magacinskaKartica.getMagacin()),
				new PoslovnaGodinaDTO(magacinskaKartica.getPoslovnaGodina()));
	}

}
