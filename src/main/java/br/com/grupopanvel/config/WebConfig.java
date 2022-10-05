package br.com.grupopanvel.config;

import br.com.grupopanvel.interceptors.LogGenerator;
import br.com.grupopanvel.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    LogService logService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogGenerator(logService)).addPathPatterns("/api/**");
    }
}