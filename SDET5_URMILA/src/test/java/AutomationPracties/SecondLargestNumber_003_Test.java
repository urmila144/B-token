package AutomationPracties;

public class SecondLargestNumber_003_Test {
	
	public static void main(String[] args) {
		 
		int n=5;
		 
		int a[]= {14,25,10,24,34};
		
		int temp;
		
		for(int i=0; i<n; i++) {
			
			for(int j=i+1; j<n; j++) {
				
				if(a[i]>a[j]) {
					
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			
		}
	System.out.println("second largest number is"+ a[n-2]);
	}
}
