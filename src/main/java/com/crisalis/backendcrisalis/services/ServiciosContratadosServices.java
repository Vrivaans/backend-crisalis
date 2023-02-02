package com.crisalis.backendcrisalis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.dto.DtoServiciosContratados;
import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.models.Servicios;
import com.crisalis.backendcrisalis.models.ServiciosContratados;
import com.crisalis.backendcrisalis.repository.ServiciosContratadosRepository;

@Service
@Transactional
public class ServiciosContratadosServices implements IServiciosContratadosServices {

    @Autowired
    private ServiciosContratadosRepository serviciosContratadosRepository;

    @Override
    public void saveServicioContratado(ServiciosContratados servicioContratado) {
        serviciosContratadosRepository.save(servicioContratado);
        
    }

    @Override
    public void deleteServicioContratado(int id) {
        serviciosContratadosRepository.deleteById(id);
        
    }

    @Override
    public ServiciosContratados findServicioContratado(int id) {
        ServiciosContratados serviciosContratados = serviciosContratadosRepository.findById(id).orElse(null);
        return serviciosContratados;
    }

    @Override
    public boolean existById(int id) {
        return serviciosContratadosRepository.existsById(id);
    }

    @Override
    public Optional<ServiciosContratados> getId(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<DtoServiciosContratados> getServicioContratados() {
        List<ServiciosContratados> listaServiciosContratados = serviciosContratadosRepository.findAll(); 
        List<DtoServiciosContratados> dtoListaServiciosContratados = new ArrayList<>();
        for(int i = 0; i < listaServiciosContratados.size(); i++){

            ServiciosContratados servicioContratado = new ServiciosContratados();
            Cliente clienteAux = new Cliente();
            Empresa empresaAux = new Empresa();
            Servicios servicioAux = new Servicios();
            DtoServiciosContratados dtoServicioContratado = new DtoServiciosContratados();

            servicioContratado = listaServiciosContratados.get(i);
            clienteAux = servicioContratado.getCliente();
            empresaAux = servicioContratado.getEmpresa();
            servicioAux = servicioContratado.getServicio();
            //Empiezo a armar el objeto
            if(clienteAux != null){
                dtoServicioContratado.setId(servicioContratado.getId());
                dtoServicioContratado.setDniCliente(clienteAux.getDniCliente());
                dtoServicioContratado.setApellido(clienteAux.getApellido());
                dtoServicioContratado.setNombre(clienteAux.getNombre());
                dtoServicioContratado.setCuit("");
                dtoServicioContratado.setRazonSocial("");
                dtoServicioContratado.setNombreServicio(servicioAux.getNombre());
                dtoServicioContratado.setPrecioBase(servicioAux.getPrecioBase());
                dtoServicioContratado.setSoportePrecio(servicioAux.getSoportePrecio());
                dtoServicioContratado.setActivo(servicioContratado.isActivo());
            }
            if (empresaAux != null){
                dtoServicioContratado.setId(servicioContratado.getId());
                dtoServicioContratado.setDniCliente("");
                dtoServicioContratado.setApellido("");
                dtoServicioContratado.setNombre("");
                dtoServicioContratado.setCuit(empresaAux.getCuit());
                dtoServicioContratado.setRazonSocial(empresaAux.getRazonSocial());
                dtoServicioContratado.setNombreServicio(servicioAux.getNombre());
                dtoServicioContratado.setPrecioBase(servicioAux.getPrecioBase());
                dtoServicioContratado.setSoportePrecio(servicioAux.getSoportePrecio());
                dtoServicioContratado.setActivo(servicioContratado.isActivo());
            }

            dtoListaServiciosContratados.add(dtoServicioContratado);
        }


        return dtoListaServiciosContratados;
    }

    @Override
    public List<DtoServiciosContratados> getServiciosCliente(int id) {
        List<ServiciosContratados> listaServiciosCliente = serviciosContratadosRepository.ServiciosContratadosPorCliente(id);
        List<DtoServiciosContratados> dtoListaServiciosCliente = new ArrayList<>();
        for(int i = 0; i < listaServiciosCliente.size(); i++){
            ServiciosContratados servicioContratado = new ServiciosContratados();
            Cliente clienteAux = new Cliente();
            Servicios servicioAux = new Servicios();
            DtoServiciosContratados dtoServicioContratado = new DtoServiciosContratados();
            //Objetos auxiliares para desglosar los datos
            servicioContratado = listaServiciosCliente.get(i);
            clienteAux = servicioContratado.getCliente();
            servicioAux = servicioContratado.getServicio();
            //Crear el dto del servicio contratado
            dtoServicioContratado.setId(servicioContratado.getId());
            dtoServicioContratado.setDniCliente(clienteAux.getDniCliente());
            dtoServicioContratado.setApellido(clienteAux.getApellido());
            dtoServicioContratado.setNombre(clienteAux.getNombre());
            dtoServicioContratado.setCuit("");
            dtoServicioContratado.setRazonSocial("");
            dtoServicioContratado.setNombreServicio(servicioAux.getNombre());
            dtoServicioContratado.setPrecioBase(servicioAux.getPrecioBase());
            dtoServicioContratado.setSoportePrecio(servicioAux.getSoportePrecio());
            dtoServicioContratado.setActivo(servicioContratado.isActivo());
            //Lo añado a la lista de los dto
            dtoListaServiciosCliente.add(dtoServicioContratado);

        }

        return dtoListaServiciosCliente;
    }

    @Override
    public List<DtoServiciosContratados> getServicioEmpresa(int id) {
       
        List<ServiciosContratados> listaServiciosEmpresa = serviciosContratadosRepository.ServiciosContratadosPorEmpresa(id);
        List<DtoServiciosContratados> dtoListaServiciosEmpresa = new ArrayList<>();
        for(int i = 0; i < listaServiciosEmpresa.size(); i++){
            
            ServiciosContratados servicioContratado = new ServiciosContratados();
            Empresa empresaAux = new Empresa();
            Servicios servicioAux = new Servicios();
            DtoServiciosContratados dtoServicioContratado = new DtoServiciosContratados();
            //Objetos auxiliares para desglosar los datos
            servicioContratado = listaServiciosEmpresa.get(i);
            empresaAux = servicioContratado.getEmpresa();
            servicioAux = servicioContratado.getServicio();
            //Crear el dto del servicio contratado
            dtoServicioContratado.setId(servicioContratado.getId());
            dtoServicioContratado.setDniCliente("");
            dtoServicioContratado.setApellido("");
            dtoServicioContratado.setNombre("");
            dtoServicioContratado.setCuit(empresaAux.getCuit());
            dtoServicioContratado.setRazonSocial(empresaAux.getRazonSocial());
            dtoServicioContratado.setNombreServicio(servicioAux.getNombre());
            dtoServicioContratado.setPrecioBase(servicioAux.getPrecioBase());
            dtoServicioContratado.setSoportePrecio(servicioAux.getSoportePrecio());
            dtoServicioContratado.setActivo(servicioContratado.isActivo());
            //Lo añado a la lista de los dto
            dtoListaServiciosEmpresa.add(dtoServicioContratado);

        }

        return dtoListaServiciosEmpresa;

    }
    
}
