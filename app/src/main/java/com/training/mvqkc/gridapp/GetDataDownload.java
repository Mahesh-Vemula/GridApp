package com.training.mvqkc.gridapp;

import android.os.AsyncTask;
import android.os.Bundle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by Nandu on 1/26/2015.
 */
public class GetDataDownload extends AsyncTask <String,String,Bundle>{

    @Override
    protected void onPostExecute(Bundle bundle) {
        super.onPostExecute(bundle);
    }

    @Override
    protected Bundle doInBackground(String... params) {

        HttpClient htpClient= new DefaultHttpClient();
        HttpGet htpGet1=new HttpGet(params[0]);
      String jsonString1=getJsonString(htpClient,htpGet1);
      String jsonString2=getJsonString(htpClient,new HttpGet(params[1]));






        return null;
    }
    private String getJsonString(HttpClient htpClient,HttpGet htpGet){
        HttpResponse htpResponse;
        HttpEntity entity =null;
        String jsonString=null;
        try {
            htpResponse=htpClient.execute(htpGet);
            entity=htpResponse.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(entity!=null)
        {
            InputStream instream = null;
            try {
                instream = entity.getContent();
                jsonString=inputStreamToString(instream);
                instream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }}
        return jsonString;
    }
    private static String inputStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
