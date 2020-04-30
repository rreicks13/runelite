package net.runelite.client.plugins.fightcave;

import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class FightCaveInfoOverlay extends OverlayPanel {
    private final FightCavePlugin plugin;

    @Inject()
    FightCaveInfoOverlay(FightCavePlugin plugin) {
        this.plugin = plugin;
        setPosition(OverlayPosition.TOP_RIGHT);
        setPreferredSize(new Dimension(1200, 200));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        // if not in fight cave don't show
        if (plugin.getInstance() == null) {
            return null;
        }

        FightCaveWave currentWave = plugin.getInstance().getCurrentWave();
        //InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
        //infoBoxComponent.setPreferredLocation(OverlayPosition.TOP_RIGHT);

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(currentWave.getName())
                .color(Color.yellow)
                .build());

        for(String fighterString: currentWave.getFighterStrings()) {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left(fighterString)
                    .build());
        }

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Next Wave")
                .color(Color.yellow)
                .build());
        for(String fighterString: plugin.getInstance().getNextWave().getFighterStrings()) {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left(fighterString)
                    .build());
        }

        return super.render(graphics);
    }

}
