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
public class Person {
    
    private String userName;
    private String PUID;
    
    public Person(String userName, String PUID){
        this.userName = userName;
        this.PUID = PUID;
    }
    
    public String getUserName(){ return this.userName;}
    public String getPUID(){ return this.PUID;}
    public void setUserName(String userName){ this.userName = userName;}
    public void setPUID(String PUID){ this.PUID = PUID;}
    
    
    
}
