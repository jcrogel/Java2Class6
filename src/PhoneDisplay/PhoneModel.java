package PhoneDisplay;

public class PhoneModel {
    private String phone = "";

    public PhoneModel(){

    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        // TODO: Validate that this is a phone (has numbers and - only)
        this.phone = phone;
    }

    public boolean appendToPhone(String phoneSuffix){
        String potentialString = this.phone.trim() + phoneSuffix.trim();
        boolean valid = this.isValid(potentialString);
        if(valid){
            this.phone = potentialString;
        }
        return valid;
    }

    public boolean isValid(String phone){
        return phone.matches("\\d{0,10}");
    }

}
