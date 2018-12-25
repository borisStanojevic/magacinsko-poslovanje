package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;

public class JedinicaMereDTO implements Serializable {

	private Integer idJedMere;
	private String nazivJediniceMere;
	private Set<ArtikalDTO> artikli;
	
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
	
	public JedinicaMereDTO() {
	}

	public JedinicaMereDTO(Integer idJedMere, String nazivJediniceMere, Set<ArtikalDTO> artikli) {
		super();
		this.idJedMere = idJedMere;
		this.nazivJediniceMere = nazivJediniceMere;
		this.artikli = artikli;
	}

	
	public JedinicaMereDTO(JedinicaMere jedinicaMere) {
		this(jedinicaMere.getIdJedMere(), jedinicaMere.getNazivJediniceMere(), ArtikalDTO.convert(jedinicaMere.getArtikli()));
	}

	public Integer getIdJedMere() {
		return idJedMere;
	}

	public void setIdJedMere(Integer idJedMere) {
		this.idJedMere = idJedMere;
	}

	public String getNazivJediniceMere() {
		return nazivJediniceMere;
	}

	public void setNazivJediniceMere(String nazivJediniceMere) {
		this.nazivJediniceMere = nazivJediniceMere;
	}

	public Set<ArtikalDTO> getArtikli() {
		return artikli;
	}

	public void setArtikli(Set<ArtikalDTO> artikli) {
		this.artikli = artikli;
	}
	
	
	
	
}
