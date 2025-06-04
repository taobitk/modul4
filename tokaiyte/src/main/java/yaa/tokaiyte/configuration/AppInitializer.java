package yaa.tokaiyte.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Nếu có các cấu hình cho tầng service, repository riêng, bạn sẽ đặt ở đây.
        // Trong ví dụ này, AppConfiguration có thể chứa tất cả.
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Trả về mảng rỗng nếu AppConfiguration đã chứa @EnableWebMvc
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
