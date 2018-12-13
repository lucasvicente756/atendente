
package AtendenteEletronico;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface Atendente_server {
    @WebMethod String sem_internet();
    @WebMethod String ar_condicionado();
    @WebMethod String sala_suja();
    @WebMethod String pc_com_defeito();
    @WebMethod String sair();
    @WebMethod String dados(String nome, String cpf);
    @WebMethod long data();
}





//suporte tecnico