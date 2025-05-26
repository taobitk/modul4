package yaa.buoi2bth5.configuration; // ĐÃ THAY ĐỔI

import yaa.buoi2bth5.service.ICustomerService; // ĐÃ THAY ĐỔI
import yaa.buoi2bth5.service.SimpleCustomerServiceImpl; // ĐÃ THAY ĐỔI
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "yaa.buoi2bth5") // ĐÃ THAY ĐỔI (quét cả controller, service nếu có @Service)
public class AppConfiguration implements WebMvcConfigurer { // Bỏ ApplicationContextAware nếu không dùng

    // Cấu hình ViewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/templates/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // Khai báo bean cho CustomerService
    @Bean
    public ICustomerService customerService() {
        return new SimpleCustomerServiceImpl();
    }
}