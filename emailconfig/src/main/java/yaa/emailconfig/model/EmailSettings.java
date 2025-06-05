package yaa.emailconfig.model;

import java.util.Arrays;
import java.util.List;

public class EmailSettings {

    private String language;
    private int pageSize;
    private boolean enableSpamsFilter;
    private String signature;

    private static final List<String> LANGUAGES_SUPPORTED = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
    private static final List<Integer> PAGE_SIZES_SUPPORTED = Arrays.asList(5, 10, 15, 25, 50, 100);

    public EmailSettings() {
        this.language = "English";
        this.pageSize = 25;
        this.enableSpamsFilter = false;
        this.signature = "";
    }

    public EmailSettings(String language, int pageSize, boolean enableSpamsFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.enableSpamsFilter = enableSpamsFilter;
        this.signature = signature;
    }

    // Getters
    public String getLanguage() {
        return language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public boolean isEnableSpamsFilter() { // Getter cho boolean thường là "isPropertyName"
        return enableSpamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    // Setters
    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setEnableSpamsFilter(boolean enableSpamsFilter) {
        this.enableSpamsFilter = enableSpamsFilter;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<String> getLanguagesSupported() {
        return LANGUAGES_SUPPORTED;
    }

    public List<Integer> getPageSizesSupported() {
        return PAGE_SIZES_SUPPORTED;
    }
}