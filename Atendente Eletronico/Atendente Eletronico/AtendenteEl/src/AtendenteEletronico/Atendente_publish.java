package AtendenteEletronico;

import javax.xml.ws.Endpoint;

public class Atendente_publish {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9876/atend", new Atendente_implements());
    }
    
}
