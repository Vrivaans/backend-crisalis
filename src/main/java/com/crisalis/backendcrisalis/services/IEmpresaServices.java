package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.Empresa;

public interface IEmpresaServices {

    public void saveEmpresa(Empresa empresa);

    public void deleteEmpresa(int id);

    public Empresa findEmpresa(int id);

    public boolean existById(int id);

    public Optional<Empresa>getId(int id);

    public List<Empresa>getEmpresas();
}
