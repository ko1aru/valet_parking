package valet;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class valet_parking {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int fare_2=20, fare_4=40;
		
		long phone_arr[]=new long[20];
		int phone_count=0;
		String name_arr[]=new String[20];
		int name_count=0;
		int vehicle_type_arr[]=new int[20];
		int vehicle_type_count=0;
		String vehicle_no_arr[]=new String[20];
		int vehicle_no_count=0;
		String vehicle_model_arr[]=new String[20];
		int vehicle_model_count=0;
		LocalTime time_in_arr[]=new LocalTime[20];
		int time_in_count=0;
		
		phone_arr[phone_count]=8939256216L;
		phone_count++;
		name_arr[name_count]="Aakash";
		name_count++;
		vehicle_type_arr[vehicle_type_count]=4;
		vehicle_type_count++;
		vehicle_no_arr[vehicle_no_count]="TN22AB1230";
		vehicle_no_count++;
		vehicle_model_arr[vehicle_model_count]="Audi A6";
		vehicle_model_count++;
		time_in_arr[time_in_count]=LocalTime.now().minusHours(2);
		time_in_count++;
		
		System.out.println("1. Check-in");
		System.out.println("2. Check-out");
		int option=sc.nextInt();
		switch(option) {
		case 1:
			System.out.println("Enter phone number");
			phone_arr[phone_count]=sc.nextLong();
			phone_count++;
			
			System.out.println("Enter your name: ");
			name_arr[name_count]=sc.next();
			name_count++;
			
			System.out.println("Enter vehicle type (2-wheeler or 4-wheeler): ");
			vehicle_type_arr[vehicle_type_count]=sc.nextInt();
			vehicle_type_count++;
			
			System.out.println("Enter vehicle number");
			vehicle_no_arr[vehicle_no_count]=sc.next();
			vehicle_no_count++;
			
			System.out.println("Enter vehicle model");
			vehicle_model_arr[vehicle_model_count]=sc.next();
			vehicle_model_count++;
			
			LocalTime time_in=LocalTime.now();
			time_in_arr[time_in_count]=time_in;
			time_in_count++;
			
			System.out.println();
			System.out.println("Phone no: "+phone_arr[phone_count-1]);
			System.out.println("Name: "+name_arr[name_count-1]);
			System.out.println("Vehicle type: "+vehicle_type_arr[vehicle_type_count-1]);
			System.out.println("Vehicle no: "+vehicle_no_arr[vehicle_no_count-1]);
			System.out.println("Vehicle model: "+vehicle_model_arr[vehicle_model_count-1]);
			System.out.println("Check-in time: "+time_in_arr[time_in_count-1]);
			break;
			
		case 2:
			System.out.println("Enter phone number");
			long phone_out=sc.nextLong();
			for(int i=0;i<=phone_count-1;i++) {
				if(phone_out==phone_arr[i]) {
					LocalTime time_out=LocalTime.now();
					System.out.println();
					System.out.println("*********RECEIPT*********");
					System.out.println("Phone no: "+phone_arr[i]);
					System.out.println("Name: "+name_arr[i]);
					System.out.println("Vehicle type: "+vehicle_type_arr[i]);
					System.out.println("Vehicle no: "+vehicle_no_arr[i]);
					System.out.println("Vehicle model: "+vehicle_model_arr[i]);
					System.out.println("Check-in time: "+time_in_arr[i]);
					System.out.println("Check-out time: "+time_out);
					
					long diff_hour=ChronoUnit.HOURS.between(time_in_arr[i], time_out);
					long diff_min=ChronoUnit.MINUTES.between(time_in_arr[i], time_out);
					if(diff_min>0) {
						diff_hour++;
					}
					
					long total=0;
					if(vehicle_type_arr[i]==2) {
						total=diff_hour*fare_2;
					} else { //(vehicle_type_arr[i]==4) {
						total=diff_hour*fare_4;
					}
					System.out.println();
					System.out.println("YOU SHOULD PAY Rs."+total);
					break;
				} else {
					System.out.println("Vehicle doesn't exist");
				}
			}
			break;
		}
	}
}