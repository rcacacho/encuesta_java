package com.diaco.web.reporte;

import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.web.utils.JasperUtil;
import com.diaco.web.utils.JsfUtil;
import com.diaco.web.utils.ReporteJasper;
import com.diaco.web.utils.SesionUsuarioMB;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "reporteMB")
@ViewScoped
public class ReporteMB implements Serializable {

    private static final Logger log = Logger.getLogger(ReporteMB.class);

    @Resource(lookup = "jdbc/diaco")
    private DataSource dataSource;

    @EJB
    private QuejaBeanLocal quejaBean;

    private Date fechaIncio;
    private Date fechaFin;

    public StreamedContent generarPdfRegion() {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String realPath = servletContext.getRealPath("/");
            String nombreReporte = "rptRegiones";
            String nombreArchivo = "region.pdf";
            HashMap parametros = new HashMap();
            parametros.put("IMAGE", "umg.png");
            parametros.put("DIRECTORIO", realPath + File.separator + "resources" + File.separator + "images" + File.separator);
            parametros.put("USUARIO", SesionUsuarioMB.getUserName());
            ReporteJasper reporteJasper = JasperUtil.jasperReportPDF(nombreReporte, nombreArchivo, parametros, dataSource);
            StreamedContent streamedContent;
            FileInputStream stream = new FileInputStream(realPath + "resources/reports/" + reporteJasper.getFileName());
            streamedContent = new DefaultStreamedContent(stream, "application/pdf", reporteJasper.getFileName());
            return streamedContent;
        } catch (Exception ex) {
            log.error(ex);
            JsfUtil.addErrorMessage("Ocurrio un error al generar el pdf del reporte");
        }
        return null;
    }

    public StreamedContent generarPdfMasQuejas() {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String realPath = servletContext.getRealPath("/");
            String nombreReporte = "rptQueja";
            String nombreArchivo = "MasQueja.pdf";
            HashMap parametros = new HashMap();
            parametros.put("IMAGE", "umg.png");
            parametros.put("DIRECTORIO", realPath + File.separator + "resources" + File.separator + "images" + File.separator);
            parametros.put("USUARIO", SesionUsuarioMB.getUserName());
            ReporteJasper reporteJasper = JasperUtil.jasperReportPDF(nombreReporte, nombreArchivo, parametros, dataSource);
            StreamedContent streamedContent;
            FileInputStream stream = new FileInputStream(realPath + "resources/reports/" + reporteJasper.getFileName());
            streamedContent = new DefaultStreamedContent(stream, "application/pdf", reporteJasper.getFileName());
            return streamedContent;
        } catch (Exception ex) {
            log.error(ex);
            JsfUtil.addErrorMessage("Ocurrio un error al generar el pdf del reporte");
        }
        return null;
    }

    public StreamedContent generarPdfFechas() {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String realPath = servletContext.getRealPath("/");
            String nombreReporte = "rptQuejaFecha";
            String nombreArchivo = "MasQueja.pdf";
            HashMap parametros = new HashMap();
            parametros.put("IMAGE", "umg.png");
            parametros.put("DIRECTORIO", realPath + File.separator + "resources" + File.separator + "images" + File.separator);
            parametros.put("USUARIO", SesionUsuarioMB.getUserName());
            parametros.put("FECHA_INICIO", fechaIncio);
            parametros.put("FECHA_FIN", fechaFin);
            ReporteJasper reporteJasper = JasperUtil.jasperReportPDF(nombreReporte, nombreArchivo, parametros, dataSource);
            StreamedContent streamedContent;
            FileInputStream stream = new FileInputStream(realPath + "resources/reports/" + reporteJasper.getFileName());
            streamedContent = new DefaultStreamedContent(stream, "application/pdf", reporteJasper.getFileName());
            return streamedContent;
        } catch (Exception ex) {
            log.error(ex);
            JsfUtil.addErrorMessage("Ocurrio un error al generar el pdf del reporte");
        }
        return null;
    }

    /*Metodos gettets y setters*/
    public Date getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
