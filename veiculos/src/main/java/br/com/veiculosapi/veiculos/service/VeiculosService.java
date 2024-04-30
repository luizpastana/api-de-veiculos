package br.com.veiculosapi.veiculos.service;

import br.com.veiculosapi.veiculos.DAO.IVeiculos;
import br.com.veiculosapi.veiculos.model.VeiculosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {
    @Autowired
    private IVeiculos dao;

    public VeiculosService(IVeiculos dao) {
        this.dao = dao;
    }

    public List<VeiculosModel> listarVeiculos() {
        return (List<VeiculosModel>) dao.findAll();
    }

    public VeiculosModel criarVeiculos(VeiculosModel veiculo) {
        return dao.save(veiculo);
    }

    public VeiculosModel editarVeiculos(VeiculosModel veiculo) {
        return dao.save(veiculo);
    }

    public Integer excluirVeiculos(Integer id) {
        dao.deleteById(id);
        return 1;
    }
}
