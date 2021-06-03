package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Profession;

public interface ProfessionService {
	Result add(Profession profession);
	DataResult<List<Profession>> getAll();

}
