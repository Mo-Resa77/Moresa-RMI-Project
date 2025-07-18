🔷 MoResa Project
📌 Overview
The MoResa Project is a distributed system implemented in Java using RMI (Remote Method Invocation) to calculate the minimum number of coins needed to reach a target amount using unique non-zero digits derived from a registration number.
The system follows a client-server architecture, where:

The server processes the core logic.

The client interacts with the server to obtain results.

📂 Project Structure
The project consists of the following key Java files:

Moresa.java
Defines the Moresa class, a serializable data structure holding:

the minimum number of coins

the unique digits used

RemoteMoresa.java
Defines the RMI interface with:

service name

port

the method signature: calculate(int targetAmount, String regNo)

MoresaServer.java
Implements the server logic, including:

extracting unique digits from the registration number

computing the result using a greedy algorithm

MoresaClient.java
Implements the client interface, which:

takes user input (registration number and target amount)

communicates with the server via RMI

displays the result

🌟 Features
✅ Unique Digit Extraction
Extracts unique non-zero digits from the given registration number, ignoring duplicates.

⚙️ Greedy Coin Calculation
Uses a greedy algorithm to calculate the minimum number of coins needed.

🔗 RMI-Based Communication
Uses Java RMI to ensure:

smooth client-server communication

each client receives its own result instance

⚠️ Error Handling
Returns -1 if the target amount cannot be achieved with the available digits.

🧰 Prerequisites
Before running the project, ensure the following:

Java Development Kit (JDK 8 or higher)

A Java IDE (e.g., NetBeans, IntelliJ IDEA) or terminal tools

Basic understanding of:

Java RMI

Distributed Systems

▶️ Setup & Running Notes
🚫 The server excludes 0 from coin denominations.

🔽 The greedy algorithm sorts digits in descending order for optimal results.

❌ If the target cannot be reached, -1 is returned.

📡 RMI service:

Service name: MoresaService

Port: 1099
