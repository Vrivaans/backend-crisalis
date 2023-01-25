package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;




//@Getter
//@Setter
@Entity
@ToString
public class Cliente extends Persona {
    


   



    /*
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PedidosClientes> pedidos = new ArrayList<>(); 
    */
    
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServiciosContratados> serviciosContratados = new ArrayList<>();


    public Cliente(){

    }   
    public Cliente(int id, String dniCliente, String nombre, String apellido){
        super(id, dniCliente, nombre, apellido);
    }
    public List<ServiciosContratados> getServiciosContratados() {
        return serviciosContratados;
    }
    public void setServiciosContratados(List<ServiciosContratados> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }

    /*public Cliente(int id,  String dniCliente,  String nombre,  String apellido{
            //List<PedidosClientes> pedidos, List<ServiciosContratados> serviciosContratados) {
        super(id, dniCliente, nombre, apellido);
        //this.pedidos = pedidos;
        //this.serviciosContratados = serviciosContratados;
    }*/
    /*

    public List<PedidosClientes> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidosClientes> pedidos) {
        this.pedidos = pedidos;
    }

    public List<ServiciosContratados> getServiciosContratados() {
        return serviciosContratados;
    }

    public void setServiciosContratados(List<ServiciosContratados> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }
     */
    

}
