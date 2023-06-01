package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return this.programmingLanguageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		List<ProgrammingLanguage> programmingLanguages;
		programmingLanguages = programmingLanguageRepository.getAll();

		for (ProgrammingLanguage language : programmingLanguages) {
			if (programmingLanguage.getName().equals(language.getName())) {
				throw new Exception("Programming language name already exists");
			}
			if (programmingLanguage.getName().isEmpty()) {
				throw new Exception("Programming Language is cannot be empty!");
			}
		}

		this.programmingLanguageRepository.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		this.programmingLanguageRepository.delete(id);
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return this.programmingLanguageRepository.getById(id);
	}

}
