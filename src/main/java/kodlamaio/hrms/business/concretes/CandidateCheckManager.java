package kodlamaio.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.dataaccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class CandidateCheckManager implements CandidateCheckService {
private CandidateDao candidateDao;

@Autowired
public CandidateCheckManager(CandidateDao candidateDao) {
	super();
	this.candidateDao = candidateDao;
}



	@Override
	public boolean isFieldsEmpty(Candidate candidate) {
		if (candidate.getFirstName() == null || candidate.getLastName() == null || candidate.getEmail() == null
				|| candidate.getNationaltyId() == null || candidate.getBirthDate() == null
				|| candidate.getPassword() == null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isMailExist(Candidate candidate) {
		System.out.println(candidateDao.findByEmail(candidate.getEmail()));
		if(candidateDao.findByEmail(candidate.getEmail())!=null) {
		return true;	
		}
		return false;
	}

	@Override
	public boolean isNatinolatiyIdExist(Candidate candidate) {
		if(candidateDao.findByNationaltyId(candidate.getNationaltyId())!=null) {
			return true;	
			}
		return false;
	}

}
