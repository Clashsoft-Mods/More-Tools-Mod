package clashsoft.mods.moretools;

import net.minecraft.client.model.ModelBiped;

public class ModelArmorTest extends ModelBiped
{
	public ModelArmorTest(float par1, float par2, int par3, int par4)
	{
		super(par1, par2, par3, par4);
		super.bipedLeftArm.addBox(par1, par2, 1.0F, 1, 1, 0);
	}
}
