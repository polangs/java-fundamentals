import java.util.Random;
import java.awt.SystemTray;
//research from stackoverflow https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
import java.time.LocalDateTime; 
//research from https://www.javatpoint.com/java-localdatetime
import java.time.format.DateTimeFormatter;
public class Main {
//this main is where we make conditions to run
//this function is to  pluralize if it is more than one and is equals to zero then concatenate it to add s
//I had help with james to understand how to pluralize

  public static String pluralize (String word, int count){
    if (count > 1 || count == 0){
      word = word + "s";
    }
    return word;
  }

  //this function choose random number bet 0 and 1 
  public static void flipNHeads(int n){
    int max= 1;
    int min= 0;
    Random flip = new Random();

    int countHeads = 0;
    int countFlips = 0;

    while(countHeads < 1){
      int randomNum = flip.nextInt((max - min) + 1) + min;
      if (randomNum == 0){
        countHeads++;
        countFlips++;
        System.out.println("heads");
      }else{
        countHeads = 0;
        countFlips++;
        System.out.println("tails");
      }
    }
    System.out.println("It took " + countFlips + " flips " + countHeads + " head in a row.");
  }

  // // LocalDateTime should show 12:10:58

  public static void clock(){
  LocalDateTime now = LocalDateTime.now();
  int hour = now.getHour();
  int minute = now.getMinute();
  int second = now.getSecond();
        int oldSecond = now.getSecond();
        while (true) {
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            now = LocalDateTime.now();
            int newSecond = now.getSecond();
            if (oldSecond != newSecond) {
                oldSecond = newSecond;
               System.out.println(time);
            }
        }        
    }

  //main method
  public static void main (String[] args) {
    
    int dogCount = 1;
    System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

    int catCount = 2;
    System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

    int turtleCount = 0;
    System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

    flipNHeads(1);

    clock();

  }

}
