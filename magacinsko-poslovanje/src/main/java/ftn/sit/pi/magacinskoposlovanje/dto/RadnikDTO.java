package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;
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
public class RadnikDTO implements Serializable {

	private Integer idRadnika;
	private String imePrezime;
	private String password;
	private String username;
	private Set<MagacinDTO> magacini;
	private Set<PreduzeceDTO> preduzeca;

	public static Set<RadnikDTO> convert(Set<Radnik> radnikEntitySet) {
		Set<RadnikDTO> radnikDTOSet = new HashSet<>();
		Iterator<Radnik> iterator = radnikEntitySet.iterator();
		while (iterator.hasNext()) {
			Radnik radnik = (Radnik) iterator.next();
			RadnikDTO radnikDTO = new RadnikDTO(radnik);
			radnikDTOSet.add(radnikDTO);
		}
		return radnikDTOSet;
	}

	public RadnikDTO(Radnik radnik) {
		this(radnik.getIdRadnika(), radnik.getImePrezime(), radnik.getPassword(), radnik.getUsername(),
				MagacinDTO.convert(radnik.getMagacini()), PreduzeceDTO.convert(radnik.getPreduzeca()));
	}

}
