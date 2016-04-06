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
public class LocalidadEvento {
    
    private int     idLocalidadEvento;
    private int     idEvento;
    private String  nombreLocalidad;
    private String  descripcion;
    private int     disponibilidadTotal;
    private int     totalDisponible;
    private double  valor;
    private String  valorPesos;
    private Date    fechaCreacion;
    private String  usuarioCreacion;
    private Date    fechaUltimaModificacion;
    private String  usuarioUltimaModificacion;

    public int getIdLocalidadEvento() {
        return idLocalidadEvento;
    }

    public void setIdLocalidadEvento(int idLocalidadEvento) {
        this.idLocalidadEvento = idLocalidadEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibilidadTotal() {
        return disponibilidadTotal;
    }

    public void setDisponibilidadTotal(int disponibilidadTotal) {
        this.disponibilidadTotal = disponibilidadTotal;
    }

    public int getTotalDisponible() {
        return totalDisponible;
    }

    public void setTotalDisponible(int totalDisponible) {
        this.totalDisponible = totalDisponible;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getValorPesos() {
        return valorPesos;
    }

    public void setValorPesos(String valorPesos) {
        this.valorPesos = valorPesos;
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
