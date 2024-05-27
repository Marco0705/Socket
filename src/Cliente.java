
// Importo las librer�as necesarias 
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {

		// Creo la clase scanner para pedirle datos al usuario
		Scanner scan = new Scanner(System.in);

		// Creaci�n del socket y conexi�n con la direcci�n del servidor (localhost)
		Socket miSocket = new Socket("localhost", 6666);

		// Indico que el flujo de salida del programa va a ser el socket
		DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());

		// Le pregunto al usuario que operaci�n quiere realizar
		System.out.print("Introduce la operaci�n: ");
		String mensaje = scan.nextLine();

		// Escribo en el flujo de salida lo que haya puesto el usuario
		flujoSalida.writeUTF(mensaje);

		// Cierro los recursos
		flujoSalida.close();
		miSocket.close();
		scan.close();
	}
}
