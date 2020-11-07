package gt.gob.mp.siamp.rrhh.acciones.wrp;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author rcacacho
 */
public class WrapperQueja implements Serializable {

    private Integer idQueja;
    private Date fechaCreacion;
    private String nombre;
    private String Metropolitana;
    private String norte;
    private String norOriente;
    private Integer surOriente;
    private String central;
    private String surOccidente;
    private String norOccidente;
    private String peten;

    /*Metodos getters y setters*/
    public Integer getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(Integer idQueja) {
        this.idQueja = idQueja;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMetropolitana() {
        return Metropolitana;
    }

    public void setMetropolitana(String Metropolitana) {
        this.Metropolitana = Metropolitana;
    }

    public String getNorte() {
        return norte;
    }

    public void setNorte(String norte) {
        this.norte = norte;
    }

    public String getNorOriente() {
        return norOriente;
    }

    public void setNorOriente(String norOriente) {
        this.norOriente = norOriente;
    }

    public Integer getSurOriente() {
        return surOriente;
    }

    public void setSurOriente(Integer surOriente) {
        this.surOriente = surOriente;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    public String getSurOccidente() {
        return surOccidente;
    }

    public void setSurOccidente(String surOccidente) {
        this.surOccidente = surOccidente;
    }

    public String getNorOccidente() {
        return norOccidente;
    }

    public void setNorOccidente(String norOccidente) {
        this.norOccidente = norOccidente;
    }

    public String getPeten() {
        return peten;
    }

    public void setPeten(String peten) {
        this.peten = peten;
    }

}
