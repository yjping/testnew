package wxapp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yuanjiaping
 * @create 2018-10-09 16:17
 * @description TODO
 **/
public class HttpClientUtil {
    // 设置body体
    public static void setBodyParamter(String sb, HttpURLConnection conn) throws IOException {
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.writeBytes(sb);
        out.flush();
        out.close();
    }

    // 添加签名header
    public static HttpURLConnection CreatePostHttpConnection(String uri) throws IOException {
        URL url= new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setInstanceFollowRedirects(true);
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept-Charset", "utf-8");
        conn.setRequestProperty("contentType", "utf-8");
        return conn;
    }

    public static byte[] readInputStream(InputStream inStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = inStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, len);
        }
        byte[] data = outputStream.toByteArray();
        outputStream.close();
        inStream.close();
        return data;
    }
}
