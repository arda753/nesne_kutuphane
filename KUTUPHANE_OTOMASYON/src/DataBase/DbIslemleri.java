package DataBase;

import Bilgiler.UyeKitap;
import Bilgiler.MevcutKitapBilgileri;
import Bilgiler.KayitliUyelerinBilgileri;
import Bilgiler.KayitliAdminBilgileri;
import DataBase.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbIslemleri extends DataBase {

    private Connection con ;
    private Statement statement ;
    private PreparedStatement preparedstatement = null;
    
    
    public DbIslemleri(){
        this.statement = null;
        this.con = null;
        
        
        // Yukarıdaki özelliklerle url oluşturmalıyız..
        // "jdbc:mysql://localhost:3306/demo
        String url = "jdbc:mysql://" + HOST + ":" + PORT_NUMARASI + "/" + DB_ISMI + "?useUnicode=true&characterEncoding=utf8";
        //Sondaki karmaşık kod Türkçe karakterlerin sıkıntı çıkarmaması için..
        try {
            //Veri tabanına bağlanmak için gerekli olan Driver'ı başlatmalyız.
            Class.forName ("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı...");
        }
        
        try {
            con = DriverManager.getConnection(url, KULLANICI_ADI, PAROLA);
            System.out.println("Bağlantı Başarılı...");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
        }
    }
    
    public boolean admin_giris_yap(String k_adi1, String sifre1){
        
        String sorgu = ("Select * From admin_bilgileri where KULLANICI_ADI = ? and ŞİFRE = ?");
        
        try {
            preparedstatement = con.prepareStatement(sorgu);
            preparedstatement.setString(1, k_adi1); //1. soru işareti yerine k_adi1 atandı
            preparedstatement.setString(2, sifre1);
            
            // sorguyu çalıştır ve bu sorgudan dönen değeri resultsete ata
            ResultSet rs = preparedstatement.executeQuery();
            
            if (rs.next() == false)
                return false;
            
            else 
                return true;
             
            
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean uye_giris_yap(String k_adi2, String sifre2){
        
        String sorgu = ("Select * From üye_bilgisi where KULLANICI_ADI = ? and ŞİFRE = ?");
        
        try {
            preparedstatement = con.prepareStatement(sorgu);
            preparedstatement.setString(1, k_adi2); //1. soru işareti yerine k_adi1 atandı
            preparedstatement.setString(2, sifre2);
            
            // sorguyu çalıştır ve bu sorgudan dönen değeri resultsete ata
            ResultSet rs = preparedstatement.executeQuery();
            
            if (rs.next() == false)
                return false;
            
            else 
                return true;
             
            
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    public void uye_ekle (String ad, String soyad, String k_adi, String sifre, String departman, String iliski){
        
        String sorgu = ("Insert Into üye_bilgisi (ADI, SOYADI, KULLANICI_ADI, ŞİFRE, YETKİ, ÜYE_NO) VALUES (?,?,?,?,?,?)");
        try {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setString(1, ad);
            preparedstatement.setString(2, soyad);
            preparedstatement.setString(3, k_adi);
            preparedstatement.setString(4, sifre);
            preparedstatement.setString(5, departman);
            preparedstatement.setString(6, iliski);
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kitap_ekle (String k_adı, String y_adı, String y_soyadı, String yayin_evi, String kitap_turu, int kitap_adedi){
        String sorgu = ("Insert Into kitap_bilgisi (KİTAP_ADI, YAZAR_ADI, YAZAR_SOYADI, YAYINEVİ, KİTAP_TÜRÜ, KİTAP_MİKTARI) VALUES (?,?,?,?,?,?)");
        
        try {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setString(1, k_adı);
            preparedstatement.setString(2, y_adı);
            preparedstatement.setString(3, y_soyadı);
            preparedstatement.setString(4, yayin_evi);
            preparedstatement.setString(5, kitap_turu);
            preparedstatement.setInt(6, kitap_adedi);
            
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }   

    public ArrayList<KayitliUyelerinBilgileri> uye_goster(){
        
        ArrayList<KayitliUyelerinBilgileri>  arraylist2= new ArrayList<KayitliUyelerinBilgileri>();
        
        try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From üye_bilgisi");
            while (rs.next()){
                int id = rs.getInt("ID");
                String ad = rs.getString("ADI");
                String soyad = rs.getString("SOYADI");
                String k_adi = rs.getString("KULLANICI_ADI");
                String sifre = rs.getString("ŞİFRE");
                String yetki = rs.getString("YETKİ");
                
                arraylist2.add(new KayitliUyelerinBilgileri(id,ad,soyad,k_adi,sifre,yetki));
    
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return arraylist2;
    }
    
    public ArrayList<KayitliAdminBilgileri> admin_goster(){
        ArrayList<KayitliAdminBilgileri>  arraylist3= new ArrayList<KayitliAdminBilgileri>();
        
        try {
            statement = con.createStatement();          
            ResultSet rs = statement.executeQuery("Select * From admin_bilgileri");
            while (rs.next()){
                int id = rs.getInt("ID");
                String ad = rs.getString("ADI");
                String soyad = rs.getString("SOYADI");
                String k_adi = rs.getString("KULLANICI_ADI");
                String sifre = rs.getString("ŞİFRE");
                String yetki = rs.getString("YETKİ");
                
                arraylist3.add(new KayitliAdminBilgileri(ad,soyad,k_adi));
    
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return arraylist3;
    }
    
    public ArrayList<MevcutKitapBilgileri> kitap_goster (){
        
        ArrayList<MevcutKitapBilgileri>  arraylist4= new ArrayList<MevcutKitapBilgileri>();
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select * From kitap_bilgisi");
            while (rs.next()){
                int id = rs.getInt("ID");
                String k_adı = rs.getString("KİTAP_ADI");
                String y_adı = rs.getString("YAZAR_ADI");
                String y_soyadı = rs.getString("YAZAR_SOYADI");
                String yayinevi = rs.getString("YAYINEVİ");
                String k_turu = rs.getString("KİTAP_TÜRÜ");
                int adet = rs.getInt("KİTAP_MİKTARI");
                
                
                arraylist4.add(new MevcutKitapBilgileri(id,k_adı,y_adı,y_soyadı,yayinevi,k_turu,adet));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return arraylist4;
        
    }
    
    
    
    public void kayitGuncelle(int id,String ad, String soyad, String k_adi, String sifre, String yetki){
        
        String sorgu = "Update üye_bilgisi set ADI = ? , SOYADI = ? , KULLANICI_ADI = ? , ŞİFRE = ? , YETKİ = ? where ID = ? ";
        
        try {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setString(1,ad);
            preparedstatement.setString(2, soyad);
            preparedstatement.setString(3,k_adi);
            preparedstatement.setString(4,sifre);
            preparedstatement.setString(5,yetki);
            preparedstatement.setInt(6,id);
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kitap_guncelle (int id, String k_adi, String y_adi, String y_soyadi, String yayinevi, String k_turu, int k_miktari){
        
        
        String sorgu = "Update kitap_bilgisi set KİTAP_ADI = ?, YAZAR_ADI = ?, YAZAR_SOYADI = ?, YAYINEVİ = ?, KİTAP_TÜRÜ = ?, KİTAP_MİKTARI = ? where ID = ? ";
        
        try {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setString(1,k_adi);
            preparedstatement.setString(2, y_adi);
            preparedstatement.setString(3,y_soyadi);
            preparedstatement.setString(4,yayinevi);
            preparedstatement.setString(5,k_turu);
            preparedstatement.setInt(6,k_miktari);
            
            preparedstatement.setInt(7,id);
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void alici_kitap_iliskisi_kur(int id, int no){
        
        
        try {
            
            preparedstatement = con.prepareStatement("Update üye_bilgisi set ÜYE_NO = ? where ID = ?;");
            preparedstatement.setInt(1,no);
            preparedstatement.setInt(2,id);
            
            preparedstatement.executeUpdate();
                
               
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<UyeKitap> uye_kitap_goster(){
        
        ArrayList<UyeKitap> test = new ArrayList<UyeKitap>();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select üye_bilgisi.ID, üye_bilgisi.ADI, üye_bilgisi.SOYADI, üye_bilgisi.KULLANICI_ADI,kitap_bilgisi.KİTAP_ADI,kitap_bilgisi.YAZAR_ADI,kitap_bilgisi.YAZAR_SOYADI From üye_bilgisi, kitap_bilgisi Where üye_bilgisi.ÜYE_NO = kitap_bilgisi.ID ");
            while (rs.next()){
                int u_id = rs.getInt("ID");
                String u_adi = rs.getString("ADI");
                String u_soyadi = rs.getString("SOYADI");
                String u_kadi = rs.getString("KULLANICI_ADI");
                
                String k_adi= rs.getString("KİTAP_ADI");
                String y_adi= rs.getString("YAZAR_ADI");
                String y_soyadi= rs.getString("YAZAR_SOYADI");
                
                test.add(new UyeKitap(u_id, u_adi, u_soyadi, u_kadi,k_adi, y_adi, y_soyadi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return test;
    }
    
        
    
    public void uye_sil(int id){
        
        String sorgu = "Delete from üye_bilgisi where ID = ?";
        
        try {
            preparedstatement = con.prepareStatement(sorgu);
            preparedstatement.setInt(1,id);
            preparedstatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DbIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


    




    

