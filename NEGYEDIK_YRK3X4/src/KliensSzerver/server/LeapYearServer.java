package KliensSzerver.server;

import java.net.*;
import java.io.*;

public class LeapYearServer {
    public static void main(String args[]) {
        ServerSocket server_socket;
        BufferedReader input;
        try {
            server_socket = new ServerSocket(1234);
            while (true) {
                Socket socket = server_socket.accept();
                System.out.println("The server is waiting for the client's input:");
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                try {
                    while (true) {
                        String input_number = input.readLine();
                        if (input_number.equals("END")) {
                            break;
                        } else {
                            System.out.println("The year you wrote:" + input_number);
                            if (Integer.parseInt(input_number) % 4 == 0) {
                                if (!(Integer.parseInt(input_number) % 100 == 0)) {
                                    System.out.println("It's a leap year!");
                                } else {
                                    if (Integer.parseInt(input_number) % 400 == 0) {
                                        System.out.println("It's a leap year!");
                                    } else {
                                        System.out.println("It's NOT a leap year!");
                                    }
                                }
                            } else {
                                System.out.println("It's NOT a leap year!");
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } catch (NullPointerException e) {
                    System.out.println("Client (" + server_socket.getInetAddress() + ") disconnected");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}







