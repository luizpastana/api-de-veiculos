package br.com.veiculosapi.veiculos.DAO;

import br.com.veiculosapi.veiculos.model.VeiculosModel;
import org.springframework.data.repository.CrudRepository;


public interface IVeiculos extends CrudRepository<VeiculosModel, Integer> {
}
