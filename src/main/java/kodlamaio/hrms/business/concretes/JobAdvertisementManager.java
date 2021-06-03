package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataaccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
private JobAdvertisementDao jobAdvertisementDao;
@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
	super();
	this.jobAdvertisementDao = jobAdvertisementDao;
}

	@Override
	public Result add(JobAdvertisement advertisement) {
		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("Advertisement added.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActive(true), "All active advertisements listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveByCompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByCompany_CompanyNameAndIsActive(companyName, true), "Data listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveSortedByDeadline() {
		Sort sort=Sort.by(Sort.Direction.ASC,"deadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	

	@Override
	public Result makePasive(JobAdvertisement advertisement) {
		this.jobAdvertisementDao.findById(advertisement.getId()).setActive(false);
		return new SuccessResult("Job Advertisement is pasive now.");
	}

}
