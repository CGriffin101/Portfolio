
public class SingleTaxBracket extends TaxBracket{
    public SingleTaxBracket(double income){
        this.income = income;
        if(income < 11000){
            this.taxRate = 0.10;
        }else if(income < 44725){
            this.taxRate = 0.12;
        }else if(income < 95375){
            this.taxRate = 0.22;
        }else if(income < 182100){
            this.taxRate = 0.24;
        }else if(income < 231250){
            this.taxRate = 0.32;
        }else if(income < 578125){
            this.taxRate = 0.35;
        }else{
            this.taxRate = 0.37;
        }
    }
}
