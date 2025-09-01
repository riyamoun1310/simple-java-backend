# Simple CSV Analyzer API (Java & Spring Boot)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

**Status:** 🚧 Work in Progress 🚧

## 🎯 Goal

This project is a simple REST API built with **Java** and **Spring Boot** to upload and perform basic analysis on CSV files. The primary goal is to demonstrate my ability to quickly learn and apply backend principles in the Java ecosystem, showcasing skills in API development and file handling.

This project is inspired by my more complex Python-based [Data-Analyst-Agent](https://github.com/riyamoun1310/Data-Analyst-Agent).

## ✨ Features

-   [x] Upload CSV files via a REST API endpoint.
-   [x] Perform basic analysis: calculate and return the number of rows and columns.
-   [ ] *(Coming Soon)* Return a sample of the first few rows from the CSV.

## 🛠️ Tech Stack

-   **Language:** Java 17
-   **Framework:** Spring Boot 3
-   **Build Tool:** Maven
-   **Libraries:**
    -   Spring Web (for REST APIs)
    -   Apache Commons CSV (for CSV parsing)

## 🚀 Getting Started

### Prerequisites

-   JDK 17 or later
-   Apache Maven

### Installation & Running the App

1.  **Clone the repository:**
    ```bash
    git clone [YOUR_NEW_JAVA_REPO_URL]
    cd [YOUR_REPO_NAME]
    ```

2.  **Build the project using Maven:**
    ```bash
    ./mvnw clean install
    ```

3.  **Run the application:**
    ```bash
    java -jar target/your-application-name-0.0.1-SNAPSHOT.jar
    ```
    The application will start on `http://localhost:8080`.

## ⚙️ API Usage

### Upload and Analyze a CSV file

Upload a CSV file to get its row and column count.

-   **Endpoint:** `POST /upload`
-   **Request Type:** `multipart/form-data`
-   **Form Key:** `file`

#### Example using `cURL`:

```bash
curl -X POST -F "file=@/path/to/your/data.csv" http://localhost:8080/upload