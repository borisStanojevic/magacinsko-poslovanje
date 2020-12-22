package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;
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
public class PreduzeceDTO implements Serializable {

	private Integer sifraPreduzeca;
	private String adresaPreduzeca;
	private String nazivPreduzeca;
	private String pib;
	//private Set<KategorijaArtikalaDTO> kategorijeArtikala;
	private Set<MagacinDTO> magacini;
	//private MestoDTO mesto;
	private String nazivMesta;
	private RadnikDTO radnik;

	public static Set<PreduzeceDTO> convert(Set<Preduzece> preduzeceEntitySet) {
		Set<PreduzeceDTO> preduzeceDTOSet = new HashSet<>();
		Iterator<Preduzece> iterator = preduzeceEntitySet.iterator();
		while (iterator.hasNext()) {
			Preduzece preduzece = (Preduzece) iterator.next();
			PreduzeceDTO preduzeceDTO = new PreduzeceDTO(preduzece);
			preduzeceDTOSet.add(preduzeceDTO);
		}
		return preduzeceDTOSet;
	}

	public PreduzeceDTO(Preduzece preduzece) {
		this(preduzece.getSifraPreduzeca(), preduzece.getAdresaPreduzeca(), preduzece.getNazivPreduzeca(),
				preduzece.getPib(), MagacinDTO.convert(preduzece.getMagacini()), preduzece.getMesto().getNazivMesta(),
				new RadnikDTO(preduzece.getRadnik()));
	}

}
