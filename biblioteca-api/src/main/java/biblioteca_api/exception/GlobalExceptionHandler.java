package biblioteca_api.exception;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AutorNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> tratarAutorNaoEncontrado(AutorNaoEncontradoException ex) {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", ex.getMessage());
        resposta.put("status", 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarValidacao(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(erro -> {
            erros.put(erro.getField(), erro.getDefaultMessage());
        });

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", "Erro de validação");
        resposta.put("status", 400);
        resposta.put("erros", erros);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> tratarLivroNaoEncontrado(LivroNaoEncontradoException ex) {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", ex.getMessage());
        resposta.put("status", 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }

}
