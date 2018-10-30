import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author yuanjiaping
 * @create 2018-10-19 15:37
 * @description TODO
 **/
public class ReadInfo {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("src/db.properties");
            Properties props = new Properties();
            props.load(is);

            String dbname = props.getProperty("databasename");
            String password = props.getProperty("password");
            System.out.println(dbname + "," + password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
