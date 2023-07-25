package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = programmingLanguages.stream()
				.map(programmingLanguage -> this.modelMapperService.forResponse()
						.map(programmingLanguage, GetAllProgrammingLanguagesResponse.class)).collect(Collectors.toList());
		
		
		return programmingLanguagesResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
		
		this.programmingLanguageRepository.save(programmingLanguage);
		
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage programmingLanguage =  this.programmingLanguageRepository.findById(id).orElseThrow();
		
		GetByIdProgrammingLanguageResponse response = this.modelMapperService.forResponse().map(programmingLanguage, GetByIdProgrammingLanguageResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		this.programmingLanguageRepository.save(programmingLanguage);
		
	}

	@Override
	public void delete(int id) {
		this.programmingLanguageRepository.deleteById(id);
		
	}
}
