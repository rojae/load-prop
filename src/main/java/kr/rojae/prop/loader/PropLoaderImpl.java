package kr.rojae.prop.loader;

import kr.rojae.prop.enums.ExtensionType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PropLoaderImpl implements PropLoader {
    private final String directoryPath;
    private final boolean printConsole;

    public PropLoaderImpl(String directoryPath, boolean printConsole) {
        if (directoryPath == null || directoryPath.equals("")) {
            try {
                throw new Exception("Parameter `directoryPath` must not be null");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.init();
        this.directoryPath = directoryPath;
        this.printConsole = printConsole;
    }

    @Override
    public void run() {
        File folder = new File(directoryPath);

        if (!folder.exists()) {
            try {
                throw new Exception("Sorry, Resources file is not Exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (folder.isFile()) {
            try {
                throw new Exception("Sorry, Resources file is not directory");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (folder.isDirectory()) {
            this.loader(folder);
        }
    }

    @Override
    public void loader(File folder) {
        File[] listOfFiles = folder.listFiles();

        // Zero index
        if (listOfFiles == null) return;

        // Props File Parsing and set Env
        for (File listOfFile : listOfFiles) {
            if (!listOfFile.isFile()) {
                this.loader(listOfFile);
            } else {
                // print log
                this.comment(listOfFile, printConsole);

                try (InputStream input = new FileInputStream(listOfFile.getAbsolutePath())) {

                    if (ExtensionType.isProperties(listOfFile.getName()))
                        this.setEnvOfProperties(input, printConsole);     // .properties
                    else if (ExtensionType.isYml(listOfFile.getName()) || ExtensionType.isYaml(listOfFile.getName()))
                        this.setEnvOfYaml(input, printConsole);          // .yml, .yaml
                    else
                        throw new IOException(String.format("Sorry, %s File Extension can't store to System Property", listOfFile.getName()));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
