package com.bci.apicliente.service.impl;

import com.bci.apicliente.bean.ResponseConsultaBean;
import com.bci.apicliente.bean.ResponseSolicitud;
import com.bci.apicliente.model.dto.SolicitudDTO;
import com.bci.apicliente.model.entity.Anexo;
import com.bci.apicliente.model.entity.Area;
import com.bci.apicliente.model.entity.Solicitante;
import com.bci.apicliente.model.entity.Solicitud;
import com.bci.apicliente.repository.SolicitudRepository;
import com.bci.apicliente.service.SolicitudService;
import com.bci.apicliente.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    final Logger logger = LoggerFactory.getLogger(SolicitudServiceImpl.class);
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public ResponseSolicitud saveSolicitud(SolicitudDTO solicitudDTO) {
        Solicitud solicitud;
        ResponseSolicitud responseSolicitud = new ResponseSolicitud();
        try {
            logger.info("saveSolicitud - Inicio con el registro de la solicitud");
            solicitud = solicitudRepository.save(this.builderSolicitudDB(solicitudDTO));
            responseSolicitud.setCodigo("Success");
            responseSolicitud.setMensaje("Se registró la solicitud correctamente.");
            responseSolicitud.setCodigoSolicitud(solicitud.getIdSolicitud());
            logger.info("saveSolicitud - Se registró la solicitud correctamente.");
        } catch (Exception e) {
            logger.error("saveSolicitud - Exception occurred. msg={}, e={}", e.getMessage(), e);
        }
        return responseSolicitud;
    }

    @Override
    public ResponseSolicitud updateSolicitud(int idSolicitud, SolicitudDTO solicitudDTO) {
        Solicitud solicitud;
        ResponseSolicitud responseSolicitud = new ResponseSolicitud();
        try {
            logger.info("saveSolicitud - Inicio de la actualizacion de la solicitud");
            solicitud = solicitudRepository.save(this.builderUpdateSolicitudDB(idSolicitud, solicitudDTO));
            responseSolicitud.setCodigo("Success");
            responseSolicitud.setMensaje("Se actualizó la solicitud correctamente.");
            responseSolicitud.setCodigoSolicitud(solicitud.getIdSolicitud());
            logger.info("saveSolicitud - Se actualizó la solicitud correctamente.");
        } catch (Exception e) {
            logger.error("saveSolicitud - Exception occurred. msg={}, e={}", e.getMessage(), e);
        }
        return responseSolicitud;
    }

    @Override
    public ResponseConsultaBean getSolicitudesBy(int estado) {
        logger.info("getSolicitudes - Se inicia con la consulta de las solicitudes por el estado indicado.");
        ResponseConsultaBean responseConsultaBean = new ResponseConsultaBean();
        List<Solicitud> solicitudes = solicitudRepository.findAllByEstado(estado);
        if(!solicitudes.isEmpty()){
            responseConsultaBean.setCodigo("Success");
            responseConsultaBean.setMensaje("Se realizó la consulta correctamente.");
            responseConsultaBean.setData(solicitudes);
            logger.info("getSolicitudes - Se realizó la consulta correctamente.");
        }
        else {
            responseConsultaBean.setCodigo("Error");
            responseConsultaBean.setMensaje("No se encontraron solicitudes.");
            logger.info("getSolicitudes - No se encontraron solicitudes.");
        }
        return responseConsultaBean;
    }

    @Override
    public ResponseSolicitud deleteSolicitud(int idSolicitud) {
        ResponseSolicitud responseSolicitud = new ResponseSolicitud();
        try {
            logger.info("saveCliente - Inicio con el registro del cliente");
            solicitudRepository.deleteById(idSolicitud);
            responseSolicitud.setCodigo("Success");
            responseSolicitud.setMensaje("Se eliminó la solicitud correctamente.");
            responseSolicitud.setCodigoSolicitud(idSolicitud);
            logger.info("saveCliente - Se registró el cliente correctamente.");

        } catch (Exception e) {
            responseSolicitud.setCodigo("Error");
            responseSolicitud.setMensaje("El cliente a registrar ya se encuentra registrado.");
            responseSolicitud.setCodigoSolicitud(0);
            logger.error("saveCliente - El nombre del cliente ya existe. msg={}, e={}", e.getMessage(), e);
        }
        return responseSolicitud;
    }

    private Solicitud builderSolicitudDB(SolicitudDTO solicitudDTO) throws ParseException {

        Anexo anexo = new Anexo();
        anexo.setIdAnexo(solicitudDTO.getAnexo().getIdAnexo());
        anexo.setDescripcion(solicitudDTO.getAnexo().getDescripcion());
        anexo.setGuid(solicitudDTO.getAnexo().getGuid());
        anexo.setEstado(1);

        Solicitante solicitante = getSolicitante(solicitudDTO);

        return Solicitud.builder()
                .idSolicitud(solicitudDTO.getIdSolicitud())
                .nombre(solicitudDTO.getNombre())
                .descripcion(solicitudDTO.getDescripcion())
                .anexo(anexo)
                .solicitante(solicitante)
                .fechaSolicitud(Util.convertirStringToDate(""))
                .estado(1)
                .build();
    }

    private Solicitud builderUpdateSolicitudDB(int idSolicitud, SolicitudDTO solicitudDTO) throws ParseException {

        Solicitud solicitud = solicitudRepository.findById(idSolicitud).get();

        Anexo anexo = new Anexo();
        anexo.setIdAnexo(solicitudDTO.getAnexo().getIdAnexo());
        anexo.setDescripcion(solicitudDTO.getAnexo().getDescripcion());
        anexo.setGuid(solicitudDTO.getAnexo().getGuid());
        anexo.setEstado(1);

        Solicitante solicitante = getSolicitante(solicitudDTO);

        solicitud.setIdSolicitud(solicitudDTO.getIdSolicitud());
        solicitud.setNombre(solicitudDTO.getNombre());
        solicitud.setDescripcion(solicitudDTO.getDescripcion());
        solicitud.setAnexo(anexo);
        solicitud.setSolicitante(solicitante);
        solicitud.setFechaSolicitud(Util.convertirStringToDate(""));
        solicitud.setEstado(1);

        return solicitud;
    }

    private static Solicitante getSolicitante(SolicitudDTO solicitudDTO) {
        Area area = new Area();
        area.setIdArea(solicitudDTO.getSolicitante().getArea().getIdArea());
        area.setDescripcion(solicitudDTO.getSolicitante().getArea().getDescripcion());
        area.setEstado(1);

        Solicitante solicitante = new Solicitante();
        solicitante.setIdSolicitante(solicitudDTO.getSolicitante().getIdSolicitante());
        solicitante.setNombres(solicitudDTO.getSolicitante().getNombres());
        solicitante.setApellidos(solicitudDTO.getSolicitante().getApellidos());
        solicitante.setArea(area);
        solicitante.setEstado(1);
        return solicitante;
    }
}
