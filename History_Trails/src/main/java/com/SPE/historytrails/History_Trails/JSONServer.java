package com.SPE.historytrails.History_Trails;

import java.io.*;
import java.util.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.springframework.web.bind.annotation.*;

@RestController

public class JSONServer
{
    @RequestMapping("/Gallery3Test")

    public String Gallery3() {
        JSONObject doc = requestJSON("https://opendata.bristol.gov.uk/api/records/1.0/search/?dataset=open-data-gallery-3-european-old-masters&q=&rows=115&sort=-order_of_appearance&facet=medium&facet=object_type","","");
        String response = "";
        // If the project exists, get it's name from the JSON doc
        if(doc != null) {
            Iterable<JSONObject> objects = (Iterable<JSONObject>) doc.get("records");
            //int i = 0;
            for(JSONObject obj : objects) {
//                System.out.printf("i = %d", i);
//                System.out.println();
                JSONObject field = (JSONObject) obj.get("fields");String imageLink = (String) field.get("link_to_additional_information");
                if (imageLink != null) {
                    //i++;
                    String body = "<HTML><body> <a href=" + imageLink + ">" + field.get("title_of_object") + "</a></body></HTML>" + "<br>\n" + " by " + field.get("artist");
                    response += body + "<br>\n\n\n\n</br>";
                }
            }
        }
        return response;
    }



    /*public static BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
          barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }*/



    private static JSONObject requestJSON(String urlString, String username, String key)
    {
        try {
            URL url = new URL(urlString);
            byte[] keyBytes = (username + ":" + key).getBytes("UTF-8");
            String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty ("Authorization", "Basic " + encodedKey);
            InputStream stream = (InputStream) connection.getInputStream();
            JSONParser parser = new JSONParser();
            return (JSONObject)parser.parse(new InputStreamReader(stream, "UTF-8"));
        }
        catch(UnsupportedEncodingException uee) { return null; }
        catch(IOException ioe) { return null; }
        catch(ParseException pe) { return null; }
    }
}