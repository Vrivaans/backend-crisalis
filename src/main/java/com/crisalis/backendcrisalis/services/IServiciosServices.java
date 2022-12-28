package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.Servicios;

public interface IServiciosServices {
    
    public void saveServicio(Servicios servicio);

    public void deleteServicio(int id);

    public Servicios findServicio(int id);

    public boolean existById(int id);

    public Optional<Servicios>getId(int id);

    public List<Servicios>getServicios();

}
