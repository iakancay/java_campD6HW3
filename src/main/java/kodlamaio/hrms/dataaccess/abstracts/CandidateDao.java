package kodlamaio.hrms.dataaccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	  Candidate findByEmail(String email); 
	  Candidate findByNationaltyId(String nationaltyId);
	 

}
