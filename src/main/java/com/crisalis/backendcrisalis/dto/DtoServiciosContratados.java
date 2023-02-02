package com.crisalis.backendcrisalis.dto;

public class DtoServiciosContratados {
    //Notas:
    //La idea es mostrar los servicios junto con los clientes
    //Para eso voy a necesitar los objetos de cliente y el servicio en el controlador
    // nombre!: string
    // apellido!: string
    // dniCliente!: string
    // //Datos del servicio
    // nombreServicio!: string
    // precioBase!: number
    // soportePrecio!: number

    private String nombre;

    private String apellido;

    private String dniCliente;

    private String razonSocial;

    private String cuit;

    private String nombreServicio;

    private float precioBase;

    private float soportePrecio;

    




    public DtoServiciosContratados(String nombre, String apellido, String dniCliente, String razonSocial,
            String cuit, String nombreServicio, float precioBase, float soportePrecio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniCliente = dniCliente;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.nombreServicio = nombreServicio;
        this.precioBase = precioBase;
        this.soportePrecio = soportePrecio;
    }



    public DtoServiciosContratados() {
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public float getSoportePrecio() {
        return soportePrecio;
    }

    public void setSoportePrecio(float soportePrecio) {
        this.soportePrecio = soportePrecio;
    }



    public String getRazonSocial() {
        return razonSocial;
    }



    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }



    public String getCuit() {
        return cuit;
    }



    public void setCuit(String cuit) {
        this.cuit = cuit;
    }


    
}
