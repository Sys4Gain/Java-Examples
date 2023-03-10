/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiffTempo;
import java.time.*;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtils {

    
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Digitare il giorno di nascita");
        int giorno=in.nextInt();
        System.out.println("Digitare il mese di nascita");
        int mese=in.nextInt();
        System.out.println("Digitare l'anno di nascita");
        int anno=in.nextInt();
        LocalDate primaData=LocalDate.of(anno,mese,giorno);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s=primaData.format(formatter);
        LocalDate parsedDate=LocalDate.parse(s, formatter);
        
        System.out.println("Digitare la data da confrontare nello stesso ordine di prima");
        int giorno1=in.nextInt();
        int mese1=in.nextInt();
        int anno1=in.nextInt();
        LocalDate secondaData=LocalDate.of(anno1,mese1,giorno1);
        String s1=secondaData.format(formatter);
        LocalDate parsedDate1=LocalDate.parse(s1, formatter);
        
        Locale italia=Locale.ITALY;
        DateFormat formatoOra=new SimpleDateFormat("HH:mm:ss");
        String ora=formatoOra.format(new Date());
        
        Period confronto=Period.between(parsedDate, parsedDate1);
        int mesiFinale=(confronto.getYears()*12)+confronto.getMonths();
        int settimane=confronto.getDays()/7;
        int giorniFinale=confronto.getDays()%7;
        
        System.out.println("Tra le due date intercorrono "+mesiFinale+" mesi, "+settimane+" settimane, "+ giorniFinale+" giorni "+ora);
        
    }
    
}
