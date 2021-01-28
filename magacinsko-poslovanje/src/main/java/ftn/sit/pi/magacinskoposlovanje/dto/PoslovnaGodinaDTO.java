package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
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
public class PoslovnaGodinaDTO implements Serializable {

	private Integer idGodine;
	private Date godina;
	private Boolean zakljucena;
	@JsonIgnore
	private Set<MagacinskaKarticaDTO> magacinskeKartice;
	@JsonIgnore
	private Set<PrometniDokumentDTO> prometniDokumenti;

	public static Set<PoslovnaGodinaDTO> convert(Set<PoslovnaGodina> poslovnaGodinaEntitySet) {
		Set<PoslovnaGodinaDTO> poslovnaGodinaDTOSet = new HashSet<>();
		Iterator<PoslovnaGodina> iterator = poslovnaGodinaEntitySet.iterator();
		while (iterator.hasNext()) {
			PoslovnaGodina poslovnaGodina = (PoslovnaGodina) iterator.next();
			PoslovnaGodinaDTO poslovnaGodinaDTO = new PoslovnaGodinaDTO(poslovnaGodina);
			poslovnaGodinaDTOSet.add(poslovnaGodinaDTO);
		}
		return poslovnaGodinaDTOSet;
	}

	public PoslovnaGodinaDTO(PoslovnaGodina poslovnaGodina) {
		this(poslovnaGodina.getIdGodine(), poslovnaGodina.getGodina(), poslovnaGodina.isZakljucena(),
				MagacinskaKarticaDTO.convert(poslovnaGodina.getMagacinskeKartice()),
				PrometniDokumentDTO.convert(poslovnaGodina.getPrometniDokumenti()));
	}

}
