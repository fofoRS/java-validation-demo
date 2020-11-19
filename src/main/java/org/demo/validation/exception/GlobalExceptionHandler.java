package org.demo.validation.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>>handleException(
            HttpServletRequest request, MethodArgumentNotValidException e) {

        var fieldErrors = e.getFieldErrors();

        List<Map<String,String>> fieldErrorsMap = fieldErrors.stream()
                .map(fieldError -> {
                    var fieldErrorObject = new Object() {
                        final String fieldName = fieldError.getField();
                        final String errorMessage = fieldError.getDefaultMessage();
                    };
                    return Map.ofEntries(
                            Map.entry("field", fieldErrorObject.fieldName),
                            Map.entry("message", fieldErrorObject.errorMessage != null
                                    ? fieldErrorObject.errorMessage
                                    : ""));})
                .collect(Collectors.toList());

        Map<String,Object> errorResponsePayload =
                Map.of("path",request.getServletPath(), "errors",fieldErrorsMap);

        return ResponseEntity.badRequest().body(errorResponsePayload);
    }
}
