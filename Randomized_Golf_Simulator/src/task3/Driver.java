package task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Driver 
{
    private JFrame frame;
    private JTextArea textArea;
    private JButton[] clubButtons;
    private Golfer golfer;
    private List<Hole> holes;
    private Hole currentHole;
    private int currentHoleIndex;
    private int yardsToPin;

    public Driver() 
    {
        initializeGame();
        initializeGUI();
    }

    private void initializeGame() 
    {
        String name = JOptionPane.showInputDialog("Welcome to the Golf Simulator! What's your name?");
        int handicap = Integer.parseInt(JOptionPane.showInputDialog("Hello " + name + "! What's your handicap?"));

        golfer = new Golfer(name, handicap);
        holes = new ArrayList<>();
        holes.add(new Hole(250, 4, 1));
        holes.add(new Hole(280, 4, 2));
        holes.add(new Hole(490, 5, 3));
        currentHoleIndex = 0;
        currentHole = holes.get(currentHoleIndex);
        yardsToPin = currentHole.getYardsToPin();
    }

    private void initializeGUI() 
    {
        frame = new JFrame("Golf Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea("Welcome " + golfer.getName() + "! Your handicap is " + golfer.getHandicap() + ".\n");
        textArea.append("Starting hole " + currentHole.getHoleNum() + ": " + yardsToPin + " yards to pin, Par " + currentHole.getPar() + ".\n");
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, golfer.clubs.size()));

        clubButtons = new JButton[golfer.clubs.size()];
        int i = 0;
        for (String clubName : golfer.clubs.keySet()) 
        {
            GolfClub club = golfer.clubs.get(clubName);
            clubButtons[i] = new JButton("<html><b>" + clubName.toUpperCase() + "</b><br>Avg Yards: " + club.getAvgYardsPerStroke() + "</html>");
            clubButtons[i].addActionListener(new ClubButtonListener(club));
            buttonPanel.add(clubButtons[i]);
            i++;
        }

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class ClubButtonListener implements ActionListener 
    {
        private final GolfClub club;

        public ClubButtonListener(GolfClub club) 
        {
            this.club = club;
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int distance = club.calculateYards();
            boolean isShanked = club.isShanked();
            int shankStrokes = isShanked ? club.addedStrokes() : 0;

            if (isShanked) 
            {
                textArea.append("You shanked it! " + shankStrokes + " strokes added.\n");
                for (int i = 0; i < shankStrokes; i++) 
                {
                    currentHole.addStroke();
                }
            } 
            else 
            {
                textArea.append("Great shot! No shank this time.\n");
                currentHole.addStroke();
            }

            yardsToPin -= distance;

            if (yardsToPin < 0) 
            {
                yardsToPin = Math.abs(yardsToPin);
            }

            int totalStrokesThisHole = currentHole.getStrokes();

            if (yardsToPin <= 3) 
            {
                textArea.append("You're in! Nice work!\n");
                evaluatePerformance(totalStrokesThisHole);
                nextHole();
            } 
            else 
            {
                textArea.append("You hit the " + club.getClubType() + " for " + distance + " yards.\n" +
                        "Yards to pin: " + yardsToPin + " yards.\n" +
                        "Strokes on this hole: " + totalStrokesThisHole + "\n");
            }
        }

        private void evaluatePerformance(int totalStrokesThisHole) 
        {
            int par = currentHole.getPar();
            if (totalStrokesThisHole == par + 2) 
            {
                textArea.append("You got a double bogey!\n");
            } 
            else if (totalStrokesThisHole == par + 1) 
            {
                textArea.append("You got a bogey!\n");
            } 
            else if (totalStrokesThisHole == par - 1) 
            {
                textArea.append("You got a birdie!\n");
            } 
            else if (totalStrokesThisHole == par - 2) 
            {
                textArea.append("You got an eagle!\n");
            } 
            else if (totalStrokesThisHole == par) 
            {
                textArea.append("You got par!\n");
            } 
            else 
            {
                textArea.append("You scored " + totalStrokesThisHole + ".\n");
            }
        }
    }

    private void nextHole() 
    {
        if (currentHoleIndex < holes.size() - 1) 
        {
            currentHoleIndex++;
            currentHole = holes.get(currentHoleIndex);
            yardsToPin = currentHole.getYardsToPin();
            textArea.append("\nStarting hole " + currentHole.getHoleNum() + ": " + yardsToPin + " yards to pin, Par " + currentHole.getPar() + ".\n");
        } 
        else 
        {
            int totalPar = holes.stream().mapToInt(Hole::getPar).sum();
            int finalScore = Golfer.strokes - golfer.getHandicap();
            String scoreRelativeToPar = (finalScore > totalPar ? "+" : "") + (finalScore - totalPar);

            textArea.append("\nGame Over! You completed all holes.\n");
            textArea.append("Final Score: " + scoreRelativeToPar + " (Par: " + totalPar + ").\n");
            for (JButton button : clubButtons) 
            {
                button.setEnabled(false);
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(Driver::new);
    }
}