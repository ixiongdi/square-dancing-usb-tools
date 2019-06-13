package com.github.ixiongdi.sdut;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.file.Files;

public class Controller {

    @FXML
    private TableView srcFileView;
    @FXML
    private TableColumn srcFileName;
    @FXML
    private TableColumn srcFileSize;

    @FXML
    private TableView dstFileView;
    @FXML
    private TableColumn dstFileName;
    @FXML
    private TableColumn dstFileSize;

    private File srcDir;

    private File dstDir;

    @FXML
    void selectSrc(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
//        directoryChooser.initialDirectoryProperty("");

        srcDir = directoryChooser.showDialog(App.window);



        ObservableList<MP4> list = FXCollections.observableArrayList();
        srcFileName.setCellValueFactory(new PropertyValueFactory("name"));
        srcFileSize.setCellValueFactory(new PropertyValueFactory("size"));

        dstFileName.setCellValueFactory(new PropertyValueFactory("dstName"));
        dstFileSize.setCellValueFactory(new PropertyValueFactory("size"));

        File[] files = srcDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        for (int i = 0; i < files.length; i++) {
//            System.out.println(file.getName());

            File file = files[i];

            list.add(new MP4(file.getName(), file.length(), String.format("%d.%s", i + 1, file.getName())));
        }


        srcFileView.setItems(list);

        dstFileView.setItems(list);
    }

    @FXML
    void selectDst(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();

        dstDir = directoryChooser.showDialog(App.window);

        for (File file : dstDir.listFiles()) {
            System.out.println(file.getName());

            file.delete();
        }



    }

    @FXML
    void copy(ActionEvent event) throws Exception {
        File[] files = srcDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        for (int i = 0; i < files.length; i++) {

            File src = files[i];

            File dst = new File(dstDir, String.format("%d.%s", i + 1, src.getName()));

            System.out.println("start copy: " + src.getName());

            Files.copy(src.toPath(), dst.toPath());
        }
    }

    @FXML
    void gen(ActionEvent event) throws Exception {
        String[] files = dstDir.list();

        File playList = new File(dstDir, "playlist.txt");

        FileOutputStream os = new FileOutputStream(playList);

        StringBuilder sb = new StringBuilder();

        for (String s: files) {
            os.write(s.getBytes());
            os.write('\n');
        }

        os.flush();

        os.close();

    }

}
