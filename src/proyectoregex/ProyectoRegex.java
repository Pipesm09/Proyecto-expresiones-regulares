package proyectoregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ProyectoRegex {

    
    public static void main(String[] args) {
        
        String regex,cadena;
        int cont=0;
        Pattern p;
        Matcher m;
        regex = "Ola";
        cadena="ola hola carola que rica que esta la ola\nola, "
                + "ola invita a Magola para que traiga las polas\nola y "
                + "salgamos al sol a escuchar la radiola";
        
        p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        m = p.matcher(cadena);
        StringBuilder sb = new StringBuilder();
        while(m.find()){
            cont++;
            sb.append("desde ").append(m.start()).append(" hasta ").append(m.end()).append(" en ").append(m.group()).append("\n");
        }
        
        if(cont==0){
            JOptionPane.showMessageDialog(null, "no es valido");
        }
        else{
            String mensaje = String.format("El se encontró %d veces en la cadena\nEstá en las siguientes posiciones:\n%s",cont ,sb.toString());
            JOptionPane.showConfirmDialog(null, mensaje);
        }
        /*if(m.matches()){
            JOptionPane.showMessageDialog(null, "Es válido");
        }
        else {
            JOptionPane.showMessageDialog(null, "No es válido");
        }
        */
    }
    
}
