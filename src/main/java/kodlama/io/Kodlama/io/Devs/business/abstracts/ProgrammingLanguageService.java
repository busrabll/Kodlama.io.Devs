package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void delete(int id);
	ProgrammingLanguage getById(int id);

}
