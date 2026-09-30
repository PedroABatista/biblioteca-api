package biblioteca_api.controller;

import biblioteca_api.model.Autor;
import biblioteca_api.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }
    @GetMapping
    public List<Autor> listar() {
        return autorService.listar();
    }

    @PostMapping
    public Autor criar(@Valid @RequestBody Autor autor) {
        return autorService.salvar(autor);
    }

    @GetMapping("/{id}")
    public Autor buscar(@PathVariable Long id) {
        return autorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id,@Valid @RequestBody Autor autor) {
        return autorService.atualizar(id, autor);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        autorService.deletar(id);
    }

}
