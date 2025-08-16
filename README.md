## Oasis Infobyte Internship Tasks

# 1. Number Guessing Game 🎯

A fun and interactive **Java-based Number Guessing Game** where the computer generates a random number and the player has to guess it within limited attempts. This project was created as part of the **Oasis Infobyte Internship Task**.

## 📌 Features 
- Random number generation between a given range.
- User-friendly prompts to guide the player.
- Feedback on each guess (too high / too low).
- Multiple rounds support.
- Score tracking system.

## 🛠 Technologies Used
- **Java** (Core Programming) 
- **Scanner** class for user input.
- **Random** class for generating numbers.

## 🚀 How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/Number-Guessing-Game.git
   ```
2. Navigate to the project folder:
   ```bash
   cd Number-Guessing-Game
   ```
3. Compile the Java file:
   ```bash
   javac NumberGuessingGame.java
   ```
4. Run the program:
   ```bash
   java NumberGuessingGame
   ```

## 🎮 How to Play
1. The game will generate a random number between **1 and 100**.
2. You will have a limited number of attempts to guess it.
3. After each guess, you'll get hints:
   - `"Too high!"` if your guess is greater.
   - `"Too low!"` if your guess is smaller.
4. If you guess correctly, you win! 🎉
5. Play multiple rounds and track your score.

## 📂 Project Structure
```
📦 Number-Guessing-Game
 ┣ 📜 GameCode.java  # Main game logic
 ┗ 📜 README.md               # Project documentation
```

## 📌 Internship Info
This project was completed as part of the **Oasis Infobyte Internship Task** in Java Programming.

## 📧 Contact
For any queries or collaboration:
- Name: Akshra
- Email: akshradang@gmail.com
- GitHub: https://github.com/iakshra22

---
**Happy Coding! 💻**

#  2.💳 Secure ATM System 

 ## 📌 ABOUT PROJECT:

 This project is a **Java-based ATM Simulation** that mimics real-world ATM functionalities such as:
 - User Authentication (UserID + PIN)
 - Balance Inquiry
 - Cash Deposit
 - Cash Withdrawal
 - Mini Statement
 - Exit Option
 Unlike traditional ATM projects with databases, this project stores all **user data in Java collections (HashMap)**.
 
## 💡 Designed for beginners to understand:
→ Object-Oriented Programming (OOP)
→ Collections in Java (HashMap)
→ Code modularity (separate files for users, ATM logic, etc.)

 ## 📁 PROJECT STRUCTURE:
:- 📂 ATM_Interface
┣ 📜 ATM.java          → Main entry point
┣ 📜 User.java         → User data model (UserID, PIN, Balance)
┣ 📜 Database.java     → Preloaded 100+ dummy users
┣ 📜 README.md         → Documentation
 
 ## ⚙️ HOW TO RUN:
1️⃣ Open project in Eclipse/IntelliJ/VS Code (Java enabled).
2️⃣ Create a new package → `atm_interface`.
3️⃣ Inside it, add the following files:
*      - ATM.java
*      - User.java
*      - Database.java
4️⃣ Copy the code into respective files.
5️⃣ Run `ATM.java` as **Java Application**.

## 👤 SAMPLE LOGIN CREDENTIALS:
:- Database.java contains preloaded users like:
users.put("1001", new User("1001", "1111", 15000));
users.put("1002", new User("1002", "2222", 20000));
users.put("1003", new User("1003", "3333", 12000));
 *
 *    ... (100+ dummy entries available)
 *
 * 👉 You can modify / add more users directly in `Database.java`
 *
 * ------------------------------------------------
 * 📊 EXAMPLE OUTPUT:
 * ------------------------------------------------
 *
 *  ===== Welcome to Secure ATM =====
 *
 *  Enter User ID: 1001
 *  Enter PIN: 1111
 *
 *  ✅ Login Successful!
 *
 *  1. Check Balance
 *  2. Deposit
 *  3. Withdraw
 *  4. Mini Statement
 *  5. Exit
 *
 * ------------------------------------------------
 * 🛠️ FUTURE ENHANCEMENTS:
 * ------------------------------------------------
 *  - Connect with MySQL Database
 *  - Add ATM Card Expiry & CVV checks
 *  - Print Receipt feature
 *  - GUI-based ATM Interface
 *
 * ------------------------------------------------
 * 👩‍💻 AUTHOR:
 * ------------------------------------------------
   ✨ Developed by Akshra Dang (iakshra22)
  ================================================
 

