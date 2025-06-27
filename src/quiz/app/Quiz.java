package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name, category;


    Quiz(String name, String category) {
        this.name = name;
        this.category = category;



        if (category.equals("Java")) {
            questions[0][0] = "Number of primitive data types in Java are?";
            questions[0][1] = "6";
            questions[0][2] = "7";
            questions[0][3] = "8";
            questions[0][4] = "9";
            answers[0][1] = "8";

            questions[1][0] = "Which of these is not a valid Java access modifier?";
            questions[1][1] = "public";
            questions[1][2] = "private";
            questions[1][3] = "protected";
            questions[1][4] = "unprotected";
            answers[1][1] = "unprotected";

            questions[2][0] = "What is the default value of a boolean variable in Java?";
            questions[2][1] = "false";
            questions[2][2] = "true";
            questions[2][3] = "null";
            questions[2][4] = "0";
            answers[2][1] = "false";

            questions[3][0] = "Which method is used to start a thread in Java?";
            questions[3][1] = "run()";
            questions[3][2] = "start()";
            questions[3][3] = "begin()";
            questions[3][4] = "execute()";
            answers[3][1] = "start()";

            questions[4][0] = "Which of the following is used for memory management in Java?";
            questions[4][1] = "Garbage collection";
            questions[4][2] = "Pointers";
            questions[4][3] = "malloc()";
            questions[4][4] = "free()";
            answers[4][1] = "Garbage collection";

            questions[5][0] = "What does JVM stand for?";
            questions[5][1] = "Java Virtual Machine";
            questions[5][2] = "Java Verified Machine";
            questions[5][3] = "Java Virtual Memory";
            questions[5][4] = "Java Value Machine";
            answers[5][1] = "Java Virtual Machine";

            questions[6][0] = "Which collection class does not allow duplicate elements in Java?";
            questions[6][1] = "ArrayList";
            questions[6][2] = "HashSet";
            questions[6][3] = "LinkedList";
            questions[6][4] = "Vector";
            answers[6][1] = "HashSet";

            questions[7][0] = "Which of these keywords is used to define a constant in Java?";
            questions[7][1] = "final";
            questions[7][2] = "static";
            questions[7][3] = "const";
            questions[7][4] = "constant";
            answers[7][1] = "final";

            questions[8][0] = "Which of these is a valid Java constructor?";
            questions[8][1] = "public MyClass() {}";
            questions[8][2] = "private MyClass() {}";
            questions[8][3] = "public void MyClass() {}";
            questions[8][4] = "None of the above";
            answers[8][1] = "public MyClass() {}";

            questions[9][0] = "What is the default value of an integer in Java?";
            questions[9][1] = "0";
            questions[9][2] = "1";
            questions[9][3] = "null";
            questions[9][4] = "undefined";
            answers[9][1] = "0";

        } else if (category.equals("C++")) {
            questions[0][0] = "Which concept allows polymorphism in C++?";
            questions[0][1] = "Inheritance";
            questions[0][2] = "Encapsulation";
            questions[0][3] = "Virtual functions";
            questions[0][4] = "None";
            answers[0][1] = "Virtual functions";

            questions[1][0] = "Which keyword is used to define a constant in C++?";
            questions[1][1] = "const";
            questions[1][2] = "static";
            questions[1][3] = "final";
            questions[1][4] = "None";
            answers[1][1] = "const";

            questions[2][0] = "Which operator is used to access members of a class in C++?";
            questions[2][1] = ".";
            questions[2][2] = "->";
            questions[2][3] = "[]";
            questions[2][4] = "#";
            answers[2][1] = ".";

            questions[3][0] = "Which of these is a feature of C++ that allows a function to have multiple implementations?";
            questions[3][1] = "Function overloading";
            questions[3][2] = "Function overriding";
            questions[3][3] = "Both function overloading and overriding";
            questions[3][4] = "None of the above";
            answers[3][1] = "Function overloading";

            questions[4][0] = "What is a pointer in C++?";
            questions[4][1] = "A variable that holds the memory address of another variable";
            questions[4][2] = "A function that returns memory";
            questions[4][3] = "A constant variable";
            questions[4][4] = "None of the above";
            answers[4][1] = "A variable that holds the memory address of another variable";

            questions[5][0] = "Which of these keywords is used to define a class in C++?";
            questions[5][1] = "class";
            questions[5][2] = "struct";
            questions[5][3] = "object";
            questions[5][4] = "define";
            answers[5][1] = "class";

            questions[6][0] = "What does the 'new' keyword do in C++?";
            questions[6][1] = "Allocates memory dynamically";
            questions[6][2] = "Deletes a pointer";
            questions[6][3] = "Defines a class object";
            questions[6][4] = "None";
            answers[6][1] = "Allocates memory dynamically";

            questions[7][0] = "Which of the following is true about destructors in C++?";
            questions[7][1] = "A destructor is called automatically when an object goes out of scope";
            questions[7][2] = "A destructor is invoked explicitly by the programmer";
            questions[7][3] = "A destructor does not have a return type";
            questions[7][4] = "All of the above";
            answers[7][1] = "All of the above";

            questions[8][0] = "Which of these is the correct syntax for declaring an array in C++?";
            questions[8][1] = "int arr[10];";
            questions[8][2] = "int arr[] = {1, 2, 3};";
            questions[8][3] = "Both 1 and 2";
            questions[8][4] = "None of the above";
            answers[8][1] = "Both 1 and 2";

            questions[9][0] = "What is the purpose of the 'virtual' keyword in C++?";
            questions[9][1] = "To enable runtime polymorphism";
            questions[9][2] = "To declare a static variable";
            questions[9][3] = "To define a constant";
            questions[9][4] = "None";
            answers[9][1] = "To enable runtime polymorphism";

        } else if (category.equals("Python")) {
            questions[0][0] = "What is the output of: print(type([]))?";
            questions[0][1] = "<class 'dict'>";
            questions[0][2] = "<class 'tuple'>";
            questions[0][3] = "<class 'list'>";
            questions[0][4] = "<class 'int'>";
            answers[0][1] = "<class 'list'>";

            questions[1][0] = "Which of these is used to define a function in Python?";
            questions[1][1] = "def";
            questions[1][2] = "func";
            questions[1][3] = "define";
            questions[1][4] = "function";
            answers[1][1] = "def";

            questions[2][0] = "What is the output of: print(2**3)?";
            questions[2][1] = "6";
            questions[2][2] = "8";
            questions[2][3] = "9";
            questions[2][4] = "None of the above";
            answers[2][1] = "8";

            questions[3][0] = "Which method is used to add an item to the end of a list in Python?";
            questions[3][1] = "append()";
            questions[3][2] = "add()";
            questions[3][3] = "insert()";
            questions[3][4] = "extend()";
            answers[3][1] = "append()";

            questions[4][0] = "Which of these is not a valid Python data type?";
            questions[4][1] = "int";
            questions[4][2] = "float";
            questions[4][3] = "char";
            questions[4][4] = "string";
            answers[4][1] = "char";

            questions[5][0] = "What is the correct syntax for creating a class in Python?";
            questions[5][1] = "class MyClass: ";
            questions[5][2] = "def MyClass():";
            questions[5][3] = "class MyClass()";
            questions[5][4] = "None of the above";
            answers[5][1] = "class MyClass: ";

            questions[6][0] = "What is a lambda function in Python?";
            questions[6][1] = "An anonymous function";
            questions[6][2] = "A regular function";
            questions[6][3] = "A predefined function";
            questions[6][4] = "None";
            answers[6][1] = "An anonymous function";

            questions[7][0] = "Which function is used to find the length of a list in Python?";
            questions[7][1] = "len()";
            questions[7][2] = "length()";
            questions[7][3] = "size()";
            questions[7][4] = "None";
            answers[7][1] = "len()";

            questions[8][0] = "Which of these is used to handle exceptions in Python?";
            questions[8][1] = "try...except";
            questions[8][2] = "catch...finally";
            questions[8][3] = "throw...catch";
            questions[8][4] = "None of the above";
            answers[8][1] = "try...except";

            questions[9][0] = "What does 'self' refer to in Python?";
            questions[9][1] = "The current object";
            questions[9][2] = "The parent class";
            questions[9][3] = "The function argument";
            questions[9][4] = "None";
            answers[9][1] = "The current object";

        } else if (category.equals("GK")) {
                questions[0][0] = "Who is known as the 'Father of the Nation' in India?";
                questions[0][1] = "Jawaharlal Nehru";
                questions[0][2] = "Mahatma Gandhi";
                questions[0][3] = "Subhas Chandra Bose";
                questions[0][4] = "Bhagat Singh";
                answers[0][1] = "Mahatma Gandhi";

                questions[1][0] = "What is the capital of Japan?";
                questions[1][1] = "Beijing";
                questions[1][2] = "Seoul";
                questions[1][3] = "Tokyo";
                questions[1][4] = "Kyoto";
                answers[1][1] = "Tokyo";

                questions[2][0] = "Which planet is known as the Red Planet?";
                questions[2][1] = "Earth";
                questions[2][2] = "Mars";
                questions[2][3] = "Venus";
                questions[2][4] = "Jupiter";
                answers[2][1] = "Mars";

                questions[3][0] = "Who wrote the famous novel '1984'?";
                questions[3][1] = "George Orwell";
                questions[3][2] = "J.K. Rowling";
                questions[3][3] = "Ernest Hemingway";
                questions[3][4] = "F. Scott Fitzgerald";
                answers[3][1] = "George Orwell";

                questions[4][0] = "In which year did World War II end?";
                questions[4][1] = "1939";
                questions[4][2] = "1941";
                questions[4][3] = "1945";
                questions[4][4] = "1950";
                answers[4][1] = "1945";

                questions[5][0] = "Who was the first woman Prime Minister of the United Kingdom?";
                questions[5][1] = "Theresa May";
                questions[5][2] = "Margaret Thatcher";
                questions[5][3] = "Queen Elizabeth II";
                questions[5][4] = "Indira Gandhi";
                answers[5][1] = "Margaret Thatcher";

                questions[6][0] = "What is the smallest country in the world by area?";
                questions[6][1] = "Monaco";
                questions[6][2] = "San Marino";
                questions[6][3] = "Vatican City";
                questions[6][4] = "Liechtenstein";
                answers[6][1] = "Vatican City";

                questions[7][0] = "Who invented the telephone?";
                questions[7][1] = "Alexander Graham Bell";
                questions[7][2] = "Thomas Edison";
                questions[7][3] = "Nikola Tesla";
                questions[7][4] = "Michael Faraday";
                answers[7][1] = "Alexander Graham Bell";

                questions[8][0] = "What is the longest river in the world?";
                questions[8][1] = "Amazon River";
                questions[8][2] = "Nile River";
                questions[8][3] = "Yangtze River";
                questions[8][4] = "Mississippi River";
                answers[8][1] = "Amazon River";

                questions[9][0] = "Which country is the largest producer of coffee?";
                questions[9][1] = "Vietnam";
                questions[9][2] = "Brazil";
                questions[9][3] = "Colombia";
                questions[9][4] = "Ethiopia";
                answers[9][1] = "Brazil";
            }



        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);


        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);



        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(700, 750, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(70, 130, 180));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("Help");
        lifeline.setBounds(930, 750, 200, 30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(70, 130, 180));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1150, 750, 200, 30);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(70, 130, 180));

        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }
    private void initializeJavaQuestions() {
        questions[0][0] = "Number of primitive data types in Java are?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";
        answers[0][1] = "8";

        questions[1][0] = "Which of these is not a valid Java access modifier?";
        questions[1][1] = "public";
        questions[1][2] = "private";
        questions[1][3] = "protected";
        questions[1][4] = "unprotected";
        answers[1][1] = "unprotected";

        questions[2][0] = "What is the default value of a boolean variable in Java?";
        questions[2][1] = "false";
        questions[2][2] = "true";
        questions[2][3] = "null";
        questions[2][4] = "0";
        answers[2][1] = "false";

        questions[3][0] = "Which method is used to start a thread in Java?";
        questions[3][1] = "run()";
        questions[3][2] = "start()";
        questions[3][3] = "begin()";
        questions[3][4] = "execute()";
        answers[3][1] = "start()";

        questions[4][0] = "Which of the following is used for memory management in Java?";
        questions[4][1] = "Garbage collection";
        questions[4][2] = "Pointers";
        questions[4][3] = "malloc()";
        questions[4][4] = "free()";
        answers[4][1] = "Garbage collection";

        questions[5][0] = "What does JVM stand for?";
        questions[5][1] = "Java Virtual Machine";
        questions[5][2] = "Java Verified Machine";
        questions[5][3] = "Java Virtual Memory";
        questions[5][4] = "Java Value Machine";
        answers[5][1] = "Java Virtual Machine";

        questions[6][0] = "Which collection class does not allow duplicate elements in Java?";
        questions[6][1] = "ArrayList";
        questions[6][2] = "HashSet";
        questions[6][3] = "LinkedList";
        questions[6][4] = "Vector";
        answers[6][1] = "HashSet";

        questions[7][0] = "Which of these keywords is used to define a constant in Java?";
        questions[7][1] = "final";
        questions[7][2] = "static";
        questions[7][3] = "const";
        questions[7][4] = "constant";
        answers[7][1] = "final";

        questions[8][0] = "Which of these is a valid Java constructor?";
        questions[8][1] = "public MyClass() {}";
        questions[8][2] = "private MyClass() {}";
        questions[8][3] = "public void MyClass() {}";
        questions[8][4] = "None of the above";
        answers[8][1] = "public MyClass() {}";

        questions[9][0] = "What is the default value of an integer in Java?";
        questions[9][1] = "0";
        questions[9][2] = "1";
        questions[9][3] = "null";
        questions[9][4] = "undefined";
        answers[9][1] = "0";

    }private void initializeCppQuestions() {
        questions[0][0] = "Which concept allows polymorphism in C++?";
        questions[0][1] = "Inheritance";
        questions[0][2] = "Encapsulation";
        questions[0][3] = "Virtual functions";
        questions[0][4] = "None";
        answers[0][1] = "Virtual functions";

        questions[1][0] = "Which keyword is used to define a constant in C++?";
        questions[1][1] = "const";
        questions[1][2] = "static";
        questions[1][3] = "final";
        questions[1][4] = "None";
        answers[1][1] = "const";

        questions[2][0] = "Which operator is used to access members of a class in C++?";
        questions[2][1] = ".";
        questions[2][2] = "->";
        questions[2][3] = "[]";
        questions[2][4] = "#";
        answers[2][1] = ".";

        questions[3][0] = "Which of these is a feature of C++ that allows a function to have multiple implementations?";
        questions[3][1] = "Function overloading";
        questions[3][2] = "Function overriding";
        questions[3][3] = "Both function overloading and overriding";
        questions[3][4] = "None of the above";
        answers[3][1] = "Function overloading";

        questions[4][0] = "What is a pointer in C++?";
        questions[4][1] = "A variable that holds the memory address of another variable";
        questions[4][2] = "A function that returns memory";
        questions[4][3] = "A constant variable";
        questions[4][4] = "None of the above";
        answers[4][1] = "A variable that holds the memory address of another variable";

        questions[5][0] = "Which of these keywords is used to define a class in C++?";
        questions[5][1] = "class";
        questions[5][2] = "struct";
        questions[5][3] = "object";
        questions[5][4] = "define";
        answers[5][1] = "class";

        questions[6][0] = "What does the 'new' keyword do in C++?";
        questions[6][1] = "Allocates memory dynamically";
        questions[6][2] = "Deletes a pointer";
        questions[6][3] = "Defines a class object";
        questions[6][4] = "None";
        answers[6][1] = "Allocates memory dynamically";

        questions[7][0] = "Which of the following is true about destructors in C++?";
        questions[7][1] = "A destructor is called automatically when an object goes out of scope";
        questions[7][2] = "A destructor is invoked explicitly by the programmer";
        questions[7][3] = "A destructor does not have a return type";
        questions[7][4] = "All of the above";
        answers[7][1] = "All of the above";

        questions[8][0] = "Which of these is the correct syntax for declaring an array in C++?";
        questions[8][1] = "int arr[10];";
        questions[8][2] = "int arr[] = {1, 2, 3};";
        questions[8][3] = "Both 1 and 2";
        questions[8][4] = "None of the above";
        answers[8][1] = "Both 1 and 2";

        questions[9][0] = "What is the purpose of the 'virtual' keyword in C++?";
        questions[9][1] = "To enable runtime polymorphism";
        questions[9][2] = "To declare a static variable";
        questions[9][3] = "To define a constant";
        questions[9][4] = "None";
        answers[9][1] = "To enable runtime polymorphism";

    } private void initializePythonQuestions() {
        questions[0][0] = "What is the output of: print(type([]))?";
        questions[0][1] = "<class 'dict'>";
        questions[0][2] = "<class 'tuple'>";
        questions[0][3] = "<class 'list'>";
        questions[0][4] = "<class 'int'>";
        answers[0][1] = "<class 'list'>";

        questions[1][0] = "Which of these is used to define a function in Python?";
        questions[1][1] = "def";
        questions[1][2] = "func";
        questions[1][3] = "define";
        questions[1][4] = "function";
        answers[1][1] = "def";

        questions[2][0] = "What is the output of: print(2**3)?";
        questions[2][1] = "6";
        questions[2][2] = "8";
        questions[2][3] = "9";
        questions[2][4] = "None of the above";
        answers[2][1] = "8";

        questions[3][0] = "Which method is used to add an item to the end of a list in Python?";
        questions[3][1] = "append()";
        questions[3][2] = "add()";
        questions[3][3] = "insert()";
        questions[3][4] = "extend()";
        answers[3][1] = "append()";

        questions[4][0] = "Which of these is not a valid Python data type?";
        questions[4][1] = "int";
        questions[4][2] = "float";
        questions[4][3] = "char";
        questions[4][4] = "string";
        answers[4][1] = "char";

        questions[5][0] = "What is the correct syntax for creating a class in Python?";
        questions[5][1] = "class MyClass: ";
        questions[5][2] = "def MyClass():";
        questions[5][3] = "class MyClass()";
        questions[5][4] = "None of the above";
        answers[5][1] = "class MyClass: ";

        questions[6][0] = "What is a lambda function in Python?";
        questions[6][1] = "An anonymous function";
        questions[6][2] = "A regular function";
        questions[6][3] = "A predefined function";
        questions[6][4] = "None";
        answers[6][1] = "An anonymous function";

        questions[7][0] = "Which function is used to find the length of a list in Python?";
        questions[7][1] = "len()";
        questions[7][2] = "length()";
        questions[7][3] = "size()";
        questions[7][4] = "None";
        answers[7][1] = "len()";

        questions[8][0] = "Which of these is used to handle exceptions in Python?";
        questions[8][1] = "try...except";
        questions[8][2] = "catch...finally";
        questions[8][3] = "throw...catch";
        questions[8][4] = "None of the above";
        answers[8][1] = "try...except";

        questions[9][0] = "What does 'self' refer to in Python?";
        questions[9][1] = "The current object";
        questions[9][2] = "The parent class";
        questions[9][3] = "The function argument";
        questions[9][4] = "None";
        answers[9][1] = "The current object";

    } private void initializeGkQuestions() {
        questions[0][0] = "Who is known as the 'Father of the Nation' in India?";
        questions[0][1] = "Jawaharlal Nehru";
        questions[0][2] = "Mahatma Gandhi";
        questions[0][3] = "Subhas Chandra Bose";
        questions[0][4] = "Bhagat Singh";
        answers[0][1] = "Mahatma Gandhi";

        questions[1][0] = "What is the capital of Japan?";
        questions[1][1] = "Beijing";
        questions[1][2] = "Seoul";
        questions[1][3] = "Tokyo";
        questions[1][4] = "Kyoto";
        answers[1][1] = "Tokyo";

        questions[2][0] = "Which planet is known as the Red Planet?";
        questions[2][1] = "Earth";
        questions[2][2] = "Mars";
        questions[2][3] = "Venus";
        questions[2][4] = "Jupiter";
        answers[2][1] = "Mars";

        questions[3][0] = "Who wrote the famous novel '1984'?";
        questions[3][1] = "George Orwell";
        questions[3][2] = "J.K. Rowling";
        questions[3][3] = "Ernest Hemingway";
        questions[3][4] = "F. Scott Fitzgerald";
        answers[3][1] = "George Orwell";

        questions[4][0] = "In which year did World War II end?";
        questions[4][1] = "1939";
        questions[4][2] = "1941";
        questions[4][3] = "1945";
        questions[4][4] = "1950";
        answers[4][1] = "1945";

        questions[5][0] = "Who was the first woman Prime Minister of the United Kingdom?";
        questions[5][1] = "Theresa May";
        questions[5][2] = "Margaret Thatcher";
        questions[5][3] = "Queen Elizabeth II";
        questions[5][4] = "Indira Gandhi";
        answers[5][1] = "Margaret Thatcher";

        questions[6][0] = "What is the smallest country in the world by area?";
        questions[6][1] = "Monaco";
        questions[6][2] = "San Marino";
        questions[6][3] = "Vatican City";
        questions[6][4] = "Liechtenstein";
        answers[6][1] = "Vatican City";

        questions[7][0] = "Who invented the telephone?";
        questions[7][1] = "Alexander Graham Bell";
        questions[7][2] = "Thomas Edison";
        questions[7][3] = "Nikola Tesla";
        questions[7][4] = "Michael Faraday";
        answers[7][1] = "Alexander Graham Bell";

        questions[8][0] = "What is the longest river in the world?";
        questions[8][1] = "Amazon River";
        questions[8][2] = "Nile River";
        questions[8][3] = "Yangtze River";
        questions[8][4] = "Mississippi River";
        answers[8][1] = "Amazon River";

        questions[9][0] = "Which country is the largest producer of coffee?";
        questions[9][1] = "Vietnam";
        questions[9][2] = "Brazil";
        questions[9][3] = "Colombia";
        questions[9][4] = "Ethiopia";
        answers[9][1] = "Brazil";
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score,category);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score,category);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {

        new Quiz("User","default");
    }
}
