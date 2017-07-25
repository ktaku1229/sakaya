import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


class FileTest{
	static Stock s = new Stock();
	static File file = new File("src/zaiko.txt");

  public static void main(String args[]){
    try{
      BufferedReader br = new BufferedReader( new FileReader(file) );
      String str;

      String zaiko[];

      while( (str = br.readLine()) != null ) {
    	  zaiko = str.split(",");
    	  Drink d = new Drink();
    	  d.setBrand(zaiko[0]);
    	  d.setNum(Integer.parseInt(zaiko[1]));
    	  s.setStock(d);
      }

      br.close();
    }catch(FileNotFoundException e){
      System.out.println("ファイルが存在しません.");
    }catch(IOException e){
      System.out.println("ファイルを読み込めませんでした.");
    }catch(NumberFormatException e){
    	System.out.println("ファイルの形式が正しくありません.");
    }

    try{
    	if(!file.exists()){
    		file.createNewFile();
    	}
/*
    	Drink d = new Drink();
    	d.setBrand("asahi");
    	d.setNum(10);
    	s.setStock(d);
*/

    	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    	ArrayList<Drink> list = s.getStock();

    	for(int i=0; i<list.size(); i++){
    		String tmp;
    		tmp = list.get(i).getBrand() + "," + list.get(i).getNum();
    		bw.write(tmp);
    		bw.newLine();
    	}

    	bw.close();


    }catch(FileNotFoundException e){
        System.out.println("ファイルが存在しません.");
      }catch(IOException e){
        System.out.println("ファイルに書き込めませんでした.");
      }
  }
}