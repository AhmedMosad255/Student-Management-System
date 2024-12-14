# Student Management System

## Overview

The Student Management System is a desktop application developed using Java Swing and JFrame for the user interface, and MySQL for database management. The project implements the Factory design pattern to manage students based on their status, such as undergraduate or graduate. The system supports CRUD (Create, Read, Update, Delete) operations for student records.

## Features

- **User Interface**: Built using Java Swing and JFrame for an intuitive user experience.
- **Database Management**: MySQL is used to store student data, course details, and grades.
- **Design Patterns**:
  - **Singleton Pattern**:
    - *Course Registration System*: Ensures that course enrollments are handled by a single instance across the application.
    - *Grade Processing System*: Guarantees that grade calculations are managed by a single instance.
  - **Factory Pattern**:
    - *Course Factory*: Dynamically creates different types of courses (Core, Elective, Lab).
    - *Student Factory*: Dynamically creates different types of students (Undergraduate, Graduate, Part-time).
- **CRUD Operations**: Enables users to manage student records and course registrations.

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
   git clone https://github.com/AhmedMosad255/Student-Management-System.git
   cd student-management-system

![Screenshot (120)](https://github.com/user-attachments/assets/84c6fe51-6c92-47e7-9d6d-54a77408232b)
![Screenshot (121)](https://github.com/user-attachments/assets/c5e1a702-fb34-46f5-a6ed-ce70407f2d2c)
![Screenshot (122)](https://github.com/user-attachments/assets/c2ed8494-a460-46df-a651-ddc588c4d503)
![Screenshot (123)](https://github.com/user-attachments/assets/b4700712-4081-41ed-851e-a68ed36f289b)



