package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.Impuestos;

public interface IImpuestosServices {
    
    public void saveImpuestos(Impuestos impuesto);

    public void deleteImpuestos(int id);

    public Impuestos findImpuestos(int id);

    // public Impuestos findByNombre(String nombreImpuesto);

    public boolean existById(int id);

    public Optional<Impuestos>getId(int id);

    public List<Impuestos>getImpuestoss();

}
