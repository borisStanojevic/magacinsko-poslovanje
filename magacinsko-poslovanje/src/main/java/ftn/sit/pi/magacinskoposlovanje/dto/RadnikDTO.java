package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;

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
	
	
	public RadnikDTO() {	
	}

	public RadnikDTO(Integer idRadnika, String imePrezime, String password, String username, Set<MagacinDTO> magacini,
			Set<PreduzeceDTO> preduzeca) {
		super();
		this.idRadnika = idRadnika;
		this.imePrezime = imePrezime;
		this.password = password;
		this.username = username;
		this.magacini = magacini;
		this.preduzeca = preduzeca;
	}

	public RadnikDTO(Radnik radnik) {
		this(radnik.getIdRadnika(), radnik.getImePrezime(), radnik.getPassword(), radnik.getUsername(), MagacinDTO.convert(radnik.getMagacini()), PreduzeceDTO.convert(radnik.getPreduzeca()));
	}


	public Integer getIdRadnika() {
		return idRadnika;
	}

	public void setIdRadnika(Integer idRadnika) {
		this.idRadnika = idRadnika;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<MagacinDTO> getMagacini() {
		return magacini;
	}

	public void setMagacini(Set<MagacinDTO> magacini) {
		this.magacini = magacini;
	}

	public Set<PreduzeceDTO> getPreduzeca() {
		return preduzeca;
	}

	public void setPreduzeca(Set<PreduzeceDTO> preduzeca) {
		this.preduzeca = preduzeca;
	}
	
	
}
