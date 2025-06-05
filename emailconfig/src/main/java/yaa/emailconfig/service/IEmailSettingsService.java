package yaa.emailconfig.service;

import yaa.emailconfig.model.EmailSettings;

public interface IEmailSettingsService {
    EmailSettings getSettings();
    void saveSettings(EmailSettings settings);
}