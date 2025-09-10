//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package FakeFire.patchs;


import FakeFire.helpers.ModHelper;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;



public class DestoryOption extends AbstractCampfireOption {
    public static final String[] TEXT;

    public DestoryOption(boolean active) {
        this.label = TEXT[0];
        this.usable = active;
        this.updateUsability(active);
    }

    public void updateUsability(boolean canUse) {
        this.description = canUse ? TEXT[1] : TEXT[2];
        this.img = ImageMaster.loadImage("FakeFireResources/images/smith3.png");
    }

    public void useOption() {
        if (this.usable) {
            AbstractDungeon.effectList.add(new DestoryEffect());
            this.usable = false;
        }

    }

    static {
        String ID = ModHelper.makePath("DestroyOption");
        TEXT =( CardCrawlGame.languagePack.getUIString(ID)).TEXT;

    }
    @Override
    public void render(SpriteBatch sb) {
        Color color=sb.getColor();
        sb.setColor(Color.WHITE);
        sb.setColor(color);
        super.render(sb);
    }
}
