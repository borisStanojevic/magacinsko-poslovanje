package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
public class PrijemnicaDTO implements Serializable {

	private MagacinDTO magacin;
	private PoslovniPartnerDTO poslovniPartner;
	private String datumKreiranja;
	private List<StavkaPrometnogDokumentaDTO> stavkePrometnogDokumenta;
}
