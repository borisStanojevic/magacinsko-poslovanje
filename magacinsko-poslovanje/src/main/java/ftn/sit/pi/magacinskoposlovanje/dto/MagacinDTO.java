package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
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
public class MagacinDTO implements Serializable {

	private Integer sifraMagacina;
	private String nazivMagacina;
	private PreduzeceDTO preduzece;
	private RadnikDTO radnik;
	private Set<MagacinskaKarticaDTO> magacinskeKartice;
	private Set<PrometniDokumentDTO> prometniDokument;

	public static Set<MagacinDTO> convert(Set<Magacin> magacinEntitySet) {
		Set<MagacinDTO> magacinDTOSet = new HashSet<>();
		Iterator<Magacin> iterator = magacinEntitySet.iterator();
		while (iterator.hasNext()) {
			Magacin magacin = (Magacin) iterator.next();
			MagacinDTO magacinDTO = new MagacinDTO(magacin);
			magacinDTOSet.add(magacinDTO);
		}
		return magacinDTOSet;
	}

	public MagacinDTO(Magacin magacin) {
		this(magacin.getSifraMagacina(), magacin.getNazivMagacina(), new PreduzeceDTO(magacin.getPreduzece()),
				new RadnikDTO(magacin.getRadnik()), MagacinskaKarticaDTO.convert(magacin.getMagacinskeKartice()),
				PrometniDokumentDTO.convert(magacin.getPrometniDokumenti()));
	}
}
