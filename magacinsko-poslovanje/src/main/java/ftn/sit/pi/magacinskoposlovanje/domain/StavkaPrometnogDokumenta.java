package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="stavke_prometnog_dokumenta")
@NamedQuery(name="StavkaPrometnogDokumenta.findAll", query="SELECT s FROM StavkaPrometnogDokumenta s")
public class StavkaPrometnogDokumenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STAVKE_PROMETNOG_DOKUMENTA")
	private Integer idStavkePrometnogDokumenta;

	private BigDecimal cena;

	private BigDecimal kolicina;

	private BigDecimal vrednost;

	//bi-directional many-to-one association to Artikal
	@ManyToOne
	@JoinColumn(name="SIFRA_ARTIKLA")
	private Artikal artikal;

	//bi-directional many-to-one association to PrometniDokument
	@ManyToOne
	@JoinColumn(name="ID_PROMETNOG_DOKUMENTA")
	private PrometniDokument prometniDokument;

	public StavkaPrometnogDokumenta() {
	}

	public Integer getIdStavkePrometnogDokumenta() {
		return this.idStavkePrometnogDokumenta;
	}

	public void setIdStavkePrometnogDokumenta(Integer idStavkePrometnogDokumenta) {
		this.idStavkePrometnogDokumenta = idStavkePrometnogDokumenta;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public BigDecimal getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(BigDecimal kolicina) {
		this.kolicina = kolicina;
	}

	public BigDecimal getVrednost() {
		return this.vrednost;
	}

	public void setVrednost(BigDecimal vrednost) {
		this.vrednost = vrednost;
	}

	public Artikal getArtikal() {
		return this.artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public PrometniDokument getPrometniDokument() {
		return this.prometniDokument;
	}

	public void setPrometniDokument(PrometniDokument prometniDokument) {
		this.prometniDokument = prometniDokument;
	}

}