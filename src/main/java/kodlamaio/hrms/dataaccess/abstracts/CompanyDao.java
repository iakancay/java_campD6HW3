package kodlamaio.hrms.dataaccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyDao extends JpaRepository<Company,Integer>{
	Company findByEmail(String email);

}
