package Bilgiler;


public class UyeKitap {
    
    private int u_id;
    private String u_adi;
    private String u_soyadi;
    private String u_kadi;
    private String k_adi;
    private String k_yadi;
    private String k_ysoyadi;
    

    public UyeKitap(int u_id, String u_adi, String u_soyadi, String u_kadi,String k_adi,String k_yadi,String k_ysoyadi) {
        this.u_id = u_id;
        this.u_adi = u_adi;
        this.u_soyadi = u_soyadi;
        this.u_kadi = u_kadi;
        this.k_adi = k_adi;
        this.k_yadi = k_yadi;
        this.k_ysoyadi = k_ysoyadi;
        
    }

    public String getK_adi() {
        return k_adi;
    }

    public String getK_yadi() {
        return k_yadi;
    }

    public String getK_ysoyadi() {
        return k_ysoyadi;
    }

    public int getU_id() {
        return u_id;
    }

    public String getU_adi() {
        return u_adi;
    }

    public String getU_soyadi() {
        return u_soyadi;
    }

    public String getU_kadi() {
        return u_kadi;
    }

    
}
