package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;
import ftn.sit.pi.magacinskoposlovanje.dto.MestoDTO;

@Component
public class DTOToMesto implements Converter<MestoDTO, Mesto> {

	@Override
	public Mesto convert(MestoDTO source) {
		if(source == null) {
			return null;
		}
		Mesto mesto = new Mesto();
		mesto.setPostanskiBroj(source.getPostanskiBroj());
		mesto.setNazivMesta(source.getNazivMesta());
		mesto.setDrzava(source.getDrzava());
		return mesto;
	}
}
