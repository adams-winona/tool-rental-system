# Tool Rental App

This is a Java-based console application that simulates a point-of-sale tool rental system for a hardware store. It handles tool rental transactions, applies holiday/weekend rules, and generates detailed rental agreements.

---

## ✅ Features

- Tool rental calculation based on type, date, and rental duration
- Holiday-aware pricing (Independence Day & Labor Day)
- Chargeable days calculation per tool type
- Discount application and charge breakdown
- Custom exception handling
- JUnit 5 test suite covering all business cases

---

## 🛠 Technologies Used

- Java 21
- Maven
- JUnit 5

---

## 🚀 How to Run

### Prerequisites:
- Java 17+ installed
- Maven installed

### Run the App:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.example.toolrental.Main"
```

Or run `Main.java` directly in IntelliJ.

---

## 🧪 Running Tests

```bash
mvn test
```

Or right-click `ToolRentalTests.java` in IntelliJ and select **Run**.

---

## 📂 Project Structure

```
src/
├── main/
│   └── java/
│       └── com.example.toolrental/
│           ├── model/
│           ├── service/
│           ├── exception/
│           └── Main.java
├── test/
│   └── java/
│       └── com.example.toolrental/
│           └── ToolRentalTests.java
```

---

## 📋 Assignment Notes

- No external database or UI required.
- Full coverage of all tool types and business cases in tests.
- Holiday rules and discount logic implemented as per spec.