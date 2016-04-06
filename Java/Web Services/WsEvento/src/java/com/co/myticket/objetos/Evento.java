/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.objetos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joanrincon
 */
@XmlRootElement
public class Evento {
    
    private int    idEvento;
    private String nombreEvento;
    private String descripcionEvento;
    private String nombreEscenario;
    private String descripcionEscenario;
    private String direccionEvento;
    private String ciudadEvento;
    private String tipoIdOrganizacion;
    private String numeroIdOrganizacion;
    private String razonSocial;
    private String direccionOrganizacion;
    private String tipoEvento;
    private String estadoEvento;
    private String   fechaEvento;
    private String   horaInicio;
    private String   horaFin;
    private String disponibilidad;
    private Date   fechaCreacion;
    private String usuarioCreacion;
    private Date   fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getNombreEscenario() {
        return nombreEscenario;
    }

    public void setNombreEscenario(String nombreEscenario) {
        this.nombreEscenario = nombreEscenario;
    }

    public String getDescripcionEscenario() {
        return descripcionEscenario;
    }

    public void setDescripcionEscenario(String descripcionEscenario) {
        this.descripcionEscenario = descripcionEscenario;
    }

    public String getDireccionEvento() {
        return direccionEvento;
    }

    public void setDireccionEvento(String direccionEvento) {
        this.direccionEvento = direccionEvento;
    }

    public String getCiudadEvento() {
        return ciudadEvento;
    }

    public void setCiudadEvento(String ciudadEvento) {
        this.ciudadEvento = ciudadEvento;
    }

    public String getTipoIdOrganizacion() {
        return tipoIdOrganizacion;
    }

    public void setTipoIdOrganizacion(String tipoIdOrganizacion) {
        this.tipoIdOrganizacion = tipoIdOrganizacion;
    }

    public String getNumeroIdOrganizacion() {
        return numeroIdOrganizacion;
    }

    public void setNumeroIdOrganizacion(String numeroIdOrganizacion) {
        this.numeroIdOrganizacion = numeroIdOrganizacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccionOrganizacion() {
        return direccionOrganizacion;
    }

    public void setDireccionOrganizacion(String direccionOrganizacion) {
        this.direccionOrganizacion = direccionOrganizacion;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }



    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public String getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }
    
    
    
}
