package Star_7;

public class Star_3 {public static void main(String[] args) {
	int line = 3;
	for (int j = 0; j < line; j++) {
		for (int i = 0; i < line - 1; i++) {
			System.out.print(' ');
		}
		System.out.println('*');

		for (int k = 0; k <= j; k++) {
			System.out.println("*");
		}
		System.out.println();
	}
}

}
