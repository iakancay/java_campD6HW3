package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	public boolean isFieldsEmpty(Candidate candidate);
	public boolean isMailExist(Candidate candidate);
	public boolean isNatinolatiyIdExist(Candidate candidate);
	
	

}
