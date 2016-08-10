package com.lftechnology.phpjava.ems.utlis;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * SqlRunner
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 11 2016
 */
public class SqlRunner {
    private static final String basePath = System.getProperty("user.dir") + "/src/main/java/com/lftechnology/phpjava/ems/autorun/";
    private List<String> files;
    private List<String> sql = new ArrayList<>();

    public List getSqlFileList() {
        File folder = new File(basePath);
        File[] listOfFiles = folder.listFiles();
        List<String> sqlFiles = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            String fileName = listOfFiles[i].getName();
            if (listOfFiles[i].isFile() && fileName.endsWith(".sql")) {
                sqlFiles.add(fileName);
            }
        }
        return sqlFiles;
    }

    public List<String> getSql() {
        this.files = this.getSqlFileList();
        List<String> executedFilesList = this.getExecutedFileList();
        for (String file : files) {
            if (!executedFilesList.contains(file)) {
                getFileContent(file);

            }
        }
        return this.sql;
    }

    private void getFileContent(String file) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(basePath + file))) {
                String line = br.readLine();
                while (line != null) {
                    this.sql.add(line);
                    line = br.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getExecutedFileList() {
        List<String> executedFiles = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(basePath + "executedFiles.txt"))) {
                String line = br.readLine();
                while (line != null) {
                    executedFiles.add(line);
                    line = br.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return executedFiles;
    }


    public void executeSql() {
        this.getSql();
        Connection connection = DbFactory.getConnection();
        try {
            if (!this.sql.isEmpty()) {
                for (String query : this.sql) {
                    if (!query.isEmpty()) {
                        PreparedStatement stmt = connection.prepareStatement(query.toString());
                        stmt.execute();
                    }
                }
                Path excludedFileList = Paths.get(basePath + "executedFiles.txt");
                try {
                    Files.write(excludedFileList, this.files, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbFactory.closeConnection();
        }

    }
}
