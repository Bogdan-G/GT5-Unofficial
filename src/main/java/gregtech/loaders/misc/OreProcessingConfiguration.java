package gregtech.loaders.misc;

import java.io.File;
import java.util.HashMap;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.eclipse.collections.impl.map.mutable.primitive.ObjectBooleanHashMap;

public class OreProcessingConfiguration
    implements Runnable
{
    private final Configuration mConfiguration;
    private final ObjectBooleanHashMap mEnabledMaterials;
    public OreProcessingConfiguration(File aModConfigurationDirectory)
    {
        this.mEnabledMaterials = new ObjectBooleanHashMap();
        this.mConfiguration =
            new Configuration(new File(new File(aModConfigurationDirectory, "GregTech"), "OreProcessing.cfg"));
        this.mConfiguration.load();
        this.loadConfiguration();
        if (this.mConfiguration.hasChanged())
        {
            this.mConfiguration.save();
        }
    }
    private void loadConfiguration()
    {
        for (Materials tMaterial : GregTech_API.sGeneratedMaterials)
        {
            if (tMaterial != null && tMaterial != Materials._NULL)
            {
                String tMaterialName = tMaterial.name();
                boolean tDefaultValue = (tMaterial.mTypes & 8) != 0;
                Property tProperty =
                    this.mConfiguration.get("processores", tMaterialName + "_" + tDefaultValue, tDefaultValue);
                this.mEnabledMaterials.put(tMaterialName, tProperty.getBoolean(tDefaultValue));
            }
        }
    }
    @Override
    public void run()
    {
        for (Object tMaterialName0 : this.mEnabledMaterials.keySet())
        {
            String tMaterialName = (String)tMaterialName0;
            if (this.mEnabledMaterials.get(tMaterialName))
            {
                Materials.valueOf(tMaterialName).mTypes |= 8;
            }
            else if ((Materials.valueOf(tMaterialName).mTypes & 8) != 0)
            {
                Materials.valueOf(tMaterialName).mTypes ^= 8;
            }
        }
    }
}

