package com.gkoliver.nwis.common.gui;

import com.gkoliver.nwis.NotWhatItSeems;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.GrindstoneContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ImposterScreen extends ContainerScreen<ImposterContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(NotWhatItSeems.MODID,"textures/gui/container/copier.png");

	   public ImposterScreen(ImposterContainer container, PlayerInventory inv, ITextComponent component) {
	      super(container, inv, component);
	   }

	   /**
	    * Draw the foreground layer for the GuiContainer (everything in front of the items)
	    */
	   protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	      this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
	      this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 128 + 2), 4210752);
	   }

	   public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
	      this.renderBackground();
	      this.drawGuiContainerBackgroundLayer(p_render_3_, p_render_1_, p_render_2_);
	      super.render(p_render_1_, p_render_2_, p_render_3_);
	      this.renderHoveredToolTip(p_render_1_, p_render_2_);
	   }

	   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	      this.minecraft.getTextureManager().bindTexture(TEXTURE);
	      int i = (this.width - this.xSize) / 2;
	      int j = (this.height - this.ySize) / 2;
	      this.blit(i, j, 0, 0, this.xSize, this.ySize);
	      if ((this.container.getSlot(0).getHasStack() || this.container.getSlot(1).getHasStack()) && !this.container.getSlot(2).getHasStack()) {
	         this.blit(i + 92, j + 31, this.xSize, 0, 28, 21);
	      }

	   }

}
