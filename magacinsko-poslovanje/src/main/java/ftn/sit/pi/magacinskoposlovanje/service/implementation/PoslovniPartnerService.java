package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.dto.converters.PoslovniPartnerToDTO;
import ftn.sit.pi.magacinskoposlovanje.repository.PoslovniPartnerRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPoslovniPartnerService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class PoslovniPartnerService implements IPoslovniPartnerService {

	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;
	
	@Autowired
	PoslovniPartnerToDTO poslovniPartnerToDTO;

	
	@Override
	@Transactional(readOnly = true)
	public PoslovniPartner getById(Integer sifraPartnera) {
		return poslovniPartnerRepository.findBySifraPartnera(sifraPartnera);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PoslovniPartner> getAll(Pageable pageable) {
		return poslovniPartnerRepository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<PoslovniPartner> getByDobavljaci(Pageable pageable) {
		return poslovniPartnerRepository.findByTipPartneraD(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<PoslovniPartner> getByKupci(Pageable pageable) {
		return poslovniPartnerRepository.findByTipPartneraK(pageable);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PoslovniPartner add(PoslovniPartner poslovniPartner) {
		return poslovniPartnerRepository.save(poslovniPartner);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PoslovniPartner update(PoslovniPartner poslovniPartner) {

		PoslovniPartner poslovniPartnerEdit = poslovniPartnerRepository.findBySifraPartnera(poslovniPartner.getSifraPartnera());
		poslovniPartnerEdit.setAdresaPoslovnogPartnera(poslovniPartner.getAdresaPoslovnogPartnera());
		poslovniPartnerEdit.setNazivPartnera(poslovniPartner.getNazivPartnera());
		poslovniPartnerEdit.setPib(poslovniPartner.getPib());
		poslovniPartnerEdit.setTipPartnera(poslovniPartner.getTipPartnera());
		poslovniPartnerEdit.setMesto(poslovniPartner.getMesto());
		return poslovniPartnerRepository.save(poslovniPartnerEdit);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(PoslovniPartner poslovniPartner) {
		PoslovniPartner poslovniPartnerToBeDeleted = poslovniPartnerRepository.findBySifraPartnera(poslovniPartner.getSifraPartnera());
		poslovniPartnerRepository.delete(poslovniPartnerToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer sifraPartnera) {
		poslovniPartnerRepository.deleteBySifraPartnera(sifraPartnera);	
	}
	
}
