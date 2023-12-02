public class MarriedJointlyTaxBracket extends TaxBracket{
    public MarriedJointlyTaxBracket(double income){
        this.income = income;
        if(income < 22000){
            this.taxRate = 0.10;
        }else if(income < 89450){
            this.taxRate = 0.12;
        }else if(income < 190750){
            this.taxRate = 0.22;
        }else if(income < 364200){
            this.taxRate = 0.24;
        }else if(income < 462500){
            this.taxRate = 0.32;
        }else if(income < 693750){
            this.taxRate = 0.35;
        }else{
            this.taxRate = 0.37;
        }
    }
}
