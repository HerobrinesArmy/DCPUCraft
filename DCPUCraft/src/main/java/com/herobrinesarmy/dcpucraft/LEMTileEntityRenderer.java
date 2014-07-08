package com.herobrinesarmy.dcpucraft;

import java.util.LinkedHashMap;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.herobrinesarmy.dcpucraft.LEMBlock.LEMTileEntity;

public class LEMTileEntityRenderer extends TileEntitySpecialRenderer {
//   private static final ResourceLocation screenTexture = new ResourceLocation("textures/entity/skeleton/skeleton.png");
   public static LEMTileEntityRenderer renderer;
   LinkedHashMap<TileEntity,DynamicTexture> textures = new LinkedHashMap<TileEntity, DynamicTexture>();
   private static ResourceLocation topTexLoc = new ResourceLocation("textures/blocks/lemtop.png");
   private static ResourceLocation bottomTexLoc = new ResourceLocation("textures/blocks/lembottom.png");
   private static ResourceLocation sideTexLoc = new ResourceLocation("textures/blocks/lemside.png");
   private static ResourceLocation backTexLoc = new ResourceLocation("textures/blocks/lemback.png");
//   private static SimpleTexture topTex = new SimpleTexture(topTexLoc);
//   private static SimpleTexture bottomTex = new SimpleTexture(bottomTexLoc);
//   private static SimpleTexture sideTex = new SimpleTexture(sideTexLoc);
//   private static SimpleTexture backTex = new SimpleTexture(backTexLoc);
//   private ModelLEM modelLEM = new ModelLEM(0, 0, 64, 32);
   private ModelQuad screenQuad = new ModelQuad(0, -0.5f, -0.5f, 0.5f, 0, 0, 0, 0.75f*0.5f, 0);
   private ModelQuad topQuad = new ModelQuad(0, -0.5f-0.75f*0.5f, 0, 0.5f, 0, 0, 0, 0, 0.5f);
   private ModelQuad bottomQuad = new ModelQuad(0, -0.5f+0.75f*0.5f, 0, 0.5f, 0, 0, 0, 0, 0.5f);
   private ModelQuad leftQuad = new ModelQuad(-0.5f, -0.5f, 0, 0, 0, 0.5f, 0, 0.75f*0.5f, 0);
   private ModelQuad rightQuad = new ModelQuad(0.5f, -0.5f, 0, 0, 0, 0.5f, 0, 0.75f*0.5f, 0);
   private ModelQuad backQuad = new ModelQuad(0, -0.5f, 0.5f, 0.5f, 0, 0, 0, 0.75f*0.5f, 0);
   @Override
   public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float var8) {
      LEMTileEntity lemTileEntity = (LEMTileEntity) entity;
//      ModelLEM modelLEMlocal = this.modelLEM;
//      this.bindTexture(screenTexture);
         DynamicTexture tex = textures.get(entity);

         if (tex == null)
         {
             tex = new DynamicTexture(128, 96);
             textures.put(entity, tex);
         }
         lemTileEntity.lem.tick60hz();
         lemTileEntity.lem.render();
//         lemTileEntity.block.setLightLevel(lemTileEntity.lem.getLightLevel());
//         lemTileEntity.getWorldObj().updateLightByType(EnumSkyBlock.Block, (int)x, (int)y, (int)z);
         System.arraycopy(lemTileEntity.lem.pixels, 0, tex.getTextureData(), 0, 128*96);
         tex.updateDynamicTexture();
         GL11.glPushMatrix();
         GL11.glDisable(GL11.GL_CULL_FACE);
      GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
//      float f4 = 0.0625F;
      GL11.glEnable(GL12.GL_RESCALE_NORMAL);
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      GL11.glEnable(GL11.GL_ALPHA_TEST);
      GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex.getGlTextureId());
      screenQuad.render(Tessellator.instance, 1);
//      GL11.glBindTexture(GL11.GL_TEXTURE_2D, topTex.getGlTextureId());
      this.bindTexture(topTexLoc);
      topQuad.render(Tessellator.instance, 1);
//      GL11.glBindTexture(GL11.GL_TEXTURE_2D, bottomTex.getGlTextureId());
      this.bindTexture(bottomTexLoc);
      bottomQuad.render(Tessellator.instance, 1);
//      GL11.glBindTexture(GL11.GL_TEXTURE_2D, backTex.getGlTextureId());
      this.bindTexture(backTexLoc);
      backQuad.render(Tessellator.instance, 1);
//      GL11.glBindTexture(GL11.GL_TEXTURE_2D, sideTex.getGlTextureId());
      this.bindTexture(sideTexLoc);
      leftQuad.render(Tessellator.instance, 1);
      rightQuad.render(Tessellator.instance, 1);
//      modelLEMlocal.render((Entity)null, 0.0F, 0.0F, 0.0F, 0f, 0.0F, f4);
      GL11.glPopMatrix();
   }
}
