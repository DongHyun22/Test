package com.donghyun.Fitness.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Component
public class KisUtil {

    @Value("${PROD_APPKEY}")
    private String prodAppkey;

    @Value("${PROD_APPSECRET}")
    private String prodAppSecret;

    @Value("${PROD}")
    private String prod;

    public String generateKisToken() throws IOException {
        String apiURL = prod+"/oauth2/tokenP";

        BufferedReader br;
        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            con.setRequestProperty("grant_type", "client_credentials");
            con.setRequestProperty("appkey", prodAppkey);
            con.setRequestProperty("appsecret", prodAppSecret);

            int responseCode = con.getResponseCode();
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                log.debug("에러 발생!");
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

        } catch (IOException e) {
            throw new IOException(e);
        }

        return br.readLine();
    }

}
