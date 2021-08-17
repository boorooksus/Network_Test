package com.example.networktestclient;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {



    Button buttonSend;
    EditText editTextNumber;

    class RunningAppsThread extends Thread {


        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {

            Editable text = editTextNumber.getText();

            if(!text.toString().isEmpty()){

                // 서버와 소켓 통신
                try {
                    // ip address 정보 객체 생성
                    IpAddress ipAddress = new IpAddress();

                    Socket socket = new Socket(ipAddress.getIpAddress(), 5000);

                    int number = Integer.parseInt(text.toString());
                    System.out.println(("Input: " + number));
                    System.out.println(("Size: " + Integer.BYTES));

                    DataOutputStream dos
                            = new DataOutputStream(socket.getOutputStream());

                    // 데이터 전송
                    dos.writeInt(number);
                    //dos.writeInt(number);

                    socket.close();
                } catch (Exception e) {
                    System.out.println("================ Error =====================");
                    e.printStackTrace();
                }

            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSend = findViewById(R.id.buttonSend);
        editTextNumber = findViewById(R.id.editTextNumber);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RunningAppsThread thread = new RunningAppsThread();
                thread.start();

            }
        });
    }
}