package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	GetByIdProgrammingLanguageResponse getById(int id);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	void delete(int id);
}
