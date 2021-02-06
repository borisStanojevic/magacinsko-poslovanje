package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinskaKarticaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPrometniDokumentIzvestajService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.LagerListaReportModel;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.LagerListaStavkaReportModel;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.PrometniDokumentReportModel;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.PrometniDokumentStavkaReportModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PrometniDokumentIzvestajService implements IPrometniDokumentIzvestajService {
	private static final String REPORT_TEMPLATE_NAME = "prometni-dokument";

	@Autowired
	private MagacinskaKarticaRepository magacinskaKarticaRepository;

	@Override
	public byte[] generisiIzvestaj(int idMagacina, int idPrometnogDokumenta) throws FileNotFoundException, JRException {
		File reportTemplateFile = loadReportTemplateFile(REPORT_TEMPLATE_NAME);

		JasperReport compiledReport = compileReport(reportTemplateFile.getAbsolutePath());

		JasperPrint filledReport = fillReport(compiledReport);

		return JasperExportManager.exportReportToPdf(filledReport);

	}

	private File loadReportTemplateFile(String fileName) throws FileNotFoundException {
		File reportTemplateFile = ResourceUtils.getFile("classpath:" + fileName + ".jrxml");

		return reportTemplateFile;
	}

	private JasperReport compileReport(String reportTemplateFileAbsolutePath) throws JRException {
		JasperReport compiledReport = JasperCompileManager.compileReport(reportTemplateFileAbsolutePath);

		return compiledReport;
	}

	private JasperPrint fillReport(JasperReport compiledReport) throws JRException {
		PrometniDokumentReportModel prometniDokumentReportModel = createPrometniDokumentReportModel();

		// Iterable<MagacinskaKartica> magacinskeKartice =
		// magacinskaKarticaRepository.findAll();

		// List<LagerListaStavkaReportModel> lagerListaStavkaReportModels = new
		// ArrayList<>();
		// for (MagacinskaKartica magacinskaKartica : magacinskeKartice) {
		// lagerListaStavkaReportModels.add(createFromMagacinskaKartica(magacinskaKartica));
		// }

		Map<String, Object> parameters = new HashMap<>();

		parameters.put(PrometniDokumentReportModel.BROJ_PROMETNOG_DOKUMENTA_REPORT_TEMPLATE_KEY,
				prometniDokumentReportModel.getBrojPrometnogDokumenta());
		parameters.put(PrometniDokumentReportModel.DATUM_FORMIRANJA_REPORT_TEMPLATE_KEY,

				prometniDokumentReportModel.getDatumFormiranja());

		parameters.put(PrometniDokumentReportModel.MAGACIN_REPORT_TEMPLATE_KEY,

				prometniDokumentReportModel.getMagacin());

		parameters.put(PrometniDokumentReportModel.POSLOVNA_GODINA_REPORT_TEMPLATE_KEY,

				prometniDokumentReportModel.getPoslovnaGodina());

		parameters.put(PrometniDokumentReportModel.POSLOVNI_PARTNER_REPORT_TEMPLATE_KEY,
				prometniDokumentReportModel.getPoslovniPartner());
		parameters.put(PrometniDokumentReportModel.STATUS_REPORT_TEMPLATE_KEY, prometniDokumentReportModel.getStatus());

		parameters.put(PrometniDokumentReportModel.TIP_PROMETNOG_DOKUMENTA_REPORT_TEMPLATE_KEY,
				prometniDokumentReportModel.getTipPrometnogDokumenta());

		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(
				prometniDokumentReportModel.getStavke());

		JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, parameters, jrBeanCollectionDataSource);

		return filledReport;
	}

	private PrometniDokumentReportModel createPrometniDokumentReportModel() {
		PrometniDokumentReportModel prometniDokumentReportModel = new PrometniDokumentReportModel();
		prometniDokumentReportModel.setBrojPrometnogDokumenta(69);
		prometniDokumentReportModel.setMagacin("mMagacin");
		prometniDokumentReportModel.setDatumFormiranja("01/01/1990");
		prometniDokumentReportModel.setPoslovnaGodina(1990);
		prometniDokumentReportModel.setPoslovniPartner(101);
		prometniDokumentReportModel.setStatus("mStatus");
		prometniDokumentReportModel.setTipPrometnogDokumenta(new Random().nextInt(10) < 5 ? "mPrijemnica" : "mOtpremnica");

		prometniDokumentReportModel.setStavke(createStavkePrometnogDokumenta());

		return prometniDokumentReportModel;
	}

	private List<PrometniDokumentStavkaReportModel> createStavkePrometnogDokumenta() {
		List<PrometniDokumentStavkaReportModel> stavkePrometnogDokumenta = new ArrayList<>(10);

		for (int i = 0; i < 10; i++) {
			PrometniDokumentStavkaReportModel stavkaPrometnogDokumenta = new PrometniDokumentStavkaReportModel();

			stavkaPrometnogDokumenta.setRedniBrojStavkePrometnogDokumenta(i + 1);
			stavkaPrometnogDokumenta.setArtikal("Artikal " + (i + 1));
			stavkaPrometnogDokumenta.setCena(new Random().nextDouble());
			stavkaPrometnogDokumenta.setKolicina(new Random().nextDouble());
			stavkaPrometnogDokumenta.setVrednost(new Random().nextDouble());

			stavkePrometnogDokumenta.add(stavkaPrometnogDokumenta);
		}

		return stavkePrometnogDokumenta;
	}

	// LagerListaStavkaReportModel lagerListaStavkaReportModel = new
	// LagerListaStavkaReportModel();
	//
	// lagerListaStavkaReportModel.setRedniBroj(magacinskaKartica.getRedniBrMagacinskeKar());
	// lagerListaStavkaReportModel.setArtikal(magacinskaKartica.getArtikal().getNazivArtikla());
	// lagerListaStavkaReportModel.setCena(magacinskaKartica.getCena());
	// lagerListaStavkaReportModel.setKolicina(magacinskaKartica.getUkupnaKolicina());
	// lagerListaStavkaReportModel.setVrednost(magacinskaKartica.getUkupnaVrednost());
	//
	// return lagerListaStavkaReportModel;
	// }

}
