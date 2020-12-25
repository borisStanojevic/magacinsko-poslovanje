package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "poslovna_godina")
@NamedQuery(name = "PoslovnaGodina.findAll", query = "SELECT p FROM PoslovnaGodina p")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PoslovnaGodina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GODINE")
	private Integer idGodine;

	@Temporal(TemporalType.DATE)
	private Date godina;

	private Boolean zakljucena;

	// bi-directional many-to-one association to MagacinskaKartica
	@OneToMany(mappedBy = "poslovnaGodina")
	private Set<MagacinskaKartica> magacinskeKartice = new HashSet<>();

	// bi-directional many-to-one association to PrometniDokument
	@OneToMany(mappedBy = "poslovnaGodina")
	private Set<PrometniDokument> prometniDokumenti = new HashSet<>();

	@Version
	private Integer version;
	
	@Column(name = "DELETED", columnDefinition = "tinyint(1) default 0")
	private boolean deleted;
	
	//test commit
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