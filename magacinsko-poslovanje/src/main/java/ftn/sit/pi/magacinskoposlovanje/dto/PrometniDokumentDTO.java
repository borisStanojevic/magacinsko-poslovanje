package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.domain.Status;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometnogDokumenta;
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
public class PrometniDokumentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2562294355463301143L;
	private Integer idPrometnogDokumenta;
	private Integer brojPrometnogDokumenta;
	private Date datumFormiranja;
	private Date datumKnjizenja;
	private Status status;
	private TipPrometnogDokumenta tipPrometnogDokumenta;
	//private MagacinDTO magacin;
	private PoslovnaGodinaDTO poslovnaGodina;
	private PoslovniPartnerDTO poslovniPartner;
	private Set<StavkaPrometnogDokumentaDTO> stavkePrometnogDokumenta;

	public static Set<PrometniDokumentDTO> convert(Set<PrometniDokument> prometniDokumentEntitySet) {
		Set<PrometniDokumentDTO> prometniDokumentDTOSet = new HashSet<>();
		Iterator<PrometniDokument> iterator = prometniDokumentEntitySet.iterator();
		while (iterator.hasNext()) {
			PrometniDokument prometniDokument = (PrometniDokument) iterator.next();
			PrometniDokumentDTO prometniDokumentDTO = new PrometniDokumentDTO(prometniDokument);
			prometniDokumentDTOSet.add(prometniDokumentDTO);
		}
		return prometniDokumentDTOSet;
	}

	public PrometniDokumentDTO(PrometniDokument prometniDokument) {
		this(prometniDokument.getIdPrometnogDokumenta(), prometniDokument.getBrojPrometnogDokumenta(),
				prometniDokument.getDatumFormiranja(), prometniDokument.getDatumKnjizenja(),
				prometniDokument.getStatus(), prometniDokument.getTipPrometnogDokumenta(), 
				new PoslovnaGodinaDTO(prometniDokument.getPoslovnaGodina()),
				new PoslovniPartnerDTO(prometniDokument.getPoslovniPartner()),
				StavkaPrometnogDokumentaDTO.convert(prometniDokument.getStavkePrometnogDokumenta()));
	}

}
