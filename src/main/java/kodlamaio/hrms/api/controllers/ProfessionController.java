package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProfessionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Profession;

@RestController
@RequestMapping("/api/professions/")
public class ProfessionController {
	private ProfessionService professionService;

	@Autowired
	public ProfessionController(ProfessionService professionService) {
		super();
		this.professionService = professionService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Profession>> getAll(){
		return this.professionService.getAll();
	}
	
	@PostMapping("add")
	public Result add(Profession profession) {
		return this.professionService.add(profession);
	}

}
