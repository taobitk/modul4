package yaa.uploadfile.configuration; // Đã thay đổi package

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Trả về lớp cấu hình chính của ứng dụng (chứa service, repository beans)
        // Trong trường hợp này, AppConfiguration chứa cả cấu hình web và có thể cả service (nếu có)
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Trả về mảng rỗng nếu tất cả cấu hình web đã nằm trong getRootConfigClasses
        // Hoặc bạn có thể trả về AppConfiguration.class ở đây và null ở getRootConfigClasses
        // nếu AppConfiguration chỉ chứa cấu hình cho DispatcherServlet.
        // Cách phổ biến là để AppConfiguration ở root và trả về mảng rỗng ở đây.
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        // Ánh xạ DispatcherServlet với URL pattern "/" (xử lý tất cả request)
        return new String[]{"/"};
    }
}
