package pe.edu.upeu.cafeteria.service;

import pe.edu.upeu.cafeteria.dto.ModeloDataAutocomplet;
import pe.edu.upeu.cafeteria.model.Cliente;

import java.util.List;

public interface IClienteService extends ICrudGenericoService<Cliente,String>{
    List<ModeloDataAutocomplet> listAutoCompletCliente();
}
