package com.bci.apicliente.controller;

import static org.mockito.Mockito.*;

import com.bci.apicliente.bean.ResponseBean;
import com.bci.apicliente.bean.ResponseConsultaBean;
import com.bci.apicliente.model.dto.ClienteDTO;
import com.bci.apicliente.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @MockBean
    private ClienteService clienteService;

    @Test
    public void createCliente_Success() {

        ClienteDTO clienteDTO = this.createClienteDto();

        ResponseBean responseBean = this.createAddClienteResponse();

        when(clienteService.saveCliente(clienteDTO)).thenReturn(responseBean);
    }
    @Test
    public void createUser_Exception() {
        when(clienteService.saveCliente(any(ClienteDTO.class))).thenThrow(new RuntimeException());
    }

    @Test
    public void listCliente_Success() {

        ResponseConsultaBean responseConsultaBean = this.createListClienteResponse();

        when(clienteService.getCliente(1)).thenReturn(responseConsultaBean);
    }
    private ClienteDTO createClienteDto(){
        return ClienteDTO.builder()
                .codigoCliente(0)
                .nombres("Jose Luis")
                .appaterno("Calderon22222")
                .apmaterno("Jimenez")
                .nacimiento("20/04/1991")
                .genero("M")
                .correo("jluiscalderon91@hotmail.com")
                .telefono("987367819")
                .estado("1")
                .build();
    }

    private ClienteDTO createClienteDtoConsulta(){
        return ClienteDTO.builder()
                .codigoCliente(1)
                .nombres("Jose Luis")
                .appaterno("Calderon")
                .apmaterno("Jimenez")
                .nacimiento("20/04/1991")
                .genero("M")
                .correo("jluiscalderon91@hotmail.com")
                .telefono("987367819")
                .estado("1")
                .build();
    }

    private ResponseBean createAddClienteResponse() {
        return ResponseBean.builder()
                .codigo("success")
                .mensaje("Se registró el cliente correctamente.")
                .codigoCliente(1)
                .build();
    }

    private ResponseConsultaBean createListClienteResponse() {
        return ResponseConsultaBean.builder()
                .codigo("success")
                .mensaje("Se registró el cliente correctamente.")
                .data(createClienteDtoConsulta())
                .build();
    }
}
