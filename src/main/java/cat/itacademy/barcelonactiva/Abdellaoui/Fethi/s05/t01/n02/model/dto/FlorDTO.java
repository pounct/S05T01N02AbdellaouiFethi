package cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.domain.FlorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlorDTO {

	final static String[] EU = { "Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia",
			"Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia",
			"República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania",
			"Portugal", "Rumanía" };

	private Integer pk_FlorID;
	private String nomFlor;
	private String paisFlor;

	private String tipusFlor;

	private static List<String> paisos = new ArrayList<>(Arrays.asList(EU));

	public static FlorDTO toDTO(FlorEntity flor) {
		FlorDTO dto = FlorDTO.builder()
				.pk_FlorID(flor.getPk_FlorID())
				.nomFlor(flor.getNomFlor())
				.paisFlor(flor.getPaisFlor())
				.build();

		dto.setTipusFlor(paisos.contains(dto.getPaisFlor()) ? "EU" : "ForaUE");
		return dto;
	}

}
