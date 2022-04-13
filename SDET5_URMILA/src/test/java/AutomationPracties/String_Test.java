package AutomationPracties;

public class String_Test {
	public static void main(String[] args) {
		int n=3;
			
		String name[]={"urmila","asia","padmaja"};
		String temp;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(name[i].compareTo(name[j])>0){
					temp=name[i];
					name[i]=name[j];
					name[j]=temp;
					
			}
		}
		
		}
		System.out.println("order:");
		for(int i=0; i<n; i++) {
			System.out.println(name[i]);
		}
	}
}
