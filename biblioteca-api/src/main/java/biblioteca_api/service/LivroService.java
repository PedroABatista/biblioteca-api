package biblioteca_api.service;
import biblioteca_api.exception.AutorNaoEncontradoException;
import biblioteca_api.exception.LivroNaoEncontradoException;
import biblioteca_api.model.Autor;
import biblioteca_api.model.Livro;
import biblioteca_api.repository.AutorRepository;
import biblioteca_api.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public Livro salvar(Livro livro) {
        Long autorId = livro.getAutor().getAutorId();
        Autor autorExistente = autorRepository.findById(autorId).orElse(null);

        if (autorExistente == null) {
            throw new AutorNaoEncontradoException("Autor com id " + autorId + " não encontrado");
        }
        livro.setAutor(autorExistente);
        return livroRepository.save(livro);
    }

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public Livro buscar(Long id) {
        Livro livroExistente = livroRepository.findById(id).orElse(null);

        if (livroExistente == null) {
            throw new LivroNaoEncontradoException("Livro com id " + id + " não encontrado");
        }
        return livroExistente;
    }

    public Livro atualizar(Long id, Livro livro) {
        Livro livroExistente = livroRepository.findById(id).orElse(null);
        if (livroExistente != null) {
            livroExistente.setTitulo(livro.getTitulo());
            livroExistente.setIsbn(livro.getIsbn());
            livroExistente.setAnoPublicacao(livro.getAnoPublicacao());
            livroExistente.setDisponivel(livro.getDisponivel());
            livroExistente.setAutor(livro.getAutor());
        } else {
            throw new LivroNaoEncontradoException("Livro com id " + id + " não encontrado");
        }
        return livroRepository.save(livroExistente);
    }

    public void deletar(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
        } else {
            throw new LivroNaoEncontradoException("Livro com id " + id + " não encontrado");
        }
    }
}