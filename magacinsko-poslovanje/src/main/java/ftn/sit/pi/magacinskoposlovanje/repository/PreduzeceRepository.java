package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;

@Repository
public interface PreduzeceRepository extends PagingAndSortingRepository<Preduzece, Integer> {

}
