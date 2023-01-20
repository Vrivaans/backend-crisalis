package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.Impuestos;
import com.crisalis.backendcrisalis.repository.ImpuestosRepository;

@Service
@Transactional
public class ImpuestosServices implements IImpuestosServices {

    @Autowired
    private ImpuestosRepository impuestosRepository;
    
    @Override
    public void saveImpuestos(Impuestos impuesto) {
        impuestosRepository.save(impuesto);
        
    }

    @Override
    public void deleteImpuestos(int id) {
        impuestosRepository.deleteById(id);
        
    }

    @Override
    public Impuestos findImpuestos(int id) {
        Impuestos impuesto = impuestosRepository.findById(id).orElse(null);
        return impuesto;
    }

    @Override
    public boolean existById(int id) {
       
        return impuestosRepository.existsById(id);
    }

    @Override
    public Optional<Impuestos> getId(int id) {
        
        return impuestosRepository.findById(id);
    }

    @Override
    public List<Impuestos> getImpuestoss() {
        List<Impuestos> listaImpuestos = impuestosRepository.findAll();
        return listaImpuestos;
        
    }
    
}
