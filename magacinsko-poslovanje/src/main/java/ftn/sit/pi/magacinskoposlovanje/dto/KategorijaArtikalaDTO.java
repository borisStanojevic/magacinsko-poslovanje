package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;

public class KategorijaArtikalaDTO implements Serializable {

	private Integer idKategorije;
	private String nazivKategorije;
	private Set<ArtikalDTO> artikli;
	private PreduzeceDTO preduzece;
	
	public static Set<KategorijaArtikalaDTO> convert(Set<KategorijaArtikala> kategorijaArtikalaEntitySet) {
		Set<KategorijaArtikalaDTO> kategorijaArtikalaDTOSet = new HashSet<>();
		Iterator<KategorijaArtikala> iterator = kategorijaArtikalaEntitySet.iterator();
		while (iterator.hasNext()) {
			KategorijaArtikala kategorijaArtikala = (KategorijaArtikala) iterator.next();
			KategorijaArtikalaDTO kategorijaArtikalaDTO = new KategorijaArtikalaDTO(kategorijaArtikala);
			kategorijaArtikalaDTOSet.add(kategorijaArtikalaDTO);			
		}
		return kategorijaArtikalaDTOSet;
	}
	
	public KategorijaArtikalaDTO() {		
	}

	public KategorijaArtikalaDTO(Integer idKategorije, String nazivKategorije, Set<ArtikalDTO> artikli,
			PreduzeceDTO preduzece) {
		super();
		this.idKategorije = idKategorije;
		this.nazivKategorije = nazivKategorije;
		this.artikli = artikli;
		this.preduzece = preduzece;
	}

	public KategorijaArtikalaDTO(KategorijaArtikala kategorijaArtikala) {
		this(kategorijaArtikala.getIdKategorije(), kategorijaArtikala.getNazivKategorije(), ArtikalDTO.convert(kategorijaArtikala.getArtikli()), 
				new PreduzeceDTO(kategorijaArtikala.getPreduzece()));
	}

	public Integer getIdKategorije() {
		return idKategorije;
	}

	public void setIdKategorije(Integer idKategorije) {
		this.idKategorije = idKategorije;
	}

	public String getNazivKategorije() {
		return nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public Set<ArtikalDTO> getArtikli() {
		return artikli;
	}

	public void setArtikli(Set<ArtikalDTO> artikli) {
		this.artikli = artikli;
	}

	public PreduzeceDTO getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(PreduzeceDTO preduzece) {
		this.preduzece = preduzece;
	}
	
	
	
}
