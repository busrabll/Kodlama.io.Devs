package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguage() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Ruby"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
		programmingLanguages.add(new ProgrammingLanguage(4, "C"));
		programmingLanguages.add(new ProgrammingLanguage(5, "C++"));
		programmingLanguages.add(new ProgrammingLanguage(6, "C sharp"));
		programmingLanguages.add(new ProgrammingLanguage(7, "PHP"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		this.programmingLanguages.remove(id);
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id);
	}

}
