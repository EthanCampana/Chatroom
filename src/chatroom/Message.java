/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatroom;

/**
 *
 * @author ecampana
 */
public class Message {
    
    
    
    private String Message;
    
    public void sendMessage(String Message){
    
    this.Message = Message;
    
    }
    
    public String ReceiveMessage(){
    
    return this.Message;
    
    }
    
    
            
}
