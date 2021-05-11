package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyCheckService;
import kodlamaio.hrms.dataaccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;
@Service
public class CompanyCheckManager implements CompanyCheckService{
	private CompanyDao companyDao;
@Autowired
	public CompanyCheckManager(CompanyDao companyDao) {
		super();
		this.companyDao = companyDao;
	}

	@Override
	public boolean isFieldsEmpty(Company company) {
		if(company.getCompanyName()==null || company.getCompanyUrl()==null || 
				company.getEmail()==null||company.getPassword()==null || company.getPhone()==null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isMailExist(Company company) {
		if(companyDao.findByEmail(company.getEmail())!=null) {
			return true;
		}
		return false;
	}

	

}
