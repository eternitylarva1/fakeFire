package FakeFire.patchs;

import FakeFire.modcore.fakefire;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.rooms.MonsterRoom;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.saveAndContinue.SaveFile;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import static FakeFire.modcore.fakefire.firemap;
import static FakeFire.modcore.fakefire.hasselected;

@SpirePatch(clz = AbstractDungeon.class, method = "nextRoomTransition", paramtypez = {SaveFile.class})
  public class BigTreasurePatch
  {
    @SpireInsertPatch(rloc = 0)
    public static void MapPatchInsert(AbstractDungeon __instance, SaveFile saveFile) {
      if (firemap.isEmpty()) {
        fakefire.initializeHashmap();
      }

    }

  }
