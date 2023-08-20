# Snake_AI

# Snake Game AI Agent

Welcome to the Snake Game AI Agent project! This Java implementation allows an AI agent to compete in the Snake game environment. The agent employs various strategies to navigate the grid, avoid obstacles, and consume apples, all while competing against other snakes.

## Getting Started

To run the Snake game AI agent, follow these steps:

1. Clone or download this repository to your local machine.

2. Make sure you have Java JDK installed on your system.

3. Open a terminal or command prompt and navigate to the directory where the repository is located.

4. Compile the code using the following command:

   ```bash
   javac MyAgent.java
   ```
Run the compiled code:
   ```bash
   java MyAgent
   ```

 ### Game Environment
The Snake game environment is represented by a grid of cells. Each cell can contain different entities:

+ 0: Empty cell
+ A: Apple
+ S: Snake's head
+ *: Path taken by the AI agent during calculations
+ 1: AI-controlled snake
+ 2: Zombie snake
+ 8: Enemy snake

### AI Strategies 
The AI agent employs the following strategies to play the game:

1. Pathfinding: The agent uses a BFS-based pathfinding algorithm to find the shortest path to the nearest apple while avoiding obstacles.

2. Collision Avoidance: The agent keeps track of other snakes' positions and avoids collisions by choosing safe paths.

3. Zombie Management: The agent identifies zombie snakes (snakes that have been eliminated) and updates the board to represent their potential threat.

4. Decision Making: The agent evaluates the available moves, considers potential outcomes, and selects the best move based on the calculated pathfinding and collision avoidance.

### Code Structure
+ MyAgent.java: The main class containing the AI agent implementation. It reads game input, processes the game state, and makes decisions to control the snake's movements.

+ Pointy.java: A utility class representing a point with x and y coordinates.

+ shortestpath.java: Contains the BFS-based shortest pathfinding algorithm to find the optimal path to the nearest apple.

+ Logger1.java: A utility class for logging game board states and information.

### Customization
Feel free to experiment with different AI strategies, enhance the pathfinding algorithm, or implement advanced decision-making mechanisms to improve the AI agent's performance.

### Acknowledgments
This project was developed as part of an AI development exercise at the University of Witwatersrand and can serve as a starting point for more sophisticated Snake game AI agents.

