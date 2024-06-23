package uam.fia.jaguarcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaguarcareApplication {

	public static void main(String[] args) {
		String applicationTitle = "Universidad Americana";
		String applicationVersion = "1.0.0";

		String asciiArt =
				"      ,--.                                                                  \n" +
						"     |  | ,--,--. ,---.,--.,--. ,--,--.,--.--. ,---. ,--,--.,--.--. ,---.  \n" +
						" ,--. |  |' ,-.  || .-. |  ||  |' ,-.  ||  .--'| .--'' ,-.  ||  .--'| .-. : \n" +
						" |  '-'  /\\ '-'  |' '-' '  ''  '\\ '-'  ||  |   \\ `--.\\ '-'  ||  |   \\   --. \n" +
						"  `-----'  `--`--'.`-  / `----'  `--`--'`--'    `---' `--`--'`--'    `----' \n" +
						"                  `---'                                                      \n" +
						"${application.title} ${application.version}\n" +
						"Powered by Spring Boot";

		String display = asciiArt
				.replace("${application.title}", applicationTitle)
				.replace("${application.version}", applicationVersion);

		System.out.println(display);

		SpringApplication.run(JaguarcareApplication.class, args);
	}

}
