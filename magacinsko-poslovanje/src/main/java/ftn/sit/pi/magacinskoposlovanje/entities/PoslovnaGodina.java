package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the poslovna_godina database table.
 * 
 */
@Entity
@Table(name="poslovna_godina")
@NamedQuery(name="PoslovnaGodina.findAll", query="SELECT p FROM PoslovnaGodina p")
public class PoslovnaGodina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GODINE")
	private int idGodine;

	@Temporal(TemporalType.DATE)
	private Date godina;

	private byte zakljucena;

	//bi-directional many-to-one association to MagacinskaKartica
	@OneToMany(mappedBy="poslovnaGodina")
	private Set<MagacinskaKartica> magacinskeKartice;

	//bi-directional many-to-one association to PrometniDokument
	@OneToMany(mappedBy="poslovnaGodina")
	private Set<PrometniDokument> prometniDokumenti;

	public PoslovnaGodina() {
	}

	public int getIdGodine() {
		return this.idGodine;
	}

	public void setIdGodine(int idGodine) {
		this.idGodine = idGodine;
	}

	public Date getGodina() {
		return this.godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public byte getZakljucena() {
		return this.zakljucena;
	}

	public void setZakljucena(byte zakljucena) {
		this.zakljucena = zakljucena;
	}

	public Set<MagacinskaKartica> getMagacinskeKartice() {
		return this.magacinskeKartice;
	}

	public void setMagacinskeKartice(Set<MagacinskaKartica> magacinskeKartice) {
		this.magacinskeKartice = magacinskeKartice;
	}

	public MagacinskaKartica addMagacinskeKartice(MagacinskaKartica magacinskeKartice) {
		getMagacinskeKartice().add(magacinskeKartice);
		magacinskeKartice.setPoslovnaGodina(this);

		return magacinskeKartice;
	}

	public MagacinskaKartica removeMagacinskeKartice(MagacinskaKartica magacinskeKartice) {
		getMagacinskeKartice().remove(magacinskeKartice);
		magacinskeKartice.setPoslovnaGodina(null);

		return magacinskeKartice;
	}

	public Set<PrometniDokument> getPrometniDokumenti() {
		return this.prometniDokumenti;
	}

	public void setPrometniDokumenti(Set<PrometniDokument> prometniDokumenti) {
		this.prometniDokumenti = prometniDokumenti;
	}

	public PrometniDokument addPrometniDokumenti(PrometniDokument prometniDokumenti) {
		getPrometniDokumenti().add(prometniDokumenti);
		prometniDokumenti.setPoslovnaGodina(this);

		return prometniDokumenti;
	}

	public PrometniDokument removePrometniDokumenti(PrometniDokument prometniDokumenti) {
		getPrometniDokumenti().remove(prometniDokumenti);
		prometniDokumenti.setPoslovnaGodina(null);

		return prometniDokumenti;
	}

}