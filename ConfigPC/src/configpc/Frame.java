package configpc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
    
    //Oggetti grafici
    JFrame j=new JFrame();
    Container c=j.getContentPane();
    JLabel lbSelTarget,lbPSU,lbCPU,lbRAM,lbMOBO,lbGFX,lbGFX2,lbStorage,lbStorage2,lbTower,lbPrezzoPSU
           ,lbPrezzoCPU,lbPrezzoRAM,lbPrezzoMOBO,lbPrezzoGFX,lbPrezzoGFX2,lbPrezzoStorage,lbPrezzoStorage2,lbPrezzoTower
            ,lbTotDesc,lbTotPrezzo;
    JButton generatore,AMD,INTEL,prezzo;
    JPanel p,p2,pHDD,p3;
    
    Choice scelta=new Choice();
    Choice sceltaStorage=new Choice();
    Choice sceltaStorage2=new Choice();
    Choice sceltaPSU=new Choice();
    Choice sceltaCPU=new Choice();
    Choice sceltaRAM=new Choice();
    Choice sceltaTower=new Choice();
    Choice sceltaMOBO=new Choice();
    Choice sceltaGFX=new Choice();
    Choice sceltaGFX2=new Choice();
    
    //ArrayLists
    ArrayList <Double> prezzoStorage=new ArrayList<>();
    ArrayList <Double> prezzoStorage2=new ArrayList<>();
    
    ArrayList <Double> prezzoPSUufficio=new ArrayList<>();
    ArrayList <Double> prezzoPSUbudget=new ArrayList<>();
    ArrayList <Double> prezzoPSUpro=new ArrayList<>();
    ArrayList <Double> prezzoPSUhigh=new ArrayList<>();
    
    ArrayList <Double> prezzoCPUAMDufficio=new ArrayList<>();
    ArrayList <Double> prezzoCPUINTELufficio=new ArrayList<>();
    ArrayList <Double> prezzoCPUAMDbudget=new ArrayList<>();
    ArrayList <Double> prezzoCPUINTELbudget=new ArrayList<>();
    ArrayList <Double> prezzoCPUAMDpro=new ArrayList<>();
    ArrayList <Double> prezzoCPUINTELpro=new ArrayList<>();
    ArrayList <Double> prezzoCPUAMDhigh=new ArrayList<>();
    ArrayList <Double> prezzoCPUINTELhigh=new ArrayList<>();
    
    ArrayList <Double> prezzoRAMufficio=new ArrayList<>();
    ArrayList <Double> prezzoRAMbudget=new ArrayList<>();
    ArrayList <Double> prezzoRAMpro=new ArrayList<>();
    ArrayList <Double> prezzoRAMhigh=new ArrayList<>();
    
    ArrayList <Double> prezzoTowerUfficio=new ArrayList<>();
    ArrayList <Double> prezzoTowerBudget=new ArrayList<>();
    ArrayList <Double> prezzoTowerPro=new ArrayList<>();
    ArrayList <Double> prezzoTowerHigh=new ArrayList<>();
    
    ArrayList <Double> prezzoMOBOAMDufficio=new ArrayList<>();
    ArrayList <Double> prezzoMOBOINTELufficio=new ArrayList<>();
    ArrayList <Double> prezzoMOBOAMDbudget=new ArrayList<>();
    ArrayList <Double> prezzoMOBOINTELbudget=new ArrayList<>();
    ArrayList <Double> prezzoMOBOAMDpro=new ArrayList<>();
    ArrayList <Double> prezzoMOBOINTELpro=new ArrayList<>();
    ArrayList <Double> prezzoMOBOAMDhigh=new ArrayList<>();
    ArrayList <Double> prezzoMOBOINTELhigh=new ArrayList<>();
    
    ArrayList <Double> prezzoGFXbudget=new ArrayList<>();
    ArrayList <Double> prezzoGFXpro=new ArrayList<>();
    ArrayList <Double> prezzoGFXhigh=new ArrayList<>();
    
    ArrayList <Double> prezzoGFX2pro=new ArrayList<>();
    ArrayList <Double> prezzoGFX2high=new ArrayList<>();
    
    
    
    
    //Select Storage
    String selectHDD1TB="SELECT * FROM storage WHERE idstorage = 1";
    String selectHDD2TB="SELECT * FROM storage WHERE idstorage = 2";
    String selectSSD240GB="SELECT * FROM storage WHERE idstorage = 3";
    String selectSSD480GB="SELECT * FROM storage WHERE idstorage = 4";
    String selectSSD960GB="SELECT * FROM storage WHERE idstorage = 5";
    
    //Select PSU
    String selectPSUufficio="SELECT * FROM alimentatore WHERE idtarget = 1";
    String selectPSUbudget="SELECT * FROM alimentatore WHERE idtarget = 2";
    String selectPSUpro="SELECT * FROM alimentatore WHERE idtarget = 3";
    String selectPSUhigh="SELECT * FROM alimentatore WHERE idtarget = 4";
    String selectPSUbudgetpro="SELECT * FROM alimentatore WHERE idtarget = 23";
    String selectPSUbudgethigh="SELECT * FROM alimentatore WHERE idtarget = 24";
    
    //Select CPU
    String selectCPUAMDufficio="SELECT * FROM cpu WHERE idtarget = 1 AND idsocket = 1";
    String selectCPUIntelUfficio="SELECT * FROM cpu WHERE idtarget = 1 AND idsocket = 2";
    String selectCPUAMDbudget="SELECT * FROM cpu WHERE idtarget = 2 AND idsocket = 1";
    String selectCPUIntelbudget="SELECT * FROM cpu WHERE idtarget = 2 AND idsocket = 2";
    String selectCPUAMDpro="SELECT * FROM cpu WHERE idtarget = 3 AND idsocket = 1";
    String selectCPUIntelpro="SELECT * FROM cpu WHERE idtarget = 3 AND idsocket = 2";
    String selectCPUAMDhigh="SELECT * FROM cpu WHERE idtarget = 4 AND idsocket = 1";
    String selectCPUIntelhigh="SELECT * FROM cpu WHERE idtarget = 4 AND idsocket = 2";
    String selectCPUAMDbudgetpro="SELECT * FROM cpu WHERE idtarget = 23 AND idsocket = 1";
    String selectCPUIntelbudgetpro="SELECT * FROM cpu WHERE idtarget = 23 AND idsocket = 2";
    String selectCPUAMDbudgethigh="SELECT * FROM cpu WHERE idtarget = 24 AND idsocket = 1";
    String selectCPUIntelbudgethigh="SELECT * FROM cpu WHERE idtarget = 24 AND idsocket = 2";
    
    //Select RAM
    String selectRAMufficio="SELECT * FROM ram WHERE idtarget = 1";
    String selectRAMbudget="SELECT * FROM ram WHERE idtarget = 2";
    String selectRAMpro="SELECT * FROM ram WHERE idtarget = 3";
    String selectRAMhigh="SELECT * FROM ram WHERE idtarget = 4";
    String selectRAMbudgetpro="SELECT * FROM ram WHERE idtarget = 23";
    String selectRAMbudgethigh="SELECT * FROM ram WHERE idtarget = 24";
    
    //Select MOBO
    String selectMOBOAMDufficio="SELECT * FROM schedamadre WHERE idtarget = 1 AND idsocket = 1";
    String selectMOBOIntelUfficio="SELECT * FROM schedamadre WHERE idtarget = 1 AND idsocket = 2";
    String selectMOBOAMDbudget="SELECT * FROM schedamadre WHERE idtarget = 2 AND idsocket = 1";
    String selectMOBOIntelbudget="SELECT * FROM schedamadre WHERE idtarget = 2 AND idsocket = 2";
    String selectMOBOAMDpro="SELECT * FROM schedamadre WHERE idtarget = 3 AND idsocket = 1";
    String selectMOBOIntelpro="SELECT * FROM schedamadre WHERE idtarget = 3 AND idsocket = 2";
    String selectMOBOAMDhigh="SELECT * FROM schedamadre WHERE idtarget = 4 AND idsocket = 1";
    String selectMOBOIntelhigh="SELECT * FROM schedamadre WHERE idtarget = 4 AND idsocket = 2";
    String selectMOBOAMDbudgetpro="SELECT * FROM schedamadre WHERE idtarget = 23 AND idsocket = 1";
    String selectMOBOIntelbudgetpro="SELECT * FROM schedamadre WHERE idtarget = 23 AND idsocket = 2"; 
    String selectMOBOAMDbudgethigh="SELECT * FROM schedamadre WHERE idtarget = 24 AND idsocket = 1";
    String selectMOBOIntelbudgethigh="SELECT * FROM schedamadre WHERE idtarget = 24 AND idsocket = 2";
    
    //Select GFX
    String selectGFXufficio="SELECT * FROM idintegratedgfx WHERE idintegratedgfx = 1";
    String selectGFXbudget="SELECT * FROM schedavideo WHERE idtarget = 2";
    String selectGFXpro="SELECT * FROM schedavideo WHERE idtarget = 3";
    String selectGFXhigh="SELECT * FROM schedavideo WHERE idtarget = 4";
    String selectGFXbudgetpro="SELECT * FROM schedavideo WHERE idtarget = 23";
    String selectGFXbudgethigh="SELECT * FROM schedavideo WHERE idtarget = 24";
    
    //Select Tower
    String selectTowerUfficio="SELECT * FROM tower WHERE idtarget = 1";
    String selectTowerBudget="SELECT * FROM tower WHERE idtarget = 2";
    String selectTowerPro="SELECT * FROM tower WHERE idtarget = 3";
    String selectTowerHigh="SELECT * FROM tower WHERE idtarget = 4";
    String selectTowerBudgetpro="SELECT * FROM tower WHERE idtarget = 23";
    String selectTowerBudgethigh="SELECT * FROM tower WHERE idtarget = 24";
    
    java.sql.Connection connection=null;
            
    public Frame() throws Exception{
        
        Class.forName("org.postgresql.Driver");
        String dbUrl = "jdbc:postgresql://localhost:5432/gencomp";
        String userName = "leonardo";
        String userPassword = "postgres";
        connection = DriverManager.getConnection(dbUrl,userName,userPassword);
        connection.setAutoCommit(false);
        
        setTitle("Configuratore PC");
        p=new JPanel(new FlowLayout());
        pHDD=new JPanel(new FlowLayout());
        p2=new JPanel(new GridLayout(10,2,20,20));
        p3=new JPanel(new GridLayout(1,2,20,20));
        lbSelTarget=new JLabel("Seleziona il tuo target: ");
        scelta.addItem("Ufficio");
        scelta.addItem("Budget Gaming");
        scelta.addItem("Produttivita'");
        scelta.addItem("High End Gaming");
        generatore=new JButton("Genera");
        generatore.addActionListener(this);
        prezzo=new JButton("Aggiorna prezzi");
        prezzo.addActionListener(this);
        AMD=new JButton("AMD");
        INTEL=new JButton("INTEL");
        AMD.addActionListener(this);
        INTEL.addActionListener(this);
        lbPSU=new JLabel("Alimentatore: ");
        lbCPU=new JLabel("Processore: ");
        lbTower=new JLabel("Case: ");
        lbRAM=new JLabel("RAM: ");
        lbMOBO=new JLabel("Scheda madre: ");
        lbGFX=new JLabel("Scheda video: ");
        lbGFX2=new JLabel("Scheda video n.2: ");
        lbStorage=new JLabel("Storage: ");
        lbStorage2=new JLabel("Storage n.2: ");
        lbPrezzoPSU=new JLabel("----");
        lbPrezzoCPU=new JLabel("----");
        lbPrezzoTower=new JLabel("----");
        lbPrezzoGFX=new JLabel("----");
        lbPrezzoGFX2=new JLabel("----");
        lbPrezzoMOBO=new JLabel("----");
        lbPrezzoStorage=new JLabel("----");
        lbPrezzoStorage2=new JLabel("----");
        lbPrezzoRAM=new JLabel("----");
        lbTotDesc=new JLabel("Prezzo totale dei componenti = ");
        lbTotPrezzo=new JLabel("");
        p.add(lbSelTarget);
        p.add(scelta);
        pHDD.add(sceltaStorage);
        pHDD.add(sceltaStorage2);
        pHDD.add(generatore);
        pHDD.add(prezzo);
        p.add(pHDD);
        p.add(p2);
        p.add(p3);
        //---------
        p2.add(lbPSU);
        p2.add(sceltaPSU);
        p2.add(lbPrezzoPSU);
        
        p2.add(lbCPU);
        p2.add(sceltaCPU);
        p2.add(lbPrezzoCPU);
        
        p2.add(lbTower);
        p2.add(sceltaTower);
        p2.add(lbPrezzoTower);
        
        p2.add(lbRAM);
        p2.add(sceltaRAM);
        p2.add(lbPrezzoRAM);
        
        p2.add(lbMOBO);
        p2.add(sceltaMOBO);
        p2.add(lbPrezzoMOBO);
        
        p2.add(lbGFX);
        p2.add(sceltaGFX);
        p2.add(lbPrezzoGFX);
        
        p2.add(lbGFX2);
        p2.add(sceltaGFX2);
        p2.add(lbPrezzoGFX2);
        
        p2.add(lbStorage);
        p2.add(sceltaStorage);
        p2.add(lbPrezzoStorage);
        
        p2.add(lbStorage2);
        p2.add(sceltaStorage2);
        p2.add(lbPrezzoStorage2);
        //---------
        p3.add(AMD);
        p3.add(INTEL);
        p3.add(lbTotDesc);
        p3.add(lbTotPrezzo);
        c.add(p);
        setContentPane(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,520);
        setLocation(700,350);
        setVisible(true);
        
    }
        
    
    //Void SQL ---------------------------------------------
    
    public void sqlPSUufficio(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String watt=resultset.getString("wattaggio");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoPSUufficio.add(prezzo);
        sceltaPSU.add(marca+" "+modello+" "+watt+" W");
        }
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlPSUbudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String watt=resultset.getString("wattaggio");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoPSUbudget.add(prezzo);
        sceltaPSU.add(marca+" "+modello+" "+watt+" W");
        }
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlPSUpro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String watt=resultset.getString("wattaggio");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoPSUpro.add(prezzo);
        sceltaPSU.add(marca+" "+modello+" "+watt+" W");
        }
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlPSUhigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String watt=resultset.getString("wattaggio");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoPSUhigh.add(prezzo);
        sceltaPSU.add(marca+" "+modello+" "+watt+" W");
        }
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUAMDufficio(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUAMDufficio.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUINTELufficio(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUINTELufficio.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUAMDbudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUAMDbudget.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUINTELbudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUINTELbudget.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUAMDpro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUAMDpro.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUINTELpro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUINTELpro.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUAMDhigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUAMDhigh.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlCPUINTELhigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String freqCore=resultset.getString("frequenza core");
        String numCore=resultset.getString("numero core");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoCPUINTELhigh.add(prezzo);
        sceltaCPU.add(marca+" "+modello+" "+freqCore+" Mhz "+numCore+" Core");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlRAMufficio(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita");
        String freq=resultset.getString("frequenza");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoRAMufficio.add(prezzo);
        sceltaRAM.add(marca+" "+modello+" "+capacita+" Gb "+freq+" Mhz");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlRAMbudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita");
        String freq=resultset.getString("frequenza");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoRAMbudget.add(prezzo);
        sceltaRAM.add(marca+" "+modello+" "+capacita+" Gb "+freq+" Mhz");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlRAMpro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita");
        String freq=resultset.getString("frequenza");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoRAMpro.add(prezzo);
        sceltaRAM.add(marca+" "+modello+" "+capacita+" Gb "+freq+" Mhz");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlRAMhigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita");
        String freq=resultset.getString("frequenza");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoRAMhigh.add(prezzo);
        sceltaRAM.add(marca+" "+modello+" "+capacita+" Gb "+freq+" Mhz");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOAMDufficio(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOAMDufficio.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOINTELufficio(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOINTELufficio.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOAMDbudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOAMDbudget.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOINTELbudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOINTELbudget.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOAMDpro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOAMDpro.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOINTELpro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOINTELpro.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOAMDhigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOAMDhigh.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlMOBOINTELhigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoMOBOINTELhigh.add(prezzo);
        sceltaMOBO.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlGFXbudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita vram");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoGFXbudget.add(prezzo);
        sceltaGFX.add(marca+" "+modello+" "+capacita+" Gb");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlGFXpro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita vram");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoGFXpro.add(prezzo);
        sceltaGFX.add(marca+" "+modello+" "+capacita+" Gb");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlGFXhigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita vram");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoGFXhigh.add(prezzo);
        sceltaGFX.add(marca+" "+modello+" "+capacita+" Gb");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlGFX2pro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita vram");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoGFX2pro.add(prezzo);
        sceltaGFX2.add(marca+" "+modello+" "+capacita+" Gb");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlGFX2high(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita vram");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoGFX2high.add(prezzo);
        sceltaGFX2.add(marca+" "+modello+" "+capacita+" Gb");
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlTowerUfficio(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoTowerUfficio.add(prezzo);
        sceltaTower.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlTowerBudget(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoTowerBudget.add(prezzo);
        sceltaTower.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlTowerPro(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoTowerPro.add(prezzo);
        sceltaTower.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlTowerHigh(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoTowerHigh.add(prezzo);
        sceltaTower.add(marca+" "+modello);
        }
        
        
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlIntGFX(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
        String desc=resultset.getString("descrizione");
        
        sceltaGFX.add(desc);
        }
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlStorage(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoStorage.add(prezzo);
        sceltaStorage.add(marca+" "+modello+" "+capacita+" Gb");
        }
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    public void sqlStorage2(String select) throws Exception{
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        while(resultset.next()){
        String marca=resultset.getString("marca");
        String modello=resultset.getString("modello");
        String capacita=resultset.getString("capacita");
        Double prezzo=resultset.getDouble("prezzo");
        
        prezzoStorage2.add(prezzo);
        sceltaStorage2.add(marca+" "+modello+" "+capacita+" Gb");
        }
        
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        connection.commit();
        resultset.close();
    }
    
    //---------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource().equals(generatore)){
                
            if(scelta.getItem(scelta.getSelectedIndex())=="Ufficio"){
                sceltaPSU.removeAll();
                sceltaCPU.removeAll();
                sceltaRAM.removeAll();
                sceltaMOBO.removeAll();
                sceltaTower.removeAll();
                sceltaGFX.removeAll();
                sceltaGFX2.removeAll();
                
                try{
                sqlPSUufficio(selectPSUufficio);
                sqlCPUAMDufficio(selectCPUAMDufficio);
                sqlTowerUfficio(selectTowerUfficio);
                sqlRAMufficio(selectRAMufficio);
                sqlMOBOAMDufficio(selectMOBOAMDufficio);
                sqlIntGFX(selectGFXufficio);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Budget Gaming"){
                sceltaPSU.removeAll();
                sceltaCPU.removeAll();
                sceltaRAM.removeAll();
                sceltaMOBO.removeAll();
                sceltaTower.removeAll();
                sceltaGFX.removeAll();
                sceltaGFX2.removeAll();
                
                try{
                sqlPSUbudget(selectPSUbudget);
                sqlPSUbudget(selectPSUbudgetpro);
                sqlPSUbudget(selectPSUbudgethigh);
                sqlCPUAMDbudget(selectCPUAMDbudget);
                sqlTowerBudget(selectTowerBudget);
                sqlTowerBudget(selectTowerBudgetpro);
                sqlTowerBudget(selectTowerBudgethigh);
                sqlRAMbudget(selectRAMbudget);
                sqlRAMbudget(selectRAMbudgetpro);
                sqlRAMbudget(selectRAMbudgethigh);
                sqlMOBOAMDbudget(selectMOBOAMDbudget);
                sqlMOBOAMDbudget(selectMOBOAMDbudgetpro);
                sqlMOBOAMDbudget(selectMOBOAMDbudgethigh);
                sqlGFXbudget(selectGFXbudget);
                sqlGFXbudget(selectGFXbudgetpro);
                sqlGFXbudget(selectGFXbudgethigh);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Produttivita'"){
                sceltaPSU.removeAll();
                sceltaCPU.removeAll();
                sceltaRAM.removeAll();
                sceltaMOBO.removeAll();
                sceltaTower.removeAll();
                sceltaGFX.removeAll();
                sceltaGFX2.removeAll();
                
                try{
                sqlPSUpro(selectPSUpro);
                sqlPSUpro(selectPSUbudgetpro);
                sqlCPUAMDpro(selectCPUAMDpro);
                sqlTowerPro(selectTowerPro);
                sqlTowerPro(selectTowerBudgetpro);
                sqlRAMpro(selectRAMpro);
                sqlRAMpro(selectRAMbudgetpro);
                sqlMOBOAMDpro(selectMOBOAMDpro);
                sqlMOBOAMDpro(selectMOBOAMDbudgetpro);
                sqlGFXpro(selectGFXpro);
                sqlGFXpro(selectGFXbudgetpro);
                sqlGFX2pro(selectGFXpro);
                sqlGFX2pro(selectGFXbudgetpro);
                sceltaGFX2.add("Vuoto");
                prezzoGFX2pro.add(0.0);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="High End Gaming"){
                sceltaPSU.removeAll();
                sceltaCPU.removeAll();
                sceltaRAM.removeAll();
                sceltaMOBO.removeAll();
                sceltaTower.removeAll();
                sceltaGFX.removeAll();
                sceltaGFX2.removeAll();
                
                try{
                sqlPSUhigh(selectPSUhigh);
                sqlPSUhigh(selectPSUbudgethigh);
                sqlCPUAMDhigh(selectCPUAMDhigh);
                sqlTowerHigh(selectTowerHigh);
                sqlTowerHigh(selectTowerBudgethigh);
                sqlRAMhigh(selectRAMhigh);
                sqlRAMhigh(selectRAMbudgethigh);
                sqlMOBOAMDhigh(selectMOBOAMDhigh);
                sqlMOBOAMDhigh(selectMOBOAMDbudgethigh);
                sqlGFXhigh(selectGFXhigh);
                sqlGFXhigh(selectGFXbudgethigh);
                sqlGFX2high(selectGFXhigh);
                sqlGFX2high(selectGFXbudgethigh);
                sceltaGFX2.add("Vuoto");
                prezzoGFX2high.add(0.0);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            
            try{
            sceltaStorage.removeAll();
            sceltaStorage2.removeAll();
            sqlStorage(selectHDD1TB);
            sqlStorage(selectHDD2TB);
            sqlStorage(selectSSD240GB);
            sqlStorage(selectSSD480GB);
            sqlStorage(selectSSD960GB);
            sqlStorage2(selectHDD1TB);
            sqlStorage2(selectHDD2TB);
            sqlStorage2(selectSSD240GB);
            sqlStorage2(selectSSD480GB);
            sqlStorage2(selectSSD960GB);
            sceltaStorage2.add("Vuoto");
            prezzoStorage2.add(0.0);
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            SwingUtilities.updateComponentTreeUI(p);
            
        }
        
        else if(e.getSource().equals(AMD)){
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Ufficio"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUAMDufficio(selectCPUAMDufficio);
            sqlMOBOAMDufficio(selectMOBOAMDufficio);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Budget Gaming"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUAMDbudget(selectCPUAMDbudget);
            sqlCPUAMDbudget(selectCPUAMDbudgetpro);
            sqlCPUAMDbudget(selectCPUAMDbudgethigh);
            sqlMOBOAMDbudget(selectMOBOAMDbudget);
            sqlMOBOAMDbudget(selectMOBOAMDbudgetpro);
            sqlMOBOAMDbudget(selectMOBOAMDbudgethigh);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Produttivita'"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUAMDpro(selectCPUAMDpro);
            sqlCPUAMDpro(selectCPUAMDbudgetpro);
            sqlMOBOAMDpro(selectMOBOAMDpro);
            sqlMOBOAMDpro(selectMOBOAMDbudgetpro);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="High End Gaming"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUAMDhigh(selectCPUAMDhigh);
            sqlCPUAMDhigh(selectCPUAMDbudgethigh);
            sqlMOBOAMDhigh(selectMOBOAMDhigh);
            sqlMOBOAMDhigh(selectMOBOAMDbudgethigh);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
        }
        
        else if(e.getSource().equals(INTEL)){
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Ufficio"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUINTELufficio(selectCPUIntelUfficio);
            sqlMOBOINTELufficio(selectMOBOIntelUfficio);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Budget Gaming"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUINTELbudget(selectCPUIntelbudget);
            sqlCPUINTELbudget(selectCPUIntelbudgetpro);
            sqlCPUINTELbudget(selectCPUIntelbudgethigh);
            sqlMOBOINTELbudget(selectMOBOIntelbudget);
            sqlMOBOINTELbudget(selectMOBOIntelbudgetpro);
            sqlMOBOINTELbudget(selectMOBOIntelbudgethigh);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Produttivita'"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUINTELpro(selectCPUIntelpro);
            sqlCPUINTELpro(selectCPUIntelbudgetpro);
            sqlMOBOINTELpro(selectMOBOIntelpro);
            sqlMOBOINTELpro(selectMOBOIntelbudgetpro);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
            if(scelta.getItem(scelta.getSelectedIndex())=="High End Gaming"){
            sceltaCPU.removeAll();
            sceltaMOBO.removeAll();
            try{
            sqlCPUINTELhigh(selectCPUIntelhigh);
            sqlCPUINTELhigh(selectCPUIntelbudgethigh);
            sqlMOBOINTELhigh(selectMOBOIntelhigh);
            sqlMOBOINTELhigh(selectMOBOIntelbudgethigh);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }
            
        }
        
        if(e.getSource().equals(prezzo)){
            
            DecimalFormat df=new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Ufficio") {
         
            Double PSUPrezzo=prezzoPSUufficio.get(sceltaPSU.getSelectedIndex());
            Double CPUAMDPrezzo=prezzoCPUAMDufficio.get(sceltaCPU.getSelectedIndex());
            Double RAMPrezzo=prezzoRAMufficio.get(sceltaRAM.getSelectedIndex());
            Double MOBOAMDPrezzo=prezzoMOBOAMDufficio.get(sceltaMOBO.getSelectedIndex());
            Double TowerPrezzo=prezzoTowerUfficio.get(sceltaTower.getSelectedIndex());
            Double StoragePrezzo=prezzoStorage.get(sceltaStorage.getSelectedIndex());
            Double Storage2Prezzo=prezzoStorage2.get(sceltaStorage2.getSelectedIndex());
            
            
            
            
            
            String TotalePrezziAMD=df.format(PSUPrezzo+CPUAMDPrezzo+RAMPrezzo+MOBOAMDPrezzo+TowerPrezzo+StoragePrezzo+Storage2Prezzo);
            
            lbPrezzoPSU.setText("€ "+Double.toString(PSUPrezzo));
            lbPrezzoCPU.setText("€ "+Double.toString(CPUAMDPrezzo));
            lbPrezzoRAM.setText("€ "+Double.toString(RAMPrezzo));
            lbPrezzoMOBO.setText("€ "+Double.toString(MOBOAMDPrezzo));
            lbPrezzoTower.setText("€ "+Double.toString(TowerPrezzo));
            lbPrezzoGFX.setText("---");
            lbPrezzoGFX2.setText("---");
            lbPrezzoStorage.setText("€ "+Double.toString(StoragePrezzo));
            lbPrezzoStorage2.setText("€ "+Double.toString(Storage2Prezzo));
            lbTotPrezzo.setText("€ "+TotalePrezziAMD);
            }
            
            
            if(scelta.getItem(scelta.getSelectedIndex())=="Budget Gaming"){
                
            Double PSUPrezzo=prezzoPSUbudget.get(sceltaPSU.getSelectedIndex());
            Double CPUAMDPrezzo=prezzoCPUAMDbudget.get(sceltaCPU.getSelectedIndex());
            Double RAMPrezzo=prezzoRAMbudget.get(sceltaRAM.getSelectedIndex());
            Double MOBOAMDPrezzo=prezzoMOBOAMDbudget.get(sceltaMOBO.getSelectedIndex());
            Double TowerPrezzo=prezzoTowerBudget.get(sceltaTower.getSelectedIndex());
            Double GFXPrezzo=prezzoGFXbudget.get(sceltaGFX.getSelectedIndex());
            Double StoragePrezzo=prezzoStorage.get(sceltaStorage.getSelectedIndex());
            Double Storage2Prezzo=prezzoStorage2.get(sceltaStorage2.getSelectedIndex());
            
            String TotalePrezziAMD=df.format(PSUPrezzo+CPUAMDPrezzo+RAMPrezzo+MOBOAMDPrezzo+TowerPrezzo+GFXPrezzo+StoragePrezzo+Storage2Prezzo);
            
            lbPrezzoPSU.setText("€ "+Double.toString(PSUPrezzo));
            lbPrezzoCPU.setText("€ "+Double.toString(CPUAMDPrezzo));
            lbPrezzoRAM.setText("€ "+Double.toString(RAMPrezzo));
            lbPrezzoMOBO.setText("€ "+Double.toString(MOBOAMDPrezzo));
            lbPrezzoTower.setText("€ "+Double.toString(TowerPrezzo));
            lbPrezzoGFX.setText("€ "+Double.toString(GFXPrezzo));
            lbPrezzoGFX2.setText("---");
            lbPrezzoStorage.setText("€ "+Double.toString(StoragePrezzo));
            lbPrezzoStorage2.setText("€ "+Double.toString(Storage2Prezzo));
            lbTotPrezzo.setText("€ "+TotalePrezziAMD);
            }
            
            else if(scelta.getItem(scelta.getSelectedIndex())=="Produttivita'"){
                
            Double PSUPrezzo=prezzoPSUpro.get(sceltaPSU.getSelectedIndex());
            Double CPUAMDPrezzo=prezzoCPUAMDpro.get(sceltaCPU.getSelectedIndex());
            Double RAMPrezzo=prezzoRAMpro.get(sceltaRAM.getSelectedIndex());
            Double MOBOAMDPrezzo=prezzoMOBOAMDpro.get(sceltaMOBO.getSelectedIndex());
            Double TowerPrezzo=prezzoTowerPro.get(sceltaTower.getSelectedIndex());
            Double GFXPrezzo=prezzoGFXpro.get(sceltaGFX.getSelectedIndex());
            Double GFX2Prezzo=prezzoGFX2pro.get(sceltaGFX2.getSelectedIndex());
            Double StoragePrezzo=prezzoStorage.get(sceltaStorage.getSelectedIndex());
            Double Storage2Prezzo=prezzoStorage2.get(sceltaStorage2.getSelectedIndex());
            
            String TotalePrezziAMD=df.format(PSUPrezzo+CPUAMDPrezzo+RAMPrezzo+MOBOAMDPrezzo+TowerPrezzo+GFXPrezzo+GFX2Prezzo+StoragePrezzo+Storage2Prezzo);
            
            lbPrezzoPSU.setText("€ "+Double.toString(PSUPrezzo));
            lbPrezzoCPU.setText("€ "+Double.toString(CPUAMDPrezzo));
            lbPrezzoRAM.setText("€ "+Double.toString(RAMPrezzo));
            lbPrezzoMOBO.setText("€ "+Double.toString(MOBOAMDPrezzo));
            lbPrezzoTower.setText("€ "+Double.toString(TowerPrezzo));
            lbPrezzoGFX.setText("€ "+Double.toString(GFXPrezzo));
            lbPrezzoGFX2.setText("€ "+Double.toString(GFX2Prezzo));
            lbPrezzoStorage.setText("€ "+Double.toString(StoragePrezzo));
            lbPrezzoStorage2.setText("€ "+Double.toString(Storage2Prezzo));
            lbTotPrezzo.setText("€ "+TotalePrezziAMD);
            }
            
            else if(scelta.getItem(scelta.getSelectedIndex())=="High End Gaming"){
                
            Double PSUPrezzo=prezzoPSUhigh.get(sceltaPSU.getSelectedIndex());
            Double CPUAMDPrezzo=prezzoCPUAMDhigh.get(sceltaCPU.getSelectedIndex());
            Double RAMPrezzo=prezzoRAMhigh.get(sceltaRAM.getSelectedIndex());
            Double MOBOAMDPrezzo=prezzoMOBOAMDhigh.get(sceltaMOBO.getSelectedIndex());
            Double TowerPrezzo=prezzoTowerHigh.get(sceltaTower.getSelectedIndex());
            Double GFXPrezzo=prezzoGFXhigh.get(sceltaGFX.getSelectedIndex());
            Double GFX2Prezzo=prezzoGFX2high.get(sceltaGFX2.getSelectedIndex());
            Double StoragePrezzo=prezzoStorage.get(sceltaStorage.getSelectedIndex());
            Double Storage2Prezzo=prezzoStorage2.get(sceltaStorage2.getSelectedIndex());
            
            String TotalePrezziAMD=df.format(PSUPrezzo+CPUAMDPrezzo+RAMPrezzo+MOBOAMDPrezzo+TowerPrezzo+GFXPrezzo+GFX2Prezzo+StoragePrezzo+Storage2Prezzo);
            
            lbPrezzoPSU.setText("€ "+Double.toString(PSUPrezzo));
            lbPrezzoCPU.setText("€ "+Double.toString(CPUAMDPrezzo));
            lbPrezzoRAM.setText("€ "+Double.toString(RAMPrezzo));
            lbPrezzoMOBO.setText("€ "+Double.toString(MOBOAMDPrezzo));
            lbPrezzoTower.setText("€ "+Double.toString(TowerPrezzo));
            lbPrezzoGFX.setText("€ "+Double.toString(GFXPrezzo));
            lbPrezzoGFX2.setText("€ "+Double.toString(GFX2Prezzo));
            lbPrezzoStorage.setText("€ "+Double.toString(StoragePrezzo));
            lbPrezzoStorage2.setText("€ "+Double.toString(Storage2Prezzo));
            lbTotPrezzo.setText("€ "+TotalePrezziAMD);
            }
            
            /*Double CPUINTELPrezzo=prezzoCPUINTELufficio.get(sceltaCPU.getSelectedIndex());
            Double MOBOINTELPrezzo=prezzoMOBOINTELufficio.get(sceltaMOBO.getSelectedIndex());
            String TotalePrezziINTEL=df.format(PSUPrezzo+CPUINTELPrezzo+RAMPrezzo+MOBOINTELPrezzo+TowerPrezzo+StoragePrezzo+Storage2Prezzo);
            */
            
            
            
            
            
            
            
            
            
            
        }
    }
}

