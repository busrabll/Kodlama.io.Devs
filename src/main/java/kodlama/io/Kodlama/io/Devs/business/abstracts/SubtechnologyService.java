package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateSubtechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateSubtechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllSubtechnologiesResponse;

public interface SubtechnologyService {
	List<GetAllSubtechnologiesResponse> getAll();
	void add(CreateSubtechnologyRequest createSubtechnologyRequest);
	void update(UpdateSubtechnologyRequest updateSubtechnologyRequest);
	void delete(int id);
}
