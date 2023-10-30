package cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.Abdellaoui.Fethi.s05.t01.n02.model.services.FlorService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/flor")
public class FlorController {

	FlorService florService;

	@PostMapping("/add")
	public ResponseEntity<FlorDTO> add(@RequestBody FlorDTO dto) {
		florService.addFlor(dto);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<FlorDTO> update(@RequestBody FlorDTO dto) {
		florService.update(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
		FlorDTO fdto = florService.getFlor(id);
		if(fdto==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		florService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<FlorDTO> getFlor(@PathVariable Integer id) {
		FlorDTO fdto = florService.getFlor(id);
		if(fdto==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(fdto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> getAllFlors() {
		List<FlorDTO> flors = florService.getAll();
		if (flors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(flors, HttpStatus.OK);
	}

}
