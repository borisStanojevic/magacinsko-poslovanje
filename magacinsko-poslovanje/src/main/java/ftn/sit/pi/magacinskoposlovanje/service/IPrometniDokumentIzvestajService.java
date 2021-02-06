package ftn.sit.pi.magacinskoposlovanje.service;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;

public interface IPrometniDokumentIzvestajService {
	byte[] generisiIzvestaj(int idMagacina, int idPrometnogDokumenta) throws FileNotFoundException, JRException ;
}
