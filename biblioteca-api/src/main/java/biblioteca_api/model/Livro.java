package biblioteca_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livros")
@Getter
@Setter
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 50)
    private String titulo;

    @NotBlank
    @Size(min = 10, max = 20)
    private String isbn;

    @NotNull
    @Min(1400)
    private Integer anoPublicacao;

    private Boolean disponivel = true;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @NotNull
    private Autor autor;
}
