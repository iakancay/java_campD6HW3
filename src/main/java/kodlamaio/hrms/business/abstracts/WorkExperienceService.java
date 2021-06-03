package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService {
	Result add(WorkExperience experience);
	DataResult<List<WorkExperience>> getAll();
	DataResult<List<WorkExperience>> getAllSorted();
}
