package com.crisalis.backendcrisalis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.dto.DtoEmpresa;
import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.repository.EmpresaRepository;

@Service
@Transactional
public class EmpresaServices implements IEmpresaServices{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public void saveEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public void deleteEmpresa(int id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa findEmpresa(int id) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        return empresa;
    }

    @Override
    public boolean existById(int id) {  
        return empresaRepository.existsById(id);
    }

    @Override
    public Optional<Empresa> getId(int id) {
        
        return empresaRepository.findById(id);
    }

    @Override
    public List<DtoEmpresa> getEmpresas() {
        List<Empresa> listaEmpresas = empresaRepository.findAll();
        List<DtoEmpresa> listaEmpresasDto = new ArrayList<>();
        listaEmpresas.forEach(empresa -> listaEmpresasDto.add(new DtoEmpresa(empresa)));

        return listaEmpresasDto;
    }
    

}
