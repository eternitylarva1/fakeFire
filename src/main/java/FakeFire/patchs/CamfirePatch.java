package FakeFire.patchs;


import FakeFire.utils.Invoker;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.city.CursedTome;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import com.megacrit.cardcrawl.ui.campfire.RestOption;
import com.megacrit.cardcrawl.ui.campfire.SmithOption;
import com.megacrit.cardcrawl.vfx.campfire.CampfireSleepEffect;
import com.megacrit.cardcrawl.vfx.campfire.CampfireSmithEffect;

import java.util.ArrayList;

import static FakeFire.modcore.fakefire.firemap;


public class CamfirePatch {
    @SpirePatch(clz = CampfireUI.class, method = "initializeButtons")
    public static class ModifyRewardScreenStuff {
        @SpirePrefixPatch
        public static void patch(CampfireUI __instance) {
            ArrayList<AbstractCampfireOption> buttons = Invoker.getField(__instance, "buttons");
            buttons.add(new DestoryOption(true));

        }
    } @SpirePatch(clz = AbstractPlayer .class, method = "renderShoulderImg")
    public static class AbstractPlayerStuff {
        @SpirePrefixPatch
        public static SpireReturn patch(AbstractPlayer __instance, SpriteBatch sb) {
            if (CampfireUI.hidden||firemap.get(AbstractDungeon.floorNum)==false) {
                sb.draw(__instance.shoulder2Img, 0.0F, 0.0F, 1920.0F * Settings.scale, 1136.0F * Settings.scale);
            } else {
                sb.draw(__instance.shoulderImg, __instance.animX, 0.0F, 1920.0F * Settings.scale, 1136.0F * Settings.scale);
            }
            return SpireReturn.Return();
        }
    }   @SpirePatch(clz = RestOption.class, method = "useOption")
    public static class CampfireSleepEffectPatch {
        @SpirePostfixPatch
        public static void patch(RestOption __instance) {
         if (firemap.get(AbstractDungeon.floorNum)==false){

             AbstractDungeon.player.damage(new DamageInfo((AbstractCreature)null, 10, DamageInfo.DamageType.HP_LOSS));
         }
        }
    }   @SpirePatch(clz = SmithOption.class, method = "useOption")
    public static class CampfireSmithEffectPatch {
        @SpirePostfixPatch
        public static void patch(SmithOption __instance) {
         if (firemap.get(AbstractDungeon.floorNum)==false){
             AbstractDungeon.player.damage(new DamageInfo((AbstractCreature)null, 10, DamageInfo.DamageType.HP_LOSS));
         }
        }
    }
}
