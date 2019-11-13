package cn.com.cube.platform.barber.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by liang_zhang on 2017/12/18.
 */
@Component
public class JSONHelper {


    private static String apiKey;


    private static final Logger log = LoggerFactory.getLogger(JSONHelper.class);

    public static String loadJson(String urlStr) throws IOException {
        StringBuilder sb = new StringBuilder("{");
        URL url = new URL(urlStr);
        HttpURLConnection httpURLConnection;
        httpURLConnection = (HttpURLConnection) url.openConnection(); // 获取连接
        httpURLConnection.setRequestMethod("GET"); // 设置请求方法为POST, 也可以为GET
        httpURLConnection.setDoOutput(true);

        // 接收返回结果
        InputStream is = httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf8"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(is, "gb2312"));
        while (br.read() != -1) {
            sb.append(br.readLine());
        }
        return new String(sb);
    }


    public static String loadJsonUTF(String urlStr) throws IOException {
        StringBuilder sb = new StringBuilder("");
        URL url = new URL(urlStr);
        HttpURLConnection httpURLConnection;
        httpURLConnection = (HttpURLConnection) url.openConnection(); // 获取连接
        httpURLConnection.setRequestMethod("GET"); // 设置请求方法为POST, 也可以为GET
        httpURLConnection.setDoOutput(true);
        // 接收返回结果
        InputStream is = httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf8"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(is, "gb2312"));
        while (br.read() != -1) {
            sb.append(br.readLine());
        }
        return new String(sb);
    }


    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
           conn = (HttpURLConnection) realUrl.openConnection();

            // 打开和URL之间的连接
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");    // POST方法


            // 设置通用的请求属性

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/form-data");

            conn.connect();

            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送GET请求
     * @param path 请求路径
     * @param params 请求参数
     * @return 请求是否成功
     */
    public static String sendGETRequest(String path, Map<String, String> params) throws Exception{
        StringBuilder url = new StringBuilder(path);
        url.append("?");
        for(Map.Entry<String, String> entry : params.entrySet()){
            url.append(entry.getKey()).append("=");
            url.append(URLEncoder.encode(entry.getValue(),"utf-8"));
            url.append("&");
        }
        url.deleteCharAt(url.length() - 1);
        HttpURLConnection conn = (HttpURLConnection)new URL(url.toString()).openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        StringBuilder sb = new StringBuilder("{");
        if(conn.getResponseCode() == 200){
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf8"));
            while (br.read() != -1) {
                sb.append(br.readLine());
            }
            return new String(sb);
        }
        return null;
    }



    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam){
        //post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    log.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
        }
        return jsonResult;
    }


    public static String HttpGet(String url) {
        PrintWriter out = null;
        String result = "";
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuffer strBuffer = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(300000);
            conn.setRequestProperty("Content-Type", "application/json");
            is = conn.getInputStream();
            br = new BufferedReader( new InputStreamReader(is));
            String line = null;
            while ((line=br.readLine())!= null) {
                strBuffer.append(line);
            }
            result = strBuffer.toString();
        } catch (Exception e) {
            System.out.println( "发送 GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (br != null) {
                    br.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}

