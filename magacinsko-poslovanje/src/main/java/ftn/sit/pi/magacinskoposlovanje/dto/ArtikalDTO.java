package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;

public class ArtikalDTO implements Serializable {

	
	private Integer sifraArtikla;
	private String nazivArtikla;
	private JedinicaMereDTO jedinicaMere;
	private KategorijaArtikalaDTO kategorijaArtikala;
	private Set<MagacinskaKarticaDTO> magacinskeKartice;
	private Set<StavkePrometnogDokumentaDTO> stavkePrometnogDokumenta;
	
	public static Set<ArtikalDTO> convert(Set<Artikal> artikalEntitySet) {
		Set<ArtikalDTO> artikalDTOSet = new HashSet<>();
		Iterator<Artikal> iterator = artikalEntitySet.iterator();
		while (iterator.hasNext()) {
			Artikal artikal = (Artikal) iterator.next();
			ArtikalDTO artikalDTO = new ArtikalDTO(artikal);
			artikalDTOSet.add(artikalDTO);			
		}
		return artikalDTOSet;
	}
	
	
	public ArtikalDTO() {		
	}

	public ArtikalDTO(Integer sifraArtikla, String nazivArtikla, JedinicaMereDTO jedinicaMere,
			KategorijaArtikalaDTO kategorijaArtikala, Set<MagacinskaKarticaDTO> magacinskeKartice,
			Set<StavkePrometnogDokumentaDTO> stavkePrometnogDokumenta) {
		super();
		this.sifraArtikla = sifraArtikla;
		this.nazivArtikla = nazivArtikla;
		this.jedinicaMere = jedinicaMere;
		this.kategorijaArtikala = kategorijaArtikala;
		this.magacinskeKartice = magacinskeKartice;
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}
	
	

	public ArtikalDTO(Artikal artikal) {
		this(artikal.getSifraArtikla(), artikal.getNazivArtikla(), new JedinicaMereDTO(artikal.getJedinicaMere()), new KategorijaArtikalaDTO(artikal.getKategorijaArtikala()), 
				MagacinskaKarticaDTO.convert(artikal.getMagacinskeKartice()), StavkePrometnogDokumentaDTO.convert(artikal.getStavkePrometnogDokumenta()));
	}


	public Integer getSifraArtikla() {
		return sifraArtikla;
	}

	public void setSifraArtikla(Integer sifraArtikla) {
		this.sifraArtikla = sifraArtikla;
	}

	public String getNazivArtikla() {
		return nazivArtikla;
	}

	public void setNazivArtikla(String nazivArtikla) {
		this.nazivArtikla = nazivArtikla;
	}

	public JedinicaMereDTO getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMereDTO jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public KategorijaArtikalaDTO getKategorijaArtikala() {
		return kategorijaArtikala;
	}

	public void setKategorijaArtikala(KategorijaArtikalaDTO kategorijaArtikala) {
		this.kategorijaArtikala = kategorijaArtikala;
	}

	public Set<MagacinskaKarticaDTO> getMagacinskeKartice() {
		return magacinskeKartice;
	}

	public void setMagacinskeKartice(Set<MagacinskaKarticaDTO> magacinskeKartice) {
		this.magacinskeKartice = magacinskeKartice;
	}

	public Set<StavkePrometnogDokumentaDTO> getStavkePrometnogDokumenta() {
		return stavkePrometnogDokumenta;
	}

	public void setStavkePrometnogDokumenta(Set<StavkePrometnogDokumentaDTO> stavkePrometnogDokumenta) {
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}
	
	
}
