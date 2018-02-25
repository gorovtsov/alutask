package by.gorovtsov.alutask.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"by.gorovtsov.alutask.controller"})
@Import(value = {ServiceConfig.class, InternationalizationConfig.class, ThymeleafConfig.class})
public class WebConfig {

}
