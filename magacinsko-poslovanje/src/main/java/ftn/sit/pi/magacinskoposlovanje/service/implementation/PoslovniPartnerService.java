package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.repository.PoslovniPartnerRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPoslovniPartnerService;

@Service
@Transactional
public class PoslovniPartnerService implements IPoslovniPartnerService {

	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;

	
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
	public PoslovniPartner add(PoslovniPartner poslovniPartner) {
		return poslovniPartnerRepository.save(poslovniPartner);
	}

	@Override
	public PoslovniPartner update(PoslovniPartner PoslovniPartner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PoslovniPartner poslovniPartner) {
		PoslovniPartner poslovniPartnerToBeDeleted = poslovniPartnerRepository.findBySifraPartnera(poslovniPartner.getSifraPartnera());
		poslovniPartnerRepository.delete(poslovniPartnerToBeDeleted);
	}

	@Override
	public void deleteById(Integer sifraPartnera) {
		poslovniPartnerRepository.deleteBySifraPartnera(sifraPartnera);	
	}
	
	
	
}