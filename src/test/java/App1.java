import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class App1 {

  public static void main(String[] args) {

    try (OutputStream output = new FileOutputStream("/Users/rojae/Documents/workbook/load-prop/src/main/resources/api.properties")) {

      Properties prop = new Properties();

      // set the properties value
      prop.setProperty("db.url", "localhost");
      prop.setProperty("db.user", "rojae");
      prop.setProperty("db.password", "password");

      // save properties to project root folder
      prop.store(output, "################\n db properties \n################");

      System.out.println(prop);

    } catch (IOException io) {
      io.printStackTrace();
    }

  }
}