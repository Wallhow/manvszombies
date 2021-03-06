package wallhow.manvszombies.game.objects.models.weapons.rifles

import com.badlogic.gdx.graphics.Color
import wallhow.manvszombies.game.objects.models.Player
import wallhow.manvszombies.game.objects.models.gun.GunType

/**
 * Created by wallhow on 13.05.17.
 */
class RifleBlue(player: Player) : Rifle(player) {
    init {
        bulletColor = Color.BLUE
        gunType = GunType.BLUE
    }
}