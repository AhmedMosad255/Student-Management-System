
-- Recreate the student table
CREATE TABLE student (
  entrynumber VARCHAR(50) PRIMARY KEY,  -- Assuming entrynumber is the unique identifier for students
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  contactnumber VARCHAR(15) NOT NULL,
  homecity VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Recreate the courses table
CREATE TABLE courses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  course_name VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create the grades table
CREATE TABLE grades (
  id INT AUTO_INCREMENT PRIMARY KEY,
  course_id INT NOT NULL,
  student_id VARCHAR(50) NOT NULL,
  grade VARCHAR(5) NOT NULL,
  CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses(id),  -- Foreign key for course
  CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(entrynumber)  -- Foreign key for student
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
