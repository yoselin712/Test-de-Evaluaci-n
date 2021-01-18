package com.aedo.domain;

public class StatusInfo {

    int status;
    String mensaje;
    Object data;

    public StatusInfo() {
        super();
    }

    public StatusInfo(int status, String mensaje) {
        super();
        this.status = status;
        this.mensaje = mensaje;
    }

    public StatusInfo(int status, String mensaje, Object data) {
        super();
        this.status = status;
        this.mensaje = mensaje;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SPStatus [status=" + status + ", message=" + mensaje + ", data=" + data + "]";
    }


}
