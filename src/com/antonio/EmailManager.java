package com.antonio;

import com.antonio.controller.services.FetchFoldersService;
import com.antonio.controller.services.FolderUpdaterService;
import com.antonio.model.EmailAccount;
import com.antonio.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

import javax.mail.Folder;
import java.util.ArrayList;
import java.util.List;

public class EmailManager {
    private FolderUpdaterService folderUpdaterService;
    // Folders handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    private List<Folder> folderList = new ArrayList<Folder>();

    public List<Folder> getFolderList() {
        return this.folderList;
    }

    public EmailManager(){
        folderUpdaterService = new FolderUpdaterService(folderList);
        folderUpdaterService.start();
    }

    public void addEmailAccount(EmailAccount emailAccount) {
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem, folderList);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
