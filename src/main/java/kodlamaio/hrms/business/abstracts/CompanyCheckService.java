package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyCheckService {
	public boolean isFieldsEmpty(Company company);
	public boolean isMailExist(Company company);
	

}
