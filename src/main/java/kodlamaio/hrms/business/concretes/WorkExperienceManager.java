package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataaccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{

	private WorkExperienceDao workExperienceDao;
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public Result add(WorkExperience experience) {
		this.workExperienceDao.save(experience);
		return new SuccessResult("Work experience added.");
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {		
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(), "Data listed.");
	}

	@Override
	public DataResult<List<WorkExperience>> getAllSorted() {
		Sort sort=Sort.by(new Sort.Order(Sort.Direction.DESC, "finishDate", Sort.NullHandling.NULLS_FIRST));
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(sort), "Data listed.");
	}

}
