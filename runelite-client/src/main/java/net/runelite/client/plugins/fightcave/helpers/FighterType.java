package net.runelite.client.plugins.fightcave.helpers;

import net.runelite.api.NpcID;
import net.runelite.client.plugins.zulrah.phase.ZulrahType;

import java.util.Arrays;
import java.util.List;

public enum FighterType {
    DRAINER, BLOB, RANGER, MAGE, MELEE, JAD, HEALER;

    private static final List<Integer> DRAINER_IDS =  Arrays.asList(NpcID.TZKIH_2190, NpcID.TZKIH_2190, NpcID.TZKIH_3116, NpcID.TZKIH_3117);
    private static final List<Integer> BLOB_IDS =  Arrays.asList(NpcID.TZKEK, NpcID.TZKEK_2192, NpcID.TZKEK_3118, NpcID.TZKEK_3119, NpcID.TZKEK_3120);
    private static final List<Integer> RANGER_IDS =  Arrays.asList(NpcID.TOKXIL, NpcID.TOKXIL_2193,NpcID.TOKXIL_2194,NpcID.TOKXIL_3121,NpcID.TOKXIL_3122);
    private static final List<Integer> MAGE_IDS =  Arrays.asList(NpcID.KETZEK, NpcID.KETZEK_3126);
    private static final List<Integer> MELEE_IDS =  Arrays.asList(NpcID.YTMEJKOT, NpcID.YTMEJKOT_3124);
    private static final List<Integer> JAD_IDS =  Arrays.asList(NpcID.TZTOKJAD, NpcID.TZTOKJAD_6506);
    private static final List<Integer> HEALER_IDS =  Arrays.asList(NpcID.YTHURKOT, NpcID.YTHURKOT_7701, NpcID.YTHURKOT_7705);

    public static FighterType valueOf(int entityId)
    {
        if (DRAINER_IDS.contains(entityId))
            return FighterType.DRAINER;
        if (BLOB_IDS.contains(entityId))
            return FighterType.BLOB;
        if (RANGER_IDS.contains(entityId))
            return FighterType.RANGER;
        if (MAGE_IDS.contains(entityId))
            return FighterType.MAGE;
        if (MELEE_IDS.contains(entityId))
            return FighterType.MELEE;
        if (JAD_IDS.contains(entityId))
            return FighterType.JAD;
        if (HEALER_IDS.contains(entityId))
            return FighterType.HEALER;
        return null;
    }
}
