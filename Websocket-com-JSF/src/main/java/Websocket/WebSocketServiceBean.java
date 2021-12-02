/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Websocket;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class WebSocketServiceBean implements WebSocketServiceBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List<String> messages;
    private List<String> respostas;
    @Override
    public List<String> getRespostas() {
        return respostas;
    }
    @Override
    public void setRespostas(List<String> respostas) {
        this.respostas = respostas;
    }
    
    @Override
    public List<String> getMessages() {
        return messages;
    }
    
    @Override
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @PostConstruct
    private void init(){
        messages = new ArrayList<>();
        respostas = new ArrayList<>();
    }

    @Override
    public void add(String message) {
        messages.add(message);        
    }

    @Override
    public void addResposta(String resposta) {
        respostas.add(resposta);
    }
    
    
}
