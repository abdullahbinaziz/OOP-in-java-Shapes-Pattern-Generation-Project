/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oops;

/**
 *
 * @author hp
 */

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


// ABSTRACT CLASS
abstract class Pattern {
    private int size;
    private char symbol;

    public Pattern(int size, char symbol) {
        this.size = size;
        this.symbol = symbol;
    }
    public int getSize(){ 
         return size; }
    public char getSymbol(){
         return symbol; }

    public abstract void generate();
}


// 2. ALL PATTERN CLASSES

class SquarePattern extends Pattern {
    public SquarePattern(int size, char symbol) { super(size, symbol); }

    public void generate() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                System.out.print(getSymbol() + " ");
            }
            System.out.println();
        }
    }
}

class TrianglePattern extends Pattern {
    public TrianglePattern(int size, char symbol) { super(size, symbol); }

    public void generate() {
        for (int i = 1; i <= getSize(); i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(getSymbol() + " ");
            }
            System.out.println();
        }
    }
}

class InvertedTriangle extends Pattern {
    public InvertedTriangle(int size, char symbol) { super(size, symbol); }
    
    public void generate() {
        for (int i = getSize(); i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(getSymbol() + " ");
            }
            System.out.println();
        }
    }
}

class Pyramid extends Pattern {
    public Pyramid(int size, char symbol) { super(size, symbol); }

    public void generate() {
        for (int i = 1; i <= getSize(); i++) {
            for (int j = i; j < getSize(); j++) System.out.print(" ");
            for (int k = 1; k <= (2 * i - 1); k++) System.out.print(getSymbol());
            System.out.println();
        }
    }
}

class Butterfly extends Pattern {
    public Butterfly(int size, char symbol) { super(size, symbol); }

    public void generate() {

        for (int i = 1; i <= getSize(); i++) {
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            for (int j = 1; j <= 2 * (getSize() - i); j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            System.out.println();
        }

        for (int i = getSize() - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            for (int j = 1; j <= 2 * (getSize() - i); j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            System.out.println();
        }
    }
}

class XPattern extends Pattern {
    public XPattern(int size, char symbol) { super(size, symbol); }

    public void generate() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (i == j || i + j == getSize() - 1)
                    System.out.print(getSymbol());
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class RightArrow extends Pattern {
    public RightArrow(int size, char symbol) { super(size, symbol); }

    public void generate() {
        for (int i = 1; i <= getSize(); i++) {
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            System.out.println();
        }
        for (int i = getSize() - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            System.out.println();
        }
    }
}

class LeftArrow extends Pattern {
    public LeftArrow(int size, char symbol) { super(size, symbol); }

    public void generate() {
        for (int i = 1; i <= getSize(); i++) {
            for (int j = i; j < getSize(); j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            System.out.println();
        }

        for (int i = getSize() - 1; i >= 1; i--) {
            for (int j = getSize(); j > i; j--) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(getSymbol());
            System.out.println();
        }
    }
}
// MAIN CLASS
public class Oops {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatternGUI());

    }

    public static void runConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Symbol: ");
        char symbol = sc.next().charAt(0);
        System.out.print("Size: ");
        int size = sc.nextInt();

        System.out.println("1 Square");
        System.out.println("2 Triangle");
        System.out.println("3 Inverted Triangle");
        System.out.println("4 Pyramid");
        System.out.println("5 Butterfly");
        System.out.println("6 X Pattern");
        System.out.println("7 Right Arrow");
        System.out.println("8 Left Arrow");

        int choice = sc.nextInt();
        Pattern p = null;
        
        switch (choice) {
            case 1 -> p = new SquarePattern(size, symbol);
            case 2 -> p = new TrianglePattern(size, symbol);
            case 3 -> p = new InvertedTriangle(size, symbol);
            case 4 -> p = new Pyramid(size, symbol);
            case 5 -> p = new Butterfly(size, symbol);
            case 6 -> p = new XPattern(size, symbol);
            case 7 -> p = new RightArrow(size, symbol);
            case 8 -> p = new LeftArrow(size, symbol);
        }
        if (p != null) p.generate();
    }
}
//  GUI CLASS

class PatternGUI extends JFrame {

    private JTextField txtSymbol = new JTextField(5);
    private JTextField txtSize = new JTextField(5);
    private JComboBox<String> cmbPattern;
    private JTextArea output = new JTextArea(15, 40);

    public PatternGUI() {

        setTitle("Pattern Generator");
        setSize(650, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Symbol"));
        add(txtSymbol);

        add(new JLabel("Size"));
        add(txtSize);

        String[] patterns = {
                "Square",
                "Triangle",
                "Inverted Triangle",
                "Pyramid",
                "Butterfly",
                "X Pattern",
                "Right Arrow",
                "Left Arrow"
        };

        cmbPattern = new JComboBox<>(patterns);
        add(cmbPattern);

        JButton btn = new JButton("Generate");
        add(btn);

        output.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(output));

        btn.addActionListener(e -> generatePattern());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generatePattern() {
        try {
            char symbol = txtSymbol.getText().charAt(0);
            int size = Integer.parseInt(txtSize.getText());

            Pattern p = null;

            switch ((String) cmbPattern.getSelectedItem()) {
                case "Square" -> p = new SquarePattern(size, symbol);
                case "Triangle" -> p = new TrianglePattern(size, symbol);
                case "Inverted Triangle" -> p = new InvertedTriangle(size, symbol);
                case "Pyramid" -> p = new Pyramid(size, symbol);
                case "Butterfly" -> p = new Butterfly(size, symbol);
                case "X Pattern" -> p = new XPattern(size, symbol);
                case "Right Arrow" -> p = new RightArrow(size, symbol);
                case "Left Arrow" -> p = new LeftArrow(size, symbol);
            }
            if (p == null) return;

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);

            PrintStream old = System.out;
            System.setOut(ps);

            p.generate();

            System.out.flush();
            System.setOut(old);

            output.setText(baos.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }
}