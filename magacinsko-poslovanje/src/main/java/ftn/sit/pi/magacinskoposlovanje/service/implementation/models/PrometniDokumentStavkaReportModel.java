package ftn.sit.pi.magacinskoposlovanje.service.implementation.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PrometniDokumentStavkaReportModel {
	private int redniBrojStavkePrometnogDokumenta;
	private String artikal;
	private double kolicina;
	private double cena;
	private double vrednost;
}
