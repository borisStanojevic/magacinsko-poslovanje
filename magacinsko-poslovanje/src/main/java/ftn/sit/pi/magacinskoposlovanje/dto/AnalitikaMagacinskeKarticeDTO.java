package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.domain.Smer;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometa;

public class AnalitikaMagacinskeKarticeDTO implements Serializable {

	private Integer idAnalitike;
	private BigDecimal cena;
	private Date datumNastanka;
	private BigDecimal kolicina;
	private Smer smer;
	private TipPrometa tipPrometa;
	private BigDecimal vrednost;
	private MagacinskaKarticaDTO magacinskaKartica;
	
	public static Set<AnalitikaMagacinskeKarticeDTO> convert(Set<AnalitikaMagacinskeKartice> analitikaMagacinskeKarticeEntitySet) {
		Set<AnalitikaMagacinskeKarticeDTO> analitikaMagacinskeKarticeDTOSet = new HashSet<>();
		Iterator<AnalitikaMagacinskeKartice> iterator = analitikaMagacinskeKarticeEntitySet.iterator();
		while (iterator.hasNext()) {
			AnalitikaMagacinskeKartice analitikaMagacinskeKartice = (AnalitikaMagacinskeKartice) iterator.next();
			AnalitikaMagacinskeKarticeDTO analitikaMagacinskeKarticeDTO = new AnalitikaMagacinskeKarticeDTO(analitikaMagacinskeKartice);
			analitikaMagacinskeKarticeDTOSet.add(analitikaMagacinskeKarticeDTO);			
		}
		return analitikaMagacinskeKarticeDTOSet;
	}
	
	public AnalitikaMagacinskeKarticeDTO() {		
	}

	public AnalitikaMagacinskeKarticeDTO(Integer idAnalitike, BigDecimal cena, Date datumNastanka, BigDecimal kolicina,
			Smer smer, TipPrometa tipPrometa, BigDecimal vrednost, MagacinskaKarticaDTO magacinskaKartica) {
		super();
		this.idAnalitike = idAnalitike;
		this.cena = cena;
		this.datumNastanka = datumNastanka;
		this.kolicina = kolicina;
		this.smer = smer;
		this.tipPrometa = tipPrometa;
		this.vrednost = vrednost;
		this.magacinskaKartica = magacinskaKartica;
	}
	
	

	public AnalitikaMagacinskeKarticeDTO(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		this(analitikaMagacinskeKartice.getIdAnalitike(), analitikaMagacinskeKartice.getCena(), analitikaMagacinskeKartice.getDatumNastanka(), 
				analitikaMagacinskeKartice.getKolicina(), analitikaMagacinskeKartice.getSmer(), analitikaMagacinskeKartice.getTipPrometa(), 
				analitikaMagacinskeKartice.getVrednost(), new MagacinskaKarticaDTO(analitikaMagacinskeKartice.getMagacinskaKartica()));
	}

	public Integer getIdAnalitike() {
		return idAnalitike;
	}

	public void setIdAnalitike(Integer idAnalitike) {
		this.idAnalitike = idAnalitike;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public Date getDatumNastanka() {
		return datumNastanka;
	}

	public void setDatumNastanka(Date datumNastanka) {
		this.datumNastanka = datumNastanka;
	}

	public BigDecimal getKolicina() {
		return kolicina;
	}

	public void setKolicina(BigDecimal kolicina) {
		this.kolicina = kolicina;
	}

	public Smer getSmer() {
		return smer;
	}

	public void setSmer(Smer smer) {
		this.smer = smer;
	}

	public TipPrometa getTipPrometa() {
		return tipPrometa;
	}

	public void setTipPrometa(TipPrometa tipPrometa) {
		this.tipPrometa = tipPrometa;
	}

	public BigDecimal getVrednost() {
		return vrednost;
	}

	public void setVrednost(BigDecimal vrednost) {
		this.vrednost = vrednost;
	}

	public MagacinskaKarticaDTO getMagacinskaKartica() {
		return magacinskaKartica;
	}

	public void setMagacinskaKartica(MagacinskaKarticaDTO magacinskaKartica) {
		this.magacinskaKartica = magacinskaKartica;
	}
	
	
}
