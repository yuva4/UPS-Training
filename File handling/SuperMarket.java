package nested_switch;

import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class SuperMarket {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int category,product,quantity;
		int total=0;
		int price=0;
		String name="";
		char choice;
		
		StringBuilder bill = new StringBuilder();

        bill.append("========== SUPERMARKET BILL ==========\n\n");

        bill.append(String.format("%-15s %8s %8s %10s%n",
                "Product", "Price", "Qty", "Amount"));

        bill.append("---------------------------------------------\n");
		
		do {
			System.out.println("Super Market");
			System.out.println("1.Snacks");
			System.out.println("2.Stationary");
			System.out.println("Select Category");
			category=sc.nextInt();
			
			switch(category){
			
			case 1:
			System.out.println("Chips - Rs-20");
			System.out.println("Biscuits - Rs-40");
			System.out.println("Chocolate - Rs-60");
			System.out.println("Select product");
			product=sc.nextInt();
			
			switch(product)
			{
			case 1:
				name="Chips";
				price=20;
				break;
			case 2:
				name="Biscuits";
				price=40;
				break;
			case 3:
				name="chocolate";
				price=60;
				break;
			default:
				System.out.println("invalid product");
				
			}
			break;
			
			case 2:
				System.out.println("Pen - Rs-15");
				System.out.println("Books - Rs-60");
				System.out.println("Marker - Rs-80");
				System.out.println("Select product");
				product=sc.nextInt();
				
				switch(product) {
				case 1:
					name="Pen";
					price=15;
				case 2:
					name="Books";
					price=60;
				case 3:
					name="Marker";
					price=80;
				default:
					System.out.println("invalid product");
				}
				break;
			
		}
			if(!name.equals("")) {
				System.out.println("Enter quantity");
				quantity=sc.nextInt();
				
				int amount=price*quantity;
				total=total+amount;
				
				System.out.println("Product: " + name);
                System.out.println("Amount: Rs." + amount);

                bill.append(String.format(
                        "%-15s %8d %8d %10d%n",
                        name, price, quantity, amount));
			}
			System.out.println("Do you want to add any other products? y/n");
			choice=sc.next().charAt(0);
	}while( choice =='y' || choice == 'Y');
	
		bill.append("---------------------------------------------\n");
        bill.append("TOTAL BILL: Rs. ").append(total).append("\n");
        bill.append("Thank you for shopping!\n");
        bill.append("=============================================\n");

        try {
            File file = new File("SuperMarketBill.txt");

            FileWriter writer = new FileWriter(file);
            writer.write(bill.toString());
            writer.close();

            System.out.println("\nBill saved successfully!");
            System.out.println("File location: " + file.getAbsolutePath());

            

        } catch (Exception e) {
            System.out.println("Error creating bill: " + e.getMessage());
        }

        sc.close();
    }

}

