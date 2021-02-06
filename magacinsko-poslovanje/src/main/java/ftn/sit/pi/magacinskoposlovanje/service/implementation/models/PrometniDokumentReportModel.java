package ftn.sit.pi.magacinskoposlovanje.service.implementation.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PrometniDokumentReportModel {
	public static final String MAGACIN_REPORT_TEMPLATE_KEY = "magacin";
	public static final String POSLOVNA_GODINA_REPORT_TEMPLATE_KEY = "poslovnaGodina";
	public static final String POSLOVNI_PARTNER_REPORT_TEMPLATE_KEY = "poslovniPartner";
	public static final String BROJ_PROMETNOG_DOKUMENTA_REPORT_TEMPLATE_KEY = "brojPrometnogDokumenta";
	public static final String DATUM_FORMIRANJA_REPORT_TEMPLATE_KEY = "datumFormiranja";
	public static final String STATUS_REPORT_TEMPLATE_KEY = "status";
	public static final String TIP_PROMETNOG_DOKUMENTA_REPORT_TEMPLATE_KEY = "tipPrometnogDokumenta";
	
	private String magacin;
	private int poslovnaGodina;
	private int poslovniPartner;
	private int brojPrometnogDokumenta;
	private String datumFormiranja;
	private String status;
	private String tipPrometnogDokumenta;
	private List<PrometniDokumentStavkaReportModel> stavke;

}
