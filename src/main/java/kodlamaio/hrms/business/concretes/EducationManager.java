package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataaccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
@Service
public class EducationManager implements EducationService {
	private EducationDao educationDao;
@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Education added.");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Data listed.");
	}

	@Override
	public DataResult<List<Education>> getAllSorted() {
		Sort sort=Sort.by(new Sort.Order(Sort.Direction.DESC, "schoolFinishDate", Sort.NullHandling.NULLS_FIRST));
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(sort),"Data listed.");
	}

}
