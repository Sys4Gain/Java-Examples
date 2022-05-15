package moto;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Moto{
    
    /*String marca,modello,motore,link;
    int cc,cv,nm,prezzo,idmoto;
    
    public Moto(String marca,String modello,int cc,String motore,int cv,int nm,int prezzo,int idmoto,String link){
        
        this.marca=marca;
        this.modello=modello;
        this.cc=cc;
        this.motore=motore;
        this.cv=cv;
        this.nm=nm;
        this.prezzo=prezzo;
        this.idmoto=idmoto;
        this.link=link;
        
    }*/
    
    String selectMoto="SELECT * FROM motoa2";
    java.sql.Connection connection=null;
    
    public Moto() throws Exception{
        
        Class.forName("org.postgresql.Driver");
        String dbUrl = "jdbc:postgresql://localhost:5432/moto";
        String userName = "leonardo";
        String userPassword = "postgres";
        connection = DriverManager.getConnection(dbUrl,userName,userPassword);
        connection.setAutoCommit(false);
        
        sqlMoto(selectMoto);
    }
    
    
    public void sqlMoto(String select) throws Exception{
        
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultset=statement.executeQuery(select);
        
        while(resultset.next()){
            
            String marca=resultset.getString("marca");
            String modello=resultset.getString("modello");
            int cc=resultset.getInt("cc");
            String motore=resultset.getString("motore");
            int cv=resultset.getInt("cv");
            int nm=resultset.getInt("nm");
            int prezzo=resultset.getInt("prezzo");
            int idmoto=resultset.getInt("idmoto");
            String link=resultset.getString("link");
            
            System.out.println(marca+" "+modello+" "+cc+"cc "+motore+" "+cv+"cv "+nm+"nm "+prezzo+"euro id moto="+idmoto+" link="+link);
            
            if(connection!=null){
            try{
                connection.rollback();
            }catch(SQLException sqlEx){
                sqlEx.printStackTrace();
            }
            }
        
        }
        connection.commit();
        resultset.close();
    }
    
    
}
