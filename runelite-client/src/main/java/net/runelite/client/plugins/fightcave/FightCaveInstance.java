package net.runelite.client.plugins.fightcave;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class FightCaveInstance {
    @Setter
    private int waveNumber;

    public FightCaveWave getCurrentWave() {
        return waves.get(waveNumber - 1);
    }

    public FightCaveWave getNextWave() {
        if (waveNumber == 63) {
            return null;
        }
        return waves.get(waveNumber);
    }

    private static final LinkedList<FightCaveWave> waves = new LinkedList(Arrays.asList(
            new FightCaveWave(1, getFighters(1, 0, 0, 0, 0)),
            new FightCaveWave(2, getFighters(2, 0, 0, 0, 0)),
            new FightCaveWave(3, getFighters(0, 1, 0, 0, 0)),
            new FightCaveWave(4, getFighters(1, 1, 0, 0, 0)),
            new FightCaveWave(5, getFighters(2, 1, 0, 0, 0)),
            new FightCaveWave(6, getFighters(0, 2, 0, 0, 0)),
            new FightCaveWave(7, getFighters(0, 0, 1, 0, 0)),
            new FightCaveWave(8, getFighters(1, 0, 1, 0, 0)),
            new FightCaveWave(9, getFighters(2, 0, 1, 0, 0)),
            new FightCaveWave(10, getFighters(0, 1, 1, 0, 0)),
            new FightCaveWave(11, getFighters(1, 1, 1, 0, 0)),
            new FightCaveWave(12, getFighters(2, 1, 1, 0, 0)),
            new FightCaveWave(13, getFighters(0, 2, 1, 0, 0)),
            new FightCaveWave(14, getFighters(0, 0, 2, 0, 0)),
            new FightCaveWave(15, getFighters(0, 0, 0, 1, 0)),
            new FightCaveWave(16, getFighters(1, 0, 0, 1, 0)),
            new FightCaveWave(17, getFighters(2, 0, 0, 1, 0)),
            new FightCaveWave(18, getFighters(0, 1, 0, 1, 0)),
            new FightCaveWave(19, getFighters(1, 1, 0, 1, 0)),
            new FightCaveWave(20, getFighters(2, 1, 0, 1, 0)),
            new FightCaveWave(21, getFighters(0, 2, 0, 1, 0)),
            new FightCaveWave(22, getFighters(0, 0, 1, 1, 0)),
            new FightCaveWave(23, getFighters(1, 0, 1, 1, 0)),
            new FightCaveWave(24, getFighters(2, 0, 1, 1, 0)),
            new FightCaveWave(25, getFighters(0, 1, 1, 1, 0)),
            new FightCaveWave(26, getFighters(1, 1, 1, 1, 0)),
            new FightCaveWave(27, getFighters(2, 1, 1, 1, 0)),
            new FightCaveWave(28, getFighters(0, 2, 1, 1, 0)),
            new FightCaveWave(29, getFighters(0, 0, 2, 1, 0)),
            new FightCaveWave(30, getFighters(0, 0, 0, 2, 0)),
            new FightCaveWave(31, getFighters(0, 0, 0, 0, 1)),
            new FightCaveWave(32, getFighters(1, 0, 0, 0, 1)),
            new FightCaveWave(33, getFighters(2, 0, 0, 0, 1)),
            new FightCaveWave(34, getFighters(0, 1, 0, 0, 1)),
            new FightCaveWave(35, getFighters(1, 1, 0, 0, 1)),
            new FightCaveWave(36, getFighters(2, 1, 0, 0, 1)),
            new FightCaveWave(37, getFighters(0, 2, 0, 0, 1)),
            new FightCaveWave(38, getFighters(0, 0, 1, 0, 1)),
            new FightCaveWave(39, getFighters(1, 0, 1, 0, 1)),
            new FightCaveWave(40, getFighters(2, 0, 1, 0, 1)),
            new FightCaveWave(41, getFighters(0, 1, 1, 0, 1)),
            new FightCaveWave(42, getFighters(1, 1, 1, 0, 1)),
            new FightCaveWave(43, getFighters(2, 1, 1, 0, 1)),
            new FightCaveWave(44, getFighters(0, 2, 1, 0, 1)),
            new FightCaveWave(45, getFighters(0, 0, 2, 0, 1)),
            new FightCaveWave(46, getFighters(0, 0, 0, 1, 1)),
            new FightCaveWave(47, getFighters(1, 0, 0, 1, 1)),
            new FightCaveWave(48, getFighters(2, 0, 0, 1, 1)),
            new FightCaveWave(49, getFighters(0, 1, 0, 1, 1)),
            new FightCaveWave(50, getFighters(1, 1, 0, 1, 1)),
            new FightCaveWave(51, getFighters(2, 1, 0, 1, 1)),
            new FightCaveWave(52, getFighters(0, 2, 0, 1, 1)),
            new FightCaveWave(53, getFighters(0, 0, 1, 1, 1)),
            new FightCaveWave(54, getFighters(1, 0, 1, 1, 1)),
            new FightCaveWave(55, getFighters(2, 0, 1, 1, 1)),
            new FightCaveWave(56, getFighters(0, 1, 1, 1, 1)),
            new FightCaveWave(57, getFighters(1, 1, 1, 1, 1)),
            new FightCaveWave(58, getFighters(2, 1, 1, 1, 1)),
            new FightCaveWave(59, getFighters(0, 2, 1, 1, 1)),
            new FightCaveWave(60, getFighters(0, 0, 2, 1, 1)),
            new FightCaveWave(61, getFighters(0, 0, 0, 2, 1)),
            new FightCaveWave(62, getFighters(0, 0, 0, 0, 2)),
            new FightCaveWave(63, Arrays.asList(0,0,0,0,0,1))
    ));

    private static List getFighters(int drainers, int blobs, int rangers, int melee, int mages) {
        return Arrays.asList(drainers, blobs, rangers, melee, mages, 0);
    }
}
