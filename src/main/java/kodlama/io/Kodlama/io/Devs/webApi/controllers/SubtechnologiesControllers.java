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
import kodlama.io.Kodlama.io.Devs.business.abstracts.SubtechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateSubtechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubtechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllSubtechnologiesResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subtechnologies")
@AllArgsConstructor
public class SubtechnologiesControllers {
	
	private SubtechnologyService subtechnologyService;
	
	@GetMapping()
	public List<GetAllSubtechnologiesResponse> getAll(){
		return subtechnologyService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateSubtechnologyRequest createSubtechnologyRequest) {
		this.subtechnologyService.add(createSubtechnologyRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateSubtechnologyRequest updateSubtechnologyRequest) {
		this.subtechnologyService.update(updateSubtechnologyRequest);	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.subtechnologyService.delete(id);
	}

}
