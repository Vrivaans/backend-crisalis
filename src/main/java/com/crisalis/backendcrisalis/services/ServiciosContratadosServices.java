package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ServiciosContratados> getServicioContratados() {
        List<ServiciosContratados> listaServiciosContratados = serviciosContratadosRepository.findAll(); 
        return listaServiciosContratados;
    }
    
}
