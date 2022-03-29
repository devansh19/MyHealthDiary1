package com.example.dispro;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Communicate {
    public String communicate(String txt){
        String rec="<error>";
        SocketSend socketSend=new SocketSend();
        try {
            rec=socketSend.execute(txt).get(5, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return rec;
    }
    public String communicate(JSONObject jsonObject){
        String rec="<error>";
        String jsonTxt= jsonObject.toString();
        SocketSend socketSend=new SocketSend();
        try {
            rec=socketSend.execute(jsonTxt).get(5, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return rec;
    }
}

class SocketSend extends AsyncTask<String, Void, String> {
    Socket socket;
    DataOutputStream dataOutputStream;
    PrintWriter printWriter;

    String buffer = "";
    int inp=-2;

    final private String ip="192.168.0.31";
    final private int port = 5000;

    @Override
    protected String doInBackground(String... voids) {
        String message = voids[0];
        try{
            socket=new Socket(ip,port);
            printWriter=new PrintWriter(socket.getOutputStream());
            printWriter.write(message);
            printWriter.flush();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            inp=-2;
            inp=input.read();
            buffer="";
            while(inp!=-1){
                buffer+=(char)inp;
                inp=input.read();
            }
            printWriter.close();

            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}