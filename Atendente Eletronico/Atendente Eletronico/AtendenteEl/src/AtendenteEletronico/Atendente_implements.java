package AtendenteEletronico;

import java.util.Date;
import javax.jws.WebService;

@WebService(endpointInterface = "AtendenteEletronico.Atendente_server")
public class Atendente_implements implements Atendente_server{
    Date d = new Date();

    @Override
    public String sem_internet() {
       return "Ok, tentaremos solucionar o problema.";
    }

    @Override
    public String ar_condicionado() {
       return "Um colaborador está a caminho.";
    }

    @Override
    public String sala_suja() {
        return "Em breve inspecionaremos a sala.";
    }

    @Override
    public String pc_com_defeito() {
        return "Estamos encaminhando um técnico.s";
    }
    
    @Override
    public String sair(){
        return "Até mais!! Volte sempre!!";
    }
    
    @Override
    public String dados(String nome, String cpf){
        return "Dados recebidos do usuario(a): " + nome + " de CPF: " + cpf;
    }
    
    @Override
    public long data(){
        return this.d.getTime();
    }
}
