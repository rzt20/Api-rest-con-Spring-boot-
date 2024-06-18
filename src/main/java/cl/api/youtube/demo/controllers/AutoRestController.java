package cl.api.youtube.demo.controllers;

import cl.api.youtube.demo.models.Autos;
import cl.api.youtube.demo.request.AutoRequest;
import cl.api.youtube.demo.services.AutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/autos")
public class AutoRestController {
    private AutosService autosService;
    @Autowired
    public AutoRestController(AutosService autosService) {
        this.autosService = autosService;
    }

    @PostMapping(value="crear",headers = "Accept=application/json")
    public void crearAuto(@RequestBody AutoRequest autoRequest){
        autosService.crearAuto(autoRequest);
    }

    @GetMapping(value="listar",headers = "Accept=application/json")
    public List<Autos> listarAutos(){
        return autosService.listarAutos();
    }
    @GetMapping(value = "listarPorId/{id}" , headers = "Accept=application/json")
    public Optional<Autos> listarPorId(@PathVariable Long id){
        return autosService.buscarPorId(id);
    }
    @PutMapping(value = "/{idAuto}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarAuto(@PathVariable("idAuto") long idAuto,@RequestBody Autos autos){
        autosService.actualizarAuto(idAuto,autos);
    }
    @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
    public void eliminarAuto(@PathVariable Long id){
        autosService.eliminarAutoPorId(id);
    }
    @GetMapping(value = "listarMarca/{marca}",headers = "Accept=application/json")
    public List<Autos> listarPorMarca(@PathVariable String marca){
        return autosService.buscarPorMarca(marca);
    }
    @GetMapping(value = "listarPorModelo/{modelo}",headers = "Accept=application/json")
    public List<Autos> listarPorModelo(@PathVariable String modelo){
        return autosService.buscarPorModelo(modelo);
    }
    @GetMapping(value = "listarPorColor{color}", headers = "Accept=application/json")
    public List<Autos> listarPorColor(@PathVariable String color){
        return autosService.buscarPorColor(color);
    }

    @GetMapping(value = "listarPorAnio{anio}", headers = "Accept=application/json")
    public List<Autos> listarPorAnio(@PathVariable Long anio){
        return autosService.buscarPorAnio(anio);
    }


}
