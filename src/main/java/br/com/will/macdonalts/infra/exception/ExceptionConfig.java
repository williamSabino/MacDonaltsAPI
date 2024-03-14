package br.com.will.macdonalts.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratar400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(TratarErros::new));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratar404(EntityNotFoundException ex){
        return ResponseEntity.badRequest().body(ex);
    }

    private record TratarErros(String erro, String descricao){
        public TratarErros(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
