import java.io.Serializable;

public class Registro implements Serializable {
    private String codigo;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String dia;
    private String mes;
    private String año;
    private String signo;
    private boolean rojo;
    private boolean verde;
    private boolean ninguno;
    private boolean estaCasado;

    public Registro(String codigo, String cedula, String nombres, String apellidos, String dia, String mes, String año,
                    boolean rojo, boolean verde, boolean ninguno, boolean estaCasado, String signo) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.rojo = rojo;
        this.verde = verde;
        this.ninguno = ninguno;
        this.estaCasado = estaCasado;
        this.signo = signo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public boolean isRojo() {
        return rojo;
    }

    public void setRojo(boolean rojo) {
        this.rojo = rojo;
    }

    public boolean isVerde() {
        return verde;
    }

    public void setVerde(boolean verde) {
        this.verde = verde;
    }

    public boolean isNinguno() {
        return ninguno;
    }

    public void setNinguno(boolean ninguno) {
        this.ninguno = ninguno;
    }

    public boolean isEstaCasado() {
        return estaCasado;
    }

    public void setEstaCasado(boolean estaCasado) {
        this.estaCasado = estaCasado;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }
}
