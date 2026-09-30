package biblioteca_api.exception;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}