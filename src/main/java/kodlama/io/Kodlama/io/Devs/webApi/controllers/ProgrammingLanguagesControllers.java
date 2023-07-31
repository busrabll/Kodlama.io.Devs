package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/programmingLanguages")
@AllArgsConstructor
public class ProgrammingLanguagesControllers {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	
	@GetMapping()
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdProgrammingLanguageResponse getById(@PathVariable int id){
		return programmingLanguageService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		this.programmingLanguageService.add(createProgrammingLanguageRequest); 
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		this.programmingLanguageService.update(updateProgrammingLanguageRequest);	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.programmingLanguageService.delete(id);
	}
	
}
