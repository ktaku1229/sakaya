import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class FileTest{
	static Stock s = new Stock();
	static File file = new File("src/zaiko.txt");
	static TicketList tl = new TicketList();
	static File tlFile = new File("src/ticket.txt");

  public static void main(String args[]){
    try{
      BufferedReader br = new BufferedReader( new FileReader(file) );
      String str;

      String zaiko[];
      ArrayList<Drink> stock = new ArrayList<Drink>();

      while( (str = br.readLine()) != null ) {
    	  zaiko = str.split(",");
    	  Drink d = new Drink();
    	  d.setBrand(zaiko[0]);
    	  d.setNum(Integer.parseInt(zaiko[1]));
    	  stock.add(d);
      }
      s.setStock(stock);

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

    try{
        BufferedReader br2 = new BufferedReader( new FileReader(tlFile) );
        String str2;

        String ticket[];

        while( (str2 = br2.readLine()) != null ) {
      	  ticket = str2.split(",");
      	  Ticket t = new Ticket();
      	  t.setNumber(Integer.parseInt(ticket[0]));
      	  Customer customer = new Customer();
      	  customer.setName(ticket[1]);
      	  t.setCustomer(customer);
      	  Drink d = new Drink();
      	  d.setBrand(ticket[2]);
      	  d.setNum(Integer.parseInt(ticket[3]));
      	  t.setDrink(d);
      	  tl.ticket.add(t);
        }

        br2.close();
      }catch(FileNotFoundException e){
        System.out.println("ファイルが存在しません.");
      }catch(IOException e){
        System.out.println("ファイルを読み込めませんでした.");
      }catch(NumberFormatException e){
      	System.out.println("ファイルの形式が正しくありません.");
      }

    try{
    	if(!tlFile.exists()){
    		tlFile.createNewFile();
    	}
/*
    	Customer c = new Customer();
    	c.setName("藤崎");
    	Drink d = new Drink();
    	d.setBrand("mio");
    	d.setNum(5);

    	Ticket t = new Ticket();
    	t.setNumber(1);
    	t.setCustomer(c);
    	t.setDrink(d);

    	tl.ticket.add(t);
*/

    	BufferedWriter bw2 = new BufferedWriter(new FileWriter(tlFile));
    	List<Ticket> ticketList = tl.ticket;

    	for(int i=0; i<ticketList.size(); i++){
    		String tmp;
    		tmp = ticketList.get(i).getNumber() + "," + ticketList.get(i).getCustomer().getName() + "," + ticketList.get(i).getDrink().getBrand() + "," + ticketList.get(i).getDrink().getNum();
    		bw2.write(tmp);
    		bw2.newLine();
    	}

    	bw2.close();


    }catch(FileNotFoundException e){
        System.out.println("ファイルが存在しません.");
      }catch(IOException e){
        System.out.println("ファイルに書き込めませんでした.");
      }

  }
}