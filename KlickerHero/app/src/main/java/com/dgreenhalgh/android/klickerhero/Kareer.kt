package com.dgreenhalgh.android.klickerhero

import android.support.annotation.ColorRes
import com.dgreenhalgh.android.klickerhero.Tier.Companion.getTierForLevel

class Kareer(_kount: Int = 0, var tier: Tier = Tier.Baby) {

    var kount = _kount
        set(value) {
            field = value
            if (value > tier.maxKlicks) {
                tier = getTierForLevel(tier.level + 1)
            }
        }
}

enum class Tier(var level : Int = 0, val maxKlicks : Int, @ColorRes val kolorResId : Int) {
    Baby(0, 5, R.color.baby_blue),
    Novice(1, 15, R.color.light_green),
    Pro(2, 30, R.color.light_red),
    Master(3, 100, R.color.light_yellow),
    Grandmaster(4, Int.MAX_VALUE, R.color.grandmaster_purple);

    companion object {
        fun getTierForLevel(level: Int) : Tier {
            Tier.values()
                    .filter { it.level == level }
                    .forEach { return it }

            throw IllegalArgumentException()
        }
    }
}
