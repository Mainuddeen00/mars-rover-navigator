# 🚀 Mars Rover Navigator

An interactive Full-Stack web application built with **Spring Boot** and **Vanilla JavaScript** that simulates navigating a Mars Rover across a bounded 10x10 plateau matrix (coordinates `0` to `9`).

---

## 🛰️ Tech Stack

- **Backend:** Java 17, Spring Boot 3.x (REST API)
- **Frontend:** HTML5, CSS3 (Futuristic HUD Theme), Vanilla JavaScript
- **Build Tool:** Maven

---

## 🧭 System Architecture & Movement Rules

The Rover starts at position `(0, 0)` facing **North (`N`)**. It updates its coordinates safely within a `0` to `9` bounding box according to standard compass movements:
- **`L`** / **`R`**: Rotate the rover 90 degrees left or right without shifting location.
- **`F`**: Move forward one grid space in the direction the rover is currently facing.

---

## 🛠️ Installation & Setup

Ensure you have **Java 17** and **Maven** installed on your local computer before continuing.

### 1. Clone the Repository
```bash
git clone https://github.com
cd mars-rover-navigator
```

### 2. Start the Backend API (Port 8080)
```bash
mvn spring-boot:run
```
The server will boot up locally at `http://localhost:8080`.

### 3. Start the Frontend Server (Port 3000)
Open a new terminal tab or window, navigate to the directory containing `FrontendLauncher.java`, and run:
```bash
javac FrontendLauncher.java
java FrontendLauncher
```
Open your web browser and navigate to **`http://localhost:3000`** to access the control room dashboard.

---

## 🔌 API Documentation

All back-end endpoints are prefixed under the `/api` routing space.

### 1. Get Telemetry Status
Retrieves the current coordinates and heading of the Rover.
- **URL:** `/api/status`
- **Method:** `GET`
- **Response:**
  ```json
  { "x": 0, "y": 0, "direction": "N" }
  ```

### 2. Transmit Movement Commands
Processes a sequential string of navigation instructions. Invalid characters are safely skipped.
- **URL:** `/api/move`
- **Method:** `POST`
- **Query Parameter:** `commands` (e.g., `FFRFFL`)
- **Response:**
  ```json
  { "x": 2, "y": 2, "direction": "N" }
  ```

### 3. Reset Telemetry Calibration
Resets the rover back to origin coordinates `(0,0,N)`.
- **URL:** `/api/reset`
- **Method:** `POST`
- **Response:**
  ```json
  { "x": 0, "y": 0, "direction": "N" }
  ```