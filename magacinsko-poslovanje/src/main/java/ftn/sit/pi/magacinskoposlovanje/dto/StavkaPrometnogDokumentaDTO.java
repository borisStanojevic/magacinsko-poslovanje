package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
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
public class StavkaPrometnogDokumentaDTO implements Serializable {

	private Integer idStavkePrometnogDokumenta;
	private Double cena;
	private Double kolicina;
	private Double vrednost;
	private ArtikalDTO artikal;
	//private PrometniDokumentDTO prometniDokument;

	public static Set<StavkaPrometnogDokumentaDTO> convert(
			Set<StavkaPrometnogDokumenta> stavkePrometnogDokumentaEntitySet) {
		Set<StavkaPrometnogDokumentaDTO> stavkePrometnogDokumentaDTOSet = new HashSet<>();
		Iterator<StavkaPrometnogDokumenta> iterator = stavkePrometnogDokumentaEntitySet.iterator();
		while (iterator.hasNext()) {
			StavkaPrometnogDokumenta stavkePrometnogDokumenta = (StavkaPrometnogDokumenta) iterator.next();
			StavkaPrometnogDokumentaDTO stavkePrometnogDokumentaDTO = new StavkaPrometnogDokumentaDTO(
					stavkePrometnogDokumenta);
			stavkePrometnogDokumentaDTOSet.add(stavkePrometnogDokumentaDTO);
		}
		return stavkePrometnogDokumentaDTOSet;
	}

	public StavkaPrometnogDokumentaDTO(StavkaPrometnogDokumenta stavkePrometnogDokumenta) {
		this(stavkePrometnogDokumenta.getIdStavkePrometnogDokumenta(), stavkePrometnogDokumenta.getCena(),
				stavkePrometnogDokumenta.getKolicina(), stavkePrometnogDokumenta.getVrednost(),
				new ArtikalDTO(stavkePrometnogDokumenta.getArtikal()));
	}

}
