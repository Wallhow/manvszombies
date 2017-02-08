package wallhow.manvszombies.game.objects.models

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2
import wallhow.acentauri.ashley.components.CImage
import wallhow.acentauri.ashley.components.CMovement
import wallhow.acentauri.ashley.components.CPosition
import wallhow.acentauri.ashley.components.ComponentResolver
import wallhow.acentauri.ashley.components.extension.halfSize
import wallhow.acentauri.ashley.components.extension.position
import wallhow.manvszombies.game.Game
import wallhow.manvszombies.game.objects.models.gun.CGun
import wallhow.manvszombies.game.components.CKickMob
import wallhow.manvszombies.game.objects.Balance
import wallhow.manvszombies.game.objects.models.gun.Gun
import wallhow.manvszombies.game.objects.models.gun.GunType

/**
 * Created by wallhow on 22.01.17.
 */
class Player : Entity() {
    val gun: Gun
    init {
        val view = Game.viewport
        add(CImage(Game.atlas.findRegion("player")).apply { scale = 1.2f })
        add(CPosition(Vector2(view.worldWidth/2- CImage[this].width/2,0f- CImage[this].height/2)).apply {
            zIndex = -position.y.toInt()
        })
        gun = Gun(this)
        Game.engine.addEntity(gun)
    }

    fun see(x: Float,y : Float) {
        val d = Vector2(x,y).sub(CPosition[this].position.x+ CImage[this].width/2,
                CPosition[this].position.y+ CImage[this].height/2).nor()
        val a = d.angle()
        CImage[this].rotation = a - 90
        gun.shot(d)
    }

    fun getMaxCountBullet() : Int {
        return CGun[gun].max_bullets
    }
    fun getCountBullet() : Int {
        return  CGun[gun].bullets
    }

    fun takeRedGun() {
        CGun[gun].gunType = GunType.RED
    }
    fun takeGreenGun() {
        CGun[gun].gunType = GunType.GREEN
    }
    fun takeBlueGun() {
        CGun[gun].gunType = GunType.BLUE
    }
}