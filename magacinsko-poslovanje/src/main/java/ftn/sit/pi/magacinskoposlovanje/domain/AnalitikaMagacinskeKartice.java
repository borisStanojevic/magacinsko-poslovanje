package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="analitika_magacinske_kartice")
@NamedQuery(name="AnalitikaMagacinskeKartice.findAll", query="SELECT a FROM AnalitikaMagacinskeKartice a")
public class AnalitikaMagacinskeKartice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ANALITIKE")
	private Integer idAnalitike;

	private BigDecimal cena;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_NASTANKA")
	private Date datumNastanka;

	private BigDecimal kolicina;

	private Smer smer;

	@Column(name="TIP_PROMETA")
	private TipPrometa tipPrometa;

	private BigDecimal vrednost;

	//bi-directional many-to-one association to MagacinskaKartica
	@ManyToOne
	@JoinColumn(name="ID_MAGACINSKE_KARTICE")
	private MagacinskaKartica magacinskaKartica;

	public AnalitikaMagacinskeKartice() {
	}

	public Integer getIdAnalitike() {
		return this.idAnalitike;
	}

	public void setIdAnalitike(Integer idAnalitike) {
		this.idAnalitike = idAnalitike;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public Date getDatumNastanka() {
		return this.datumNastanka;
	}

	public void setDatumNastanka(Date datumNastanka) {
		this.datumNastanka = datumNastanka;
	}

	public BigDecimal getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(BigDecimal kolicina) {
		this.kolicina = kolicina;
	}

	public Smer getSmer() {
		return this.smer;
	}

	public void setSmer(Smer smer) {
		this.smer = smer;
	}

	public TipPrometa getTipPrometa() {
		return this.tipPrometa;
	}

	public void setTipPrometa(TipPrometa tipPrometa) {
		this.tipPrometa = tipPrometa;
	}

	public BigDecimal getVrednost() {
		return this.vrednost;
	}

	public void setVrednost(BigDecimal vrednost) {
		this.vrednost = vrednost;
	}

	public MagacinskaKartica getMagacinskaKartica() {
		return this.magacinskaKartica;
	}

	public void setMagacinskaKartica(MagacinskaKartica magacinskaKartica) {
		this.magacinskaKartica = magacinskaKartica;
	}

}