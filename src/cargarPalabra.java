
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Calendar;
import java.util.TimeZone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mariogarsia
 */
class cargarPalabra {
    
    
     public static String palabraRandom (String ruta) throws IOException{
        File archivo = new File(ruta);
        BufferedReader br = null;
        FileReader fr = null;
        ArrayList<String> ListaPalabras = new ArrayList<>();
        
        
        
        try {
            fr = new FileReader(archivo);
            if (fr.ready()){
                String palabraLeida;
                br = new BufferedReader(fr);
              while ((palabraLeida = br.readLine()) != null){
                
                ListaPalabras.add(palabraLeida);  
              }  
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
   
     Random rand = new Random();
     
     int r = rand.nextInt(ListaPalabras.size());
     
     String palabraRandom = ListaPalabras.get(r); 
        
    return palabraRandom;   
    }
     
     
     public static String selecionPalabraBD (String tema) throws SQLException {
         ArrayList<String> ListaPalabras = new ArrayList<>();
         
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (Exception ex){
             System.out.println(ex);
         }
         
         Connection con = null;
         
         //VARIABLES PARA BD
         
         String BD = "Wordle_Palabras";
         String USER = "root";
         String PASS = "m1509911Mm!";
         String HOST = "localhost";
         Calendar now = Calendar.getInstance();
         TimeZone zonahoraria = now.getTimeZone();
         
         con = (Connection) DriverManager.getConnection("jdbc:mysql:// "
         + HOST + "/" + BD + "?user="
         + USER + "&password=" + PASS
         + "&useLegacyDatetimeCode=false&serverTimezone="
         + zonahoraria.getID());
         
         //SENTENCIAS SQL
         String consulta = "SELECT * FROM Palabras WHERE Ámbito = '" + tema +"'";
         
         Statement stmt = con.createStatement();
         
         //REALIZAR CONSULTA
         ResultSet rset = stmt.executeQuery(consulta);
         
         //OBTENER RESULTADOS DE CONSULTA
         while (rset.next()){
             String palabra = rset.getString("Palabra");
             ListaPalabras.add(palabra);
             //System.out.println(palabra);
         }
         
         //SELECCIÓN DE PALABRA AL AZAHAR DE LA ARRAY LISTAPALABRAS
         
        Random rand = new Random();
     
        int r = rand.nextInt(ListaPalabras.size());
     
        String palabraRandom = ListaPalabras.get(r);
         
         return palabraRandom;
     }
}
