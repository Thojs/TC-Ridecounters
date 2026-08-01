package be.mrtibo.ridecounters.hooks

interface Hook {
    fun enable()
    fun disable()

    val canEnable: Boolean
}