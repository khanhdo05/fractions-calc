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

## Files

- `edu.grinnell.csc207.util.BigFraction.java`: Contains utility methods for ...
- `edu.grinnell.csc207.util.BFCalculator.java`: ...
- `edu.grinnell.csc207.util.BFRegisterSet.java`: ...
- `edu.grinnell.csc207.main.InteractiveCalculator.java`: ...
- `edu.grinnell.csc207.main.QuickCalculator.java`: ...

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

### To use `prettier` to format code

- In VSCode, `ctrl` + `shift` + `P`
- Choose `Format Document`
- Choose `Configure`
- Choose accordingly

### To run test

```bash
mvn test -q
```

### To check style

```bash
mvn checkstyle:check -q
```

### Run the InteractiveCalculator program

### Run the QuickCalculator program
