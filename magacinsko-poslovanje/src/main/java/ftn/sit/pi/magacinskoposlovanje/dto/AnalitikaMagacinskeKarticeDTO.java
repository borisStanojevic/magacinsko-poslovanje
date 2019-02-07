package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
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
public class AnalitikaMagacinskeKarticeDTO implements Serializable {

	private Integer idAnalitike;
	private Double cena;
	private Date datumNastanka;
	private Double kolicina;
	private Smer smer;
	private TipPrometa tipPrometa;
	private Double vrednost;
	private MagacinskaKarticaDTO magacinskaKartica;

	public static Set<AnalitikaMagacinskeKarticeDTO> convert(
			Set<AnalitikaMagacinskeKartice> analitikaMagacinskeKarticeEntitySet) {
		Set<AnalitikaMagacinskeKarticeDTO> analitikaMagacinskeKarticeDTOSet = new HashSet<>();
		Iterator<AnalitikaMagacinskeKartice> iterator = analitikaMagacinskeKarticeEntitySet.iterator();
		while (iterator.hasNext()) {
			AnalitikaMagacinskeKartice analitikaMagacinskeKartice = (AnalitikaMagacinskeKartice) iterator.next();
			AnalitikaMagacinskeKarticeDTO analitikaMagacinskeKarticeDTO = new AnalitikaMagacinskeKarticeDTO(
					analitikaMagacinskeKartice);
			analitikaMagacinskeKarticeDTOSet.add(analitikaMagacinskeKarticeDTO);
		}
		return analitikaMagacinskeKarticeDTOSet;
	}

	public AnalitikaMagacinskeKarticeDTO(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		this(analitikaMagacinskeKartice.getIdAnalitike(), analitikaMagacinskeKartice.getCena(),
				analitikaMagacinskeKartice.getDatumNastanka(), analitikaMagacinskeKartice.getKolicina(),
				analitikaMagacinskeKartice.getSmer(), analitikaMagacinskeKartice.getTipPrometa(),
				analitikaMagacinskeKartice.getVrednost(),
				new MagacinskaKarticaDTO(analitikaMagacinskeKartice.getMagacinskaKartica()));
	}

}
