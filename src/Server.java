/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandra
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    
    public static final int PORT = 7020; //for now, de schimbat in 80/81/82
    static int i;
    
    public static void main (String[] arg) throws IOException, InterruptedException{
        
        //conectarea
        ServerSocket ss = null; Socket cs = null;
        ss = new ServerSocket (Server.PORT);
        System.out.println("\n Serverul a pornit");
        
        while (true){
            cs = ss.accept();
            System.out.println("\n Client nou");
            new Conexiune(cs, ++i);
        }
    
    }
}



class Conexiune extends Thread{
    int id;
    Socket cs = null;
    DataInputStream dis; DataOutputStream dos;
    
    public Conexiune(Socket client, int i) throws IOException{
        cs = client;
        id = i;
        
        //imi stabilesc caile de comunicare pentru conexiunea existenta pe socket
        //streamul de citire de date
        dis = new DataInputStream(cs.getInputStream());
        //streamul de scriere de date
        dos = new DataOutputStream(cs.getOutputStream());
        
        
        InputStream input = new FileInputStream("C:\\Users\\Alexandra\\Documents\\NetBeansProjects\\Honeypot\\banner.txt");
        
        Reader reader = new InputStreamReader(input);
        
        int data = reader.read();
        
        while (data != -1){
            char theChar = (char) data;
            data = reader.read();
        }
        
        reader.close();
        
        //threadul porneste din constructor
        start();
    }
    
    public void run(){
        try{
            while (true){
                Thread.sleep(1000);
                System.out.println(dis.readUTF());
            }
        } catch (Exception e){
            //in caz de exceptie nu face nimic
        }
    }
}
