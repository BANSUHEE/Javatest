//  <재네릭 컬렉션> 형식


package Stack;

public class GenericEx1<T> {

	T[] v;

	public void set(T[] n) {
		v = n;
	}

	public void print() {
		for (T s : v)
			//out.println(s);
	}

	public class GennericEx1Main{
	public static void main(String[]args) {
			  GenericEx1<String> t = new GenericEx1<String>();
			  
			  String[]ss = {"애","아","서"};
			  t.set(ss);
			  t.print();
		  }
	}

}