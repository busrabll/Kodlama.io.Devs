package kodlama.io.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.core.exceptions.BusinessException;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRules {
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public void checkIfProgrammingLanguageNameExists(String name) {
		
		if(this.programmingLanguageRepository.existsByName(name)) {
			throw new BusinessException("Programming Language Name Already Exists");
		}
		
	}
	
}
