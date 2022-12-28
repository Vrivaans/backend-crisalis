package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.Servicios;
import com.crisalis.backendcrisalis.repository.ServiciosRepository;

@Service
@Transactional
public class ServiciosServices implements IServiciosServices {

    @Autowired
    ServiciosRepository serviciosRepository;

    @Override
    public void saveServicio(Servicios servicio) {
        serviciosRepository.save(servicio);
    }

    @Override
    public void deleteServicio(int id) {
        serviciosRepository.deleteById(id);        
    }

    @Override
    public Servicios findServicio(int id) {
        Servicios servicio = serviciosRepository.findById(id).orElse(null);
        return servicio;
    }

    @Override
    public boolean existById(int id) {
        return serviciosRepository.existsById(id);
    }

    @Override
    public Optional<Servicios> getId(int id) {
        return serviciosRepository.findById(id);
    }

    @Override
    public List<Servicios> getServicios() {
        List<Servicios> listaServicios = serviciosRepository.findAll();
        return listaServicios;
    }
    
}
