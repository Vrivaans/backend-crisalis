package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.dto.DtoServiciosContratados;
import com.crisalis.backendcrisalis.models.ServiciosContratados;

public interface IServiciosContratadosServices {

    public void saveServicioContratado(ServiciosContratados servicioContratado);

    public void deleteServicioContratado(int id);

    public ServiciosContratados findServicioContratado(int id);

    public boolean existById(int id);

    public Optional<ServiciosContratados>getId(int id);

    public List<DtoServiciosContratados> getServicioContratados();

    public List<DtoServiciosContratados>getServiciosCliente(int id);
    
    public List<DtoServiciosContratados>getServicioEmpresa(int id);

    //Tengo que crear funciones que traigan servicios contratados según la empresa o el cliente


}
