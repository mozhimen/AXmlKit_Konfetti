package com.mozhimen.xmlk.konfetti

import nl.dionsegijn.konfetti.core.Angle
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.Spread
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

/**
 * @ClassName KonfettiUtil
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/7/25
 * @Version 1.0
 */
object KonfettiUtil {
    @JvmStatic
    fun explode(position: Position): List<Party> {
        return listOf(
            Party(
                speed = 0f,
                maxSpeed = 30f,
                damping = 0.9f,
                spread = 360,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                position = position//Position.Relative(0.1, 0.95)
            )
        )
    }

    @JvmStatic
    fun rain(): List<Party> {
        return listOf(
            Party(
                speed = 0f,
                maxSpeed = 10f,
                damping = 0.9f,
                angle = Angle.BOTTOM,
                spread = Spread.ROUND,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = 3, TimeUnit.SECONDS).perSecond(50),
                position = Position.Relative(0.0, 0.0).between(Position.Relative(1.0, 0.0))
            )
        )
    }

    @JvmStatic
    fun rain_fast(): List<Party> {
        return listOf(
            Party(
                speed = 0f,
                maxSpeed = 30f,
                damping = 0.9f,
                angle = Angle.BOTTOM,
                spread = Spread.ROUND,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = 2, TimeUnit.SECONDS).perSecond(50),
                position = Position.Relative(0.0, 0.0).between(Position.Relative(1.0, 0.0))
            )
        )
    }
}