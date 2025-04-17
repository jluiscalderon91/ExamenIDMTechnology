package com.bci.apicliente.service;
import com.bci.apicliente.bean.ResponseConsultaBean;
import com.bci.apicliente.bean.ResponseSolicitud;
import com.bci.apicliente.model.dto.SolicitudDTO;

public interface SolicitudService {
    ResponseSolicitud saveSolicitud(SolicitudDTO solicitudDTO);
    ResponseSolicitud updateSolicitud(int idSolicitud,SolicitudDTO solicitudDTO);
    ResponseConsultaBean getSolicitudesBy(int estado);
    ResponseSolicitud deleteSolicitud(int idSolicitud);
}
