package net.runelite.client.plugins.fightcave;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FightCaveWave {
    private String name;
    private List<String> fighterStrings = new ArrayList<>();

    public FightCaveWave(int wave, List<Integer> fighters) {
        this.name = "Wave " + wave;
        if (fighters.size() < 6) {
            // need to make the array valid
        }
        buildFighters(fighters.toArray(new Integer[fighters.size()]));
    }

    private void buildFighters(Integer[] fighters) {
        if (fighters[0] > 0) {
            if (fighters[0] > 1) {
                fighterStrings.add(fighters[0] + "x Drainers - Level 22");
            }
            else {
                fighterStrings.add(fighters[0] + "x Drainer - Level 22");
            }
        }
        if (fighters[1] > 0) {
            if (fighters[1] > 1) {
                fighterStrings.add(fighters[1] + "x Blobs - Level 45");
            }
            else {
                fighterStrings.add(fighters[1] + "x Blob - Level 45");
            }
        }
        if (fighters[2] > 0) {
            if (fighters[2] > 1) {
                fighterStrings.add(fighters[2] + "x Ranger - Level 90");
            }
            else {
                fighterStrings.add(fighters[2] + "x Rangers - Level 90");
            }
        }
        if (fighters[3] > 0) {
            fighterStrings.add(fighters[3] + "x Melee - Level 180");
        }
        if (fighters[4] > 0) {
            if (fighters[4] > 1) {
                fighterStrings.add(fighters[4] + "x Mages - Level 360");
            }
            else {
                fighterStrings.add(fighters[4] + "x Mage - Level 360");
            }
        }
        if (fighters[5] > 0) {
            fighterStrings.add("1 Jad - Level 702");
            fighterStrings.add("4 Healers - Level 108");
        }
    }
}
