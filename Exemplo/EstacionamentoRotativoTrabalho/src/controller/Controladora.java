package controller;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controladora {

    public static void avisoPreencherTodosCampos(){//avisa para o usuário quando um campo não está preenchido
        JOptionPane.showMessageDialog(null, "Preencher todos os campos");
    }
    
    public static String formatarPlaca(String placa) {
	String um = placa.substring(0, 3);
        um = toUpperCase(um);
	String dois = placa.substring(3, 7);
        dois = toUpperCase(dois);
	return ( um+"-"+dois);
    }
    
    public static String formatarTelefone(String telefone) {
        String parenteses = telefone.substring(0, 2);
        String ponto = telefone.substring(2, 3);
        String barra = telefone.substring(3, 7);
        String fim = telefone.substring(7, 11);
        return ( "("+parenteses+") "+ponto+"."+barra+"-"+fim);
    }
    
    public static String dataSaida(int p){
        int permanencia = p;
        
        LocalDate data = LocalDate.now();
        LocalDate dataSaida = data.plusDays(permanencia);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String retorna = formato.format(dataSaida);
        
        System.out.println("Objeto criado: " +dataSaida);
        
        return retorna;
    }
}
