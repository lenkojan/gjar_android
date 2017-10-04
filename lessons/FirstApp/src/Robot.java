
public class Robot{
		String name = "";
		
		public void setName(String newName) {
			name = newName;
		}
		
		public String getName() {
			return name;
		}
		
		public int factorial(int seed) {
			int f = 1;
			for(int i=2;i<seed+1;i++) {
				f=f*i;
			}
			return f;
		}
	}