package es.etg.daw.dawes.java.web.Concessionary.ADDcar.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Coche {

private int id;
private String marca;
private String modelo;
private String foto;
private double precio;
private LocalDateTime createdAt;
}
