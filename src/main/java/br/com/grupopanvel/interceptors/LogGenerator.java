package br.com.grupopanvel.interceptors;

import br.com.grupopanvel.entity.LogEntity;
import br.com.grupopanvel.service.LogService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Log
@Component
@AllArgsConstructor
public class LogGenerator implements HandlerInterceptor {

    LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("DENTRO DA preHandle");
        Acesso acesso = new Acesso();
        acesso.usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        acesso.modulo = request.getRequestURI() + " [" + request.getMethod() + "]";

        request.setAttribute("acesso", acesso);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("DENTRO DA afterCompletion");
        Acesso acesso = (Acesso) request.getAttribute("acesso");
        acesso.data = LocalDateTime.now();

        addLog(acesso);
    }

    private void addLog(Acesso acesso) {

        logService.upsert(LogEntity.builder()
                .usuario(acesso.getUsuario())
                .modulo(acesso.getModulo())
                .data(acesso.getData())
                .build());
    }

    @Getter
    public static class Acesso {
        private String usuario;
        private String modulo;
        private LocalDateTime data;
    }
}
