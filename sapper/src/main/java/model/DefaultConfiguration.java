package model;

import java.util.ArrayList;
import java.util.List;

public class DefaultConfiguration {

    private List<GameConfiguration> gameConfigurations;

    public DefaultConfiguration() {
        this.gameConfigurations = new ArrayList<>();
        gameConfigurations.add(new GameConfiguration("Standart", 9, 9, 10, true, 0));
        gameConfigurations.add(new GameConfiguration("Normal", 16, 16, 40, true, 1));
        gameConfigurations.add(new GameConfiguration("Profi", 30, 16, 99, true, 2));
    }

    public List<GameConfiguration> getGameConfigurations() {
        return gameConfigurations;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (GameConfiguration gameConfiguration : gameConfigurations){
            names.add(gameConfiguration.getName());
        }
        return names;
    }

    public GameConfiguration getGameConfigurationsToName(String name) {
        int i = 0;
        while (!name.equals(gameConfigurations.get(i).getName()))
        {
            i++;
        }
        return gameConfigurations.get(i);
    }

    public GameConfiguration getGameConfigurationsToParameter(int h, int w, int bomb) {
        return new GameConfiguration(null, h, w, bomb, false);
    }
}
