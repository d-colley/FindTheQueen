package com.FindTheQueen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class FindTheQueenOtherClient {

public static void main(String args[]) throws IOException{


    InetAddress address=InetAddress.getLocalHost();
    Socket s1=null;
    String line=null;
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;

    try {
        s1=new Socket(address, 7621); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
        
        System.out.println("Client Address : "+address);
        System.out.println("Enter your username: ( Enter QUIT to end):");
        

    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception:");
    }

    //System.out.println("Client Address : "+address);
    //System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

    String response=null;
    try{
        line=br.readLine(); 
        
                os.println(line);
                os.flush();
                response=is.readLine();
                System.out.println("Server Response : "+response);
                //line=br.readLine();        

    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    
    //password flow
    try {
        //s1=new Socket(address, 7621); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
        
        System.out.println("Enter your pw: ( Enter QUIT to end):");
        
        

    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception:");
    }
    
    //read line
    try{
        line=br.readLine(); 
        
                os.println(line);
                os.flush();
                response=is.readLine();
                System.out.println("Server Response : "+response);
                //line=br.readLine();        

    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    
    
    //game starts
    try {
        //s1=new Socket(address, 7621); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
        
        System.out.println("Player2 Ready");
        System.out.println("Waiting on other player");
              

    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception:");
        
    }
    
    
    
    
    //check in with other player
    try {
        //s1=new Socket(address, 7621); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
        
        System.out.println("Tell the other player you're ready (type 'Player2Ready')");
              

    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception:");
        
    }
    
    //server response for ready
    response=null;
    try{
        line=(br.readLine()); 
        os.println(line);
        os.flush();
        response=is.readLine();
        	System.out.println("Server Response : "+response);
            line=br.readLine();
        
        

    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    
    //start game
    try {
        //s1=new Socket(address, 7621); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
        
        System.out.println("Waiting on Player2, Game Start? (type 'Start')");
              

    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception:");
        
    }
    
  //server response for start
    response=null;
    try{
        line=(br.readLine()); 
        os.println(line);
        os.flush();
        response=is.readLine();
        	System.out.println("Server Response : "+response);
            line=br.readLine();
        
        

    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    
    
    finally{

        is.close();os.close();br.close();s1.close();
                System.out.println("Connection Closed");

    }

}
}