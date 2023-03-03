package View;

import javax.swing.JOptionPane;

import Controller.RedesController;

public class Main {

	public static void main(String[] args) {

		RedesController Rc = new RedesController();

		int opc = 0;
		while (opc != 9) {
			opc = Integer
					.parseInt(JOptionPane.showInputDialog("1 - Verificar ip \n 2 - Verificar ping \n 9 - Finalizar"));
			switch (opc) {
			case 1:
				Rc.ip();
				break;
			case 2:
				Rc.ping();
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
