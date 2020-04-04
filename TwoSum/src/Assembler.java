import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Assembler {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String fileName = "D:/eclipseWorkspace/DigitalDesign/src/input.txt";
		Path path = Paths.get("D:/eclipseWorkspace/Digital3/out.txt"); //get path of out file
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try(BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
			File file =new File("D:/eclipseWorkspace/Digital3/out.txt");
			// if file doesnt exists, then create it
						if (!file.exists()) {
							file.createNewFile();
						}

						// true = append file
						fw = new FileWriter(file.getAbsoluteFile(),false);
						bw = new BufferedWriter(fw);
			
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) { //Reads the file line by line
				
				//ADDI 0001
				if(line.substring(0,4).equals("ADDI")){   
					String destinationRegister = Register(line.substring(5,7));
					String sourceRegister1 = Register(line.substring(8,10));
					String imm;
					int immint = Integer.parseInt(line.substring(11));
					if(line.charAt(11)=='-'){
					   imm =  Integer.toBinaryString(immint);
					   imm = imm.substring(24);
					}
					else{
					   imm = DecimalToBinary(immint);
					}
					imm = imm.substring(0, 4) + " " + imm.substring(4);
				    System.out.println("0001" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm);
				    bw.write("0001" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm);
				    bw.newLine();
				    //System.out.println("Hexadecimal converted version:");
				    String wholeStr="0001".concat(destinationRegister).concat(sourceRegister1).concat(imm);
				    
				   // convertHex(wholeStr);
				    continue; //continues the loop
					
				}
				//ANDI 0010
				if(line.substring(0,4).equals("ANDI")){   
					String destinationRegister = Register(line.substring(5,7));
					String sourceRegister1 = Register(line.substring(8,10));
					String imm;
					int immint = Integer.parseInt(line.substring(11));
					if(line.charAt(11)=='-'){
					   imm =  Integer.toBinaryString(immint);
					   imm = imm.substring(24);
					}
					else{
					   imm = DecimalToBinary(immint);
					}
					imm = imm.substring(0,4) + " " + imm.substring(4);
				    System.out.println("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm );
				    bw.write("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm);
					bw.newLine();

				 
					continue; //continues the loop
				}
				
				//ADD 0000
				if(line.substring(0,3).equals("ADD")){   
					String destinationRegister = Register(line.substring(4,6));
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0000" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " 0000");
					bw.write("0000" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + "0000\n");
					bw.newLine();
					
					continue; //continues the loop
				}
				//AND 0010
				if(line.substring(0,3).equals("AND")){   
					String destinationRegister = Register(line.substring(4,6));
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0010" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + "0000");
					bw.write("0010" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + "0000\n");
					bw.newLine();
					
					continue; //continues the loop
				}
			
				//ORI 0011
				if(line.substring(0, 3).equals("ORI")){   
					String destinationRegister = Register(line.substring(4,6));
					String sourceRegister1 = Register(line.substring(7,9));
					String imm;
					int immint = Integer.parseInt(line.substring(10));
					if(line.charAt(10)=='-'){
					   imm =  Integer.toBinaryString(immint);
					   imm = imm.substring(24);
					}
					else{
					   imm = DecimalToBinary(immint);
					}
					imm = imm.substring(0, 4) + " " + imm.substring(4);
				    System.out.println("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm );
				    bw.write("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm);
					bw.newLine();
					continue; //continues the loop
				}
				//OR 0100
				if(line.substring(0,3).equals("OR")){   
					String destinationRegister = Register(line.substring(4,6));
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + "0000");
					bw.write("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + "0000\n");
					bw.newLine();
					
					continue; //continues the loop
				}
				//XORI 0100
				if(line.substring(0, 4).equals("XORI")){   
					String destinationRegister = Register(line.substring(5,7));
					String sourceRegister1 = Register(line.substring(8,10));
					String imm;
					int immint = Integer.parseInt(line.substring(11));
					if(line.charAt(11)=='-'){
					   imm =  Integer.toBinaryString(immint);
					   imm = imm.substring(24);
					}
					else{
					   imm = DecimalToBinary(immint);
					}
					imm = imm.substring(0, 4) + " " + imm.substring(4);
				    System.out.println("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm );
				    bw.write("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm);
					bw.newLine();
				
					continue; //continues the loop
				}

				//XOR 0110
				if(line.substring(0,3).equals("XOR")){   
					String destinationRegister = Register(line.substring(4,6));
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0110" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + "0000");
					bw.write("0110" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + "0000\n");
					bw.newLine();
					
					continue; //continues the loop
				}
				
				//JUMP 0101
				if(line.substring(0, 4).equals("JUMP")){   
					String add;
					int address = Integer.parseInt(line.substring(5));
					if(line.charAt(5)=='-'){
					   add =  Integer.toBinaryString(address);
					   add = add.substring(24);
					}
					else{
					   add = DecimalToBinary(address);
					}
					
					  add = add.substring(0, 4) + " " + add.substring(4);
					  System.out.println("0101" + " " +  add + " " + " 0000");
					  bw.write("0101" + " " +  add + " " + " 0000");
					  bw.newLine();
					  continue; //continues the loop
				}
				//LD 0110
				if(line.substring(0,2).equals("LD")){
					String destinationRegister = Register(line.substring(3,5));
					String add;
					int address = Integer.parseInt(line.substring(6));
					if(line.charAt(6)=='-'){
					   add =  Integer.toBinaryString(address);
					   add = add.substring(24);
					}
					else{
					   add = DecimalToBinary(address);
					}
					add = add.substring(0, 4) + " " + add.substring(4);	 
				    System.out.println("0110"+" "+ destinationRegister+" " +  add);
				    bw.write("0110"+" "+ destinationRegister+" " +  add);
				    bw.newLine();
				}
				//ST 0111
				if(line.substring(0,2).equals("ST")){
					String sourceRegister = Register(line.substring(3,5));
					String add;
					int address = Integer.parseInt(line.substring(6));
					if(line.charAt(6)=='-'){
					   add =  Integer.toBinaryString(address);
					   add = add.substring(24);
					}
					else{
					   add = DecimalToBinary(address);
					}
					add = add.substring(0, 4) + " " + add.substring(4);
				    System.out.println("0111"+" "+ sourceRegister+" " +  add);
				    
				   bw.write("0111"+" "+ sourceRegister+" " +  add+"\n");
				    bw.newLine();
				}
				//BEQ 1010
				if(line.substring(0,3).equals("BEQ")){
					String operand1= Register(line.substring(4,6));
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					
					 
				System.out.println("1010"+" "+ operand1 + " " +  operand2 + " " + address);
				bw.write("\n1010"+" "+ operand1 + " " +  operand2 + " " + address);
				bw.newLine();
				}
				
				//BLT 1100
				if(line.substring(0,3).equals("BLT")){
					String operand1= Register(line.substring(4,6));
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					
					 
				System.out.println("1100"+" "+ operand1 + " " +  operand2 + " " +  address);
				bw.write("1100"+" "+ operand1 + " " +  operand2 + " " + address);
				bw.newLine();
				}
				//BGT 1001
				if(line.substring(0,3).equals("BGT")){
					String operand1= Register(line.substring(4,6));
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					
					 
				System.out.println("1001"+" "+ operand1 + " " +  operand2 + " " + address);
				
				bw.write("1001"+" "+ operand1 + " " +  operand2 + " " + address);
				bw.newLine();
				}
				//BLE 1110
				if(line.substring(0,3).equals("BLE")){
					String operand1= Register(line.substring(4,6));
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					
					 
				System.out.println("1110"+" "+ operand1 + " " +  operand2 + " " + address);
				
				bw.write("1110"+" "+ operand1 + " " +  operand2 + " " + address);
				bw.newLine();
				}
				//BGE 1011
				if(line.substring(0,3).equals("BGE")){
					String operand1= Register(line.substring(4,6));
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					
					 
				System.out.println("1011"+" "+ operand1 + " " +  operand2 + " " + address);
				bw.write("1011"+" "+ operand1 + " " +  operand2 + " " + address);
				bw.newLine();
				
				}
				
			}
			if(br.readLine()==null){
				br.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		} //file try
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}//finally
	

}
	
		

	public static String Register(String line){ //Method for converting binary numbers to decimal for registers
		switch (line) {
        case "R0": 
                 return "0000";
                 
        case "R1":  
                 return "0001";
                 
        case "R2":  
                 return "0010";
                 
        case "R3":  
                 return "0011";
                 
        case "R4":  
                 return "0100";
                 
        case "R5":  
                 return "0101";
                 
        case "R6":  
                 return "0110";
                 
        case "R7":  
                 return "0111";
                 
        case "R8":  
                 return "1000";
                 
        case "R9":  
                 return "1001";
                 
        case "R10":  
                 return "1010";
                 
        case "R11":  
                 return "1011";
                 
        case "R12":  
                 return "1100";
                 
        case "R13":  
                 return "1101";
                 
        case "R14":  
                 return "1110";
                 
        case "R15":  
                 return "1111";
                 
        default: 
        	     return"Invalid register";
                 
    }
		
	}

	public static String DecimalToBinary(int num){
	   
	    StringBuilder buf1=new StringBuilder();
	    StringBuilder buf2=new StringBuilder();
	    while (num != 0){
	        int digit = num % 2;
	        buf1.append(digit); // apend 0101 order
	        num = num/2;
	    }
	    String binary=buf1.reverse().toString();// reverse to get binary 1010
	    int length=binary.length();
	    if(length<8){
	       while (8-length>0){
	           buf2.append("0");// add zero until length =8
	           length++;
	       }
	    }
	    String bin=buf2.toString()+binary;// binary string with leading 0's
	    return bin;
	}

	public static String GetBinarySum(String a, String b){
        int left = Integer.parseInt(a, 2);
        int right = Integer.parseInt(b, 2);
        int sum = left + right;
        return Integer.toBinaryString(sum);
    }
	
	public static  String convertHex(String wholeStr)
	{
		int digitNumber = 1;
	    int sum = 0;
	    String summ;
	    //String binary = "011110101010"; //12 bit
	    for(int i = 0; i < wholeStr.length(); i++){
	        if(digitNumber == 1)
	            sum+=Integer.parseInt(wholeStr.charAt(i)+"")*8;
	        else if(digitNumber == 2)
	            sum+=Integer.parseInt(wholeStr.charAt(i) + "")*4;
	        else if(digitNumber == 3)
	            sum+=Integer.parseInt(wholeStr.charAt(i) + "")*2;
	        else if(digitNumber == 4 || i < wholeStr.length()+1){
	            sum+=Integer.parseInt(wholeStr.charAt(i) + "")*1;
	            digitNumber = 0;
	            if(sum < 10)
	                System.out.print(sum);
	            else if(sum == 10)
	                System.out.print("A");
	            else if(sum == 11)
	                System.out.print("B");
	            else if(sum == 12)
	                System.out.print("C");
	            else if(sum == 13)
	                System.out.print("D");
	            else if(sum == 14)
	                System.out.print("E");
	            else if(sum == 15)
	                System.out.print("F");
	            sum=0;
	        }
	        digitNumber++;  
	     
	    }
	    summ=Integer.toString(sum);
	    //String reverse = new StringBuffer(summ).reverse().toString();
	    return summ;
		
		
		
		
		
	}
	
	
	
}
