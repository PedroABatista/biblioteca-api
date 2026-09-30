package biblioteca_api.controller;

import biblioteca_api.model.Livro;
import biblioteca_api.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listar() {
        return livroService.listar();
    }

    @PostMapping
    public Livro criar(@Valid @RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return livroService.buscar(id);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        return livroService.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        livroService.deletar(id);
    }
}