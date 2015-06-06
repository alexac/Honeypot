/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandra
 */

import java.net.*;
import java.io.*;
        
public class Client {
    
    static final int PORT = 7020;
    static String adresa = "localhost"; //for now
    
    public static void main(String[] args) throws Exception{
        //conexiune la server
        Socket cs = new Socket (adresa, PORT);
        
        DataInputStream dis = new DataInputStream(cs.getInputStream());
        DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
        
        while (true){
            dos.writeUTF("\n Vreau sa ma conectez");
        }
    }
    
}
