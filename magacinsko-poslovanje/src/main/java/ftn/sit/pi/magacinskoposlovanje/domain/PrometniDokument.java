package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="prometni_dokument")
@NamedQuery(name="PrometniDokument.findAll", query="SELECT p FROM PrometniDokument p")
public class PrometniDokument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROMETNOG_DOKUMENTA")
	private Integer idPrometnogDokumenta;

	@Column(name="BROJ_PROMETNOG_DOKUMENTA")
	private Integer brojPrometnogDokumenta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATUM_FORMIRANJA")
	private Date datumFormiranja;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATUM_KNJIZENJA")
	private Date datumKnjizenja;

	@Column(name="REDNI_BROJ_DOKUMETNA")
	private Integer redniBrojDokumetna;

	private Status status;

	@Column(name="TIP_PROMETNOG_DOKUMENTA")
	private TipPrometnogDokumenta tipPrometnogDokumenta;

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
	private Set<StavkaPrometnogDokumenta> stavkePrometnogDokumenta;

	public PrometniDokument() {
	}

	public Integer getIdPrometnogDokumenta() {
		return this.idPrometnogDokumenta;
	}

	public void setIdPrometnogDokumenta(Integer idPrometnogDokumenta) {
		this.idPrometnogDokumenta = idPrometnogDokumenta;
	}

	public Integer getBrojPrometnogDokumenta() {
		return this.brojPrometnogDokumenta;
	}

	public void setBrojPrometnogDokumenta(Integer brojPrometnogDokumenta) {
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

	public Integer getRedniBrojDokumetna() {
		return this.redniBrojDokumetna;
	}

	public void setRedniBrojDokumetna(Integer redniBrojDokumetna) {
		this.redniBrojDokumetna = redniBrojDokumetna;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipPrometnogDokumenta getTipPrometnogDokumenta() {
		return this.tipPrometnogDokumenta;
	}

	public void setTipPrometnogDokumenta(TipPrometnogDokumenta tipPrometnogDokumenta) {
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

	public Set<StavkaPrometnogDokumenta> getStavkePrometnogDokumenta() {
		return this.stavkePrometnogDokumenta;
	}

	public void setStavkePrometnogDokumenta(Set<StavkaPrometnogDokumenta> stavkePrometnogDokumenta) {
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}

	public StavkaPrometnogDokumenta addStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().add(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setPrometniDokument(this);

		return stavkaPrometnogDokumenta;
	}

	public StavkaPrometnogDokumenta removeStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().remove(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setPrometniDokument(null);

		return stavkaPrometnogDokumenta;
	}

}