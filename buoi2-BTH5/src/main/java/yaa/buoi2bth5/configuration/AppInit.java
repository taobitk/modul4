package yaa.buoi2bth5.configuration; // ĐÃ THAY ĐỔI

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Nếu AppConfiguration đã @EnableWebMvc và @ComponentScan controllers,
        // và nó được trả về ở getRootConfigClasses, thì ở đây có thể để trống.
        // Hoặc trả về AppConfiguration.class nếu bạn muốn nó là ServletConfig.
        // Để đơn giản và theo hướng dẫn thường thấy, nếu AppConfiguration là config chính,
        // có thể trả về nó ở cả hai hoặc chỉ ở root.
        return new Class[]{}; // Hoặc return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}