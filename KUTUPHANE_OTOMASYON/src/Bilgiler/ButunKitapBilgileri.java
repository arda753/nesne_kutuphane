package Bilgiler;


public abstract class ButunKitapBilgileri {
    
    private String kitap_adi;
    private String yazar_adi;
    private String yazar_soyadi;
    private String yayin_evi;
    private String kitap_turu;
    private int miktar;
    
    
    public void ekle (){
        System.out.println("Abstract çalışıyor");
    }
    
    public abstract String getKitap_adi();
    
    public abstract String getYazar_adi();
    
    public abstract String getYazar_soyadi();
    
    public abstract String getYayin_evi();
 
    public abstract String getKitap_turu();
    
    public abstract int getMiktar();
    
    

    public abstract void setKitap_adi(String kitap_adi);

    public abstract void setYazar_adi(String yazar_adi) ;

    public abstract void setYazar_soyadi(String yazar_soyadi);

    public abstract void setYayin_evi(String yayin_evi);

    public abstract void setKitap_turu(String kitap_turu);
   
}
