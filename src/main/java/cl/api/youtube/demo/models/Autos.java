package cl.api.youtube.demo.models;


import cl.api.youtube.demo.request.AutoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Autos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")
    private Long idAuto;
    private String marca;
    private String modelo;
    private String color;
    private Long anio;

    public Autos(AutoRequest autoRequest){
        this.color = autoRequest.getColor();
        this.modelo = autoRequest.getModelo();
        this.marca = autoRequest.getMarca();
        this.anio = autoRequest.getAnio();
    }

public void update(Autos auto){
    this.anio = auto.getAnio();
    this.modelo = auto.getModelo();
    this.marca = auto.getMarca();
    this.color = auto.getColor();
}
}
