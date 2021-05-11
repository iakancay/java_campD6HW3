package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;

@RestController
@RequestMapping("api/companies/")
public class CompanyController {
	private CompanyService companyService;
@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

@GetMapping("getall")
public DataResult<List<Company>> getAll() {
	return this.companyService.getAll();
}
@PostMapping("add")
public Result add(Company company) {
	return companyService.signUp(company);
}
}
