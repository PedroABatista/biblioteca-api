package biblioteca_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "autores")
@Getter
@Setter
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;

    @NotBlank
    @Size(min = 2, max = 100)
    private String nome;

    @NotBlank
    @Size(min = 2, max = 50)
    private String nacionalidade;

    @NotNull
    private LocalDate dataNascimento;
}