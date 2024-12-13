# Student Management System

## Overview

The Student Management System is a desktop application developed using Java Swing and JFrame for the user interface, and MySQL for database management. The project implements the Factory design pattern to manage students based on their status, such as undergraduate or graduate. The system supports CRUD (Create, Read, Update, Delete) operations for student records.

## Features

- **User Interface**: Developed using Java Swing and JFrame to provide a responsive and user-friendly interface.
- **Database Management**: MySQL is used to store and manage student data efficiently.
- **Design Patterns**: 
  - **Factory Pattern**: Used to create student objects dynamically based on their status (Undergraduate, Graduate).
- **CRUD Operations**: Allows users to perform Create, Read, Update, and Delete operations on student records.

## Project Structure

- **src**: Contains the Java source files.
  - **student.management.system**: Package containing the main classes for the application.
    - `StudentManagementApp.java`: The main class that sets up the user interface and handles events.
    - `Student.java`: Abstract base class for student types.
    - `UndergraduateStudent.java`: Class representing undergraduate students.
    - `GraduateStudent.java`: Class representing graduate students.
    - `StudentFactory.java`: Factory class to create student objects based on their status.
    - `Menu.java`: Class for the main menu interface.
    - `UpdateStudent.java`: Class for updating student details.
    - `ViewStudent.java`: Class for viewing student details.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database
- An Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans

### Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/student-management-system.git
   cd student-management-system

![Screenshot (118)](https://github.com/user-attachments/assets/73453574-3d2a-42c5-9067-11491c9bd2d2)
![Screenshot (119)](https://github.com/user-attachments/assets/004d48ed-149d-4ae0-a276-806bcf390d25)

