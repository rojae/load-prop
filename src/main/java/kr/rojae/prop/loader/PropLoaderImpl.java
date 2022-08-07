package kr.rojae.prop.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropLoaderImpl implements PropLoader{
    private final String directoryPath;
    private final boolean printConsole;

    public PropLoaderImpl(String directoryPath, boolean printConsole){
        if(directoryPath == null || directoryPath.equals("")){
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

        if(!folder.exists()){
            System.out.println("Sorry, Properties file is not exist");
        }
        else if(folder.isFile()){
            System.out.println("Sorry, Resources file is not directory");
        }
        else if(folder.isDirectory()){
            this.loader(folder);
        }
    }

    @Override
    public void loader(File folder) {
        File[] listOfFiles = folder.listFiles();

        // Zero index
        if(listOfFiles == null) return;

        // Props File Parsing and set Env
        for (File listOfFile : listOfFiles) {
            if (!listOfFile.isFile()) {
                this.loader(listOfFile);
            } else {
                // print log
                this.comment(listOfFile, printConsole);

                try (InputStream input = new FileInputStream(listOfFile.getAbsolutePath())) {
                    Properties prop = new Properties();

                    // load a properties file
                    prop.load(input);

                    // set environment (key, value)
                    this.setEnv(prop, printConsole);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
