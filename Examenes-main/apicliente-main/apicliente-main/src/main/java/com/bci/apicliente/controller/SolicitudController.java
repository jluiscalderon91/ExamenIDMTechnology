package com.bci.apicliente.controller;
import com.bci.apicliente.model.dto.SolicitudDTO;
import com.bci.apicliente.service.SolicitudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitud")
@Tag(name="Solicitud")
public class SolicitudController {
	@Autowired
	private SolicitudService solicitudService;

	@Operation(summary = "Api para la creación de una solicitud")
	@Validated
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema =
			@Schema(implementation = SolicitudController.class))}, description = "Registra a un cliente"),
			@ApiResponse(responseCode = "404", content = {@Content(mediaType = "application/json")}, description =
					"La url ingresada no existe"),
			@ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")}, description =
					"Hubo un error en el servidor al momento de realizar el registro")
	})
	@PostMapping("/add")
	public ResponseEntity guardaSolicitud(@RequestBody SolicitudDTO solicitudDTO){
		return new ResponseEntity(solicitudService.saveSolicitud(solicitudDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Api para la actualizacion de una solicitud")
	@Validated
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema =
			@Schema(implementation = SolicitudController.class))}, description = "Actualiza una solicitud"),
			@ApiResponse(responseCode = "404", content = {@Content(mediaType = "application/json")}, description =
					"La url ingresada no existe"),
			@ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")}, description =
					"Hubo un error en el servidor al momento de realizar la actualizacion")
	})
	@PutMapping("/update/{idSolicitud}")
	public ResponseEntity updateSolicitud(@PathVariable("idSolicitud") int idSolicitud, @RequestBody SolicitudDTO solicitudDTO){
		return new ResponseEntity(solicitudService.updateSolicitud(idSolicitud, solicitudDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Obtiene un usuario por su codigo")
	@Validated
	@GetMapping("/getAll/estado/{estado}")
	public ResponseEntity getSolicitudXestado(@PathVariable("estado") int estado){
		return new ResponseEntity(solicitudService.getSolicitudesBy(estado), HttpStatus.OK);
	}

	@Operation(summary = "Elimina una solicitud por su idSolicitud")
	@Validated
	@DeleteMapping("/delete/{idSolicitud}")
	public ResponseEntity deleteSolicitud(@PathVariable("idSolicitud") int idSolicitud){
		return new ResponseEntity(solicitudService.deleteSolicitud(idSolicitud), HttpStatus.OK);
	}
}
