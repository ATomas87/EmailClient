package com.antonio;

import com.antonio.controller.services.FetchFoldersService;
import com.antonio.model.EmailAccount;
import com.antonio.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

public class EmailManager {
    // Folders handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount) {
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
