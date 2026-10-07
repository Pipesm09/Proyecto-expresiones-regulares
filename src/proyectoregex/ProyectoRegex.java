package proyectoregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProyectoRegex {

    public static void main(String[] args) {

        // Demostración de métodos requeridos por la guía
        demostrarMetodos();

        // 1. Placas de carros en Colombia
        probarRegex(
                "1. Placas de carro en Colombia",
                "^[A-Z]{3}-?[0-9]{3}$",
                new String[]{"ASV-558", "FGG887", "DDE445"},
                new String[]{"AdV-558", "fG887", "DDE44f"}
        );

        // 2. Codigos postales en Medellin
        probarRegex(
                "2. Codigos postales para Medellin",
                "^0500\\d{2}$",
                new String[]{"050001", "050021", "050010"},
                new String[]{"040001", "050121", "50001"}
        );

        // 3. Numeros de telefonos fijos en Medellin
        probarRegex(
                "3. Numeros de telefonos fijos en Medellin",
                "^(?:604)?\\d{7}$",
                new String[]{"6044441234", "6041234", "4441234"},
                new String[]{"404123", "70412345"}
        );

        // 4. Numeros de telefono celular en Colombia
        probarRegex(
                "4. Numeros de telefonos celulares en Colombia",
                "^3\\d{9}$",
                new String[]{"3104567890", "3001234567", "3219876543"},
                new String[]{"2104567890", "310456789", "41045678901"}
        );

        // 5. Direcciones de correo electronico
        probarRegex(
                "5. Direcciones de correo electronico",
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                new String[]{"usuario@gmail.com", "test.123@univalle.edu.co", "a@b.co"},
                new String[]{"usuario.com", "@g.com", "usuario@gmail"}
        );

        // 6. Fecha en formato dd/mm/aaaa
        probarRegex(
                "6. Fecha en formato dd/mm/aaaa",
                "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$",
                new String[]{"01/01/2023", "25/09/2026", "31/12/1999"},
                new String[]{"32/01/2023", "15/13/2023", "1/1/2023"}
        );

        // 7. Hora en formato 24 horas hh:mm:ss
        probarRegex(
                "7. Hora en formato de 24 horas hh:mm:ss",
                "^([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$",
                new String[]{"14:30:00", "00:00:00", "23:59:59"},
                new String[]{"24:00:00", "14:60:00", "14:30"}
        );

        // 8. Hora en formato 12 horas hh:mm:ss AM/PM
        probarRegex(
                "8. Hora en formato de 12 horas hh:mm:ss AM/PM",
                "^(0?[1-9]|1[0-2]):[0-5][0-9]:[0-5][0-9]\\s*(AM|PM|am|pm)$",
                new String[]{"02:30:00 AM", "12:00:00 pm", "5:45:12 PM"},
                new String[]{"13:30:00 AM", "02:60:00 PM", "02:30:00"}
        );

        // 9. Declaracion de variables en Java
        probarRegex(
                "9. Declaracion de variables en Java",
                "^(int|double|String|boolean|float)\\s+[a-zA-Z_$][a-zA-Z0-9_$]*\\s*(=\\s*.*;|;)$",
                new String[]{"int contador = 0;", "String nombre = \"Juan\";", "double pi = 3.14;"},
                new String[]{"int 1var = 0;", "contador = 0;", "String = \"test\";"}
        );

        // 10. URL (Formato general)
        probarRegex(
                "10. URL (Formato general)",
                "^(https?|ftp)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$",
                new String[]{"https://www.google.com", "http://univalle.edu.co/index.html", "ftp://files.servidor.org"},
                new String[]{"www.google.com", "http://", "htp://error.com"}
        );

        // 11. Codigo ISBN
        probarRegex(
                "11. Codigo ISBN (ISBN-13)",
                "^97[89]-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1}$",
                new String[]{"978-3-16-148410-0", "979-8-1234-5678-9"},
                new String[]{"123-3-16-148410-0", "978-3161484100"}
        );

        // 12. Codigo de barras en Colombia
        probarRegex(
                "12. Codigo de barras en Colombia",
                "^77[01]\\d{10}$",
                new String[]{"7701234567890", "7719876543210"},
                new String[]{"7721234567890", "770123456789"}
        );

        // 13. Nombres y apellidos
        probarRegex(
                "13. Nombres y apellidos con tildes y 'ñ'",
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$",
                new String[]{"María José Núñez", "Ángel Pérez", "José Luis Muñoz"},
                new String[]{"Jose123", "María_Pérez", "Juan#Gómez"}
        );

        // 14. Contraseña segura
        probarRegex(
                "14. Contrasena segura",
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                new String[]{"Clave1234*", "Segura$99", "Abcdef12!"},
                new String[]{"debil", "SOLOMAYUSCULAS1", "12345678"}
        );

        // 15. Estructura de un ciclo for
        probarRegex(
                "15. Estructura de un ciclo for",
                "^[Ff]or\\s*\\([a-zA-Z]+\\s*=\\s*\\d+;\\s*[a-zA-Z]+\\s*[<>]?=\\s*[a-zA-Z0-9]+;\\s*[a-zA-Z]+(\\+\\+|--)\\s*\\)$",
                new String[]{"For(k=1; k<N;k++)", "for (i = 0; i <= 10; i++)"},
                new String[]{"for(1=1; i<10; i++)", "For(k=1 k<N)"}
        );

        // 16. Numero Double
        probarRegex(
                "16. Codigo para representar un numero double",
                "^[+-]?\\d+(\\.\\d+)?$",
                new String[]{"3.14159", "-0.001", "100"},
                new String[]{"3.14.15", "abc", "10,5"}
        );

        // 17. Leyes, decretos y articulos en Colombia
        probarRegex(
                "17. Leyes, decretos y articulos en Colombia",
                "(?i)^(Ley|Decreto|Artículo|Art\\.)\\s+\\d+(\\s+de\\s+\\d{4})?$",
                new String[]{"Ley 100 de 1993", "Decreto 410", "Art. 12"},
                new String[]{"Reglamento 45", "Ley ABC", "Norma 12"}
        );

        // 18. Referencias de libros en normas IEEE
        probarRegex(
                "18. Referencias de libros impresos en normas IEEE",
                "^\\[\\d+\\]\\s+[A-Z]\\.\\s+[A-Za-z]+,\\s+.*,\\s+[^,]+:\\s+[^,]+,\\s+\\d{4}\\.$",
                new String[]{"[1] J. Smith, Intro to Java, NY: Pearson, 2020."},
                new String[]{"J. Smith 2020 Java", "1. J. Smith, Intro"}
        );

        // 19. Referencias de libros en normas APA
        probarRegex(
                "19. Referencias de libros impresos en normas APA",
                "^[A-Z][a-z]+,\\s+[A-Z]\\.\\s+\\(\\d{4}\\)\\.\\s+.*\\.\\s+.*$",
                new String[]{"Quintero, G. (2026). Programacion en Java. Medellin."},
                new String[]{"Quintero G. Programacion", "G. Quintero (2026)"}
        );

        // 20. Precios de productos
        probarRegex(
                "20. Precios de productos",
                "^\\$?\\s?\\d{1,3}(?:\\.\\d{3})*(?:,\\d{2})?(\\s?COP)?$",
                new String[]{"$ 150.000 COP", "$1.500,50", "2000"},
                new String[]{"150abc", "$ 10.00.0", "USD 100"}
        );

        // 21. Diptongos e hiatos
        probarRegex(
                "21. Diptongos e hiatos",
                ".*([aeoáéó][aeoáéó]|[iíuú][iíuú]|[aeoáéó][íú]|[íú][aeoáéó]|[iu][aeoáéó]|[aeoáéó][iu]).*",
                new String[]{"caos", "ciudad", "país", "miedo"},
                new String[]{"sol", "pan", "mar"}
        );
    }

    // Demostracion de los metodos requeridos por la guia
    public static void demostrarMetodos() {
        System.out.println("Demostracion de metodos String / Pattern / Matcher\n");
        String texto = "Placa ABC-123 y XYZ-987";
        String regex = "[A-Z]{3}-\\d{3}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(texto);

        // 1. find()
        System.out.println("Metodo find():");
        while (m.find()) {
            System.out.println(" Encontrado: " + m.group() + " en inicio: " + m.start() + ", fin: " + m.end());
        }

        // 2. matches()
        System.out.println("Metodo matches():");
        System.out.println(" 'ABC-123' coincide totalmente: " + Pattern.matches("^[A-Z]{3}-\\d{3}$", "ABC-123"));

        // 3. lookingAt()
        System.out.println("Metodo lookingAt():");
        Matcher m2 = p.matcher("ABC-123 texto adicional");
        System.out.println(" Empieza con el patron: " + m2.lookingAt());

        // 4. replaceFirst()
        System.out.println("Metodo replaceFirst():");
        System.out.println(" Resultado: " + m.reset().replaceFirst("[PLACA_1]"));

        // 5. replaceAll()
        System.out.println("Metodo replaceAll():");
        System.out.println(" Resultado: " + m.reset().replaceAll("[PLACA]"));

        // 6. split()
        System.out.println("Metodo split():");
        String[] partes = texto.split("\\s+");
        for (String parte : partes) {
            System.out.println(" Subcadena: " + parte);
        }
        System.out.println();
    }

    // Metodo auxiliar reutilizable para probar casos validos e invalidos
    public static void probarRegex(String titulo, String regex, String[] casosValidos, String[] casosInValidos) {
        System.out.println("Prueba: " + titulo);

        Pattern pattern = Pattern.compile(regex);

        System.out.println("Casos validos:");
        for (int i = 0; i < casosValidos.length; i++) {
            String texto = casosValidos[i];
            boolean resultado = pattern.matcher(texto).matches();
            System.out.println(" El texto \"" + texto + "\" Coincide? (true): " + resultado);
        }

        // Cambia este bloque dentro de probarRegex:
        System.out.println("Casos invalidos:");
        for (int i = 0; i < casosInValidos.length; i++) {
            String texto = casosInValidos[i];
            boolean resultado = pattern.matcher(texto).matches();
            System.out.println(" El texto \"" + texto + "\" Coincide? (esperado false): " + resultado);
        }
        System.out.println();
    }
}
