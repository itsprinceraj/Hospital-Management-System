# 🏥 Hospital Management System

Welcome to the **Hospital Management System** repository! This project is a comprehensive Java application designed to efficiently manage key hospital operations including patient registration, doctor information, appointments, and billing.

## ✨ Features
- **Patient Management**: Register and manage patient details effortlessly.
- **Doctor Directory**: Keep track of doctor information and specializations.
- **Appointments**: Schedule, modify, and cancel patient appointments.

## 🛠️ Technologies Used
- **Java**: Core logic and backend functionality.
- **JDBC/SQL**: For database interactions.


## 🚀 Getting Started
1. **Clone the repository**:
   ```bash
   git clone https://github.com/itsprinceraj/Hospital-Management-System.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd Hospital-Management-System
   ```
3. **Compile and run the project** using your preferred IDE or the command line.

## 📂 Project Structure
- **src/**: Contains all the Java source code files.
- **.gitignore**: Lists files to be ignored by Git.
- **Hospital Management System.iml**: IntelliJ IDEA module file.

## 📊 Database Table Details
### 1. Patients Table
| Column Name      | Data Type     | Description                    |
|------------------|---------------|--------------------------------|
| id               | INT (Primary) | Unique identifier for patients |
| name             | VARCHAR       | Patient's full name            |
| age              | INT           | Patient's age                  |
| gender           | VARCHAR       | Patient's gender               |


### 2. Doctors Table
| Column Name      | Data Type     | Description                          |
|------------------|---------------|--------------------------------------|
| id               | INT (Primary) | Unique identifier for doctors        |
| name             | VARCHAR       | Doctor's full name                   |
| specialization   | VARCHAR       | Area of specialization               |


### 3. Appointments Table
| Column Name      | Data Type     | Description                                    |
|------------------|---------------|------------------------------------------------|
| id               | INT (Primary) | Unique identifier for appointments             |
| patient_id       | INT (Foreign) | Identifier linking to the patient              |
| doctor_id        | INT (Foreign) | Identifier linking to the doctor               |
| appointment_date | DATE          | Scheduled date for the appointment             |



## 🤝 Contribution
Contributions are welcome! Feel free to fork this repo and submit pull requests.


**Enjoy managing your hospital operations with ease!** 🏧✨

