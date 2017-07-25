import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

class FileTest{
  public static void main(String args[]){
    try{
      //File file = new File("/home/ensyum/m171X205/Documents/workspace/sakaya/src/zaiko.txt");
      //File file = new File("src/zaiko.txt");

      BufferedReader br = new BufferedReader( new FileReader("src/zaiko.txt") );
      String s;

      String zaiko[];

      while( (s = br.readLine()) != null ) {
    	  zaiko = s.split(",");
    	  Drink d = new Drink();
    	  d.setBrand(zaiko[0]);
    	  d.setNum(Integer.parseInt(zaiko[1]));
    	  System.out.println(d.getBrand());
    	  System.out.println(d.getNum());
      }

      br.close();
    }catch(FileNotFoundException e){
      System.out.println(e);
    }catch(IOException e){
      System.out.println(e);
    }catch(NumberFormatException e){
    	System.out.println(e);
    }
  }
}