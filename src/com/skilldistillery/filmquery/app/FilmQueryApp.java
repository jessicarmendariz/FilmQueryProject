package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int userInput = 0;
		do {
			try {
				menu();
				userInput = input.nextInt();
				switch (userInput) {
					case 1:
						searchFilmById(input);
						break;
					case 2:
						searchFilmByKeyword(input);
						break;
					case 3:
						break;
					default:
						System.err.println("Please pick an option from the menu.");
				}
			} catch (InputMismatchException e) {
				System.err.println("invalid input please pick an option from the menu. \n");
				input.next();
			}
		} while (userInput != 3);
		System.out.println("Goodbye!");

	}

	private void menu() {
		System.out.println("1. Search by Film ID");
		System.out.println("2. Search by Keyword");
		System.out.println("3. Exit");
		System.out.println("Make A Selection: ");
	}

	private void searchFilmById(Scanner input) {
		int filmId = 0;
		do {
			try {
				System.out.print("Enter Film ID: ");
				filmId = input.nextInt();
				Film film = db.findFilmById(filmId);
				if (film == null) {
					System.err.println("Film Not Found \n");
				} else {
					displayFilm(film);
				}
			} catch (InputMismatchException e) {
				System.err.println("Invalid Entry - Please Make a Selection from the Menu: \n");
				input.next();
			}
		} while (filmId == 0);

	}

	private void searchFilmByKeyword(Scanner input) {
		String keyword = null;
		do {
			System.out.print("Enter Keyword: ");
			keyword = input.next();
			List<Film> films = db.findFilmByKeyword(keyword);
			if (films.size() == 0) {
				System.err.println("Film Not Found \n");
			} else {
				for(Film film : films) {
					displayFilm(film);
				}
			}
		} while (keyword == null);

	}

	private void displayFilm(Film film) {
		System.out.println("\nFilm Title: " + film.getTitle() + "\nRelease Year: " + film.getReleaseYear() + "\nRating: " + film.getRating() + "\nLanguage: " + film.getFilmLanguage()  +  "\nDescription: " + film.getDescription() + "\nActors: " + film.getActors() + "\n");
	}

}