import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class App4 {

    public static void main(String[] args) {
        App4 app = new App4();
        app.printAll("application.properties");
    }

    private void printAll(String filename) {

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filename)) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }

            prop.load(input);

//            Java 8 , print key and values
//            prop.forEach((key, value) -> System.out.printf("%s=%s%n", key, value));

            Set<Object> objects = prop.keySet();

            // When < Java 8
            Enumeration e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.printf("%s=%s%n", key, value);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}