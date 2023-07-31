package kodlama.io.Kodlama.io.Devs.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubtechnologyRequest {
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private int programmingLanguageId;
}
