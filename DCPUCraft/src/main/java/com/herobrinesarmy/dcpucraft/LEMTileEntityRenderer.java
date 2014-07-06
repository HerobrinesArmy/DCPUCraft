package com.herobrinesarmy.dcpucraft;

import java.util.LinkedHashMap;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.herobrinesarmy.dcpucraft.LEMBlock.LEMTileEntity;

public class LEMTileEntityRenderer extends TileEntitySpecialRenderer {
//   private static final ResourceLocation screenTexture = new ResourceLocation("textures/entity/skeleton/skeleton.png");
   public static LEMTileEntityRenderer renderer;
   LinkedHashMap<TileEntity,DynamicTexture> textures = new LinkedHashMap<TileEntity, DynamicTexture>();
//   private ModelLEM modelLEM = new ModelLEM(0, 0, 64, 32);
   private ModelQuad screenQuad = new ModelQuad(0, -0.5f, -0.5f, 0.5f, 0, 0, 0, 0.75f*0.5f, 0);

   @Override
   public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float var8) {
      LEMTileEntity lemTileEntity = (LEMTileEntity) entity;
      
//      ModelLEM modelLEMlocal = this.modelLEM;
//      this.bindTexture(screenTexture);
//          texturemanager.bindTexture(screenTexture);
         DynamicTexture tex = textures.get(entity);

         if (tex == null)
         {
             tex = new DynamicTexture(128, 96);
//             texturemanager.loadTexture(screenTexture, tex);
             textures.put(entity, tex);
         }
         lemTileEntity.lem.tick60hz();
         lemTileEntity.lem.render();
         System.arraycopy(lemTileEntity.lem.pixels, 0, tex.getTextureData(), 0, 128*96);
         tex.updateDynamicTexture();
         GL11.glPushMatrix();
         GL11.glDisable(GL11.GL_CULL_FACE);
         GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex.getGlTextureId());
//         TextureUtil.bindTexture(((ITextureObject)object).getGlTextureId());
//         GL11.glBegin(GL11.GL_QUADS);
//         //Top Left
//         GL11.glTexCoord2f(0.0f, 1.0f);
//         GL11.glVertex3f((float)x+1.0f, (float)y+1.0f, (float)z+-1.0f);
//         //Top Right
//         GL11.glTexCoord2f(1.0f, 1.0f);
//         GL11.glVertex3f((float)x+1.0f, (float)y+1.0f, (float)z+1.0f);
//         //Bottom Left
//         GL11.glTexCoord2f(0.0f, 0.0f);
//         GL11.glVertex3f((float)x+-1.0f, (float)y+1.0f, (float)z+1.0f); 
//         //Bottom Right
//         GL11.glTexCoord2f(1.0f, 0.0f);
//         GL11.glVertex3f((float)x+-1.0f, (float)y+1.0f, (float)z+-1.0f);
//         GL11.glEnd();
      
      
      GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
//      float f4 = 0.0625F;
      GL11.glEnable(GL12.GL_RESCALE_NORMAL);
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      GL11.glEnable(GL11.GL_ALPHA_TEST);
      screenQuad.render(Tessellator.instance, 1);
//      modelLEMlocal.render((Entity)null, 0.0F, 0.0F, 0.0F, 0f, 0.0F, f4);
      GL11.glPopMatrix();
   }
}
