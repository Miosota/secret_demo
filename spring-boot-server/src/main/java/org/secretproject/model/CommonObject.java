package org.secretproject.model;



public class CommonObject {

    private String userName = "";
    private String secretText = "";
    private int timesToView = 0;

                
    public CommonObject(
            String userName, 
            String secretText,
            int timesToView){
        this.userName = userName;
        this.secretText = secretText;
        this.timesToView = timesToView;

    }

    public CommonObject(){
      
    }

    //setters
    public void userName(String userName) {
        this.userName = userName;
    }

    public void setSecretText(String secretText) {
        this.secretText = secretText;
    }

    public void setTimesToView (int timesToView) {
        this.timesToView = timesToView;
    }

    //getters
    public String getUserName() {
        return this.userName;
    }

    public String getSecretText() {
        return this.secretText;
    }

    public int getTimesToView () {
        return this.timesToView;
    }


}
