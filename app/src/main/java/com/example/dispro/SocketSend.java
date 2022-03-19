package com.example.dispro;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketSend extends AsyncTask<String,Void,Void> {
    Socket socket;
    DataOutputStream dataOutputStream;
    PrintWriter printWriter;

    String buffer = "";
    int inp=-2;

    final private String ip="192.168.0.103";
    final private int port = 5000;

    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];
        try{
            socket=new Socket(ip,port);
            printWriter=new PrintWriter(socket.getOutputStream());
            printWriter.write(message);
            printWriter.flush();

            Log.d("send1122", "Inside thread :1");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Log.d("send1122", "Inside thread : 2");
            Log.d("send1122", "Inside thread : 2buf == "+ (char)input.read()+(char)input.read());
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Log.d("send1122", "Inside thread : 3");
//            Log.d("send1122", "Inside thread : buffer == "+input.readLine());
//            Log.d("send1122", "Inside thread : buffer == "+input.read()+" "+input.read());
            inp=-2;
            inp=input.read();
            Log.d("send1122", "Inside thread : base val == "+inp);
            buffer="";
            while(inp!=-1){
                Log.d("send1122", "Inside thread : running == "+inp);
                buffer+=(char)inp;
                inp=input.read();
            }
            Log.d("send1122", "Inside thread : final string == "+buffer);
            printWriter.close();

            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}