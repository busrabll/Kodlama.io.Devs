package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.SubtechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateSubtechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubtechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllSubtechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubtechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Subtechnology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubtechnologyManager implements SubtechnologyService {

	private SubtechnologyRepository subtechnologyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllSubtechnologiesResponse> getAll() {
		List<Subtechnology> subtechnologies = subtechnologyRepository.findAll();

		List<GetAllSubtechnologiesResponse> subtechnologiesResponse = subtechnologies.stream()
				.map(subtechnology -> this.modelMapperService.forResponse().map(subtechnology,
						GetAllSubtechnologiesResponse.class))
				.collect(Collectors.toList());

		return subtechnologiesResponse;
	}

	@Override
	public void add(CreateSubtechnologyRequest createSubtechnologyRequest) {
		Subtechnology subtechnology = this.modelMapperService.forRequest()
				.map(createSubtechnologyRequest, Subtechnology.class);

		this.subtechnologyRepository.save(subtechnology);
	}

	@Override
	public void update(UpdateSubtechnologyRequest updateSubtechnologyRequest) {
		Subtechnology subtechnology = this.modelMapperService.forRequest().map(updateSubtechnologyRequest, Subtechnology.class);
		this.subtechnologyRepository.save(subtechnology);
		
	}

	@Override
	public void delete(int id) {
		this.subtechnologyRepository.deleteById(id);		
	}

}
