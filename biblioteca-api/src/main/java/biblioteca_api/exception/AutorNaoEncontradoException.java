package biblioteca_api.exception;

public class AutorNaoEncontradoException extends RuntimeException {
    public AutorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
