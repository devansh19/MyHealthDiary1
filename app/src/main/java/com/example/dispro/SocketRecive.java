package com.example.dispro;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketRecive implements Runnable{
    Socket socket;
    ServerSocket serverSocket;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;
    String message;
    Handler handler = new Handler();

    final private String ip="192.168.0.103";
    final private int port = 5000;
    @Override
    public void run(){

    }
}