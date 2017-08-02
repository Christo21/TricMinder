package cdfy.tricminder01;

public class User {
    private String id_pelanggan;
    private String no_meter;
    private String name;
    private String tarif;
    private String daya;

    public User(){

    }

    public String getId_pelanggan(){
        return id_pelanggan;
    }
    public String getNo_meter(){
        return no_meter;
    }
    public String getName(){
        return name;
    }
    public String getTarif(){
        return tarif;
    }
    public String getDaya(){
        return daya;
    }

    public void setData(String id_pelanggan, String no_meter, String name, String tarif, String daya){
        this.id_pelanggan = id_pelanggan;
        this.no_meter = no_meter;
        this.name = name;
        this.tarif = tarif;
        this.daya = daya;
    }
}
