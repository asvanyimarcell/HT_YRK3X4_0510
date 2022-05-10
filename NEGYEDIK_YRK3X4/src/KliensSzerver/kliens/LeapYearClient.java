package KliensSzerver.kliens;

import java.net.*;
import java.io.*;

public class LeapYearClient {
    public static void main(String[] args) {
        Socket socket = null;
        String lineToBeSent;
        BufferedReader input;
        PrintWriter output;
        try {
            socket = new Socket("localhost",1234);
        }
        catch (UnknownHostException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            output = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("If you want to quit, please write END");
            while(true) {
                System.out.println("Please write the year that you want to examine:");
                lineToBeSent = input.readLine();
                if(lineToBeSent.equals("END")) {
                    break;
                } else {
                    if (Integer.parseInt(lineToBeSent) % 1 == 0) {
                        output.println(lineToBeSent);
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong format! Please rerun the application and write your input in YYYY format. E.g: 1984");
        }
        try {
            socket.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}







