import java.util.ArrayList;
import java.util.Scanner;
//Busra yasar
public class ArrayListExample {
	static boolean checkInt( int input) {
		if(( input%1)!=0){
			System.out.println("not a integer, try again"); return false;}
		else{	//System.out.println("integer");	
			return true;   }
		}
		
			
			public static void main(String[] args) {
				
				ArrayList<Integer> nums1 = new ArrayList<Integer>();
				ArrayList<Integer> nums2 = new ArrayList<Integer>();
				int check = 1;
				while(check == 1) {
					System.out.println("Please enter an element for first list: ");
					Scanner input = new Scanner(System.in);
					int arrElm = input.nextInt();
					//take first sorted array
					if(checkInt(arrElm) == true) {
						nums1.add(arrElm);
						System.out.println("Do you want to continue addition? Enter Y or N");
						Scanner ans = new Scanner(System.in);
						String answer = ans.nextLine();
						if(answer.equalsIgnoreCase("y")) {check = 1;	
						}else {	check = 2; /*exit from loop	*/}	
					}else {
						System.out.println("The number didn't inserted. Try again..");
						System.out.println("Do you want to continue addition? Enter Y or N");
						Scanner ans = new Scanner(System.in);
						String answer = ans.nextLine();
						if(answer.equalsIgnoreCase("y")) {
							check = 1;	
						}else {	check = 2; /*exit from loop	*/}	
					}	
				}
				//take second sorted array
				while(check == 2) {
					System.out.println("Please enter an element for second list: ");
					Scanner inp = new Scanner(System.in);
					int arrElm = inp.nextInt();
					//take first sorted array
					if(checkInt(arrElm) == true) {
						nums2.add(arrElm);//add second arr
						System.out.println("Do you want to continue addition? Enter Y or N");
						Scanner ans = new Scanner(System.in);
						String answer = ans.nextLine();
						if(answer.equalsIgnoreCase("y")) {check = 2;	
						}else {	check = 3; /*exit from loop	*/}	
					}else {
						System.out.println("The number didn't inserted. Try again..");
						System.out.println("Do you want to continue addition? Enter Y or N");
						Scanner ans = new Scanner(System.in);
						String answer = ans.nextLine();
						if(answer.equalsIgnoreCase("y")) {
							check = 2;	
						}else {	check = 3; /*exit from loop	*/}	
					}	
				}
				System.out.println("Your arrays :");
				for(int i = 0; i < nums1.size(); i++) {   
				    System.out.print(nums1.get(i));
				} 
				System.out.print("\n");
				for(int j = 0; j < nums2.size(); j++) {   
				    System.out.print(nums2.get(j));
				} 
				
				
			}

	}


