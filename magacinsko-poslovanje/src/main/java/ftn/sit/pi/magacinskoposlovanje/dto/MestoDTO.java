package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;
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
public class MestoDTO implements Serializable {

	private String postanskiBroj;
	private String drzava;
	private String nazivMesta;
	//private Set<PoslovniPartnerDTO> poslovniPartner;
	private Set<PreduzeceDTO> preduzeca;

	public static Set<MestoDTO> convert(Set<Mesto> mestoEntitySet) {
		Set<MestoDTO> mestoDTOSet = new HashSet<>();
		Iterator<Mesto> iterator = mestoEntitySet.iterator();
		while (iterator.hasNext()) {
			Mesto mesto = (Mesto) iterator.next();
			MestoDTO mestoDTO = new MestoDTO(mesto);
			mestoDTOSet.add(mestoDTO);
		}
		return mestoDTOSet;
	}

	public MestoDTO(Mesto mesto) {
		this(mesto.getPostanskiBroj(), mesto.getDrzava(), mesto.getNazivMesta(),
				PreduzeceDTO.convert(mesto.getPreduzeca()));
	}

}
