import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProyectoRegex {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  DEMOSTRACIÓN DE EXPRESIONES REGULARES EN JAVA   ");
        System.out.println("==================================================");

        // =====================================================================
        // 1. PLACAS DE CARRO EN COLOMBIA (Ej: ABC-123 o ABC123)
        // =====================================================================
        String regexPlaca = "^[A-Z]{3}-?[0-9]{3}$";
        Pattern patternPlaca = Pattern.compile(regexPlaca);
        String[] validosPlaca = {"ASV-558", "FGG887", "DDE445"};
        String[] invalidosPlaca = {"AdV-558", "fG887", "DDE44f"};
        
        imprimirResultados("1. Placas de carro en Colombia", patternPlaca, validosPlaca, invalidosPlaca);


        // =====================================================================
        // 2. CÓDIGOS POSTALES PARA MEDELLÍN (Ej: 050021)
        // =====================================================================
        String regexPostal = "^0500\\d{2}$";
        Pattern patternPostal = Pattern.compile(regexPostal);
        String[] validosPostal = {"050001", "050021", "050010"};
        String[] invalidosPostal = {"040001", "050121", "50001"};
        
        imprimirResultados("2. Códigos postales para Medellín", patternPostal, validosPostal, invalidosPostal);


        // =====================================================================
        // 3. NÚMEROS DE TELÉFONOS FIJOS EN MEDELLÍN (7 dígitos, empiezan por 6)
        // =====================================================================
        String regexFijo = "^6\\d{6}$";
        Pattern patternFijo = Pattern.compile(regexFijo);
        String[] validosFijo = {"6041234", "6023344", "6009988"};
        String[] invalidosFijo = {"4041234", "604123", "70412345"};
        
        imprimirResultados("3. Números de teléfonos fijos en Medellín", patternFijo, validosFijo, invalidosFijo);


        // =====================================================================
        // 4. NÚMEROS DE TELÉFONOS CELULARES EN COLOMBIA (10 dígitos, empiezan por 3)
        // =====================================================================
        String regexCelular = "^3\\d{9}$";
        Pattern patternCelular = Pattern.compile(regexCelular);
        String[] validosCelular = {"3104567890", "3001234567", "3219876543"};
        String[] invalidosCelular = {"2104567890", "310456789", "41045678901"};
        
        imprimirResultados("4. Números de teléfonos celulares en Colombia", patternCelular, validosCelular, invalidosCelular);


        // =====================================================================
        // 5. DIRECCIONES DE CORREO ELECTRÓNICO (Formato general)
        // =====================================================================
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern patternEmail = Pattern.compile(regexEmail);
        String[] validosEmail = {"usuario@gmail.com", "test.123@univalle.edu.co", "a@b.co"};
        String[] invalidosEmail = {"usuario.com", "@g.com", "usuario@gmail"};
        
        imprimirResultados("5. Direcciones de correo electrónico", patternEmail, validosEmail, invalidosEmail);


        // =====================================================================
        // 6. FECHA EN FORMATO dd/mm/aaaa (Ej. 01/01/2023)
        // =====================================================================
        String regexFecha = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern patternFecha = Pattern.compile(regexFecha);
        String[] validosFecha = {"01/01/2023", "25/09/2026", "31/12/1999"};
        String[] invalidosFecha = {"32/01/2023", "15/13/2023", "1/1/2023"};
        
        imprimirResultados("6. Fecha en formato dd/mm/aaaa", patternFecha, validosFecha, invalidosFecha);


        // =====================================================================
        // 7. HORA EN FORMATO 24 HORAS hh:mm:ss (Ej. 14:30:00)
        // =====================================================================
        String regexHora24 = "^([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
        Pattern patternHora24 = Pattern.compile(regexHora24);
        String[] validosHora24 = {"14:30:00", "00:00:00", "23:59:59"};
        String[] invalidosHora24 = {"24:00:00", "14:60:00", "14:30"};
        
        imprimirResultados("7. Hora en formato de 24 horas hh:mm:ss", patternHora24, validosHora24, invalidosHora24);


        // =====================================================================
        // 8. HORA EN FORMATO 12 HORAS hh:mm:ss AM/PM (Ej. 02:30:00 AM/PM)
        // =====================================================================
        String regexHora12 = "^(0?[1-9]|1[0-2]):[0-5][0-9]:[0-5][0-9]\\s*(AM|PM|am|pm)$";
        Pattern patternHora12 = Pattern.compile(regexHora12);
        String[] validosHora12 = {"02:30:00 AM", "12:00:00 pm", "5:45:12 PM"};
        String[] invalidosHora12 = {"13:30:00 AM", "02:60:00 PM", "02:30:00"};
        
        imprimirResultados("8. Hora en formato de 12 horas hh:mm:ss AM/PM", patternHora12, validosHora12, invalidosHora12);


        // =====================================================================
        // 9. DECLARACIÓN DE VARIABLES EN JAVA (Ej. int contador = 0;)
        // =====================================================================
        String regexVarJava = "^(int|double|String|boolean|float)\\s+[a-zA-Z_$][a-zA-Z0-9_$]*\\s*=\\s*.*;$";
        Pattern patternVarJava = Pattern.compile(regexVarJava);
        String[] validosVar = {"int contador = 0;", "String nombre = \"Juan\";", "double pi = 3.14;"};
        String[] invalidosVar = {"int 1var = 0;", "contador = 0;", "String = \"test\";"};
        
        imprimirResultados("9. Declaración de variables en Java", patternVarJava, validosVar, invalidosVar);


        // =====================================================================
        // 10. URL (Formato general)
        // =====================================================================
        String regexUrl = "^(https?|ftp)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$";
        Pattern patternUrl = Pattern.compile(regexUrl);
        String[] validosUrl = {"https://www.google.com", "http://univalle.edu.co/index.html", "ftp://files.servidor.org"};
        String[] invalidosUrl = {"www.google.com", "http://", "htp://error.com"};
        
        imprimirResultados("10. URL (Formato general)", patternUrl, validosUrl, invalidosUrl);


        // =====================================================================
        // 11. CÓDIGO ISBN (ISBN-13)
        // =====================================================================
        String regexIsbn = "^97[89]-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1}$";
        Pattern patternIsbn = Pattern.compile(regexIsbn);
        String[] validosIsbn = {"978-3-16-148410-0", "979-8-1234-5678-9"};
        String[] invalidosIsbn = {"123-3-16-148410-0", "978-3161484100"};
        
        imprimirResultados("11. Código ISBN (ISBN-13)", patternIsbn, validosIsbn, invalidosIsbn);


        // =====================================================================
        // 12. CÓDIGO DE BARRAS EN COLOMBIA (EAN-13, empieza por 770 o 771)
        // =====================================================================
        String regexCodBarras = "^77[01]\\d{10}$";
        Pattern patternCodBarras = Pattern.compile(regexCodBarras);
        String[] validosBarras = {"7701234567890", "7719876543210"};
        String[] invalidosBarras = {"7721234567890", "770123456789"};
        
        imprimirResultados("12. Código de barras en Colombia", patternCodBarras, validosBarras, invalidosBarras);


        // =====================================================================
        // 13. NOMBRES Y APELLIDOS CON TILDES Y 'Ñ'
        // =====================================================================
        String regexNombre = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(\\s+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)+$";
        Pattern patternNombre = Pattern.compile(regexNombre);
        String[] validosNombre = {"María José Núñez", "Ángel Pérez", "José Luis Múñoz"};
        String[] invalidosNombre = {"maría pérez", "José123", "Maria"};
        
        imprimirResultados("13. Nombres y apellidos con tildes y 'ñ'", patternNombre, validosNombre, invalidosNombre);


        // =====================================================================
        // 14. CONTRASEÑA SEGURA (Mínimo 8 caracteres, 1 mayúscula, 1 minúscula, 1 número)
        // =====================================================================
        String regexPass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern patternPass = Pattern.compile(regexPass);
        String[] validosPass = {"Clave1234", "Segura$99", "Abcdef12"};
        String[] invalidosPass = {"debil", "SOLOMAYUSCULAS1", "12345678"};
        
        imprimirResultados("14. Contraseña segura", patternPass, validosPass, invalidosPass);


        // =====================================================================
        // 15. ESTRUCTURA DE UN CICLO FOR (Ej. For(k=1; k<N;k++))
        // =====================================================================
        String regexFor = "^[Ff]or\\s*\\([a-zA-Z]+\\s*=\\s*\\d+;\\s*[a-zA-Z]+\\s*[<>]?=\\s*[a-zA-Z0-9]+;\\s*[a-zA-Z]+(\\+\\+|--)\\s*\\)$";
        Pattern patternFor = Pattern.compile(regexFor);
        String[] validosFor = {"For(k=1; k<N;k++)", "for (i = 0; i <= 10; i++)"};
        String[] invalidosFor = {"for(1=1; i<10; i++)", "For(k=1 k<N)"};
        
        imprimirResultados("15. Estructura de un ciclo for", patternFor, validosFor, invalidosFor);


        // =====================================================================
        // 16. NÚMERO DOUBLE (Ej. 3.14159)
        // =====================================================================
        String regexDouble = "^[+-]?\\d+(\\.\\d+)?$";
        Pattern patternDouble = Pattern.compile(regexDouble);
        String[] validosDouble = {"3.14159", "-0.001", "100"};
        String[] invalidosDouble = {"3.14.15", "abc", "10,5"};
        
        imprimirResultados("16. Código para representar un número double", patternDouble, validosDouble, invalidosDouble);
    }

    // Método auxiliar para mantener tu estructura limpia de impresión con ciclos for
    public static void imprimirResultados(String titulo, Pattern pattern, String[] validos, String[] invalidos) {
        System.out.println("\n==================================================");
        System.out.println(" PRUEBA: " + titulo);
        System.out.println("==================================================");
        
        System.out.println("--- Probando Cadenas Válidas (Esperado: true) ---");
        for (int i = 0; i < validos.length; i++) {
            String texto = validos[i];
            boolean resultado = pattern.matcher(texto).matches();
            System.out.println("El texto \"" + texto + "\" ¿Coincide? " + resultado);
        }

        System.out.println("\n--- Probando Cadenas Inválidas (Esperado: false) ---");
        for (int i = 0; i < invalidos.length; i++) {
            String texto = invalidos[i];
            boolean resultado = pattern.matcher(texto).matches();
            System.out.println("El texto \"" + texto + "\" ¿No Coincide? " + !resultado + " (matches: " + resultado + ")");
        }
    }
}
