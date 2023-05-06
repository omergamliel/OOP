public class Clothing {

    //Features:
    private String clothingType;        //The type of garment.
    private String barCode;             //Unique barcode.
    private double price;               //The price of the garment.
    private String gender_fit;          //Matching the garment to the gender.
    private boolean isSale;             //Is the garment discounted.

    //Constructors:
    public Clothing(String clothingType, String barCode, double price, String gender_fit, boolean isSale) {
        setClothingType(clothingType);
        setBarCode(barCode);
        setPrice(price);
        setGender_fit(gender_fit);
        setSale(isSale);
    }

    public Clothing(String clothingType, String barCode, double price, String gender_fit) {
        setClothingType(clothingType);
        setBarCode(barCode);
        setPrice(price);
        setGender_fit(gender_fit);
        setSale(true);
    }

    //Set:
    public void setClothingType(String clothingType) {
        if(checkClothingType(clothingType)){
            this.clothingType = clothingType;
            System.out.println("ClothingType: The value ("+clothingType+") has been successfully updated."); //User feedback - success
        }
        else{
            System.out.println("ClothingType: The value ("+clothingType+") was not updated."); //User feedback - failure
        }
    }

    public void setBarCode(String barCode) {
        if(checkBarCode(barCode)){
            this.barCode = barCode;
            System.out.println("BarCode: The value ("+barCode+") has been successfully updated."); //User feedback - success
        }
        else{
            System.out.println("BarCode: The value ("+barCode+") was not updated."); //User feedback - failure
        }
    }

    public void setPrice(double price) {
        if(checkPrice(price)){
            this.price = price;
            System.out.println("Price: The value ("+price+") has been successfully updated."); //User feedback - success
        }
        else{
            System.out.println("Price: The value ("+price+") was not updated."); //User feedback - failure
        }
    }

    public void setGender_fit(String gender_fit) {
        if(checkGender(gender_fit)){
            this.gender_fit = gender_fit;
            System.out.println("Gender Fit: The value ("+gender_fit+") has been successfully updated."); //User feedback - success
        }
        else{
            System.out.println("Gender Fit: The value ("+gender_fit+") was not updated."); //User feedback - failure
        }
    }

    public void setSale(boolean sale) {
        isSale = sale;
        System.out.println("Sale: The value ("+sale+") has been successfully updated."); //User feedback - success
    }

    //Get:
    public String getClothingType() {
        return clothingType;
    }

    public String getBarCode() {
        return barCode;
    }

    public double getPrice() {
        return price;
    }

    public String getGender_fit() {
        return gender_fit;
    }

    public boolean isSale() {
        return isSale;
    }

    //Equals:
    public boolean equals(Clothing obj) {
        return this.clothingType.equals(obj.clothingType) && this.barCode.equals(obj.barCode);
    }

    //toString:
    public String toString(){
        return "\n Features of the garment:\n"+
                "1) Clothing type: "+clothingType+"\n"+
                "2) Bar Code: "+barCode+"\n"+
                "3) Price: "+price+"\n"+
                "4) Gender: "+gender_fit+"\n"+
                "5) Is On Sale?: "+isSale;
    }

    //Methods:

    //A method that checks if the user value has only letters and has at least 5 characters.
    public boolean checkClothingType(String clothingTypeCheck) {
        final int MIN_LENGTH = 5; //Fixed number - defined as final.
        int clothingTypeLen = clothingTypeCheck.length();
        for (int i = 0; i < clothingTypeLen; i++) {
            if (!Character.isLetter(clothingTypeCheck.charAt(i))) {
                return false;
            }
        }
        return clothingTypeLen >= MIN_LENGTH;
    }

    /* A method that checks if the user value has only
    letters and numbers together and has more than 8 characters. */
    public boolean checkBarCode(String barCodeCheck) {
        final int MIN_LENGTH = 8; //Fixed number - defined as final.
        int barCodeLen = barCodeCheck.length();
        boolean numberValue=false, lettersValue=false;

        if(barCodeLen>MIN_LENGTH) {
            for (int i = 0; i < barCodeLen; i++) {
                if (Character.isLetter(barCodeCheck.charAt(i))) {
                    lettersValue = true;
                } else if (Character.isDigit(barCodeCheck.charAt(i))) {
                    numberValue = true;
                } else {
                    return false;
                }
            }
            return numberValue && lettersValue;
        }
        return false;
    }

    //A method that checks if the user's value is greater than 50.
    public boolean checkPrice(double price){
        final int MIN_PRICE = 50; //Fixed number - defined as final.
        return price>MIN_PRICE;
    }

    /*A method that checks if the user value is: male/female/both only.
    (the size of the letters does not matter) */
    public boolean checkGender(String gender){
        return gender.equalsIgnoreCase("Male")||
                gender.equalsIgnoreCase("Female")||
                gender.equalsIgnoreCase("Both");
    }

    //A method that checks if the price of the garment is less than 70 and at a discount.
    public boolean greatDeal(){
        final int MAX_DEAL = 70; //Fixed number - defined as final.
        return price<MAX_DEAL && isSale;
    }
}