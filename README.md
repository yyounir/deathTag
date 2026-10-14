# DeathTag

## 🍿 Overview
**Death Tag** is a 2D Java-based game project. Built using the Eclipse IDE, the game features a custom rendering engine with sprite animations, collision detection, and a rich variety of interactive items and creatures. 

## 🎮 Features
Based on the core class architecture, the game includes:
* **Custom Game Engine:** Powered by `GameBase` and `GameS26` classes to handle the main game loop and logic.
* **Entity Management:** Utilizes a central `Sprite` class to manage on-screen elements, alongside an `Animation` class for dynamic visuals.
* **Environment & Physics:** Features collision and boundary systems using `Rect`, `Wall`, `Obstacle`, and `NonObstacles` classes.
* **Dynamic Backgrounds:** Handled by the `Background` class, with specific stage elements like `maze1.png`.

## 🕹️ Controls
While specific keybindings can be configured in the main game loop, the game defaults to standard 2D top-down controls:
* **Movement:** `W`, `A`, `S`, `D` or **Arrow Keys** to move Violetta or Youn.
* **Interaction/Action:** Typically `Spacebar` or `Enter` (check `GameBase.java` for specific event listeners).
* **UI/Menu:** `Escape` to pause or exit menus.

## 👤 Characters & Enemies
### Playables
* **Youn:** The main character, featuring 4-directional sprite animations (Up, Down, Left, Right).
* **Violetta:** The enemy, chases after Youn

## 🍕 Foods
The game is packed with a massive assortment of food-based sprites, used for collection, increasing speed, abd scoring. Highlights include:
* **Fruits & Veggies:** Apple, Avocado, Cherry, DragonFruit, Eggplant, Lemon, Olive, Onion, Peach, Peppers (Green/Red), Potato, Strawberry, Tomato, and Turnip.
* **Baked Goods & Sweets:** Bread, Brownie, Cookie, Honeycomb, Jam, Marmalade, Pretzel, Roll, Tart, and Waffles.
* **Pies:** Apple Pie, Lemon Pie, and Pumpkin Pie.
* **Meats & Proteins:** Chicken, Chicken Leg, Eggs, Fish (Fillet & Steak), Jerky, Pepperoni, Ribs, Sardines, Sashimi, Shrimp, Steak, and Sushi.
* **Beverages:** Beer, Moonshine, Saki, Stein, and Whiskey.

## ⚙️ Technical Details
* **Language:** Java
* **IDE:** Eclipse (includes `.project` and `.classpath` configuration files)
* **Game Loop & State:** Driven by the `GameBase` and `GameS26` classes.
* **Physics & Collisions:** Implements 2D collision using bounding boxes (`Rect`), walls (`Wall`), and interactable objects (`Obstacle`, `NonObstacles`).

## 🖼️ Assets
All game assets are packed directly alongside the compiled code within the `/bin/` directory:
* **Sprites:** PNG format (`.png`) with transparency, handling everything from food items to characters and level layouts (e.g., `maze1.png`, `complete.png`, `gameover.png`).
* **Typography:** Utilizes a custom TrueType Font, `Jersey10-Regular.ttf`, for in-game text rendering.

## 🏗️ Project Structure
```text
deathTag/
├── .settings/            # Eclipse workspace preferences
├── .classpath            # Eclipse build path config
├── .project              # Eclipse project definition
├── README.md             # Project documentation
├── src/                  # Java Source Code
│   ├── Animation.java    # Handles sprite sheet cycling
│   ├── Background.java   # Manages map rendering
│   ├── BadChar.java      # Enemy logic and AI
│   ├── Food.java         # Collectible item logic
│   ├── GameBase.java     # Core engine and graphics context
│   ├── GameS26.java      # Main execution and game loop
│   ├── Obstacle.java     # Solid level objects
│   ├── Sprite.java       # Base entity class
│   └── ... (Character & Environment classes)
├── image/                # Raw image assets (.png)
└── bin/                  # Compiled .class files and packed runtime assets
```

## 🚀 How to Run

Because this project includes Eclipse configuration files, running it via the Eclipse IDE is the most straightforward method:

1. **Prerequisites:** Ensure you have the Java Development Kit (JDK) installed on your system, as well as Eclipse, this is essential to run the game in general.
2. **Download:** Clone or download the repository to your local machine.
3. **Import to Eclipse:** 
   * Open Eclipse IDE.
   * Go to **File** > **Import...**
   * Select **General** > **Existing Projects into Workspace** and click **Next**.
   * Browse to the downloaded `deathTag` folder and click **Finish**.
4. **Run the Game:** 
   * In the Package Explorer, navigate to the `/bin/` folder or your source folder.
   * Locate the main execution class (likely `GameS26.java` or `GameBase.java`).
   * Right-click the file, select **Run As** > **Java Application**.

*(Alternatively, you can run the compiled `.class` files directly from the command line using `java GameS26` inside the `/bin/` directory, provided your classpath is set correctly.)*

## 📹 Video Explanation
https://www.loom.com/share/1986f3357ab84d95ac132d7dd857bd12

## 🙌 Associated With
CMP 429 - Videogame Development <br/>
CUNY Lehman College
