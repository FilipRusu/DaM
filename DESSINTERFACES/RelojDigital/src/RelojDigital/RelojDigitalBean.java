package RelojDigital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventListener;
import java.util.List;
import javax.swing.*;

public class RelojDigitalBean extends JLabel implements ActionListener, Serializable {

    protected boolean modo24;
    private Timer t;
    private Calendar calendario;
    private String[] horas = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    private String[] minutos = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
    private String[] segundos = minutos;
    private String[] AMPM = {"AM","PM"};

    private AlarmaListener receptor;
    private List<alarma> alarmas;

    public RelojDigitalBean() {
        modo24 = true;
        t = new Timer(1000, this);
        t.start();
        calendario = Calendar.getInstance();
        setText(getHoraActual());
        alarmas = new ArrayList<>();
    }

    public boolean isModo24() {
        return modo24;
    }

    public void setModo24(boolean modo24) {
        this.modo24 = modo24;
    }

    public void addAlarmaListener(AlarmaListener receptor) {
        this.receptor = receptor;
    }

    public void removeAlarmaListener() {
        this.receptor = null;
    }

    public AlarmaListener getReceptor() {
        return receptor;
    }

    public void agregarAlarma(alarma a) {
        alarmas.add(a);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calendario = Calendar.getInstance();
        setText(getHoraActual());
        verificarAlarmas();
    }

    private String getHoraActual() {
        String h, m, s, AM_PM;
        if (modo24) {
            h = horas[calendario.get(Calendar.HOUR_OF_DAY)];
            m = minutos[calendario.get(Calendar.MINUTE)];
            s = segundos[calendario.get(Calendar.SECOND)];
            AM_PM = AMPM[calendario.get(Calendar.AM_PM)];
            return h + ":" + m + ":" + s + " " + AM_PM;
        } else {
            h = horas[calendario.get(Calendar.HOUR)];
            m = minutos[calendario.get(Calendar.MINUTE)];
            s = segundos[calendario.get(Calendar.SECOND)];
            return h + ":" + m + ":" + s;
        }
    }

    private void verificarAlarmas() {
        int horaActual = calendario.get(Calendar.HOUR_OF_DAY);
        int minutoActual = calendario.get(Calendar.MINUTE);
        for (alarma a : alarmas) {
            if (a.isActiva() && a.coincide(horaActual, minutoActual) && receptor != null) {
                receptor.SuenaAlarma(new AlarmaEvent(this, a.getMensaje()));
            }
        }
    }

    public class AlarmaEvent extends java.util.EventObject {
        String msg;
        public AlarmaEvent(Object source, String msg) {
            super(source);
            this.msg = msg;
        }
        public String getMsg() {
            return msg;
        }
    }

    public interface AlarmaListener extends EventListener {
        void SuenaAlarma(AlarmaEvent ev);
    }
    /**
     * Establece una alarma en el reloj y la agrega a la lista de alarmas.
     * @param a La alarma a activar
     */
    public void setMialarma(alarma a) {
        if (a != null) {
            a.setActiva(true);  // Activamos la alarma
            alarmas.add(a);     // La añadimos a la lista de alarmas
        }
    }

    
    
    
}
