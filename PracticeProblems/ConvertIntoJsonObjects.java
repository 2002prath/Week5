package org.example.PracticeProblems;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ConvertIntoJsonObjects {
    public static void main(String[] args) {
      Car mercedes = new Car("E-class","Petrol",2024,1_07_00_000);

      try{
      ObjectMapper object = new ObjectMapper();

       String jsonString = object.writeValueAsString(mercedes);

          System.out.println("JSON Format : "+ jsonString);
      }
      catch (Exception e)
      {
          System.out.println("-----------Error Caught -----------------");
      }
    }
}

class Car
{
    private String model;
    private String engineType;
    private int PurchasingYear;
    private double Carprice;
  public Car(String ModelName,String engine,int Year,double price)
  {
     this.model = ModelName;
     this.engineType = engine;
     this.PurchasingYear= Year;
     this.Carprice= price;
  }

    public double getCarprice() {
        return Carprice;
    }

    public int getPurchasingYear() {
        return PurchasingYear;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getModel() {
        return model;
    }
}
