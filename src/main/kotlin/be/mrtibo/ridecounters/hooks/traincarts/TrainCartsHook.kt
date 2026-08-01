package be.mrtibo.ridecounters.hooks.traincarts

import be.mrtibo.ridecounters.hooks.Hook
import com.bergerkiller.bukkit.tc.signactions.SignAction
import org.bukkit.Bukkit

object TrainCartsHook : Hook {
    private val ridecountSignAction = SignActionRidecount()

    override val canEnable: Boolean
        get() = Bukkit.getPluginManager().isPluginEnabled("Train_Carts")

    override fun enable() {
        SignAction.register(ridecountSignAction)
    }

    override fun disable() {
        SignAction.unregister(ridecountSignAction)
    }
}