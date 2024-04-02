//<자바 저장 루틴 >


package Stack;
import java.util.*;
import static java.lang-System.out;

public class HashSetEx1 {

	public static void main(String[] args) {
		String[]str = {"Java","Beans","Java","Xml"};
		
		HashSet<String>hs1 = new HashSet<String>();
		HashSet<String>hs2 = new HashSet<String>();
		for(String n :str) {
			if(!hs1.add(n))
				hs2.add(n);
		}
		out.println("hs1 :" + hs1);
		hs1.removeAll(hs2);
		out.println("hs1 :" +hs1);
		out.println("hs2 :" +hs1);
		}
	

	}

