/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facility;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author eisuranga
 */
public class HttpCall {

    protected void postHttp() throws Exception {


//        URL url = new URL("http://172.26.227.36:2480/function/demodb/testFunction");
//        String encoding = Base64.getEncoder().encodeToString(("admin:admin").getBytes("UTF‌​-8"));
//
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true);
//        connection.setRequestProperty("Authorization", "Basic " + encoding);
//        
//        StringEntity requestBody = new StringEntity(obj2.toString());
//                                                request.setEntity(requestBody);
//
//        InputStream content = (InputStream) connection.getInputStream();
//        BufferedReader in = new BufferedReader(new InputStreamReader(content));
//        String line;
//        
//        while ((line = in.readLine()) != null) {
//            System.out.println(line);
//        }
//        System.out.println(obj2.toString());
//
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        UsernamePasswordCredentials usernamePasswordCredentials = new UsernamePasswordCredentials(
//                "admin", "password");
//
//        credsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);
//
//        CloseableHttpClient client = HttpClientBuilder.create()
//                .setDefaultCredentialsProvider(credsProvider)
//                .build();
//
//        HttpPost request = new HttpPost();
//        StringEntity params = new StringEntity(obj2.toString());
//        request.addHeader("content-type", "application/json");
//        request.setEntity(params);
//        client.execute(request);
//
//        CloseableHttpResponse response = client.execute(request);
//
//        System.out.println("Response: " + response);
    }

    public String executeOrientDBFunction(String endpointURL, String basicAuthorizationEncoded, String requestPayloadJson) {

        
        HttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpPost request = new HttpPost(endpointURL);

            request.addHeader("content-type", "application/json; charset=utf-8");
            request.addHeader("authorization", "Basic " + basicAuthorizationEncoded);

            StringEntity requestBody = new StringEntity(requestPayloadJson);
            request.setEntity(requestBody);

            HttpResponse response = httpClient.execute(request);

            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();

            String body = EntityUtils.toString(entity, "utf-8");

            if (status == 200) {
//                                                                LOGGER.info("Executed DB Function: " + endpointURL);
                return body;
            } else {
//                                                                LOGGER.error("An error occurred while requesting from database with HTTP api. DB Function: " + endpointURL + ". Status Code: " + status);
//                                                                LOGGER.error("Response: " + body);
                return null;
            }
        } catch (Exception e) {
//                                                LOGGER.error("An error occurred while requesting from database with HTTP api. DB Function: " + endpointURL + ". Message: " + e.getMessage(), e);
            return null;
        }
    }
    
    public static void main(String[] args){
        String url = "http://172.26.227.36:2480/function/demodb/testFunction";
        String basicAuthorizationEncoded = null;
        //try {
            basicAuthorizationEncoded = Base64.getEncoder().encodeToString(("admin:admin").getBytes());
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(HttpCall.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        JSONObject obj2 = new JSONObject();
        obj2.put("name", "Raptor123");
        obj2.put("age", "24");
        
        HttpCall httpCall = new HttpCall();
        String response = httpCall.executeOrientDBFunction(url, basicAuthorizationEncoded, obj2.toString());
        
        try {
            new JSONParser().parse(response);
        } catch (ParseException ex) {
            Logger.getLogger(HttpCall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}