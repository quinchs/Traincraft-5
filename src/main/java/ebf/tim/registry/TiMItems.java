package ebf.tim.registry;

import ebf.tim.TrainsInMotion;
import ebf.tim.items.*;
import ebf.tim.utility.RecipeManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TiMItems {

    //todo
    public static Item adminKey,crowbar;


    public static Item cabinWood,cabinAluminium,cabinCopper,cabinIron,cabinSteel,cabinFiberglass,cabinPlastic;
    public static Item frameWood,frameAluminium,frameCopper,frameIron,frameSteel,frameFiberglass,framePlastic;
    public static Item wheelWood,wheelAluminium,wheelIron,wheelSteel,wheelPlastic;
    public static Item chimneyWood,chimneyAluminium,chimneyCopper,chimneyIron,chimneySteel,chimneyFiberglass,chimneyPlastic, chimneyAluminiumShort, chimneySteelShort;

    public static Item boilerWood,boilerIron,boilerSteel,boilerCopper;
    public static Item fireboxIron, fireboxSteel;
    public static Item petrolEngine,smallDieselEngine,mediumDieselEngine,largeDieselEngine;
    public static Item smallElectricEngine,mediumElectricEngine,largeElectricEngine;

    public static Item seatsWooden,seatsIron,seatsPadded,seatsLuxury;

    public static Item hydraulicTransmission,pneumaticTransmission,transformer,transformerHV,electricControls;

    public static Item enginePiston,cylinder,camshaft,graphite,steelPinCircuit, goldPinCircuit, connectingRod;

    public static Item copperWire,goldWire, carbonWire, steelWire, aluminiumWire, insulatedCopperWire, insulatedAluminiumWire;

    public static Item controlPanel, controlStand;

    public static Item walschaertsValveGear, stephensonValveGear, bakerValveGear, radialValveGear, conjugatingValveGear;

    public static Item railItem;

    public static Item generator;

    public static Item itemStake = new ItemStake();
    public static Item recipeBook = new ItemCraftGuide();


    public static void registerItems(){

        TiMGenericRegistry.RegisterItem(itemStake, TrainsInMotion.MODID, "stake",TrainsInMotion.creativeTab);

        TiMGenericRegistry.RegisterItem(new ItemAdminBook(),TrainsInMotion.MODID, "adminbook", TrainsInMotion.creativeTab);
        TiMGenericRegistry.RegisterItem(recipeBook,TrainsInMotion.MODID, "craftbook", TrainsInMotion.creativeTab);

        TiMGenericRegistry.RegisterItem(new ItemPaintBucket(),TrainsInMotion.MODID, "paintbucket", TrainsInMotion.creativeTab);
        TiMGenericRegistry.RegisterItem(new ItemKey(),TrainsInMotion.MODID,  "transportkey", TrainsInMotion.creativeTab);
        TiMGenericRegistry.RegisterItem(new ItemTicket(),TrainsInMotion.MODID,  "transportticket", TrainsInMotion.creativeTab);


        //overides the server registration of the rail item, so the client can have a complex model.
        //   server can't load the CustomItemModel class due to it's reliance on GL imports.
        if(!TrainsInMotion.proxy.isClient()) {
            railItem = TiMGenericRegistry.RegisterItem( new ItemRail(), TrainsInMotion.MODID, "timrail", TrainsInMotion.creativeTab);
        } else {
            railItem = TiMGenericRegistry.RegisterItem(new ItemRail(),TrainsInMotion.MODID,  "timrail", null, TrainsInMotion.creativeTab, null, ebf.tim.items.CustomItemModel.instance);
        }


        //Cabins
        cabinWood = createItem("cabin.wood");
        cabinAluminium = createItem("cabin.aluminium");
        cabinCopper = createItem("cabin.copper");
        cabinIron = createItem("cabin.iron");
        cabinSteel = createItem("cabin.steel");
        cabinFiberglass = createItem("cabin.fiberglass");
        cabinPlastic = createItem("cabin.plastic");

        //Frames
        frameWood = createItem("frame.wood");
        frameAluminium = createItem("frame.aluminium");
        frameCopper = createItem("frame.copper");
        frameIron = createItem("frame.iron");
        frameSteel = createItem("frame.steel");
        frameFiberglass = createItem("frame.fiberglass");
        framePlastic = createItem("frame.plastic");

        //Wheels
        wheelWood = createItem("wheel.wood");
        wheelAluminium = createItem("wheel.aluminium");
        wheelIron = createItem("wheel.iron");
        wheelSteel = createItem("wheel.steel");
        wheelPlastic = createItem("wheel.plastic");

        //Chimneys
        chimneyWood = createItem("chimney.wood");
        chimneyAluminium = createItem("chimney.aluminium");
        chimneyCopper = createItem("chimney.copper");
        chimneyIron = createItem("chimney.iron");
        chimneySteel = createItem("chimney.steel");
        chimneyFiberglass = createItem("chimney.fiberglass");
        chimneyPlastic = createItem("chimney.plastic");
        chimneyAluminiumShort = createItem("chimney.aluminium.short");
        chimneySteelShort = createItem("chimney.steel.short");

        //Boilers
        boilerWood = createItem("boiler.wood");
        boilerIron = createItem("boiler.iron");
        boilerSteel = createItem("boiler.steel");
        boilerCopper = createItem("boiler.copper");

        //Fireboxes
        fireboxIron = createItem("firebox.iron");
        fireboxSteel = createItem("firebox.steel");

        //Engines
        //petrolEngine = createItem("petrol.engine");
        //smallDieselEngine = createItem("small.diesel.engine");
        mediumDieselEngine = createItem("medium.diesel.engine");
        //largeDieselEngine = createItem("large.diesel.engine");
        smallElectricEngine = createItem("small.electric.engine");
        //mediumElectricEngine = createItem("medium.electric.engine");
        //largeElectricEngine = createItem("large.electric.engine");

        //Seats
        seatsWooden = createItem("seats.wooden");
        //seatsIron = createItem("seats.iron");
        //seatsPadded = createItem("seats.padded");
        //seatsLuxury = createItem("seats.luxury");

        //Transmissions + Other
        hydraulicTransmission = createItem("hydraulic.transmission");
        //pneumaticTransmission = createItem("pneumatic.transmission");
        transformer = createItem("transformer");
        //transformerHV = createItem("transformer.hv");
        //electricControls = createItem("electric.controls");

        //Wires
        copperWire = createItem("copper.wire");
        goldWire = createItem("gold.wire");
        carbonWire = createItem("carbon.wire");
        steelWire = createItem("steel.wire");
        aluminiumWire = createItem("aluminium.wire");
        //insulatedCopperWire = createItem("insulated.copper.wire");
        //insulatedAluminiumWire = createItem("insulated.aluminium.wire");

        //Valve Gears
        //walschaertsValveGear = createItem("walschaerts.valve.gear");
        //stephensonValveGear = createItem("stephenson.valve.gear");
        //bakerValveGear = createItem("baker.valve.gear");
        //radialValveGear = createItem("radial.valve.gear");
        //conjugatingValveGear = createItem("conjugating.valve.gear");

        //Other
        enginePiston = createItem("engine.piston");
        cylinder = createItem("engine.cylinder");
        camshaft = createItem("camshaft");
        graphite = createItem("graphite");
        steelPinCircuit = createItem("steel.pin.circuit");
        //goldPinCircuit = createItem("gold.pin.circuit");
        controlPanel = createItem("control.panel");
        //controlStand = createItem("control.stand");
        //connectingRod = createItem("connecting.rod");
        generator = createItem("generator");

        registerItemRecipes();
    }

    private static Item createItem(String unlocalizedName) {
        Item item = new Item();
        TiMGenericRegistry.RegisterItem(item, TrainsInMotion.MODID, unlocalizedName, TrainsInMotion.creativeTabCrafting);
        item.setTextureName(TrainsInMotion.MODID+ ":" + "crafting/" + item.getUnlocalizedName().replace("item.", ""));
        return item;
    }

    public static void registerItemRecipes(){
        RecipeManager.registerRecipe(
                new Object[]{Blocks.rail,Blocks.rail,Blocks.rail,Blocks.rail, Items.book,Blocks.rail,Blocks.rail,Blocks.rail,Blocks.rail},
                recipeBook);

        RecipeManager.registerRecipe(
                new Object[]{copperWire,copperWire,copperWire,Items.redstone,TiMOres.dustPlastic,Items.redstone,copperWire,copperWire,copperWire},
                steelPinCircuit);

        //wire
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.dustPlastic,TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.ingotCopper},
                new ItemStack(copperWire,8));
        RecipeManager.registerRecipe(
                new Object[]{Items.gold_ingot,Items.gold_ingot,Items.gold_ingot,Items.gold_ingot,TiMOres.dustPlastic,Items.gold_ingot,Items.gold_ingot,Items.gold_ingot,Items.gold_ingot},
                new ItemStack(goldWire,8));
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.dustPlastic,TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum},
                new ItemStack(aluminiumWire,8));
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.dustPlastic,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel},
                new ItemStack(steelWire,8));
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.ingotSteel,Blocks.glass,TiMOres.ingotSteel,Blocks.glass,Blocks.glass,Blocks.glass,TiMOres.ingotSteel,Blocks.glass,TiMOres.ingotSteel},
                new ItemStack(carbonWire,8));

        //cabins
        RecipeManager.registerRecipe(
                new Object[]{Blocks.planks,Blocks.planks,Blocks.planks,Blocks.planks,null,null,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot},
                new ItemStack(cabinWood,1));
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum,null,null,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot},
                new ItemStack(cabinAluminium,1));
        RecipeManager.registerRecipe(
                new Object[]{Items.iron_ingot,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot,null,null,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot},
                new ItemStack(cabinIron,1));
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel,null,null,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot},
                new ItemStack(cabinSteel,1));
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.ingotCopper,null,null,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot},
                new ItemStack(cabinCopper,1));
        RecipeManager.registerRecipe(
                new Object[]{Blocks.glass_pane,Blocks.glass_pane,Blocks.glass_pane,Blocks.glass_pane,null,null,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel},
                new ItemStack(cabinFiberglass,1));
        RecipeManager.registerRecipe(
                new Object[]{TiMOres.dustPlastic,TiMOres.dustPlastic,TiMOres.dustPlastic,TiMOres.dustPlastic,null,null,TiMOres.dustPlastic,Items.iron_ingot,TiMOres.dustPlastic},
                new ItemStack(cabinPlastic,1));

        //wheels
        RecipeManager.registerRecipe(
                new Object[]{null,Blocks.planks,null,Blocks.planks,Items.iron_ingot,Blocks.planks,null,Blocks.planks,null},
                new ItemStack(wheelWood,1));
        RecipeManager.registerRecipe(
                new Object[]{null,TiMOres.ingotAluminum,null,TiMOres.ingotAluminum,Items.iron_ingot,TiMOres.ingotAluminum,null,TiMOres.ingotAluminum,null},
                new ItemStack(wheelAluminium,1));
        RecipeManager.registerRecipe(
                new Object[]{null,Items.iron_ingot,null,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot,null,Items.iron_ingot,null},
                new ItemStack(wheelIron,1));
        RecipeManager.registerRecipe(
                new Object[]{null,TiMOres.ingotSteel,null,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel,null,TiMOres.ingotSteel,null},
                new ItemStack(wheelSteel,1));
        RecipeManager.registerRecipe(
                new Object[]{null,TiMOres.dustPlastic,null,TiMOres.dustPlastic,Items.iron_ingot,TiMOres.dustPlastic,null,TiMOres.dustPlastic,null},
                new ItemStack(wheelPlastic,1));


        RecipeManager.registerRecipe(
                new Object[]{null,null,null,Blocks.planks,null,Blocks.planks,Blocks.planks,Blocks.planks,Blocks.planks},
                new ItemStack(frameWood,1));
        RecipeManager.registerRecipe(
                new Object[]{null,null,null,Blocks.planks,null,Blocks.planks,Items.iron_ingot,Items.iron_ingot,Items.iron_ingot},
                new ItemStack(frameIron,1));
        RecipeManager.registerRecipe(
                new Object[]{null,null,null,Items.iron_ingot,null,Items.iron_ingot,TiMOres.ingotSteel,TiMOres.ingotSteel,TiMOres.ingotSteel},
                new ItemStack(frameSteel,1));
        RecipeManager.registerRecipe(
                new Object[]{null,null,null,TiMOres.ingotAluminum,null,TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum,TiMOres.ingotAluminum},
                new ItemStack(frameAluminium,1));
        RecipeManager.registerRecipe(
                new Object[]{null,null,null,Blocks.planks,null,Blocks.planks,TiMOres.ingotCopper,TiMOres.ingotCopper,TiMOres.ingotCopper},
                new ItemStack(frameCopper,1));
        RecipeManager.registerRecipe(
                new Object[]{null,null,null,TiMOres.dustPlastic,null,TiMOres.dustPlastic,TiMOres.dustPlastic,TiMOres.dustPlastic,TiMOres.dustPlastic},
                new ItemStack(framePlastic,1));
        RecipeManager.registerRecipe(
                new Object[]{null,null,null,TiMOres.ingotSteel,null,TiMOres.ingotSteel,Blocks.glass,Blocks.glass,Blocks.glass},
                new ItemStack(frameFiberglass,1));

    }


}
