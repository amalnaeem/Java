import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class CGPA {

	public static void main(String[] args)
	{
		Scanner input =new Scanner(System.in);
		String[][] data = new String[6][3];
	String name;
	String reg;
	String cgpa;
	for(int i = 0 ; i < 6 ; i++)
	{   System.out.println("Enter data for student "+ (i+1));
		for(int j = 0 ; j < 3 ; j++)
		{
		
		
		if (j==0)
		{
			System.out.println("Enter name ");
		name = input.nextLine();
		data[i][j] = name;
		}
		else if(j==1)
		{
			System.out.println("Enter Registration Number ");
			reg = input.nextLine();
			//boolean match = false;
			if(i==0)
			{
				//System.out.println("hello1");
				data[i][j] = reg;
			}
			else
			{
				System.out.println("hello2");
			for(int k = 0 ; k <= (i-1) ; k++)
			{
				//System.out.println("hello3");
				while(Integer.parseInt(reg)==Integer.parseInt(data[k][1]))
				{
					System.out.println("Duplicate entry. Please re enter a valid registration number");
					reg = input.nextLine();
					
				}
			}
			data[i][j] = reg;
			}

		}
		
		
		
		else if(j==2)
		{
			
			
			System.out.println("Enter cgpa");
			cgpa = input.nextLine();
			
			while(Float.parseFloat(cgpa)>4)
			{
			System.out.println("Invalid cgpa");
			cgpa = input.nextLine();
			}
			data[i][j] = cgpa;
		}
	}
	}

	
	Arrays.sort(data, new Comparator<String[]>() {
        @Override
        public int compare(final String[] entry1, final String[] entry2) {
            final String cgpa1 = entry1[2];
            final String cgpa2 = entry2[2];
            return cgpa1.compareTo(cgpa2);
        }
    });
	
	
	
	
	float min = 4; 
	float max=0;
	float sum=0;
	for(int i = 0 ; i < 6 ; i++)
	{   //System.out.println("Enter data for student"+i);
		
		sum+=Float.parseFloat(data[i][2]);
		
		/*for(int j = 0 ; j < 3 ; j++)
		{
		
		if(Float.parseFloat(data[i][2])< min)
		{
			min=Float.parseFloat(data[i][2]);
			
		}
		
		if(Float.parseFloat(data[i][2])> max)
		{
			max=Float.parseFloat(data[i][2]);
			
		}
		//Scanner input =new Scanner(System.in);
		
		
		System.out.print(data[i][j]+ "\t");
	}*/
		//System.out.println("\n");
	}
	
	float avg = sum/6;
	
	System.out.println("Minimum CGPA is " + data[0][2]);
	System.out.println("Maximum CGPA is " + data[5][2]);
	System.out.println("Average CGPA is " + avg);
	
	System.out.println("Students below average CGPA");
	for(int i = 0 ; i < 6 ; i++)
	{   
		
	if(Float.parseFloat(data[i][2])< avg)
	{
		System.out.print(data[i][0] + "\t");
	}
		
	}
		
	
	System.out.println("Enter 1 to search by name and 2 to search by registration number");
	int search = input.nextInt();
	
	if(search==1)
	{
		boolean found = false;
		String sname;
		System.out.println("Enter name");
		Scanner in =new Scanner(System.in);
		sname = in.next();
		for (int i = 0 ; i < 6; i++) {
		    if (sname.compareTo(data[i][0])==0) {
		    	System.out.println((6-i)+"\t"+ data[i][2]);
		    	found = true;
		        //break;
		    }
		}
		
		if(!found)
		{
			System.out.print("Entry not found");
		}
	}
	
	else if (search==2)
	{
		boolean found  = false;
		System.out.println("Enter Registration Number");
		Scanner inp =new Scanner(System.in);
		String snum = inp.nextLine();
		for(int i = 0 ; i < 6 ; i++)
		{   

			if(snum.compareTo(data[i][1])==0)
			{
				System.out.println((6-i)+"\t"+ data[i][2]);
				found = true;
			}
				

		}
		if(!found)
		{
			System.out.print("Entry not found");
		}
		
	}
	
	
	
	}
}
