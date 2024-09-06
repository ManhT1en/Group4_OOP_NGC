package ktragk.ex1;

public class ContinuousSignal implements Signal{
    private double Biendo;
    private double ChuKi;
    private double BuocSong;
    private double TanSo;
    

    public ContinuousSignal(double Biendo,double ChuKi,double BuocSong, double TanSo){
        this.Biendo = Biendo;
        this.ChuKi = ChuKi;
        this.BuocSong = BuocSong;
        this.TanSo = TanSo;
    }

    @Override
    public double getBienDo(){
        return Biendo;
    }

    @Override
    public double getChuKi(){
        return ChuKi;
    }

    @Override
    public double getBuocSong(){
        return BuocSong;
    }
    @Override
    public double getTanSo(){
        return TanSo;
    }
    public void displayContinuousSignal(){
        System.out.println("processing Continuous Signal");
    }
}