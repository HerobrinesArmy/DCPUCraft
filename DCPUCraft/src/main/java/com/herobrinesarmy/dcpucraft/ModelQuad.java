package com.herobrinesarmy.dcpucraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModelQuad
{
    /**
     * The (x,y,z) vertex positions and (u,v) texture coordinates for each of the 8 points on a cube
     */
//    private PositionTextureVertex[] vertexPositions;
//    /** An array of 6 TexturedQuads, one for each face of a cube */
    private TexturedQuad quad;
//    /** X vertex coordinate of lower box corner */
//    public final float posX1;
//    /** Y vertex coordinate of lower box corner */
//    public final float posY1;
//    /** Z vertex coordinate of lower box corner */
//    public final float posZ1;
//    /** X vertex coordinate of upper box corner */
//    public final float posX2;
//    /** Y vertex coordinate of upper box corner */
//    public final float posY2;
//    /** Z vertex coordinate of upper box corner */
//    public final float posZ2;
//    public String field_78247_g;

    public ModelQuad(float x, float y, float z, float ux, float uy, float uz, float vx, float vy, float vz)
    {
//        this.posX1 = par4;
//        this.posY1 = par5;
//        this.posZ1 = par6;
//        this.posX2 = par4 + (float)par7;
//        this.posY2 = par5 + (float)par8;
//        this.posZ2 = par6 + (float)par9;
//        this.vertexPositions = new PositionTextureVertex[4];
//
//        if (par1ModelRenderer.mirror)
//        {
//            float f7 = f4;
//            f4 = par4;
//            par4 = f7;
//        }

        PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(x - ux - vx, y - uy - vy, z - uz - vz, 0.0F, 0.0F);
        PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(x + ux - vx, y + uy - vy, z + uz - vz, 1.0F, 0.0F);
        PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(x + ux + vx, y + uy + vy, z + uz + vz, 1.0F, 1.0F);
        PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(x - ux + vx, y - uy + vy, z - uz + vz, 0.0F, 1.0F);
//        this.vertexPositions[0] = positiontexturevertex0;
//        this.vertexPositions[1] = positiontexturevertex1;
//        this.vertexPositions[2] = positiontexturevertex2;
//        this.vertexPositions[3] = positiontexturevertex3;
        this.quad = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0, positiontexturevertex1, positiontexturevertex2, positiontexturevertex3});

//        if (par1ModelRenderer.mirror)
//        {
//            for (int j1 = 0; j1 < this.quadList.length; ++j1)
//            {
//                this.quadList[j1].flipFace();
//            }
//        }
    }

    /**
     * Draw the six sided box defined by this ModelBox
     */
    @SideOnly(Side.CLIENT)
    public void render(Tessellator par1Tessellator, float par2)
    {
        quad.draw(par1Tessellator, par2);
    }
//
//    public ModelQuad func_78244_a(String par1Str)
//    {
//        this.field_78247_g = par1Str;
//        return this;
//    }
}