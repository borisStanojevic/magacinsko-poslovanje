package ftn.sit.pi.magacinskoposlovanje.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ftn.sit.pi.magacinskoposlovanje.service.ILagerListaIzvestajService;
import ftn.sit.pi.magacinskoposlovanje.service.IPrometniDokumentIzvestajService;

@RestController
public class IzvestajController {

	@Autowired
	private ILagerListaIzvestajService izvestajService;
	@Autowired
	private IPrometniDokumentIzvestajService prometniDokumentIzvestajService;

	@GetMapping("/magacini/{idMagacina}/poslovne-godine/{poslovnaGodina}/lager-lista")
	public ResponseEntity<ByteArrayResource> getLagerListaIzvestaj(@PathVariable int idMagacina,
			@PathVariable int poslovnaGodina) {
		try {
			byte[] izvestaj = izvestajService.generisiIzvestaj(idMagacina, poslovnaGodina);

			ByteArrayResource byteArrayResource = new ByteArrayResource(izvestaj);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.put("Content-Disposition", Collections
					.singletonList("attachment; filename=" + constructIzvestajFileName(idMagacina, poslovnaGodina)));

			return ResponseEntity.ok().headers(responseHeaders).contentType(MediaType.APPLICATION_PDF)
					.contentLength(byteArrayResource.contentLength()).body(byteArrayResource);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ByteArrayResource(new byte[0]));
		}
	}

	private String constructIzvestajFileName(int idMagacina, int poslovnaGodina) {
		return "lager-lista-" + idMagacina + "-" + poslovnaGodina + ".pdf";
	}

	@GetMapping("/magacini/{idMagacina}/prometni-dokumenti/{idPrometnogDokumenta}/izvestaj")
	public ResponseEntity<ByteArrayResource> getAnalitikeMagacinskeKarticeIzvestaj(@PathVariable int idMagacina, @PathVariable int idPrometnogDokumenta) {
		try {
			byte[] izvestaj = prometniDokumentIzvestajService.generisiIzvestaj(idMagacina, idPrometnogDokumenta);

			ByteArrayResource byteArrayResource = new ByteArrayResource(izvestaj);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.put("Content-Disposition", Collections
					.singletonList("attachment; filename=" + constructPrometniDokumentIzvestajFileName(idMagacina, idPrometnogDokumenta)));

			return ResponseEntity.ok().headers(responseHeaders).contentType(MediaType.APPLICATION_PDF)
					.contentLength(byteArrayResource.contentLength()).body(byteArrayResource);

		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ByteArrayResource(new byte[0]));
		}
	}
	
	private String constructPrometniDokumentIzvestajFileName(int idMagacina, int idPrometnogDokumenta) {
		return "magacin-" + idMagacina + "_" + "prometni-dokument" + "-" +  idPrometnogDokumenta + ".pdf";
	}

}