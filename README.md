# Mini-Project 2: Fun with Fractions

## Name

Khanh Do

## Description

**A project for CSC-207 2024Fa.**

This project implements a calculator (or perhaps many calculators) that (a) uses fractions as its basic numeric type and (b) includes registers. A register is a named storage area.

## Resources Used

- **Online Documentation:** Referenced Java documentation and StackOverflow for syntax and best practices in Java programming.
- **Maven:** Utilized Maven for project management and building the application.
- **VSCode:** Employed Visual Studio Code for editing and managing the project files.

## GitHub Repository

[https://github.com/khanhdo05/fractions-calc](https://github.com/khanhdo05/fractions-calc)

## Running the Program

### Prerequisites

Before running the code, make sure you have the following installed:

1. **Java Development Kit (JDK) 8 or higher**

   - Download and install from [Oracle's JDK page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).
   - Verify installation by running `java -version` and `javac -version` in your terminal.

2. **Apache Maven**

   - Download and install Maven from [Maven's official website](https://maven.apache.org/download.cgi).
   - Set up environment variables `M2_HOME` and add Maven's `bin` directory to your `PATH`.
   - Verify installation by running `mvn -version` in your terminal.

3. **Text Editor or Integrated Development Environment (IDE)**

   - **Visual Studio Code** or any other text editor/IDE of your choice for editing and managing code files.

4. **Build Tools**
   - Maven will handle project dependencies and building. Ensure Maven is configured correctly as described above.
  
5. **Compile**
   ```bash
   mvn compile -q
   ```

### To run test

```bash
mvn test -q
```

### To check style

```bash
mvn checkstyle:check -q
```

### Setting alias

```bash
alias qc='java -cp target/classes edu.grinnell.csc207.main.QuickCalculator'
alias ic='java -cp target/classes edu.grinnell.csc207.main.InteractiveCalculator'
```

### Run the InteractiveCalculator program

```bash
ic
```

### Run the QuickCalculator program

```bash
qc 1/2 + 3/2
```
