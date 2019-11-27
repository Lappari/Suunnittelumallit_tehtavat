package main;

public class Main {

	public static void main(String[] args) {
		
		stringTest();
	}
	
	public static void stringTest(){
		   	
				//kommenteissa on hyvin suoraan sanottu mitä tästä testistä voidaan todeta
		      String fly = "fly", weight = "weight";
		      String fly2 = "fly", weight2 = "weight"; 
		      System.out.println(fly == fly2);       // fly and fly2 refer to the same String instance
		      System.out.println(weight == weight2); // weight and weight2 also refer to
		                                             // the same String instance
		      String distinctString = fly + weight;
		      System.out.println(distinctString == "flyweight"); // flyweight and "flyweight" do not
		                                                         // refer to the same instance
		      String flyweight = (fly + weight).intern();	//ajon aikana alustetut stringit eivät ole flyweighteja, mutta niistä voideen tehdä flyweighteja .intern() metodilla
		      System.out.println(flyweight == "flyweight"); // The intern() method returns a flyweight
		      
		      Test test = new Test();
		      test.setBounds(20,20,250,150);
		      test.show();
		}
}
