import java.util.ArrayList;

public class Store {

    //Features:
    private String storeName;
    private String address;
    private String dayNightCloth;
    private String openHours;
    private ArrayList<Clothing> clothesList;

    //Constructors:
    public Store(String storeName, String address, String dayNightCloth, String openHours) {
        setStoreName(storeName);
        setAddress(address);
        setDayNightCloth(dayNightCloth);
        setOpenHours(openHours);
        this.clothesList = new ArrayList<Clothing>();
    }

    //Set:
    public void setStoreName(String storeName) {
        if(checkStoreName(storeName)){
            this.storeName = storeName;
            System.out.println("Store Name: The value ("+storeName+") has been successfully updated."); //User feedback - success
        }
        else{
            System.out.println("Store Name: The value ("+storeName+") was not updated."); //User feedback - failure
        }
    }

    public void setAddress(String address) {
        System.out.println("Address: The value ("+address+") has been successfully updated."); //User feedback - success
        this.address = address;
    }

    public void setDayNightCloth(String dayNightCloth) {
        if(checkDayNightCloth(dayNightCloth)){
            this.dayNightCloth = dayNightCloth;
            System.out.println("Day Night Cloth: The value ("+dayNightCloth+") has been successfully updated."); //User feedback - success
        }
        else{
            System.out.println("Day Night Cloth: The value ("+dayNightCloth+") was not updated."); //User feedback - failure
        }
    }

    public void setOpenHours(String openHours) {
        if(checkOpenHours(openHours)){
            this.openHours = openHours;
            System.out.println("Open Hours: The value ("+openHours+") has been successfully updated."); //User feedback - success
        }
        else{
            System.out.println("Open Hours: The value ("+openHours+") was not updated."); //User feedback - failure
        }
    }

    //Get:
    public String getStoreName() {
        return storeName;
    }

    public String getAddress() {
        return address;
    }

    public String getDayNightCloth() {
        return dayNightCloth;
    }

    public String getOpenHours() {
        return openHours;
    }

    public ArrayList<Clothing> getClothesList() {
        return clothesList;
    }

    //Equals:
    public boolean equals(Store obj) {
        return this.storeName.equals(obj.storeName) && this.address.equals(obj.address);
    }

    //toString:
    public String toString(){
        return "Features of the Store:\n"+
                "1) Store Name: "+storeName+"\n"+
                "2) Store Place: "+address+"\n"+
                "3) Store Type: "+dayNightCloth+"\n"+
                "4) Open hour: "+openHours+"\n"+
                "5) Clothes: "+clothesList;
    }

    //Methods:

    //A method that checks if the user value has only letters and has at least 2 characters.
    public boolean checkStoreName(String storeName) {
        final int MIN_LENGTH = 2; //Fixed number - defined as final.
        int storeNameLen = storeName.length();
        for (int i = 0; i < storeNameLen; i++) {
            if (!Character.isLetter(storeName.charAt(i))) {
                return false;
            }
        }
        return storeNameLen >= MIN_LENGTH;
    }

    public boolean checkOpenHours(String openHours){
        final int EARLIEST_HOUR = 7;  // Fixed number - defined as final.
        final int LATEST_HOUR = 11;   // Fixed number - defined as final.

        if(openHours.length() != 5) return false; // Check if the length of the string is 5.

        String hourString = openHours.substring(0, 2); // Extract the hour substring from the input.
        int hour = Integer.parseInt(hourString); // Convert the hour substring to an integer.

        if(hour < EARLIEST_HOUR || hour > LATEST_HOUR) return false; // Check if the hour is between 07 and 11.

        char colon = openHours.charAt(2); // Get the colon character.
        char mleft = openHours.charAt(3); // Get the left minute character.
        char mright = openHours.charAt(4); // Get the right minute character.

        return checkColon(colon) && checkMinutes(mleft, mright); // Check if the colon and minutes are valid.
    }

    public boolean checkColon(char colon){
        return colon == ':';
    }

    public boolean checkMinutes(char left,char right){
        return left == '0' && right == '0';
    }

    public boolean checkDayNightCloth(String cloth){
        return cloth.equalsIgnoreCase("day")||
                cloth.equalsIgnoreCase("night");
    }

    public Clothing findClothing(String barcode){
        for(Clothing clothing: clothesList){
            if(clothing.getBarCode().equals(barcode)){
                return clothing;
            }
        }
        return null;
    }

    public boolean addClothing(Clothing newClothing){
        for(Clothing clothing: clothesList){
            if(clothing.equals(newClothing)){
                System.out.println("Add Clothing: The garment is already in the store.");
                return false;
            }
        }
        clothesList.add(newClothing);
        System.out.println("Add Clothing: The garment has been added to the store.");
        return true;
    }

    public boolean removeClothing(Clothing newClothing){
        for(Clothing clothing: clothesList){
            if(clothing.equals(newClothing)){
                clothesList.remove(newClothing);
                System.out.println("Remove Clothing: The garment has been removed from the store.");
                return true;
            }
        }
        System.out.println("Remove Clothing: The garment is not in the store.");
        return false;
    }

    public double computePriceAvaregeClothingType(String clothingType){
        double sum=0.0;
        int cnt=0;
        for(Clothing clothing: clothesList){
            if(clothing.getClothingType().equals(clothingType)){
                sum+=clothing.getPrice();
                cnt++;
            }
        }
        return sum/cnt;
    }

    public void computeVAT(Clothing clothing, double price){
        clothing.setPrice(vatCalculate(price,17));
    }

    public double vatCalculate(double originalPrice, double vatPercentage){
        double vat = ((vatPercentage/100)*originalPrice);
        return originalPrice+vat;
    }

    public double computeDisscount(Clothing clothing){
        if(!clothing.isSale()){
            return vatCalculate(clothing.getPrice(),12);
        }
        return 0.0;
    }

    public double computePercentageByGender(String gender){
        int cnt=0;
        int storeSize=clothesList.size();
        for(Clothing clothing: clothesList){
            if(clothing.getGender_fit().equals(gender)){
                cnt++;
            }
        }
        return (((double) cnt/storeSize)*100);
    }

    public void printClothing(){
        for(Clothing clothing: clothesList){
            System.out.println("\n"+clothing.toString());
            System.out.println("------------------");
        }
    }

    public int checkGreatDeals(){
        int cnt=0;
        for(Clothing clothing: clothesList){
            if(clothing.greatDeal()){
                cnt++;
            }
        }
        return cnt;
    }
}