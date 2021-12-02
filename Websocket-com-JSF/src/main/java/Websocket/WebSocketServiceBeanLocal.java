/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Websocket;

import java.util.List;
import javax.ejb.Local;

@Local
public interface WebSocketServiceBeanLocal {
    void add(String message);
    public List<String> getMessages();
    public void setMessages(List<String> messages);
    public void setRespostas(List<String> respostas);
    public List<String> getRespostas();
    void addResposta(String resposta);
}
