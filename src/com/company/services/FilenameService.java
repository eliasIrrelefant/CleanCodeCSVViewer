package com.company.services;

public class FilenameService {
    private UIService uiService = new UIService();

    public String getFilename(String[] args) {
        if (args.length <= 0 || args[0].isEmpty()) {
            return uiService.getFilename();
        } else {
            return args[0];
        }
    }
}