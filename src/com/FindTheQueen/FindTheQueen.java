package com.FindTheQueen;
import java.util.Scanner;




//echo server
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;


public class FindTheQueen {
public static void main(String args[]){


 Socket s=null;
 ServerSocket ss2=null;
 ClientCounter playerOneReadyCount = new ClientCounter();
 ClientCounter playerTwoReadyCount = new ClientCounter();
 System.out.println("Server Listening......");
 
 
 
 try{
     ss2 = new ServerSocket(7621); // can also use static final PORT_NUM , when defined

 }
 catch(IOException e){
 e.printStackTrace();
 System.out.println("Server error");

 }

 while(true){
     try{
    	 
         s= ss2.accept();
         //readyCount.IncrementCount(1);
         //System.out.println("connection Established");
         //System.out.println("Clients contacted ");
         ServerThread st=new ServerThread(s);
         st.start();

     }

 catch(Exception e){
     e.printStackTrace();
     System.out.println("Connection Error");

 }
 }

}

}

class ServerThread extends Thread{  

 String line=null;
 BufferedReader  is = null;
 PrintWriter os=null;
 Socket s=null;
 ClientCounter playerOneReadyCount = null;
 ClientCounter playerTwoReadyCount = null;
 
 public ServerThread(Socket s){
     this.s=s;
 }

 public void run() {
 try{
     is= new BufferedReader(new InputStreamReader(s.getInputStream()));
     os=new PrintWriter(s.getOutputStream());

 }catch(IOException e){
     System.out.println("IO error in server thread");
 }

// try {
//     line=is.readLine();
//     
//     while(line.compareTo("QUIT")!=0){
//    	 if ( line.compareTo("dannyboi")==0)
//    	 {
//    		 os.println("Found danny, your password?");
//    		 os.flush();
//    		 //if ( line.compareTo("dre@margh_shelled")==0)
//    		 //{
//    			// os.println("--PASSWORD ACCEPTED FAM--");
//    		 //}
//    	 }
//    	 
//    	 if ( line.compareTo("dre@margh_shelled")==0)
//    	 {
//    		 os.println("--PASSWORD ACCEPTED FAM--");
//    		 os.flush();
//    	 }
//
//    	 if ( line.compareTo("win&win99")==0)
//    	 {
//    		 os.println("--PASSWORD ACCEPTED FAM--");
//    		 os.flush();
//    	 }
//    	 
//    	 if ( line.compareTo("matty7")==0)
//    	 {
//    		 os.println("Found matty");
//    	 }
//    	 
//    	 
//    	 //player 1 ready
//    	 if ( line.compareTo("Player1Ready")==0)
//    	 {
//    		 
//    		 ClientCounter playerOneReadyCount = new ClientCounter(); 
//    		 
//    		 playerOneReadyCount.IncrementCount(1);
//    		 
//    		 if ((playerOneReadyCount.getCount()) == 2)
//    		 {
//    			 os.println("GAME START");
//    			 os.flush();
//    		 }
//    		 else
//    		 {
//    			 os.println("Nobody here yet, try again. Player1: " + playerOneReadyCount.getCount());
//    			 os.flush();
//    			 
//    		 }
//    	 }
//    	 if ( line.compareTo("Player2Ready")==0)
//    	 {
//    			 os.println("GAME START");
//    			 os.flush();
//    	 }
//    	 
//    	 else
//    	 {
//    		 os.println("Not danny or matty, GET OUT");
//    		 s.close();
//    	 }
//         //os.println(line);
//         //os.flush();
//         //System.out.println("Response to Client  :  "+line);
//         //line=is.readLine();
//     }   
// } catch (IOException e) {
//
//     line=this.getName(); //reused String line for getting thread name
//     System.out.println("IO Error/ Client "+line+" terminated abruptly");
// }
// catch(NullPointerException e){
//     line=this.getName(); //reused String line for getting thread name
//     System.out.println("Client "+line+" Closed");
// }
 
 //manual
 
 //read name
 try {
	 ClientCounter playerOneReadyCount = new ClientCounter();
	 ClientCounter playerTwoReadyCount = new ClientCounter();
     line=is.readLine();
     if ( line.compareTo("dannyboi")==0 || line.compareTo("matty7")==0)
    	 {
    		 os.println("Found danny, your password?");
    		 os.flush();
    	 }
     
     line=is.readLine();
     if ( line.compareTo("dre@margh_shelled")==0 || line.compareTo("win&win99")==0)
	 {
		 os.println("PasswordAccepted");
		 os.flush();
	 }
     
     line=is.readLine();
     if ( line.compareTo("Player1Ready")==0)
	 {
    	 playerOneReadyCount.IncrementCount(1);
    	 os.println("Player Count: " + playerOneReadyCount.getCount());
		 os.flush();
	 }
     
     else if ( line.compareTo("Player2Ready")==0)
     {
    	 playerTwoReadyCount.IncrementCount(1);
    	 os.println("Player Count: " + playerTwoReadyCount.getCount());
		 os.flush();
     }
     
     line=is.readLine();
     if ((playerOneReadyCount.getCount()) == (playerTwoReadyCount.getCount()))
		 {
			 os.println("GAME START");
			 os.flush();
		 }
     else
     {
    	 os.println("Other Player does not exist");
		 os.flush();
     }
     
     os.println("Welcome to Find The Queen");
     os.flush();

     //to choose a role     
//     line=is.readLine();
//     if ( line.compareTo("ChooseRole")==0)
//	 {
//    	 
//	 }
     
        
 } catch (IOException e) {

     line=this.getName(); //reused String line for getting thread name
     System.out.println("IO Error/ Client "+line+" terminated abruptly");
 }
 catch(NullPointerException e){
     line=this.getName(); //reused String line for getting thread name
     System.out.println("Client "+line+" Closed");
 }
 
 

 finally{    
 try{
     System.out.println("Connection Closing..");
     if (is!=null){
         is.close(); 
         System.out.println(" Socket Input Stream Closed");
     }

     if(os!=null){
         os.close();
         System.out.println("Socket Out Closed");
     }
     if (s!=null){
     s.close();
     System.out.println("Socket Closed");
     }

     }
 catch(IOException ie){
     System.out.println("Socket Close Error");
 }
 }//end finally
 }
}