package cl.api.youtube.demo.services;

import cl.api.youtube.demo.models.Autos;
import cl.api.youtube.demo.repositories.IAutosRepository;
import cl.api.youtube.demo.request.AutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AutosService {
    private final IAutosRepository autosRepo;

    @Autowired
    public AutosService(IAutosRepository autosRepo) {
        this.autosRepo = autosRepo;
    }


    //Metodo para crear autos

    public void crearAuto(AutoRequest autoRequest) {
        Autos auto =  new Autos(autoRequest);

        autosRepo.save(auto);
    }

    //Metodo para listar todos los autos en nuestra base de datos
    public List<Autos> listarAutos() {
        return autosRepo.findAll();
    }

    //Metodo para buscar un auto por su id
   public Optional<Autos> buscarPorId(Long id) {
        return autosRepo.findById(id);
    }

    //Metodo para actualizar un auto
    public void actualizarAuto(Long idAuto,Autos auto) {
        final Autos currentAuto = autosRepo.findById(idAuto).get();
        currentAuto.update(auto);
        autosRepo.save(currentAuto);
    }

    //Mtodo para eliminar un auto
    public void eliminarAutoPorId(Long id) {
        autosRepo.deleteById(id);
    }



    //Metodo para buscar segun atributos propios de la clase
    public List<Autos>buscarPorMarca(String marca){
        return autosRepo.findByMarca(marca);
    }


    public List<Autos> buscarPorModelo(String modelo){
        return autosRepo.findByModelo(modelo);
    }

    public List<Autos> buscarPorColor(String color){
        return autosRepo.findByColor(color);
    }

    public List<Autos> buscarPorAnio(Long anio){
        return autosRepo.findByAnio(anio);
    }
}
