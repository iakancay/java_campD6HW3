package kodlamaio.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	JobAdvertisement findById(int id);
	List<JobAdvertisement> findByIsActive(boolean isActive);
	List<JobAdvertisement> findByCompany_CompanyNameAndIsActive(String companyName,boolean isActive);
	

}
