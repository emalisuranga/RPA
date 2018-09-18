/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facility;

import java.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author eisuranga
 */
public class RestController {
String basicAuthorizationEncoded = null;
        public String executeOrientDBFunction(String requestJson) {

        
            String url = "http://172.26.227.36:2480/function/demodb/testFunction";
        
        //try {
            basicAuthorizationEncoded = Base64.getEncoder().encodeToString(("admin:admin").getBytes());
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(HttpCall.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        JSONObject obj2 = new JSONObject();
        obj2.put("name", "Udapadi");
        obj2.put("age", "322");
        
            
            
        HttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpPost request = new HttpPost(url);

            request.addHeader("content-type", "application/json; charset=utf-8");
            request.addHeader("authorization", "Basic " + basicAuthorizationEncoded);

            StringEntity requestBody = new StringEntity(obj2.toString());
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
        
//        public void restCall(){
//            
//        String response = executeOrientDBFunction(obj.toString());
//        JSONObject responseObj = new JSONObject(response);
//            System.out.println("responseObj");
//        
//        }
        
//        public static void main(String[] args){
//        RestController rest = new RestController();
//        String response = rest.executeOrientDBFunction();
//        JSONObject responseObj = new JSONObject(response);
//            System.out.println(responseObj);
//        }
}
