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

      BufferedReader br
      = new BufferedReader( new FileReader("src/zaiko.txt") );
      String s;

      String zaiko[][] = null;
      Arrays.fill(zaiko, 0);
      int ch;
      
      int i=0;
      while( (s = br.readLine()) != null ) {
    	  zaiko[i] = s.split("");
      }
      System.out.println(zaiko[1][0]);

      br.close();
    }catch(FileNotFoundException e){
      System.out.println(e);
    }catch(IOException e){
      System.out.println(e);
    }
  }
}