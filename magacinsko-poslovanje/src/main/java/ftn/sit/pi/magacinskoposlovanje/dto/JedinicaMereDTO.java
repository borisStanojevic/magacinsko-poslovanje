package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;
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
public class JedinicaMereDTO implements Serializable {

	private Integer idJedMere;
	private String nazivJediniceMere;
	//private Set<ArtikalDTO> artikli;

	public static Set<JedinicaMereDTO> convert(Set<JedinicaMere> jedinicaMereEntitySet) {
		Set<JedinicaMereDTO> jedinicaMereDTOSet = new HashSet<>();
		Iterator<JedinicaMere> iterator = jedinicaMereEntitySet.iterator();
		while (iterator.hasNext()) {
			JedinicaMere jedinicaMere = (JedinicaMere) iterator.next();
			JedinicaMereDTO jedinicaMereDTO = new JedinicaMereDTO(jedinicaMere);
			jedinicaMereDTOSet.add(jedinicaMereDTO);
		}
		return jedinicaMereDTOSet;
	}

	public JedinicaMereDTO(JedinicaMere jedinicaMere) {
		this(jedinicaMere.getIdJedMere(), jedinicaMere.getNazivJediniceMere());
	}

}
