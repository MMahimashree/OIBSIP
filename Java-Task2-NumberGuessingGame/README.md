# OIBSIP Java Development - Task 2
# Number Guessing Game

## Objective

The objective of this project is to develop a Java-based Number Guessing Game in which the computer generates a random number and the user attempts to guess it with helpful hints.

## Features

- Generates a random number.
- Provides Easy, Medium, and Hard difficulty levels.
- Easy mode: numbers from 1 to 50 with 10 attempts.
- Medium mode: numbers from 1 to 100 with 7 attempts.
- Hard mode: numbers from 1 to 200 with 5 attempts.
- Accepts user guesses through the console.
- Displays "Too High!" when the guess is greater than the target.
- Displays "Too Low!" when the guess is smaller than the target.
- Displays "Correct!" when the user guesses the number.
- Tracks the number of attempts.
- Displays a "You Lost!" message when the maximum attempts are reached.
- Reveals the correct number when the player loses.
- Supports playing multiple rounds.
- Tracks rounds won.
- Displays a round summary.

## Technologies Used

- Java
- Java Standard Library
- java.util.Random
- java.util.Scanner
- Conditional statements
- Loops

## How to Run

1. Open the project in IntelliJ IDEA.
2. Open `Main.java`.
3. Run the `Main` class.
4. Select a difficulty level.
5. Enter guesses when prompted.
6. Follow the hints until the number is guessed or the maximum attempts are reached.
7. Choose whether to play another round.

## Project Structure

```text
OIBSIP_Java_Task2
│
├── src
│   └── Main.java
│
├── screenshots
│   ├── 01_game_start.png
│   ├── 02_too_high_too_low.png
│   ├── 03_correct.png
│   ├── 04_round_summary.png
│   └── 05_game_over.png
│
└── README.md