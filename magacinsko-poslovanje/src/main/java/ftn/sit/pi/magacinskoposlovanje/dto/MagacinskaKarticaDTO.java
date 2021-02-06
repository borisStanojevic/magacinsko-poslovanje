package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Double cena;
	private Double kolicinaIzlaza;
	private Double kolicinaPocetnogStanja;
	private Double kolicinaUlaza;
	private Integer redniBrMagacinskeKar;
	private Double ukupnaKolicina;
	private Double ukupnaVrednost;
	private Double vrednostIzlaza;
	private Double vrednostPocetnogStanja;
	private Double vrednostUlaza;
	private Set<AnalitikaMagacinskeKarticeDTO> analitikeMagacinskeKartice;
	private ArtikalDTO artikal;
	@JsonIgnore
	private MagacinDTO magacin;
	//@JsonIgnore
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
