# Defence System

## Overview
A Java Swing application that simulates a military defence system with three units (Tank, Helicopter, and Submarine) controlled by a central command center. The application demonstrates the Observer design pattern for communication between different military units.

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

## Demo
![Recording 2025-05-01 193455](https://github.com/user-attachments/assets/ab8e3f4c-867c-49f6-950e-b537d56eebfc)

## License
This project is provided for educational purposes only.

## Author
- Sadeepa Herath
