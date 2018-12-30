package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="poslovna_godina")
@NamedQuery(name="PoslovnaGodina.findAll", query="SELECT p FROM PoslovnaGodina p")
public class PoslovnaGodina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GODINE")
	private Integer idGodine;

	@Temporal(TemporalType.DATE)
	private Date godina;

	private Boolean zakljucena;

	//bi-directional many-to-one association to MagacinskaKartica
	@OneToMany(mappedBy="poslovnaGodina")
	private Set<MagacinskaKartica> magacinskeKartice;

	//bi-directional many-to-one association to PrometniDokument
	@OneToMany(mappedBy="poslovnaGodina")
	private Set<PrometniDokument> prometniDokumenti;

	public PoslovnaGodina() {
		magacinskeKartice = new HashSet<>();
		prometniDokumenti = new HashSet<>();
	}

	public Integer getIdGodine() {
		return this.idGodine;
	}

	public void setIdGodine(Integer idGodine) {
		this.idGodine = idGodine;
	}

	public Date getGodina() {
		return this.godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public Boolean getZakljucena() {
		return this.zakljucena;
	}

	public void setZakljucena(Boolean zakljucena) {
		this.zakljucena = zakljucena;
	}

	public Set<MagacinskaKartica> getMagacinskeKartice() {
		return this.magacinskeKartice;
	}

	public void setMagacinskeKartice(Set<MagacinskaKartica> magacinskeKartice) {
		this.magacinskeKartice = magacinskeKartice;
	}

	public MagacinskaKartica addMagacinskaKartica(MagacinskaKartica magacinskeKartica) {
		getMagacinskeKartice().add(magacinskeKartica);
		magacinskeKartica.setPoslovnaGodina(this);

		return magacinskeKartica;
	}

	public MagacinskaKartica removeMagacinskaKartica(MagacinskaKartica magacinskeKartica) {
		getMagacinskeKartice().remove(magacinskeKartica);
		magacinskeKartica.setPoslovnaGodina(null);

		return magacinskeKartica;
	}

	public Set<PrometniDokument> getPrometniDokumenti() {
		return this.prometniDokumenti;
	}

	public void setPrometniDokumenti(Set<PrometniDokument> prometniDokumenti) {
		this.prometniDokumenti = prometniDokumenti;
	}

	public PrometniDokument addPrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().add(prometniDokument);
		prometniDokument.setPoslovnaGodina(this);

		return prometniDokument;
	}

	public PrometniDokument removePrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().remove(prometniDokument);
		prometniDokument.setPoslovnaGodina(null);

		return prometniDokument;
	}

}