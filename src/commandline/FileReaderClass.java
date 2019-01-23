package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderClass {
	
	ArrayList<Card> deck;

	public void getCardsFromFile() {

		FileReader fR = null;
//		Game currentGame = new Game();
		deck = new ArrayList();
		try {
			// String filePath = "C:\\Users\\james\\Desktop\\msc\\MsC-Assignment\\src\\commandline\\StarCitizenDeck.txt";
			String filePath = "C:\\Users\\srawl\\OneDrive\\Documents\\SoftwareEngineering Back Up\\TeamProject\\MScIT_TeamProject_TemplateProject\\StarCitizenDeck.txt";
			fR = new FileReader(filePath);
			Scanner s = new Scanner(fR);
			String line = s.nextLine();

			while (s.hasNextLine()) {
				line = s.nextLine();
				String[] lineProcess = line.split(" ");
//				Card cardObject = new Card();
				Card cardObject = Card.createCard(lineProcess);
				deck.add(cardObject);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No file found");
			e.printStackTrace();

		} finally {
			try {
				fR.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}

		

	}
	public ArrayList getDeck() {
		return deck;
	}
}