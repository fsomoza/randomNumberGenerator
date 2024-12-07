# Random Number Generator Analysis Program

## Overview
This Java program generates random numbers within a user-specified range and analyzes their distribution over a given time period. The results are displayed in the console and exported to a CSV file for further analysis.

## Features
- User-defined number range
- User-defined execution duration
- Real-time random number generation and counting
- Sorted output of number frequencies
- CSV file export of results

## Requirements
- Java Runtime Environment (JRE)
- Java Development Kit (JDK)
- Access to file system for CSV output

## Usage

### Running the Program
1. Compile and run the Java program
2. When prompted, enter:
   - The upper bound for the random number range (0 to n-1)
   - The duration (in seconds) for the program to run

### Input Example
```
Enter a number, it will be a range between 0 and the number you entered:
10
Enter the amount of seconds you want to run the program:
5
```

### Output
The program provides two types of output:

1. Console Output:
   - Displays a sorted table showing each number and its frequency
   ```
   Number		Count
   3		    1250
   7		    1180
   1		    1150
   ...
   ```

2. CSV File Output:
   - Creates a file named `results.csv`
   - Uses semicolon (;) as delimiter
   - Contains two columns: Number and Count

## Technical Details

### Key Components

#### Data Structures
- `HashMap<Integer, Integer>`: Stores the number frequencies
- `ArrayList<Map.Entry<Integer, Integer>>`: Used for sorting results

#### Random Number Generation
- Uses Java's `Random` class
- Generates numbers within the specified bounds using `random.nextInt(number)`

#### Time Management
- Uses `System.currentTimeMillis()` for duration tracking
- Converts user input from seconds to milliseconds

#### File Operations
- Implements `FileWriter` for CSV generation
- Includes basic error handling for I/O operations

### Code Structure
```java
main()
├── User Input Collection
├── Map Initialization
├── Random Number Generation Loop
├── Results Sorting
├── Console Output
└── CSV File Generation
```

## Error Handling
- Includes try-catch block for file operations
- Proper resource management with try-with-resources for FileWriter
- Scanner closure implementation

## Limitations
- Integer overflow not handled for very long durations
- No input validation for negative numbers
- Single-threaded execution

## File Output Format
The generated CSV file (`results.csv`) follows this format:
```csv
Number;Count
0;1234
1;1567
2;1489
...
```

## Best Practices Implemented
1. Resource management
   - Proper scanner closure
   - Try-with-resources for file operations
2. Clear console output formatting
3. Organized code structure
4. Standard CSV file format
