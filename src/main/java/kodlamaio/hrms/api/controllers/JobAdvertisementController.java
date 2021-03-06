package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/advertisements/")
public class JobAdvertisementController {
	private  JobAdvertisementService jobAdvertisementService;
@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

@PostMapping("add")
public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
	return this.jobAdvertisementService.add(jobAdvertisement);
}
@GetMapping("getAllActive")
public DataResult<List<JobAdvertisement>> getAllActive(){
	return this.jobAdvertisementService.getAllActive();
}
@GetMapping("getAllActiveByCompanyName")
public DataResult<List<JobAdvertisement>> getAllActiveByCompanyName(@RequestParam String companyName){
	return this.jobAdvertisementService.getAllActiveByCompanyName(companyName);
}
@GetMapping("getAllActiveSortedByDeadline")
public DataResult<List<JobAdvertisement>> getAllActiveSortedByDeadline(){
	return this.jobAdvertisementService.getAllActiveSortedByDeadline();
}
@PutMapping("makePasive")
public Result makePasive(@RequestParam JobAdvertisement advertisement) {
	return this.jobAdvertisementService.makePasive(advertisement);
}
}
