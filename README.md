# Defence System

## Overview
A Java Swing application that simulates a military defence system with three units (Tank, Helicopter, and Submarine) controlled by a central command center. The application demonstrates the Observer design pattern for communication between different military units.

## Project Structure
```
Defence-System/
├── src/
│   ├── DesignPatern/
│   │   ├── Observable.java     # Implementation of the Observable pattern
│   │   └── Observer.java       # Interface for observer objects
│   ├── Images/
│   │   ├── cama.jpg            # Background image
│   │   ├── helicopter.jpg      # Helicopter unit image
│   │   ├── main.jpg            # Main controller image
│   │   ├── subMarine.jpg       # Submarine unit image
│   │   └── tank.jpg            # Tank unit image
│   ├── Start/
│   │   └── Start.java          # Main entry point for the application
│   └── Units/
│       ├── Helicopter.java     # Helicopter unit implementation
│       ├── Helicopter.form     # Helicopter GUI form
│       ├── MainController.java # Main control center implementation
│       ├── MainController.form # Main control center GUI form
│       ├── Submarine.java      # Submarine unit implementation
│       ├── Submarine.form      # Submarine GUI form
│       ├── Tank.java           # Tank unit implementation
│       └── Tank.form           # Tank GUI form
```

## Features
- **Command and Control System**: Central command center for coordinating military units
- **Multiple Defence Units**: Tank, Helicopter, and Submarine units with unique capabilities
- **Communication System**: Message passing between units and command center
- **Resource Management**: Monitor and manage fuel, ammunition, and personnel
- **Real-time Updates**: Status changes are reflected across all units

## Functionality
- **Main Controller**:
  - Adjust strength levels affecting unit capabilities
  - Send messages to all units or specific units
  - Request unit information
  - Control area clearance status

- **Units (Tank, Helicopter, Submarine)**:
  - Perform unit-specific operations based on strength levels
  - Send and receive messages
  - Monitor resources (fuel, ammunition, personnel)
  - Change position to enable/disable operations

## Design Patterns
The system implements the **Observer Pattern**:
- `Observable` class: Manages communication between units
- `Observer` interface: Implemented by all units to receive updates

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- NetBeans IDE (recommended for form editing)

### Running the Application
1. Clone the repository
2. Open the project in NetBeans IDE
3. Run the `Start.java` file in the `src/Start` directory

## Building from Source
```bash
# Navigate to project directory
cd Defence-System

# Build the project using Ant
ant build

# Run the application
java -jar dist/Course_Work.jar
```

## Screenshots
*(Include screenshots of the application here)*

## License
This project is provided for educational purposes only.

## Author
- ICET Defence Systems Team