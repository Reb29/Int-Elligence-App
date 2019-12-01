package com.example.parkinghelper.utils;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



    public class DatabaseDownloader extends AsyncTask<Void, Void, String> {
        public AsyncResponse response = null;

        private static final String SERVER = "http://3.14.150.52:7567/";
        static final String REQUEST_METHOD = "GET";
        static final int READ_TIMEOUT = 5000;
        static final int CONNECTION_TIMEOUT = 5000;

        @Override
        protected String doInBackground(Void... params){
            String result;
            String line;

            try {
                URL myUrl = new URL(SERVER);
                HttpURLConnection connection =(HttpURLConnection) myUrl.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();

                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();

                while((line = reader.readLine()) != null){
                    stringBuilder.append(line);
                }

                reader.close();
                streamReader.close();
                result = stringBuilder.toString();

            } catch(IOException e) {
                e.printStackTrace();
                result = "ERROR";
            }
            Log.d("Could not connect to server.", result);
            return result;
        }

        protected void onPostExecute(String result){
            response.onEnd(result);
        }
    }