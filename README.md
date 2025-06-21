PC Part Picker
This project is a full-stack web application designed to help users select PC components. The application features a Spring Boot backend with a PostgreSQL database and an Angular frontend.

Table of Contents
Project Overview

Prerequisites

Backend Setup (Spring Boot)

Frontend Setup (Angular)

Running the Application

Project Overview
Backend: Java, Spring Boot, Spring Security (JWT), Spring Data JPA, PostgreSQL

Frontend: TypeScript, Angular, Tailwind CSS

Database: PostgreSQL (managed with Docker)

Version Control: Git & GitHub

Prerequisites
Before you begin, ensure you have the following software installed on your new machine:

Git: To clone the repository. (Download Git)

Java Development Kit (JDK): Version 17 or later. (Download OpenJDK)

Apache Maven: To build the backend project. (Download Maven)

Node.js and npm: For the Angular frontend. (Download Node.js)

Angular CLI: Install globally after installing Node.js by running: npm install -g @angular/cli

Docker: To run the PostgreSQL database in a container. (Download Docker Desktop)

An IDE: A code editor like Visual Studio Code (VS Code) or IntelliJ IDEA.

A Database Client (Optional): A tool like DBeaver or pgAdmin to view the database.

Backend Setup (Spring Boot)
1. Clone the Repository
First, clone the project from your GitHub repository to your new machine.

git clone https://github.com/YOUR_USERNAME/your-repository-name.git
cd your-repository-name

(Replace the URL with your actual repository URL)

2. Set Up the PostgreSQL Database with Docker
You need a running PostgreSQL database for the backend to connect to. The easiest way to do this is with Docker.

Ensure Docker is running on your machine.

Open a new terminal and run the following command to start a PostgreSQL container. Replace your_db_name, your_db_user, and your_strong_password with the same credentials you used on your original machine.

# Replace 'pc-builder-postgres' with your preferred container name if you wish
docker run --name pc-builder-postgres -e POSTGRES_DB=your_db_name -e POSTGRES_USER=your_db_user -e POSTGRES_PASSWORD=your_strong_password -p 5432:5432 -d postgres

This command creates and starts a PostgreSQL container in the background, accessible on localhost:5432.

3. Configure Backend Environment Variables
Our Spring Boot application uses an environment variable for the database password to keep it secure. You need to set this up in your IDE's run configuration.

For VS Code:

Open the project root folder (pc-assembly) in VS Code.

Go to the "Run and Debug" view.

Create or open the launch.json file inside the .vscode folder.

In the configuration for launching your Spring Boot app, add an env block:

{
  "type": "java",
  "name": "Launch PcbuilderapiApplication",
  "request": "launch",
  "mainClass": "com.example.pcbuilderapi.PcbuilderapiApplication",
  "projectName": "pcbuilderapi",
  "env": {
    "DB_PASSWORD": "your_strong_password" // <-- Set your password here
  }
}

For IntelliJ IDEA:

Open the backend/pcbuilderapi folder as a project.

Go to Run -> Edit Configurations....

Select your PcbuilderapiApplication.

In the "Environment variables" field, add: DB_PASSWORD=your_strong_password

Frontend Setup (Angular)
1. Navigate to the Frontend Directory
In your terminal, navigate into your Angular project's folder.

cd frontend/your-angular-app-name 
# (e.g., cd frontend/pc-parts-ui)

2. Install Dependencies
Run npm install to download all the necessary libraries defined in package.json.

npm install

This might take a few minutes.

Running the Application
To run the full-stack application, you need to start both the backend and the frontend servers.

1. Run the Backend Server
Open the backend project (pcbuilderapi) in your IDE (VS Code or IntelliJ).

Run the main application class PcbuilderapiApplication.java using the launch configuration you set up in the backend setup section.

The backend will start up and connect to your PostgreSQL Docker container. You should see logs indicating it has started on port 8080.

2. Run the Frontend Server
In your terminal, make sure you are in the Angular project directory (.../frontend/your-angular-app-name/).

Run the Angular development server:

ng serve

The frontend will compile and start. Once it's ready, it will be available at http://localhost:4200.

Accessing the Application
Once both servers are running:

Open your web browser and go to http://localhost:4200.

You should see your application's homepage. The Angular frontend will make API calls to the Spring Boot backend running on localhost:8080.

You now have the complete development environment set up on your new machine!
