package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesControllers {
	private  ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesControllers(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		this.programmingLanguageService.add(programmingLanguage);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.programmingLanguageService.delete(id);
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable int id){
		return programmingLanguageService.getById(id);
	}
	
}
