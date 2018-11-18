package pl.edu.agh.to2.kitkats.codinlearner.level;

import javafx.beans.property.ObjectProperty;
import pl.edu.agh.to2.kitkats.codinlearner.model.Command;

import java.util.ArrayList;
import java.util.List;
public class LevelManager {

    private List<Level> levels;
    private int currentLevelNumber;
    private List<Command> currentLevelCommands;
    private int currentLevelCommandNumber;
//    private ObjectProperty<Level> currentLevel;


    public LevelManager( int currentLevelNumber) {
        this.levels = new ArrayList<>();
        this.currentLevelNumber = currentLevelNumber;
        this.currentLevelCommands = new ArrayList<>();
        this.currentLevelCommandNumber = 0;

    }

    public boolean checkCurrentLevel(String stringCommands){
        boolean passed = LevelCheck.check(levels.get(currentLevelNumber), this.currentLevelCommands);
        if(passed) {
            levels.get(this.currentLevelNumber).addSollution(this.currentLevelCommandNumber);
            return true;
        }
        else return false;
    }

    public boolean currentLevelExists() {
        return (currentLevelNumber < levels.size());
    }

    public void nextLevel() {
        if (currentLevelExists()) {
            this.currentLevelCommands.clear();
            this.currentLevelCommandNumber = 0;
            this.currentLevelNumber += 1;
        }
    }

    public void resetLevel() {
        this.currentLevelCommands.clear();
        this.currentLevelCommandNumber = 0;
    }

    public void addCommands(List<Command> commands){
        this.currentLevelCommands.addAll(commands);
        this.currentLevelCommandNumber++;
    }

    public void addLevel(Level level) {
        this.levels.add(level);
    }

    public Level getCurrentLevel() {
        if (currentLevelExists()) {
            return levels.get(currentLevelNumber);
        } else {
            return null;
        }
    }
}
