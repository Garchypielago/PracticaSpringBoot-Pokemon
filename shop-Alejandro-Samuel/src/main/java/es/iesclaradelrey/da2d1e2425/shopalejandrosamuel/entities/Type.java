package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="types")
public class Type{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String background;

    public Type(String name){
        this.name = name;
    }

}
