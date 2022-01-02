# Calculator
A simple application that reads the commands for arithmetic operations from a file and performs calculations does not pay attention to the sequence of operations.

# How to start?

After starting the application, the program will ask you to select a file that should contain arithmetic commands.

# About
The application is divided into the following classes:
- CalculatorEngine - Service responsible for performing mathematical calculations. Built on the 'Proxy' design pattern, delegating the operation of methods to the CalculatorEngineImpl implementation
- FileService - Service responsible for reading data from the file. Contains methods to convert the contents of files into a list of Strings, splitting the contents of the files at the start of a new line.
- Exceptions:
- - InvalidArithmeticMarkException - thrown when command form input contains unsupported arithmetic mark.
- - NotFoundApplyMarkException - thrown when input file doesn't contain operator 'apply'.
- - InvalidCommandParametersException - thrown when a single command has a number other than 2.
There was no information in the content of the task what actions should be taken in case of such events as: incorrect operator type, missing 'apply' operator, wrong number format. I decided that such errors should interrupt the program operation and inform about the thrown error.


# Examples
**Example 1**

Input from file:
```sh
add 2
multiply 3
apply 10
```
Output 36

Explanation 10 + 2 * 3 = 36

**Example 2**

Input from file:
```sh
multiply 3
add 2
apply 10
Output 32
```
Explanation 10 * 3 + 2 = 32

**Example 3**

Input from file
```sh
apply 1
```

Output 1