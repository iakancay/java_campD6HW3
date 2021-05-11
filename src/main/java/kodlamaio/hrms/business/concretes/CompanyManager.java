package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyCheckService;
import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataaccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;
@Service
public class CompanyManager implements CompanyService{
	private CompanyCheckService companyCheckService;
	private CompanyDao companyDao;
@Autowired
	public CompanyManager(CompanyCheckService companyCheckService, CompanyDao companyDao) {
		super();
		this.companyCheckService = companyCheckService;
		this.companyDao = companyDao;
	}

	@Override
	public Result signUp(Company candidate) {
		if(companyCheckService.isFieldsEmpty(candidate)) {
			return new ErrorResult("All fields are required.");
		}else if(companyCheckService.isMailExist(candidate)) {
			return new ErrorResult("This Email used before.");
		}
		this.companyDao.save(candidate);
		return new SuccessResult("You signup successfully.");
	}

	@Override
	public DataResult<List<Company>> getAll() {
	return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"All companies listed.");	
	
	}

}
