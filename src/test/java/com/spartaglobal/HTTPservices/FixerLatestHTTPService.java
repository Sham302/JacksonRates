package com.spartaglobal.HTTPservices;

import com.spartaglobal.config.APIKey;
import com.spartaglobal.config.FixerURLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class FixerLatestHTTPService {
    private CloseableHttpResponse fixerResponse;
    private String fixerLatestRatesJSONString;

    public void executeLatestRatesGetRequest(){
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        String latestServiceURL = FixerURLConfig.BASEURL +FixerURLConfig.LATESTRATEENDPOINT + "?" + APIKey.APIKEY; //string concatenation

        HttpGet httpGet = new HttpGet(latestServiceURL); //get message

        try {
            fixerResponse = closeableHttpClient.execute(httpGet); //executing get message based on top fixer response. http needs verb response
            fixerLatestRatesJSONString = EntityUtils.toString(fixerResponse.getEntity()); //getentity means give me the body and return message
        } catch (IOException e) { //print out anything thats wrong
            e.printStackTrace();
        }
    }

    public String getFixerLatestRatesJSONString() {
        return fixerLatestRatesJSONString;  //getters for member variables, have to call the getexecute method
    }

    public CloseableHttpResponse getFixerResponse() {
        return fixerResponse;
    }
}
