/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Websocket;

import java.io.Serializable;
import static java.lang.System.console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "websocketBean")
//@Dependent
@ApplicationScoped
//@ViewScoped
public class WebsocketBean implements Serializable{
    
private static final Logger LOG = Logger.getLogger(WebsocketBean.class.getName());
       
 @Inject
 @Push(channel = "incoming")
 private PushContext push;
 
 @Inject
 private WebSocketServiceBeanLocal websocketservice;
   private String enteredMessage;
   private String resposta;

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getEnteredMessage() {
        return enteredMessage;
    }

    public void setEnteredMessage(String enteredMessage) {
        this.enteredMessage = enteredMessage;
    }
   public List<String> getMessages(){
       
       return websocketservice.getMessages();
    }
   public List<String> getRespostas(){
       return websocketservice.getRespostas();
   }
   public void onSendMessage() {
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
       String s;
       LocalDateTime now = LocalDateTime.now();
       s=" ["+ dtf.format(now) +"] " + enteredMessage;
       websocketservice.add(s);
       push.send(websocketservice.getMessages());
       LOG.log(Level.INFO, "Messagem: {0}", enteredMessage);
    }
   public void consoleM(){
       LOG.log(Level.INFO, "Messagem recebida pelo servidor!");
       
   }
   public void bot(String enteredMessage){
       if(enteredMessage.equals("Oi")){
           resposta="Olá";
           websocketservice.addResposta(resposta);
       }
       if(enteredMessage.equals("Como vai?")){
           setResposta("Tudo Bem!");
           websocketservice.addResposta(resposta);
       }
   
   }
   
}
