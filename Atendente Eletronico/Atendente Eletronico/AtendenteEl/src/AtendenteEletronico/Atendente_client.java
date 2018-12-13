
package AtendenteEletronico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;



public class Atendente_client {
    public static void main(String[] args) throws MalformedURLException, UnknownHostException, FileNotFoundException, IOException {
        URL url = new URL("http://127.0.0.1:9876/atend?wsdl");
            QName qname = new QName("http://AtendenteEletronico/","Atendente_implementsService");
            Service ws = Service.create(url, qname);
            Atendente_server atend = ws.getPort(Atendente_server.class);
            Scanner s = new Scanner(System.in);
            //funções p pegar os dados
            InetAddress address = InetAddress.getLocalHost();
            Date d = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = new GregorianCalendar();
            cal.setTime(d);
           
            
            System.out.println("##########################################");
            System.out.println("Informe seu CPF: ");
            String cpf = s.nextLine();
            System.out.println("##########################################");
            System.out.println("Selecione a Opção desejada: ");
            System.out.println("1 - Sem Acesso à Internet. \n"
                    + "2 - Ar Condicionado. \n"
                    + "3 - Sala Desorganizada. \n"
                    + "4 - Computador com Defeito. \n"
                    + "5 - Sair. \n");
            
            System.out.println("Opção escolhida: ");
            int x = s.nextInt();
            switch(x){
                case 1: 
                    System.out.println("Servidor: " + atend.sem_internet());
                    break;
                case 2:
                    System.out.println("Servidor: " + atend.ar_condicionado());
                    break;
                case 3:
                    System.out.println("Servidor: " + atend.sala_suja());
                    break;
                case 4:
                    System.out.println("Servidor: " + atend.pc_com_defeito());
                    break;
                case 5:
                    System.out.println("Servidor: " +  atend.sair());
                    break;
            }
            
            System.out.println("Servidor: " + atend.dados(address.getHostAddress(), cpf) + " no Dia - Mês - Horário: " + cal.getTime());
            //System.out.println("\nData: "+ formatador.format(atend.data()));
            try{
            //gravar em um arquivo
            File dados = new File("dados.txt");
            FileOutputStream text_arq = new FileOutputStream(dados); 
            String dados1 = "A opção escolhida foi: " + x + "\n";
            String pula_linha = "\n";
            String data_req = " Dia da Semana - Mês - Horário - Ano: " + cal.getTime() + "\n";
            
            
            text_arq.write(dados1.getBytes());
            text_arq.write(pula_linha.getBytes());
            text_arq.write(data_req.getBytes());
            text_arq.write(pula_linha.getBytes());
            text_arq.write(atend.dados(address.getHostAddress(), cpf).getBytes());
            text_arq.write(pula_linha.getBytes());
            text_arq.close();
            
            // Lendo do arquivo  
//                System.out.println("\n");
//                dados = new File("dados.txt");  
//                FileInputStream fis = new FileInputStream(dados);  
//                int ln;  
//                while ( (ln = fis.read()) != -1 ) {  
//                   System.out.print( (char)ln );  
//                }  
//                fis.close();  
            }catch (Exception e){
                e.printStackTrace();
            }
            
    }
}
