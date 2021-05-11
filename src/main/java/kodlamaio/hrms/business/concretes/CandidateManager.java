package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataaccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService{
	private CandidateCheckService candidateCheckService;
	private CandidateDao candidateDao;
@Autowired
	public CandidateManager(CandidateCheckService candidateCheckService, CandidateDao candidateDao) {
		super();
		this.candidateCheckService = candidateCheckService;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result signUp(Candidate candidate) {
		if(candidateCheckService.isFieldsEmpty(candidate)) {
			return new ErrorResult("All fields required.");
		}
		else if(candidateCheckService.isMailExist(candidate)) {
			return new ErrorResult("This mail used before.");
		}
		else if (candidateCheckService.isNatinolatiyIdExist(candidate)) {
			return new ErrorResult("This Natoinalty Id used before.");
		}
		
		this.candidateDao.save(candidate);
		
		return new SuccessResult("You signedup succesfuly.");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"All Candidates listed.");
	}

}
