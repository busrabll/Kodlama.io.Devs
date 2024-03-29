package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

	boolean existsByName(String name);
}
