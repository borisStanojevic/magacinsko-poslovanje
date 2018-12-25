package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;

public class StavkePrometnogDokumentaDTO implements Serializable {
	
	private Integer idStavkePrometnogDokumenta;
	private BigDecimal cena;
	private BigDecimal kolicina;
	private BigDecimal vrednost;
	private ArtikalDTO artikal;
	private PrometniDokumentDTO prometniDokument;
	
	
	public static Set<StavkePrometnogDokumentaDTO> convert(Set<StavkaPrometnogDokumenta> stavkePrometnogDokumentaEntitySet) {
		Set<StavkePrometnogDokumentaDTO> stavkePrometnogDokumentaDTOSet = new HashSet<>();
		Iterator<StavkaPrometnogDokumenta> iterator = stavkePrometnogDokumentaEntitySet.iterator();
		while (iterator.hasNext()) {
			StavkaPrometnogDokumenta stavkePrometnogDokumenta = (StavkaPrometnogDokumenta) iterator.next();
			StavkePrometnogDokumentaDTO stavkePrometnogDokumentaDTO = new StavkePrometnogDokumentaDTO(stavkePrometnogDokumenta);
			stavkePrometnogDokumentaDTOSet.add(stavkePrometnogDokumentaDTO);			
		}
		return stavkePrometnogDokumentaDTOSet;
	}
	
	
	public StavkePrometnogDokumentaDTO() {		
	}

	public StavkePrometnogDokumentaDTO(Integer idStavkePrometnogDokumenta, BigDecimal cena, BigDecimal kolicina,
			BigDecimal vrednost, ArtikalDTO artikal, PrometniDokumentDTO prometniDokument) {
		super();
		this.idStavkePrometnogDokumenta = idStavkePrometnogDokumenta;
		this.cena = cena;
		this.kolicina = kolicina;
		this.vrednost = vrednost;
		this.artikal = artikal;
		this.prometniDokument = prometniDokument;
	}

	public StavkePrometnogDokumentaDTO(StavkaPrometnogDokumenta stavkePrometnogDokumenta) {
		this(stavkePrometnogDokumenta.getIdStavkePrometnogDokumenta(), stavkePrometnogDokumenta.getCena(), stavkePrometnogDokumenta.getKolicina(), 
				stavkePrometnogDokumenta.getVrednost(), new ArtikalDTO(stavkePrometnogDokumenta.getArtikal()), new PrometniDokumentDTO(stavkePrometnogDokumenta.getPrometniDokument()));
	}


	public Integer getIdStavkePrometnogDokumenta() {
		return idStavkePrometnogDokumenta;
	}

	public void setIdStavkePrometnogDokumenta(Integer idStavkePrometnogDokumenta) {
		this.idStavkePrometnogDokumenta = idStavkePrometnogDokumenta;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public BigDecimal getKolicina() {
		return kolicina;
	}

	public void setKolicina(BigDecimal kolicina) {
		this.kolicina = kolicina;
	}

	public BigDecimal getVrednost() {
		return vrednost;
	}

	public void setVrednost(BigDecimal vrednost) {
		this.vrednost = vrednost;
	}

	public ArtikalDTO getArtikal() {
		return artikal;
	}

	public void setArtikal(ArtikalDTO artikal) {
		this.artikal = artikal;
	}

	public PrometniDokumentDTO getPrometniDokument() {
		return prometniDokument;
	}

	public void setPrometniDokument(PrometniDokumentDTO prometniDokument) {
		this.prometniDokument = prometniDokument;
	}
	
	

}
