package es.iesclaradelrey.da2d1e2425.shopalejandrosamuel.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCategoryDTO {
    private Long categoryType;
    private String name;
    private String background;
}
