package View;

import javax.swing.JOptionPane;

import Controller.RedesController;

public class Main {

	public static void main(String[] args) {

		RedesController Rc = new RedesController();

		String os = Rc.os();

		System.out.println("Sistema Operacional: " + os);

		int opc = 0;
		while (opc != 9) {
			opc = Integer
					.parseInt(JOptionPane.showInputDialog("1 - Verificar ip \n 2 - Verificar ping \n 9 - Finalizar"));
			switch (opc) {
			case 1:
				if (os.contains("Windows")) {
					String process = "ipconfig";
					Rc.ip(process);
				} else {
					String process = "ifconfig";
					Rc.ip(process);
				}
				break;
			case 2:
				if (os.contains("Windows")) {
					String process = "PING -4 -n 10 www.google.com.br";
					Rc.ping(process);
				} else {
					String process = "PING -4 -c 10 www.google.com.br";
					Rc.ping(process);
				}
				break;
			case 9:
				System.out.println("Programa finalizado");
				System.exit(0);
			default:
				System.out.println("Opção Inválida");
			}
		}
	}
}
