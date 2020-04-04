
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.FileNotFoundException;


public class Assembler2 {

	public static void main(String[] args) {
	    String fileName = "D:/eclipseWorkspace/DigitalDesign/src/input.txt"; //fileName is path of the input file
		Path path = Paths.get("D:/eclipseWorkspace/Digital3/out.txt"); //get path of output file
		
		BufferedWriter bw = null; //set to null
		FileWriter fw = null;
		
		try(BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){ //BufferedWriter and FileWriter are used to write data to output files
			File file =new File("D:/eclipseWorkspace/Digital3/out.txt");
			// if file doesnt exists, then create it
						if (!file.exists()) {
							file.createNewFile();
						}

						// true = append file
						fw = new FileWriter(file.getAbsoluteFile(),false);
						bw = new BufferedWriter(fw);
			
		  try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { //BufferedReader is used to read data from input file

			String line;
			while ((line = br.readLine()) != null) { //Reads the file line by line
				
				//ADDI 0001
			if(line.substring(0,4).equals("ADDI")){   
					String destinationRegister = Register(line.substring(5,7)); //Registers 
					String sourceRegister1 = Register(line.substring(8,10));
					String imm; //immediate
					int immint = Integer.parseInt(line.substring(11));
					if(line.charAt(11)=='-'){ //if immediate value is negative
					   imm =  Integer.toBinaryString(immint); //Convert to Binary
					   imm = imm.substring(24); //Since output is 32 bits, make it 8 bits 
					}
					else{ //if immediate value is positive
					   imm = DecimalToBinary(immint);  //Convert to Binary
					}
					imm = imm.substring(0, 4) + " " + imm.substring(4);
				    System.out.println("0001" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm);
				    bw.write("0001" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm); //write to file
				    bw.newLine();
				    
				    continue; //continues the loop
					
				}
				//ANDI 0010
			if(line.substring(0,4).equals("ANDI")){   
					String destinationRegister = Register(line.substring(5,7)); //Registers 
					String sourceRegister1 = Register(line.substring(8,10));
					String imm; //immediate
					int immint = Integer.parseInt(line.substring(11));
					if(line.charAt(11)=='-'){ //if immediate value is negative
					   imm =  Integer.toBinaryString(immint); //Convert to Binary
					   imm = imm.substring(24); //Since output is 32 bits, make it 8 bits 
					}
					else{ //if immediate value is positive
					   imm = DecimalToBinary(immint); //Convert to Binary
					}
					imm = imm.substring(0,4) + " " + imm.substring(4);
				    System.out.println("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm );
				    bw.write("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm); //write to file
					bw.newLine();
				
                    continue; //continues the loop
				} 
				
				//ADD 0000
				if(line.substring(0,3).equals("ADD")){   
					String destinationRegister = Register(line.substring(4,6)); //Registers 
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0000" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx");
					bw.write("0000" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx\n"); //write to file
					bw.newLine();
					
					continue; //continues the loop
				}
				//AND 0010
				if(line.substring(0,3).equals("AND")){   
					String destinationRegister = Register(line.substring(4,6)); //Registers 
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0010" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx");
					bw.write("0010" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx\n"); //write to file
					bw.newLine();
					
					continue; //continues the loop
				}
			
				//ORI 0011
				if(line.substring(0, 3).equals("ORI")){   
					String destinationRegister = Register(line.substring(4,6)); //Registers 
					String sourceRegister1 = Register(line.substring(7,9));
					String imm; //immediate
					int immint = Integer.parseInt(line.substring(10));
					if(line.charAt(10)=='-'){ //if immediate value is negative
					   imm =  Integer.toBinaryString(immint); //Convert to Binary
					   imm = imm.substring(24); //Since output is 32 bits, make it 8 bits 
					}
					else{ //if immediate value is positive
					   imm = DecimalToBinary(immint); //Convert to Binary
					}
					imm = imm.substring(0, 4) + " " + imm.substring(4);
				    System.out.println("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm );
				    bw.write("0011" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm); //write to file
					bw.newLine();
					
					continue; //continues the loop
				}
				//OR 0100
				if(line.substring(0,3).equals("OR")){   
					String destinationRegister = Register(line.substring(4,6)); //Registers 
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx");
					bw.write("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx\n"); //write to file
					bw.newLine();
					
					continue; //continues the loop
				}
				//XORI 0100
				if(line.substring(0, 4).equals("XORI")){   
					String destinationRegister = Register(line.substring(5,7)); //Registers 
					String sourceRegister1 = Register(line.substring(8,10));
					String imm; //immediate
					int immint = Integer.parseInt(line.substring(11));
					if(line.charAt(11)=='-'){ //if immediate value is negative
					   imm =  Integer.toBinaryString(immint); //Convert to Binary
					   imm = imm.substring(24); //Since output is 32 bits, make it 8 bits 
					}
					else{ //if immediate value is positive
					   imm = DecimalToBinary(immint); //Convert to Binary
					}
					imm = imm.substring(0, 4) + " " + imm.substring(4);
				    System.out.println("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm );
				    bw.write("0100" + " " +  destinationRegister + " " +  sourceRegister1 + " " + imm); //write to file
					bw.newLine();
				
					continue; //continues the loop
				}

				//XOR 0110
				if(line.substring(0,3).equals("XOR")){   
					String destinationRegister = Register(line.substring(4,6)); //Registers
					String sourceRegister1 = Register(line.substring(7,9));
					String sourceRegister2 = Register(line.substring(10));
					System.out.println("0110" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx");
					bw.write("0110" + " " +  destinationRegister + " " +  sourceRegister1 + " " + sourceRegister2 + " xxxx\n"); //write to file
					bw.newLine();
					
					continue; //continues the loop
				}
				
				//JUMP 0101
				if(line.substring(0, 4).equals("JUMP")){   
					String add; //address
					int address = Integer.parseInt(line.substring(5));
					if(line.charAt(5)=='-'){ //if address is negative
					   add =  Integer.toBinaryString(address); //Convert to Binary
					   add = add.substring(20); //Since output is 32 bits, make it 8 bits 
					}
					else{ //if address is positive
					   add = DecimalTo12BitBinary(address); //Convert to Binary
					}
					add = add.substring(0, 4) + " " + add.substring(4, 8) + " " + add.substring(8);
					System.out.println("0101" + " " +  add + " " + " xxxx");
					bw.write("0101" + " " +  add + " " + " xxxx"); //write to file
					bw.newLine();
					  
					continue; //continues the loop
				}
				//LD 0110
				if(line.substring(0,2).equals("LD")){
					String destinationRegister = Register(line.substring(3,5)); //Register
					String add; //address
					int address = Integer.parseInt(line.substring(6));
					if(line.charAt(6)=='-'){  //if address is negative
					   add =  Integer.toBinaryString(address); //Convert to Binary
					   add = add.substring(24); //Since output is 32 bits, make it 8 bits 
					}
					else{ //if address is positive
						add = DecimalTo12BitBinary(address); //Convert to Binary
					}
					add = add.substring(0, 4) + " " + add.substring(4, 8) + " " + add.substring(8);
				    System.out.println("0110"+" "+ destinationRegister+" " +  add);
				    bw.write("0110"+" "+ destinationRegister+" " +  add); //write to file
				    bw.newLine();
				    
				    continue; //continues the loop
				}
				//ST 0111
				if(line.substring(0,2).equals("ST")){
					String sourceRegister = Register(line.substring(3,5));  //Register
					String add; //address
					int address = Integer.parseInt(line.substring(6));
					if(line.charAt(6)=='-'){ //if address is negative
					   add =  Integer.toBinaryString(address); //Convert to Binary
					   add = add.substring(24); //Since output is 32 bits, make it 8 bits 
					}
					else{ //if address is positive
						add = DecimalTo12BitBinary(address); //Convert to Binary
					}
					add = add.substring(0, 4) + " " + add.substring(4, 8) + " " + add.substring(8);
				    System.out.println("0111"+" "+ sourceRegister+" " +  add);
				    
				    bw.write("0111"+" "+ sourceRegister+" " +  add+"\n"); //write to file
				    bw.newLine();
				    
				    continue; //continues the loop
				}
				//BEQ 1010                //ADRESLER TEKRAR HESAPLANACAK VE HEX KODU KALDI
				if(line.substring(0,3).equals("BEQ")){
					String operand1= Register(line.substring(4,6)); //Registers
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					System.out.println("1010"+" "+ operand1 + " " +  operand2 + " " + address);
				    bw.write("\n1010"+" "+ operand1 + " " +  operand2 + " " + address); //write to file
				    bw.newLine();
				
				    continue; //continues the loop
				}
				
				//BLT 1100
				if(line.substring(0,3).equals("BLT")){
					String operand1= Register(line.substring(4,6)); //Registers
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					System.out.println("1100"+" "+ operand1 + " " +  operand2 + " " +  address);
				    bw.write("1100"+" "+ operand1 + " " +  operand2 + " " + address); //write to file
				    bw.newLine();
				    
				    continue; //continues the loop
				}
				//BGT 1001
				if(line.substring(0,3).equals("BGT")){
					String operand1= Register(line.substring(4,6)); //Registers
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					System.out.println("1001"+" "+ operand1 + " " +  operand2 + " " + address);
				
				    bw.write("1001"+" "+ operand1 + " " +  operand2 + " " + address); //write to file
				    bw.newLine();
				    
				    continue; //continues the loop
				}
				//BLE 1110
				if(line.substring(0,3).equals("BLE")){
					String operand1= Register(line.substring(4,6)); //Registers
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					System.out.println("1110"+" "+ operand1 + " " +  operand2 + " " + address);
				
				    bw.write("1110"+" "+ operand1 + " " +  operand2 + " " + address); //write to file
				    bw.newLine();
				    
				    continue; //continues the loop
				}
				//BGE 1011
				if(line.substring(0,3).equals("BGE")){
					String operand1= Register(line.substring(4,6)); //Registers
					String operand2= Register(line.substring(7,9));
					int address= Integer.parseInt(line.substring(16));
					System.out.println("1011"+" "+ operand1 + " " +  operand2 + " " + address);
				    bw.write("1011"+" "+ operand1 + " " +  operand2 + " " + address); //write to file
				    bw.newLine();
				    
				    continue; //continues the loop
				}
				
		}
		if(br.readLine()==null){ //if end of file
				br.close(); //close reader
		}
	  }catch (IOException e) {
			e.printStackTrace();
	  }
		
	} 
    catch (IOException e) {
		e.printStackTrace();
	}
	finally {

			try {

				if (bw != null) //if writing is done close writers
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
	}
	

}
	
		

	public static String Register(String line){ //returns binary register values
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

	public static String DecimalToBinary(int num){ //Converts decimal to binary
	   
	    StringBuilder buf1=new StringBuilder(); 
	    StringBuilder buf2=new StringBuilder();
	    while (num != 0){
	        int digit = num % 2; 
	        buf1.append(digit);  
	        num = num/2;
	    }
	    String binary=buf1.reverse().toString();
	    int length=binary.length();
	    if(length<8){
	       while (8-length>0){
	           buf2.append("0");// add zero until length = 8
	           length++;
	       }
	    }
	    String bin=buf2.toString()+binary;// binary string with leading 0's
	    return bin;
	}
	public static String DecimalTo12BitBinary(int num){ //Converts decimal to binary
		   
	    StringBuilder buf1=new StringBuilder(); 
	    StringBuilder buf2=new StringBuilder();
	    while (num != 0){
	        int digit = num % 2; 
	        buf1.append(digit);  
	        num = num/2;
	    }
	    String binary=buf1.reverse().toString();
	    int length=binary.length();
	    if(length<8){
	       while (12-length>0){
	           buf2.append("0");// add zero until length = 12
	           length++;
	       }
	    }
	    String bin=buf2.toString()+binary;// binary string with leading 0's
	    return bin;
	}
	

}
