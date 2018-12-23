package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the stavke_prometnog_dokumenta database table.
 * 
 */
@Entity
@Table(name="stavke_prometnog_dokumenta")
@NamedQuery(name="StavkePrometnogDokumenta.findAll", query="SELECT s FROM StavkePrometnogDokumenta s")
public class StavkePrometnogDokumenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STAVKE_PROMETNOG_DOKUMENTA")
	private int idStavkePrometnogDokumenta;

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

	public StavkePrometnogDokumenta() {
	}

	public int getIdStavkePrometnogDokumenta() {
		return this.idStavkePrometnogDokumenta;
	}

	public void setIdStavkePrometnogDokumenta(int idStavkePrometnogDokumenta) {
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