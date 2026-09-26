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

        /* String regex,cadena;
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
        if(m.matches()){
            JOptionPane.showMessageDialog(null, "Es válido");
        }
        else {
            JOptionPane.showMessageDialog(null, "No es válido");
        }
         */
        //PLACAS DE CARROS EN COLOMBIA
        //primero un string que va hacer el regex
        
        String regex = "^[A-Z]{3}-?[0-9]{3}$"; //debe ir asi sin espacios
        Pattern pattern = Pattern.compile(regex);
        
        //Declaracion de ejemplos de prueba
        
        String textoPrueba;
        String casosValidos[] = {"ASV-558", "FGG887", "DDE445"};
        String casosInValidos[] = {"AdV-558", "fG887", "DDE44f"};
        
        //Mostrar ejemplos
        
        System.out.println("DEMOSTRACIoN DE CASOS VALIDOS E INVALIDOS");
        System.out.println("\n---Probando Cadenas Válidas---");
        for (int i = 0; i < casosValidos.length; i++) {
         String texto = casosValidos[i];
            boolean resultado = pattern.matcher(texto).matches();
            System.out.println("El texto \"" + texto + "\" ¿Coincide? (true) " + resultado);
        }
        for(int i=0; i < casosInValidos.length; i++){
            String texto = casosInValidos[i];//extrae el texto que queremos probar
            boolean resultado = pattern.matcher(texto).matches(); //booleano porque busca el texto .matches y devuelve un true si coincide y un false sino
            System.out.println("El texto \"" + texto + "\" ¿No Coincide? (false) " + resultado);
        }
        textoPrueba = "Mi carro tiene la placa ABC-334 y el de mi novia es de AFK556";

    }

}
