package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPartnera;
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
public class PoslovniPartnerDTO implements Serializable {

	private Integer sifraPartnera;
	private String adresaPoslovnogPartnera;
	private String nazivPartnera;
	private String pib;
	private TipPartnera tipPartnera;
	private MestoDTO mesto;
	//private Set<PrometniDokumentDTO> prometniDokumenti;

	public static Set<PoslovniPartnerDTO> convert(Set<PoslovniPartner> poslovniPartnerEntitySet) {
		Set<PoslovniPartnerDTO> poslovniPartnerDTOSet = new HashSet<>();
		Iterator<PoslovniPartner> iterator = poslovniPartnerEntitySet.iterator();
		while (iterator.hasNext()) {
			PoslovniPartner poslovniPartner = (PoslovniPartner) iterator.next();
			PoslovniPartnerDTO poslovniPartnerDTO = new PoslovniPartnerDTO(poslovniPartner);
			poslovniPartnerDTOSet.add(poslovniPartnerDTO);
		}
		return poslovniPartnerDTOSet;
	}

	public PoslovniPartnerDTO(PoslovniPartner poslovniPartner) {
		this(poslovniPartner.getSifraPartnera(), poslovniPartner.getAdresaPoslovnogPartnera(),
				poslovniPartner.getNazivPartnera(), poslovniPartner.getPib(), poslovniPartner.getTipPartnera(),
				new MestoDTO(poslovniPartner.getMesto()));
	}

}
