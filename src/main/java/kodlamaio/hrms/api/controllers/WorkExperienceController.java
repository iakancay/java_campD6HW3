package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/experiences/")
public class WorkExperienceController {
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperienceController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<WorkExperience>> getAll(){
		return this.workExperienceService.getAll();
	}
	@PostMapping("add")
	public Result add(WorkExperience experience) {
		return this.workExperienceService.add(experience);
	}
	@GetMapping("getAllSorted")
	public DataResult<List<WorkExperience>> getAllSorted(){
		return this.workExperienceService.getAllSorted();
	}

}
