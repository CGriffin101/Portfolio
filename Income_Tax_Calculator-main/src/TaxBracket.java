public class TaxBracket {
    double taxRate;
    double income;
    TaxBracket(){
    }
    public double getTaxAmount(){
        return income * taxRate;
    }
}
