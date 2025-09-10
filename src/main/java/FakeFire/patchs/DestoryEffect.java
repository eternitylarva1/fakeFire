//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package FakeFire.patchs;

import FakeFire.helpers.ModHelper;

import basemod.helpers.CardModifierManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon.CurrentScreen;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.UpgradeShineEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect;

import static FakeFire.modcore.fakefire.hasselected;


public class DestoryEffect extends AbstractGameEffect {

    public static final String[] TEXT;
    private static final float DUR = 2.5F;
    private boolean openedScreen = false;
    private boolean openedScreen2 = false;
    private Color screenColor;

    public DestoryEffect() {
        this.screenColor = AbstractDungeon.fadeColor.cpy();
        this.duration = 0.5F;
        this.screenColor.a = 0.0F;
        AbstractDungeon.overlayMenu.proceedButton.hide();
    }

    public void update() {
        if (!AbstractDungeon.isScreenUp) {
            this.duration -= Gdx.graphics.getDeltaTime();
            this.updateBlackScreenColor();
        }



        if (!AbstractDungeon.isScreenUp ) {


        }



        if (this.duration < 0.0F) {
            this.isDone = true;
            hasselected=true;
            AbstractDungeon.player.gainGold(80);
            AbstractRoom.waitTimer = 0.0F;
            AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
            ((RestRoom)AbstractDungeon.getCurrRoom()).cutFireSound();
            ((RestRoom)AbstractDungeon.getCurrRoom()).fadeIn();
                AbstractRoom.waitTimer = 0.0F;
                AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
                ((RestRoom)AbstractDungeon.getCurrRoom()).cutFireSound();



                }



        }

     public static String removeUnwantedCharacters(String input) {
        if (input == null) return null;

        return input.replace("#b", "")
                .replace("#y", "")
                .replace("NL", "");
    }

    private void updateBlackScreenColor() {
        if (this.duration > 0.5F) {
            this.screenColor.a = Interpolation.fade.apply(1.0F, 0.0F, (this.duration - 0.5F) * 2.0F);
        } else {
            this.screenColor.a = Interpolation.fade.apply(0.0F, 1.0F, this.duration / 1.5F);
        }

    }

    public void render(SpriteBatch sb) {
        sb.setColor(this.screenColor);
        sb.draw(ImageMaster.WHITE_SQUARE_IMG, 0.0F, 0.0F, (float)Settings.WIDTH, (float)Settings.HEIGHT);
        if (AbstractDungeon.screen == CurrentScreen.GRID) {

        }

    }

    public void dispose() {
    }

    static {
        String ID = ModHelper.makePath("DestroyOption");
        TEXT =( CardCrawlGame.languagePack.getUIString(ID)).TEXT;
    }
}
