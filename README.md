# 🧪 Storage Monitor Automation (BDD Edition)

Behavior-Driven Development (BDD) style end-to-end automation suite for the [Storage Monitor App](https://github.com/sabligeri/storage-monitor-app), built with Selenium, Cucumber, and JUnit 5 (and Maven Surfire). This project aims to validate the critical workflows of the application using feature files written in Gherkin syntax along with Cucumber.

---

## 🚀 Features (Planned)

- 🔐 **Authentication**: Register/Login scenarios with valid/invalid credentials
- 🧭 **Navigation**: Navbar visibility and navigation link functionality
- 🏠 **Storage Module**: Create, view, delete storages and manage items
- 📦 **Products Module**: Product creation, listing, and validation
- 🏭 **Production Module**: Simulate production processes with ingredient validation
- 📚 **Gherkin Specifications**: Clear, business-readable acceptance tests
- ✅ **Access Control**: Redirect scenarios for unauthorized pages
- ♻️ **Reusable Components**: Base test hooks and page object models

> 🚧 **Note:** This project is under active development. Features are being incrementally implemented.

---

## 🏗 Tech Stack

| **Layer**             | **Technology**                                                                 |
|-----------------------|--------------------------------------------------------------------------------|
| **Test Framework**     | [![JUnit 5](https://img.shields.io/badge/-JUnit%205-25A162?logo=java&logoColor=white)](https://junit.org/junit5/) [![Cucumber](https://img.shields.io/badge/-Cucumber-23D96C?logo=cucumber&logoColor=white)](https://cucumber.io) |
| **Browser Automation** | [![Selenium](https://img.shields.io/badge/-Selenium-43B02A?logo=selenium&logoColor=white)](https://www.selenium.dev) |
| **Build Tool**         | [![Maven](https://img.shields.io/badge/-Maven-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org) [![Maven Surefire](https://img.shields.io/badge/-Surefire%20Plugin-FF6600?logo=apachemaven&logoColor=white)](https://maven.apache.org/surefire/maven-surefire-plugin/) |
| **Specification Language** | [![Gherkin](https://img.shields.io/badge/-Gherkin-5FCF80?logo=gherkin&logoColor=white)](https://cucumber.io/docs/gherkin/) |
| **Language**           | [![Java](https://img.shields.io/badge/-Java%2021-007396?logo=java&logoColor=white)](https://www.oracle.com/java/) |


---

## 📁 Project Structure

```

📦storage-monitor-automation-bdd
┣ 📂src
┃ ┣ 📂test
┃ ┃ ┣ 📂java.automation.base        # Base test setup and hooks
┃ ┃ ┣ 📂java.automation.page        # Page Object Model (POM) components
┃ ┃ ┣ 📂java.automation.stepdefs    # Step Definitions for Gherkin steps
┃ ┃ ┗ 📂resources
┃ ┃    ┣ 📂features                 # Gherkin feature files
┃ ┃    ┗ 📄cucumber.properties       # Cucumber configuration
┣ 📄pom.xml                          # Maven configuration

```

---

## ⚙️ Installation

1. **Clone the main app (SUT)**  

   Follow the instructions in the [`storage-monitor-app`](https://github.com/sabligeri/storage-monitor-app) README to clone and start the app using Docker.

2. **Clone this automation repo**
   
   ```bash
   git clone https://github.com/sabligeri/storage-monitor-automation-bdd.git
   cd storage-monitor-automation-bdd
   ```


3. **Run tests using Maven**

   ```bash
   mvn clean test
   ```
