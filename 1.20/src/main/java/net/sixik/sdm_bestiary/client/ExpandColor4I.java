package net.sixik.sdm_bestiary.client;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeConstructor;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import dev.ftb.mods.ftblibrary.icon.Color4I;
@ZenRegister
@Document("mods/sdm/bestiary/integration/ftblib/Color4I")
@NativeTypeRegistration(value = Color4I.class, zenCodeName = "mods.sdm.bestiary.integration.ftblib.Color4I",
constructors = {
        @NativeConstructor(
                value = {
                        @NativeConstructor.ConstructorParameter(
                                name = "red", type = int.class
                        ),
                        @NativeConstructor.ConstructorParameter(
                                name = "green", type = int.class
                        ),
                        @NativeConstructor.ConstructorParameter(
                                name = "blue", type = int.class
                        )
                }
        )
})
public class ExpandColor4I {
}
