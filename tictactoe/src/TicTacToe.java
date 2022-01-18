import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class TicTacToe is used to start a basic game of Tic Tac Toe. Its main method creates a new Window object, which contains the GUI for the game.
 * 
 * <p>Class also contains endProgram method that closes the program when called. On top of the methods, this class has many variables which are used in 
 * many parts of this program.
 * 
 * @author Lari Juva
 */

public class TicTacToe {
    public static int gameAreaSize = 3;
    public static int playerWinCount = 0;
    public static int computerWinCount = 0;
    public static int turnsAmount = 0;
    public static int amountForWin = 3;
    public static boolean checkPlayerWin = false;
    public static boolean almostAmountForWin = false;

    /**
     * Main method that creates a new Window object when called.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Window();
    }

    /**
     * Method endProgram closes the program when called.
     */

    public static void endProgram() {
        System.exit(0);
    }
}

/**
 * The class Window consists of a constructor that creates a JFrame and calls a method within class MainMenu.
 * 
 * @author Lari Juva
 */

class Window {

    /**
     * Constructor that creates a JFrame and sets some of its attributes, f.e. size and visibility. Lastly, it calls class MainMenu's createMainMenu method.
     */

    public Window() {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        new MainMenu(frame);
    }
}

/**
 * The method MainMenu consists of a constructor that creates JPanels and other objects to make a main menu.
 * 
 * @author Lari Juva
 */

class MainMenu {

    /**
     * Constructor that creates two JPanels. The first JPanel has a header inside of it, and the second one contains all the JButtons for the menu.
     * <p>Menu buttons are used to navigate to the game, to settings or to close the program.
     * 
     * @param frame base for all objects in GUI, created in Window class.
     */

    public MainMenu(JFrame frame) {
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(800, 200));
        headerPanel.setLayout(new GridLayout(1, 1));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(800, 600));
        GridLayout menuLayout = new GridLayout(3, 1);
        menuLayout.setVgap(20);
        menuPanel.setLayout(menuLayout);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(100, 250, 175, 250));

        JLabel header = new JLabel("Tic Tac Toe");
        header.setFont(new Font("roboto", Font.BOLD, 72));
        header.setHorizontalAlignment(JLabel.CENTER);

        JButton playBtn = new JButton("Play");
        playBtn.setFont(new Font("roboto", Font.PLAIN, 16));
        playBtn.setFocusPainted(false);
        playBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(headerPanel);
                frame.remove(menuPanel);

                new Game(frame);
            }
        });

        JButton settingsBtn = new JButton("Settings");
        settingsBtn.setFont(new Font("roboto", Font.PLAIN, 16));
        settingsBtn.setFocusPainted(false);
        settingsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(headerPanel);
                frame.remove(menuPanel);

                new Settings(frame);
            }
        });

        JButton exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("roboto", Font.PLAIN, 16));
        exitBtn.setFocusPainted(false);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TicTacToe.endProgram();
            }
        });

        headerPanel.add(header);
        menuPanel.add(playBtn);
        menuPanel.add(settingsBtn);
        menuPanel.add(exitBtn);

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(menuPanel, BorderLayout.CENTER);

        headerPanel.updateUI();
        menuPanel.updateUI();
    }
}

/**
 * The class Settings constructs the settings menu for this program.
 * 
 * @author Lari Juva
 */

class Settings {
    public static boolean falseConditions = false;

    /**
     * Constructor that creates a JPanel. The panel contains labels and text fields which are used to change game area size and the win condition.
     * <p>The game area size and win condition are set to not change if certain rules are not met. These are:
     * <p>1. Minimum game area size is 3 x 3
     * <p>2. Minimum win condition is 3
     * <p>3. If game area size is more than 10 x 10, the win condition must be 5 or more
     * 
     * @param frame base for all objects in GUI, created in Window class.
     */

    public Settings(JFrame frame) {
        JPanel settingsPanel = new JPanel();
        settingsPanel.setPreferredSize(new Dimension(800, 200));
        settingsPanel.setLayout(null);

        JLabel gameAreaSizeLabel = new JLabel("Game Area");
        gameAreaSizeLabel.setFont(new Font("roboto", Font.PLAIN, 12));
        gameAreaSizeLabel.setBounds(280, 250, 200, 50);

        JTextField setGameAreaSize = new JTextField();
        setGameAreaSize.setBounds(280, 290, 250, 50);
        if(TicTacToe.gameAreaSize != 3 && TicTacToe.gameAreaSize >= 3) {
            setGameAreaSize.setText(Integer.toString(TicTacToe.gameAreaSize));
        }else {
            setGameAreaSize.setText("3");
        }

        JLabel setWinConditionLabel = new JLabel("Win Condition");
        setWinConditionLabel.setFont(new Font("roboto", Font.PLAIN, 12));
        setWinConditionLabel.setBounds(280, 340, 200, 50);

        JTextField setWinCondition = new JTextField();
        setWinCondition.setBounds(280, 380, 250, 50);
        if(TicTacToe.amountForWin != 3 && TicTacToe.amountForWin >= 3) {
            setWinCondition.setText(Integer.toString(TicTacToe.amountForWin));
        }else {
            setWinCondition.setText("3");
        }


        JButton backBtn = new JButton("Back to main menu");
        backBtn.setFont(new Font("roboto", Font.PLAIN, 16));
        backBtn.setFocusPainted(false);
        backBtn.setBounds(300, 480, 200, 45);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                        if(!setWinCondition.getText().matches("-?\\d+(\\.\\d+)?") || Integer.parseInt(setWinCondition.getText()) < 3 || Integer.parseInt(setWinCondition.getText()) > Integer.parseInt(setGameAreaSize.getText()) || (Integer.parseInt(setGameAreaSize.getText()) >= 10 && Integer.parseInt(setWinCondition.getText()) < 5)) {
                            falseConditions = true;
                        }else if(!setGameAreaSize.getText().matches("-?\\d+(\\.\\d+)?") || Integer.parseInt(setGameAreaSize.getText()) < 3) {
                            falseConditions = true;
                        }else {
                            falseConditions = false;
                        }
                    

                if(!falseConditions) {
                    if(setWinCondition.getText().equals("")) {
                        setWinCondition.setText(Integer.toString(TicTacToe.amountForWin));
                    }else if(setGameAreaSize.getText().equals("")) {
                        setGameAreaSize.setText(Integer.toString(TicTacToe.gameAreaSize));
                    }

                    TicTacToe.gameAreaSize = Integer.parseInt(setGameAreaSize.getText());
                    TicTacToe.amountForWin = Integer.parseInt(setWinCondition.getText());
                    frame.remove(settingsPanel);

                    new MainMenu(frame);
                }
            }
        });

        settingsPanel.add(gameAreaSizeLabel);
        settingsPanel.add(setGameAreaSize);
        settingsPanel.add(setWinConditionLabel);
        settingsPanel.add(setWinCondition);
        settingsPanel.add(backBtn);

        frame.add(settingsPanel, BorderLayout.CENTER);

        settingsPanel.updateUI();
    }
}

/**
 * The class Game is used to create the game area. It also constructs a few labels and buttons that have important uses in the game.
 * 
 * @author Lari Juva
 */

class Game{
    public static JPanel bottomPanel;
    public static JLabel playerLabel;
    public static JLabel computerLabel;

    /**
     * The constructor creates three panels in the frame. Topmost panel contains a back button, middle one has the game area and the bottom one has score counts for player and computer.
     * 
     * @param frame base for all objects in GUI, created in Window class.
    */

    public Game(JFrame frame) {
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500, 100));
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 600, 30, 80));

        JPanel gameAreaPanel = new JPanel();
        gameAreaPanel.setPreferredSize(new Dimension(500, 600));
        gameAreaPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 80));
        gameAreaPanel.setLayout(new GridLayout(TicTacToe.gameAreaSize, TicTacToe.gameAreaSize));

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(500, 100));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 80));

        JButton backToMainMenu = new JButton("End game");
        backToMainMenu.setFont(new Font("roboto", Font.PLAIN, 14));
        backToMainMenu.setFocusPainted(false);
        backToMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TicTacToe.playerWinCount = 0;
                TicTacToe.computerWinCount = 0;
                TicTacToe.turnsAmount = 0;
                frame.remove(topPanel);
                frame.remove(gameAreaPanel);
                frame.remove(bottomPanel);

                new MainMenu(frame);
            }
        });

        JButton[][] buttons = new JButton[TicTacToe.gameAreaSize][TicTacToe.gameAreaSize];
        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++) {
                final int innerI = i;
                final int innerJ = j;
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TicTacToe.turnsAmount++;
                        TicTacToe.checkPlayerWin = true;

                        buttons[innerI][innerJ].setText("X");
                        buttons[innerI][innerJ].setEnabled(false);

                        if(TicTacToe.turnsAmount < (TicTacToe.gameAreaSize * TicTacToe.gameAreaSize)) {
                            AI.checkWinner(buttons, innerI, innerJ, frame);
                        }else {
                            resetGameArea(buttons, frame);
                        }
                    }
                });
                gameAreaPanel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("roboto", Font.PLAIN, 290 / TicTacToe.gameAreaSize));
                buttons[i][j].setFocusPainted(false);
            }
        }

        playerLabel = new JLabel("Player: " + TicTacToe.playerWinCount);
        playerLabel.setFont(new Font("roboto", Font.PLAIN, 24));
        computerLabel = new JLabel("Computer: " + TicTacToe.computerWinCount);
        computerLabel.setFont(new Font("roboto", Font.PLAIN, 24));

        topPanel.add(backToMainMenu, BorderLayout.NORTH);
        bottomPanel.add(playerLabel, BorderLayout.LINE_START);
        bottomPanel.add(computerLabel, BorderLayout.LINE_END);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(gameAreaPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        topPanel.updateUI();
        gameAreaPanel.updateUI();
        bottomPanel.updateUI();
    }

    /**
     * Method resetGameArea is used to clear the game area after a win or tie. It sets all button's texts to null and makes them clickable. Also, it updates player and computer win counts.
     * 
     * @param buttons  2D array of buttons that forms the game area.
     * @param frame  base for all objects in GUI, created in Window class.
     */

    public static void resetGameArea(JButton[][] buttons, JFrame frame) {
        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        bottomPanel.remove(playerLabel);
        bottomPanel.remove(computerLabel);

        playerLabel = new JLabel("Player: " + TicTacToe.playerWinCount);
        playerLabel.setFont(new Font("roboto", Font.PLAIN, 24));
        computerLabel = new JLabel("Computer: " + TicTacToe.computerWinCount);
        computerLabel.setFont(new Font("roboto", Font.PLAIN, 24));

        bottomPanel.add(playerLabel, BorderLayout.LINE_START);
        bottomPanel.add(computerLabel, BorderLayout.LINE_END);

        frame.revalidate();
        frame.repaint();

        bottomPanel.updateUI();

        TicTacToe.turnsAmount = 0;
    }
}

/**
 * The class AI is used to make "system" moves. It also has a method that checks if a player or a computer has won.
 * 
 * @author Lari Juva
 */

class AI {
    public static int systemX = 0;
    public static int systemY = 0;

    /**
     * The method checkWinner is used to check if a player or computer has won. It uses multiple try-catch blocks inside a switch that is inside a for-loop.
     * <p>Every case checks a type of win possibility. 0 does vertical win checking, 1 does horizontal win checking, 2 and 3 do diagonal win checking.
     * <p>It doesn't check the whole board after every move, only the rows, columns and diagonals that can result in a win at that time.
     * <p>These win checking rules can be applied everywhere on the board: if it results in a ArrayIndexOutOfBoundsException, the exception will be ignored.
     * <p>If winner is found, a boolean isWinnerFound will be changed to true, the for-loop is exited and the game area will be reseted.
     * <p>If winner is not found, the program goes to method systemChoice to make a "system" move.
     * 
     * @param buttons 2D array of buttons that forms the game area.
     * @param innerI x-position for last move
     * @param innerJ y-position for last move
     * @param frame base for all objects in GUI, created in Window class.
     */

    public static void checkWinner(JButton[][] buttons, int innerI, int innerJ, JFrame frame) {
        boolean isWinnerFound = false;
        String character = (TicTacToe.checkPlayerWin) ? "X" : "O";
        String winnerType = (TicTacToe.checkPlayerWin) ? "player" : "computer";
        int chars = 0;
        
        for(int h = 0; h < 4; h++) {
            switch(h) {
                case 0: for(int i = 0; i < TicTacToe.gameAreaSize; i++) {
                            try {
                                if(buttons[i][innerJ].getText().equals(character) && !isWinnerFound) {
                                    chars++;
                                    if(chars == (TicTacToe.amountForWin - 1)) {
                                        systemX = i + 1;
                                        systemY = innerJ;
                                        TicTacToe.almostAmountForWin = true;
                                    }else if(chars == TicTacToe.amountForWin) {
                                        isWinnerFound = true;
                                        h = 4;
                                    }
                                }else if(!buttons[i][innerJ].getText().equals(character) && !isWinnerFound) {
                                    chars = 0;
                                }
                            }catch(ArrayIndexOutOfBoundsException e) {}
                        }
                        chars = 0;
                        break;
                case 1: for(int j = 0; j < TicTacToe.gameAreaSize; j++) {
                            try {
                                if(buttons[innerI][j].getText().equals(character) && !isWinnerFound) {
                                    chars++;
                                    if(chars == (TicTacToe.amountForWin - 1)) {
                                        systemX = innerI;
                                        systemY = j + 1;
                                        TicTacToe.almostAmountForWin = true;
                                    }else if(chars == TicTacToe.amountForWin) {
                                        isWinnerFound = true;
                                        h = 4;
                                    }
                                }else if(!buttons[innerI][j].getText().equals(character) && !isWinnerFound) {
                                    chars = 0;
                                }
                            }catch(ArrayIndexOutOfBoundsException e) {}
                        }
                        chars = 0;
                        break;
                case 2: for(int k = 0; k < TicTacToe.gameAreaSize; k++) {
                            try {
                                if(innerI >= innerJ) {
                                    if(buttons[innerI - innerJ + k][k].getText().equals(character) && !isWinnerFound) {
                                        chars++;
                                        if(chars == (TicTacToe.amountForWin - 1)) {
                                            systemX = innerI + 1;
                                            systemY = innerJ + 1;
                                            TicTacToe.almostAmountForWin = true;
                                        }else if(chars == TicTacToe.amountForWin) {
                                            isWinnerFound = true;
                                            h = 4;
                                        }
                                    }else if(!buttons[innerI - innerJ + k][k].getText().equals(character) && !isWinnerFound) {
                                        chars = 0;
                                    }
                                }else if(innerI < innerJ) {
                                    if(buttons[k][innerJ - innerI + k].getText().equals(character) && !isWinnerFound) {
                                        chars++;
                                        if(chars == (TicTacToe.amountForWin - 1)) {
                                            systemX = innerI + 1;
                                            systemY = innerJ + 1;
                                            TicTacToe.almostAmountForWin = true;
                                        }else if(chars == TicTacToe.amountForWin) {
                                            isWinnerFound = true;
                                            h = 4;
                                        }
                                    }else if(!buttons[k][innerJ - innerI + k].getText().equals(character) && !isWinnerFound) {
                                        chars = 0;
                                    }
                                }
                            }catch(ArrayIndexOutOfBoundsException e) {}
                        }
                        chars = 0;
                        break;
                case 3: for(int l = 0; l < TicTacToe.gameAreaSize; l++) {
                            try {
                                if(innerI >= innerJ) {
                                    if(buttons[l][innerJ + innerI - l].getText().equals(character) && !isWinnerFound) {
                                        chars++;
                                        if(chars == (TicTacToe.amountForWin - 1)) {
                                            systemX = innerI - 1;
                                            systemY = innerJ + 1;
                                            TicTacToe.almostAmountForWin = true;
                                        }else if(chars == TicTacToe.amountForWin) {
                                            isWinnerFound = true;
                                            h = 4;
                                        }
                                    }else if(!buttons[l][innerJ + innerI - l].getText().equals(character) && !isWinnerFound) {
                                        chars = 0;
                                    }
                                }else if(innerI < innerJ) {
                                    if(buttons[innerJ + innerI - l][l].getText().equals(character) && !isWinnerFound) {
                                        chars++;
                                        if(chars == (TicTacToe.amountForWin - 1)) {
                                            systemX = innerI - 1;
                                            systemY = innerJ + 1;
                                            TicTacToe.almostAmountForWin = true;
                                        }else if(chars == TicTacToe.amountForWin) {
                                            isWinnerFound = true;
                                            h = 4;
                                        }
                                    }else if(!buttons[innerJ + innerI - l][l].getText().equals(character) && !isWinnerFound) {
                                        chars = 0;
                                    }
                                }
                            }catch(ArrayIndexOutOfBoundsException e) {}
                        }
                        chars = 0;
                        break;
        }
    }

        if(isWinnerFound) {
            switch(winnerType) {
                case "player": TicTacToe.playerWinCount++; break;
                case "computer": TicTacToe.computerWinCount++; break;
            }
            Game.resetGameArea(buttons, frame);
        }else if(TicTacToe.turnsAmount < (TicTacToe.gameAreaSize * TicTacToe.gameAreaSize) && TicTacToe.turnsAmount % 2 != 0) {
            systemChoice(buttons, innerI, innerJ, frame);
        }
    }

    /**
     * The method systemChoice will make system's moves. It checks the last move player has made, and if a win for player is iminent, it will try to block the win.
     * 
     * @param buttons 2D array of buttons that forms the game area.
     * @param innerI x-position for last move
     * @param innerJ y-position for last move
     * @param frame base for all objects in GUI, created in Window class.
     */

    public static void systemChoice(JButton[][] buttons, int innerI, int innerJ, JFrame frame) {
        TicTacToe.turnsAmount++;
        TicTacToe.checkPlayerWin = false;

        try {
            if(TicTacToe.almostAmountForWin && buttons[systemX][systemY].getText().equals("")) {
                buttons[systemX][systemY].setText("O");
                buttons[systemX][systemY].setEnabled(false);
                innerI = systemX;
                innerJ = systemY;
                TicTacToe.almostAmountForWin = false;
            }else {
                do {
                    innerI = (int) (Math.random() * (TicTacToe.gameAreaSize));
                    innerJ = (int) (Math.random() * (TicTacToe.gameAreaSize));
                }while(!buttons[innerI][innerJ].getText().equals(""));
    
                buttons[innerI][innerJ].setText("O");
                buttons[innerI][innerJ].setEnabled(false);
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            do {
                innerI = (int) (Math.random() * (TicTacToe.gameAreaSize));
                innerJ = (int) (Math.random() * (TicTacToe.gameAreaSize));
            }while(!buttons[innerI][innerJ].getText().equals(""));

            buttons[innerI][innerJ].setText("O");
            buttons[innerI][innerJ].setEnabled(false);
        }

        checkWinner(buttons, innerI, innerJ, frame);
    }
}