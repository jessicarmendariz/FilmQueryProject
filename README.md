# Film Query Application


### Overview
The Film Query Application is an application that allows a user to search movies based on the movie's Film ID, if they know it, or by using a keyword search. After finding the movie the user is looking for, the application will display the Title, Release Year, Rating, Movie Language, a Description, and the Starring Actors of the movie. After finding the information they were looking for, they can search another movie or the user can choose to exit the application.

### How To Use
Open the Film Query Application. The Main Menu will prompt the user to search by Film ID, by Keyword Search, or to Exit the program if they decide not to look anything up. When an invalid entry is selected, the application will return an Invalid Entry alert. If the film cannot be found, a Film Not Found alert will be returned. If the application is able to find the film based on the Film ID or based on a keyword search, the application will return the Title, Release Year, Rating, Movie Language, a Description, and the Starring Actors of the movie.

### Building Film Query

For the Film Query Application, multiple technologies were used:
- MySQL
- JDBC
- Maven
- Array List
- Switch
- Scanner
- While Loops

Problem:

Solution:

Problem: When the application is running and you use menu option 1 - Search by Film ID - and you enter an ID that doesn't exist the application will return "Film Not Found" and the Main Menu will reappear to allow the user to make another selection. If you selection menu option 2 - Search by Keyword - and you enter a keyword that doesn't match a film, the application will show the Main Menu again and then print the error "Film Not Found". I am searching for a way to print the alert first, and then repeat the Main Menu.

Solution:
