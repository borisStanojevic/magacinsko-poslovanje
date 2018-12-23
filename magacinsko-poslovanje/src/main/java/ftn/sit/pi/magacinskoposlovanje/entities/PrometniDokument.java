package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the prometni_dokument database table.
 * 
 */
@Entity
@Table(name="prometni_dokument")
@NamedQuery(name="PrometniDokument.findAll", query="SELECT p FROM PrometniDokument p")
public class PrometniDokument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROMETNOG_DOKUMENTA")
	private int idPrometnogDokumenta;

	@Column(name="BROJ_PROMETNOG_DOKUMENTA")
	private int brojPrometnogDokumenta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATUM_FORMIRANJA")
	private Date datumFormiranja;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATUM_KNJIZENJA")
	private Date datumKnjizenja;

	@Column(name="REDNI_BROJ_DOKUMETNA")
	private int redniBrojDokumetna;

	private String status;

	@Column(name="TIP_PROMETNOG_DOKUMENTA")
	private String tipPrometnogDokumenta;

	//bi-directional many-to-one association to Magacin
	@ManyToOne
	@JoinColumn(name="SIFRA_MAGACINA")
	private Magacin magacin;

	//bi-directional many-to-one association to PoslovnaGodina
	@ManyToOne
	@JoinColumn(name="ID_GODINE")
	private PoslovnaGodina poslovnaGodina;

	//bi-directional many-to-one association to PoslovniPartner
	@ManyToOne
	@JoinColumn(name="SIFRA_PARTNERA")
	private PoslovniPartner poslovniPartner;

	//bi-directional many-to-one association to StavkePrometnogDokumenta
	@OneToMany(mappedBy="prometniDokument")
	private Set<StavkePrometnogDokumenta> stavkePrometnogDokumenta;

	public PrometniDokument() {
	}

	public int getIdPrometnogDokumenta() {
		return this.idPrometnogDokumenta;
	}

	public void setIdPrometnogDokumenta(int idPrometnogDokumenta) {
		this.idPrometnogDokumenta = idPrometnogDokumenta;
	}

	public int getBrojPrometnogDokumenta() {
		return this.brojPrometnogDokumenta;
	}

	public void setBrojPrometnogDokumenta(int brojPrometnogDokumenta) {
		this.brojPrometnogDokumenta = brojPrometnogDokumenta;
	}

	public Date getDatumFormiranja() {
		return this.datumFormiranja;
	}

	public void setDatumFormiranja(Date datumFormiranja) {
		this.datumFormiranja = datumFormiranja;
	}

	public Date getDatumKnjizenja() {
		return this.datumKnjizenja;
	}

	public void setDatumKnjizenja(Date datumKnjizenja) {
		this.datumKnjizenja = datumKnjizenja;
	}

	public int getRedniBrojDokumetna() {
		return this.redniBrojDokumetna;
	}

	public void setRedniBrojDokumetna(int redniBrojDokumetna) {
		this.redniBrojDokumetna = redniBrojDokumetna;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipPrometnogDokumenta() {
		return this.tipPrometnogDokumenta;
	}

	public void setTipPrometnogDokumenta(String tipPrometnogDokumenta) {
		this.tipPrometnogDokumenta = tipPrometnogDokumenta;
	}

	public Magacin getMagacin() {
		return this.magacin;
	}

	public void setMagacin(Magacin magacin) {
		this.magacin = magacin;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return this.poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public PoslovniPartner getPoslovniPartner() {
		return this.poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Set<StavkePrometnogDokumenta> getStavkePrometnogDokumenta() {
		return this.stavkePrometnogDokumenta;
	}

	public void setStavkePrometnogDokumenta(Set<StavkePrometnogDokumenta> stavkePrometnogDokumenta) {
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}

	public StavkePrometnogDokumenta addStavkePrometnogDokumenta(StavkePrometnogDokumenta stavkePrometnogDokumenta) {
		getStavkePrometnogDokumenta().add(stavkePrometnogDokumenta);
		stavkePrometnogDokumenta.setPrometniDokument(this);

		return stavkePrometnogDokumenta;
	}

	public StavkePrometnogDokumenta removeStavkePrometnogDokumenta(StavkePrometnogDokumenta stavkePrometnogDokumenta) {
		getStavkePrometnogDokumenta().remove(stavkePrometnogDokumenta);
		stavkePrometnogDokumenta.setPrometniDokument(null);

		return stavkePrometnogDokumenta;
	}

}