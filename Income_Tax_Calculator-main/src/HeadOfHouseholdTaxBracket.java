public class HeadOfHouseholdTaxBracket extends TaxBracket{
    public HeadOfHouseholdTaxBracket(double income){
        this.income = income;
        if(income < 15700){
            this.taxRate = 0.10;
        }else if(income < 59850){
            this.taxRate = 0.12;
        }else if(income < 95350){
            this.taxRate = 0.22;
        }else if(income < 182100){
            this.taxRate = 0.24;
        }else if(income < 231250){
            this.taxRate = 0.32;
        }else if(income < 578100){
            this.taxRate = 0.35;
        }else{
            this.taxRate = 0.37;
        }


    }
}
