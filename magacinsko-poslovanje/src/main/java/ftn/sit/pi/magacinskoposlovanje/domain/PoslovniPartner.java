package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "poslovni_partner")
@NamedQuery(name = "PoslovniPartner.findAll", query = "SELECT p FROM PoslovniPartner p")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PoslovniPartner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIFRA_PARTNERA")
	private Integer sifraPartnera;

	@Column(name = "ADRESA_POSLOVNOG_PARTNERA")
	private String adresaPoslovnogPartnera;

	@Column(name = "NAZIV_PARTNERA")
	@NotBlank(message = "Morate navesti naziv poslovnog partnera")
	private String nazivPartnera;
	
	@NotBlank(message = "Morate navesti PIB poslovnog partnera")
	@Size(min=8, max=8, message = "PIB mora sadrzati tacno 8 cifara")
	private String pib;

	@Column(name = "TIP_PARTNERA")
	@Enumerated(EnumType.STRING)
	private TipPartnera tipPartnera;

	// bi-directional many-to-one association to Mesto
	@ManyToOne
	@JoinColumn(name = "POSTANSKI_BROJ")
	private Mesto mesto;

	// bi-directional many-to-one association to PrometniDokument
	@OneToMany(mappedBy = "poslovniPartner")
	private Set<PrometniDokument> prometniDokumenti = new HashSet<>();

	@Version
	private Integer version;

	public PrometniDokument addPrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().add(prometniDokument);
		prometniDokument.setPoslovniPartner(this);

		return prometniDokument;
	}

	public PrometniDokument removePrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().remove(prometniDokument);
		prometniDokument.setPoslovniPartner(null);

		return prometniDokument;
	}

}