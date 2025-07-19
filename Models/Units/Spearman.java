package Models.Units;

public class Spearman extends Units {
    public Spearman() {
        super(25,1,10,2,25,25,1);
    }
    public void attack() {
    }
        public void updrage() {
            unitHealth*=2;
            attackPower*=2;
            unitfood++;
        }

    @Override
    public String getType(){
        return "Spearman";
    }
}
