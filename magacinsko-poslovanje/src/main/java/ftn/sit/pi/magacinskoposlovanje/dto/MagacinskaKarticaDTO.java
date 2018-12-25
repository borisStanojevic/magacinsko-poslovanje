package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;

public class MagacinskaKarticaDTO implements Serializable {
	
	private Integer idMagacinskeKartice;
	private BigDecimal cena;
	private BigDecimal kolicinaIzlaza;
	private BigDecimal kolicinaPocetnogStanja;
	private BigDecimal kolicinaUlaza;
	private Integer redniBrMagacinskeKar;
	private BigDecimal ukupnaKolicina;
	private BigDecimal ukupnaVrednost;
	private BigDecimal vrednostIzlaza;
	private BigDecimal vrednostPocetnogStanja;
	private BigDecimal vrednostUlaza;
	private Set<AnalitikaMagacinskeKarticeDTO> analitikeMagacinskeKartice;
	private ArtikalDTO artikal;
	private MagacinDTO magacin;
	private PoslovnaGodinaDTO poslovnaGodina;
	
	
	public static Set<MagacinskaKarticaDTO> convert(Set<MagacinskaKartica> magacinskaKarticaEntitySet) {
		Set<MagacinskaKarticaDTO> magacinskaKarticaDTOSet = new HashSet<>();
		Iterator<MagacinskaKartica> iterator = magacinskaKarticaEntitySet.iterator();
		while (iterator.hasNext()) {
			MagacinskaKartica magacinskaKartica = (MagacinskaKartica) iterator.next();
			MagacinskaKarticaDTO magacinskaKarticaDTO = new MagacinskaKarticaDTO(magacinskaKartica);
			magacinskaKarticaDTOSet.add(magacinskaKarticaDTO);			
		}
		return magacinskaKarticaDTOSet;
	}
	
	
	public MagacinskaKarticaDTO() {		
	}

	public MagacinskaKarticaDTO(Integer idMagacinskeKartice, BigDecimal cena, BigDecimal kolicinaIzlaza,
			BigDecimal kolicinaPocetnogStanja, BigDecimal kolicinaUlaza, Integer redniBrMagacinskeKar,
			BigDecimal ukupnaKolicina, BigDecimal ukupnaVrednost, BigDecimal vrednostIzlaza,
			BigDecimal vrednostPocetnogStanja, BigDecimal vrednostUlaza,
			Set<AnalitikaMagacinskeKarticeDTO> analitikeMagacinskeKartice, ArtikalDTO artikal, MagacinDTO magacin,
			PoslovnaGodinaDTO poslovnaGodina) {
		super();
		this.idMagacinskeKartice = idMagacinskeKartice;
		this.cena = cena;
		this.kolicinaIzlaza = kolicinaIzlaza;
		this.kolicinaPocetnogStanja = kolicinaPocetnogStanja;
		this.kolicinaUlaza = kolicinaUlaza;
		this.redniBrMagacinskeKar = redniBrMagacinskeKar;
		this.ukupnaKolicina = ukupnaKolicina;
		this.ukupnaVrednost = ukupnaVrednost;
		this.vrednostIzlaza = vrednostIzlaza;
		this.vrednostPocetnogStanja = vrednostPocetnogStanja;
		this.vrednostUlaza = vrednostUlaza;
		this.analitikeMagacinskeKartice = analitikeMagacinskeKartice;
		this.artikal = artikal;
		this.magacin = magacin;
		this.poslovnaGodina = poslovnaGodina;
	}

	public MagacinskaKarticaDTO(MagacinskaKartica magacinskaKartica) {
		this(magacinskaKartica.getIdMagacinskeKartice(), magacinskaKartica.getCena(), magacinskaKartica.getKolicinaIzlaza(), magacinskaKartica.getKolicinaPocetnogStanja(), 
				magacinskaKartica.getKolicinaUlaza(), magacinskaKartica.getRedniBrMagacinskeKar(), magacinskaKartica.getUkupnaKolicina(), magacinskaKartica.getUkupnaVrednost(), 
				magacinskaKartica.getVrednostIzlaza(), magacinskaKartica.getVrednostPocetnogStanja(), magacinskaKartica.getVrednostUlaza(), 
				AnalitikaMagacinskeKarticeDTO.convert(magacinskaKartica.getAnalitikeMagacinskeKartice()), new ArtikalDTO(magacinskaKartica.getArtikal()), 
				new MagacinDTO(magacinskaKartica.getMagacin()), new PoslovnaGodinaDTO(magacinskaKartica.getPoslovnaGodina()));
	}


	public Integer getIdMagacinskeKartice() {
		return idMagacinskeKartice;
	}

	public void setIdMagacinskeKartice(Integer idMagacinskeKartice) {
		this.idMagacinskeKartice = idMagacinskeKartice;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public BigDecimal getKolicinaIzlaza() {
		return kolicinaIzlaza;
	}

	public void setKolicinaIzlaza(BigDecimal kolicinaIzlaza) {
		this.kolicinaIzlaza = kolicinaIzlaza;
	}

	public BigDecimal getKolicinaPocetnogStanja() {
		return kolicinaPocetnogStanja;
	}

	public void setKolicinaPocetnogStanja(BigDecimal kolicinaPocetnogStanja) {
		this.kolicinaPocetnogStanja = kolicinaPocetnogStanja;
	}

	public BigDecimal getKolicinaUlaza() {
		return kolicinaUlaza;
	}

	public void setKolicinaUlaza(BigDecimal kolicinaUlaza) {
		this.kolicinaUlaza = kolicinaUlaza;
	}

	public Integer getRedniBrMagacinskeKar() {
		return redniBrMagacinskeKar;
	}

	public void setRedniBrMagacinskeKar(Integer redniBrMagacinskeKar) {
		this.redniBrMagacinskeKar = redniBrMagacinskeKar;
	}

	public BigDecimal getUkupnaKolicina() {
		return ukupnaKolicina;
	}

	public void setUkupnaKolicina(BigDecimal ukupnaKolicina) {
		this.ukupnaKolicina = ukupnaKolicina;
	}

	public BigDecimal getUkupnaVrednost() {
		return ukupnaVrednost;
	}

	public void setUkupnaVrednost(BigDecimal ukupnaVrednost) {
		this.ukupnaVrednost = ukupnaVrednost;
	}

	public BigDecimal getVrednostIzlaza() {
		return vrednostIzlaza;
	}

	public void setVrednostIzlaza(BigDecimal vrednostIzlaza) {
		this.vrednostIzlaza = vrednostIzlaza;
	}

	public BigDecimal getVrednostPocetnogStanja() {
		return vrednostPocetnogStanja;
	}

	public void setVrednostPocetnogStanja(BigDecimal vrednostPocetnogStanja) {
		this.vrednostPocetnogStanja = vrednostPocetnogStanja;
	}

	public BigDecimal getVrednostUlaza() {
		return vrednostUlaza;
	}

	public void setVrednostUlaza(BigDecimal vrednostUlaza) {
		this.vrednostUlaza = vrednostUlaza;
	}

	public Set<AnalitikaMagacinskeKarticeDTO> getAnalitikeMagacinskeKartice() {
		return analitikeMagacinskeKartice;
	}

	public void setAnalitikeMagacinskeKartice(Set<AnalitikaMagacinskeKarticeDTO> analitikeMagacinskeKartice) {
		this.analitikeMagacinskeKartice = analitikeMagacinskeKartice;
	}

	public ArtikalDTO getArtikal() {
		return artikal;
	}

	public void setArtikal(ArtikalDTO artikal) {
		this.artikal = artikal;
	}

	public MagacinDTO getMagacin() {
		return magacin;
	}

	public void setMagacin(MagacinDTO magacin) {
		this.magacin = magacin;
	}

	public PoslovnaGodinaDTO getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodinaDTO poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}
	
	

}
