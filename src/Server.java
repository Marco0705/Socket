
// Importo las librerías necesarias
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	// Función sumar
	public static int suma(int a, int b) {
		return a + b;
	}

	// Función restar
	public static int resta(int a, int b) {
		return a - b;
	}

	// Función multiplicar
	public static int multiplicar(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) throws IOException {

		// Creación del socket y aignación del puerto
		ServerSocket server = new ServerSocket(6666);

		// Escucha y aceptación
		Socket miSocket = server.accept();

		// Indico que el flujo de entrada del programa va a ser el socket
		DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());

		// Recojo lo que haya en el flujo y lo guardo en forma de texto
		String mensaje = flujoEntrada.readUTF();

		// Si el mensaje contiene el símbolo "+"
		if (mensaje.contains("+")) {
			mensaje = mensaje.replace(" ", ""); // Reemplazo los espacios por la nada
			int operando = mensaje.indexOf("+"); // Miro donde está la posición del operando
			int n1 = Integer.parseInt(mensaje.substring(0, operando)); // Recojo el String hasta el operando
			int n2 = Integer.parseInt(mensaje.substring(operando + 1)); // Recojo el String desde el operando al final
			System.out.println("El resultado es: " + suma(n1, n2)); // Llamo a la función para que calcule la suma

			// Si el mensaje contiene el símbolo "-"
		} else if (mensaje.contains("-")) {
			mensaje = mensaje.replace(" ", ""); // Reemplazo los espacios por la nada
			int operando = mensaje.indexOf("-"); // Miro donde está la posición del operando
			int n1 = Integer.parseInt(mensaje.substring(0, operando)); // Recojo el String hasta el operando
			int n2 = Integer.parseInt(mensaje.substring(operando + 1)); // Recojo el String desde el operando al final
			System.out.println("El resultado es: " + resta(n1, n2)); // Llamo a la función para que calcule la resta

			// Si el mensaje contiene el símbolo "*"
		} else if (mensaje.contains("*")) {
			mensaje = mensaje.replace(" ", ""); // Reemplazo los espacios por la nada
			int operando = mensaje.indexOf("*"); // Miro donde está la posición del operando
			int n1 = Integer.parseInt(mensaje.substring(0, operando)); // Recojo el String hasta el operando
			int n2 = Integer.parseInt(mensaje.substring(operando + 1)); // Recojo el String desde el operando al final
			System.out.println("El resultado es: " + multiplicar(n1, n2)); // Llamo a la función para que calcule la
																			// multiplicación

			// Si el usuario realiza cualquiero otra cosa le aparece mensaje de error
		} else {
			System.err.println("Introduce una operación válida");
		}

		// Cierro los recursos
		flujoEntrada.close();
		miSocket.close();
		server.close();
	}
}
