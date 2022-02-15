package demo.web.common.handler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目: spring-boot
 * 时间: 2021/10/27 0:23
 * 全局异常捕获处理器
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Data
    static class Response {
        private final String error;
        private final String path;
        private final Timestamp timestamp;

        public Response(String error, String path) {
            this.error = error;
            this.path = path;
            this.timestamp = new Timestamp(System.currentTimeMillis());
        }

        static Response errorMessage(String error, String path) {
            return new Response(error, path);
        }
    }

    @ExceptionHandler({BindException.class})
    public Object bindException(HttpServletRequest request, BindException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String error = errors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(";"));
        return ResponseEntity.badRequest().body(Response.errorMessage(error, request.getRequestURI()));
    }

    @ExceptionHandler({Exception.class})
    public Object exception(HttpServletRequest request, Exception e) {
        log.error("异常信息:", e);
        return ResponseEntity.internalServerError().body(Response.errorMessage(e.getMessage(), request.getRequestURI()));
    }

}
