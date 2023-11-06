package cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.repository.FlorRepository;

@Service
public class FlorService {

	@Autowired
	FlorRepository florRepository;

	public FlorDTO getFlor(Integer id) {
		Optional<FlorEntity> entity = florRepository.findById(id);
		if (entity.isPresent()) {
			return FlorDTO.toDTO(entity.get());
		}
		return null;
	}

	public List<FlorDTO> getAll() {
		List<FlorEntity> listEntity = florRepository.findAll();
		List<FlorDTO> listDto = new ArrayList<>();
		if (!listEntity.isEmpty()) {
			listEntity.forEach(e -> listDto.add(FlorDTO.toDTO(e)));
		}
		return listDto;
	}

	public void deleteById(Integer id) {
		Optional<FlorEntity> entity = florRepository.findById(id);
		if (entity.isPresent()) {
			florRepository.delete(entity.get());
		} else {
			System.out.println("Flor no trobat");
		}
	}

	public void update(FlorDTO dto) {
		FlorEntity entity = FlorEntity.toEntity(dto);
		florRepository.save(entity);
	}

	public void addFlor(FlorDTO dto) {
		FlorEntity entity = FlorEntity.toEntity(dto);
		florRepository.save(entity);
	}
}
