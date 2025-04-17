package com.bci.apicliente.controller;
import com.bci.apicliente.model.dto.ClienteDTO;
import com.bci.apicliente.service.ClienteService;
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
@RequestMapping("/api/client")
@Tag(name="Clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Api para la creación de un cliente")
	@Validated
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema =
			@Schema(implementation = ClienteController.class))}, description = "Registra a un cliente"),
			@ApiResponse(responseCode = "404", content = {@Content(mediaType = "application/json")}, description =
					"La url ingresada no existe"),
			@ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")}, description =
					"Hubo un error en el servidor al momento de realizar el registro")
	})
	@PostMapping("/add")
	public ResponseEntity saveCliente(@RequestBody ClienteDTO clienteDTO){
		return new ResponseEntity(clienteService.saveCliente(clienteDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Obtiene un usuario por su codigo")
	@Validated
	@GetMapping("/get/{id}")
	public ResponseEntity getCliente(@PathVariable("id") int codigoCliente){
		return new ResponseEntity(clienteService.getCliente(codigoCliente), HttpStatus.OK);
	}
}
