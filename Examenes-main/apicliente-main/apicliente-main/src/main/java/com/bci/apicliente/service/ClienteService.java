package com.bci.apicliente.service;
import com.bci.apicliente.bean.ResponseBean;
import com.bci.apicliente.bean.ResponseConsultaBean;
import com.bci.apicliente.model.dto.ClienteDTO;
import com.bci.apicliente.model.entity.Cliente;

import java.util.List;

public interface ClienteService {
    ResponseBean saveCliente(ClienteDTO clienteDTO);
    ResponseConsultaBean getCliente(int codigoCliente);
}
