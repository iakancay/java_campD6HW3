package kodlamaio.hrms.business.abstracts;



import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public interface JobAdvertisementService {
	Result add(JobAdvertisement advertisement);
	DataResult<List<JobAdvertisement>> getAllActive();
	DataResult<List<JobAdvertisement>> getAllActiveByCompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getAllActiveSortedByDeadline();
	Result makePasive(JobAdvertisement advertisement);
	

}
