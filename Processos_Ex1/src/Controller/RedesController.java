package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	private static String os() {

		String os = System.getProperty("os.name");
		return os;

	}

	public void ip() {
		String os = Controller.RedesController.os();
		String process = " ";
		if (os.contains("Windows")) {
			process = "ipconfig";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("IPv4")) {
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (os.contains("Linux")) {
			process = "ifconfig";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("netmask")) {
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void ping() {
		String os = Controller.RedesController.os();
		String process = " ";
		if (os.contains("Windows")) {
			process = "PING -4 -n 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("M�dia")) {
						String VT[] = linha.split(",");
						for (String media : VT) {
							if (media.contains("M�dia")) {
								System.out.println(media);
							}
						}
					}
					linha = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (os.contains("Linux")) {
			process = "ping -4 -c 10 www.google.com.br";
		}
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("rtt")) {
					String VT[] = linha.split("/");
					String media = VT[4];
					System.out.println("Tempo médio do ping: " + media + " ms");

				}
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
