package biblioteca_api.service;

import biblioteca_api.exception.AutorNaoEncontradoException;
import biblioteca_api.model.Autor;
import biblioteca_api.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor buscarPorId(Long id) {
        Autor autorAchado = autorRepository.findById(id).orElse(null);

        if(autorAchado != null) {
            return autorAchado;
        }else {
            throw new AutorNaoEncontradoException("Autor com id " + id + " não encontrado");
        }
    }

    public Autor atualizar(Long id, Autor autor) {
        Autor autorExistente = autorRepository.findById(id).orElse(null);

        if (autorExistente != null) {
            autorExistente.setNome(autor.getNome());
            autorExistente.setNacionalidade(autor.getNacionalidade());
            autorExistente.setDataNascimento(autor.getDataNascimento());
            return autorRepository.save(autorExistente);
        }else
            return null;
    }

    public void deletar(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
        }else {
            throw new AutorNaoEncontradoException("Autor com id " + id + " não encontrado");
        }
    }
}