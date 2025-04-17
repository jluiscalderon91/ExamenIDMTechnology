package com.bci.apicliente.service.impl;

import com.bci.apicliente.bean.ResponseBean;
import com.bci.apicliente.bean.ResponseConsultaBean;
import com.bci.apicliente.model.dto.ClienteDTO;
import com.bci.apicliente.model.entity.Cliente;
import com.bci.apicliente.repository.ClienteRepository;
import com.bci.apicliente.service.ClienteService;
import com.bci.apicliente.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ResponseBean saveCliente(ClienteDTO clienteDTO) {
        Cliente cliente;
        ResponseBean responseBean = new ResponseBean();
        try {
            logger.info("saveCliente - Inicio con el registro del cliente");
            cliente = clienteRepository.save(this.builderClienteDB(clienteDTO));
            if (cliente != null) {
                responseBean.setCodigo("Success");
                responseBean.setMensaje("Se registró el cliente correctamente.");
                responseBean.setCodigoCliente(cliente.getCodigoCliente());
                logger.info("saveCliente - Se registró el cliente correctamente.");
            }
            else {
                responseBean.setCodigo("Error");
                responseBean.setMensaje("Ocurrió un error al intentar registrar un cliente.");
                responseBean.setCodigoCliente(0);
            }
        } catch (DataIntegrityViolationException e) {
            responseBean.setCodigo("Error");
            responseBean.setMensaje("El cliente a registrar ya se encuentra registrado.");
            responseBean.setCodigoCliente(0);
            logger.error("saveCliente - El nombre del cliente ya existe. msg={}, e={}", e.getMessage(), e);
        } catch (ParseException e) {
            logger.error("saveCliente - Exception occurred. msg={}, e={}", e.getMessage(), e);
        }
        return responseBean;
    }

    @Override
    public ResponseConsultaBean getCliente(int codigoCliente) {
        logger.info("getCliente - Se inicia con la consulta del cliente indicado.");
        ResponseConsultaBean responseConsultaBean = new ResponseConsultaBean();
        Optional<Cliente> cliente = clienteRepository.findById(codigoCliente);
        if(cliente.isPresent()){
            responseConsultaBean.setCodigo("Success");
            responseConsultaBean.setMensaje("Se realizó la consulta correctamente.");
            responseConsultaBean.setData(this.builderClienteResponse(cliente.get()));
            logger.info("getCliente - Se realizó la consulta correctamente.");
        }
        else {
            responseConsultaBean.setCodigo("Error");
            responseConsultaBean.setMensaje("código de cliente no encontrado.");
            logger.info("getCliente - código de cliente no encontrado.");
        }
        return responseConsultaBean;
    }

    private ClienteDTO builderClienteResponse(Cliente cliente) {
        return ClienteDTO.builder()
                .codigoCliente(cliente.getCodigoCliente())
                .nombres(cliente.getNombres())
                .appaterno(cliente.getAppaterno())
                .apmaterno(cliente.getApmaterno())
                .nacimiento(Util.convertirDateToString(cliente.getNacimiento()))
                .genero(cliente.getGenero().equals("M") ? "Masculino" : "Femenino")
                .correo(cliente.getCorreo())
                .telefono(cliente.getTelefono())
                .estado(cliente.getEstado().equals("1") ? "Activo" : "Inactivo")
                .build();
    }

    private Cliente builderClienteDB(ClienteDTO clienteDTO) throws ParseException {
        return Cliente.builder()
                .codigoCliente(clienteDTO.getCodigoCliente())
                .nombres(clienteDTO.getNombres())
                .appaterno(clienteDTO.getAppaterno())
                .apmaterno(clienteDTO.getApmaterno())
                .nacimiento(Util.convertirStringToDate(clienteDTO.getNacimiento()))
                .genero(clienteDTO.getGenero())
                .correo(clienteDTO.getCorreo())
                .telefono(clienteDTO.getTelefono())
                .estado(clienteDTO.getEstado())
                .build();
    }
}
