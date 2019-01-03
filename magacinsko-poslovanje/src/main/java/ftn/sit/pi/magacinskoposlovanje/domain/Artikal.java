package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "Artikal.findAll", query = "SELECT a FROM Artikal a")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Artikal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIFRA_ARTIKLA")
	private Integer sifraArtikla;

	@Column(name = "NAZIV_ARTIKLA")
	private String nazivArtikla;

	// bi-directional many-to-one association to JedinicaMere
	@ManyToOne
	@JoinColumn(name = "ID_JED_MERE")
	private JedinicaMere jedinicaMere;

	// bi-directional many-to-one association to KategorijaArtikala
	@ManyToOne
	@JoinColumn(name = "ID_KATEGORIJE")
	private KategorijaArtikala kategorijaArtikala;

	// bi-directional many-to-one association to MagacinskaKartica
	@OneToMany(mappedBy = "artikal")
	private Set<MagacinskaKartica> magacinskeKartice = new HashSet<>();

	// bi-directional many-to-one association to StavkePrometnogDokumenta
	@OneToMany(mappedBy = "artikal")
	private Set<StavkaPrometnogDokumenta> stavkePrometnogDokumenta = new HashSet<>();

	@Version
	private Integer version;

	public MagacinskaKartica addMagacinskaKartica(MagacinskaKartica magacinskaKartice) {
		getMagacinskeKartice().add(magacinskaKartice);
		magacinskaKartice.setArtikal(this);

		return magacinskaKartice;
	}

	public MagacinskaKartica removeMagacinskaKartica(MagacinskaKartica magacinskaKartica) {
		getMagacinskeKartice().remove(magacinskaKartica);
		magacinskaKartica.setArtikal(null);

		return magacinskaKartica;
	}

	public StavkaPrometnogDokumenta addStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().add(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setArtikal(this);

		return stavkaPrometnogDokumenta;
	}

	public StavkaPrometnogDokumenta removeStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().remove(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setArtikal(null);

		return stavkaPrometnogDokumenta;
	}

}