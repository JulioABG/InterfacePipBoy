package com.example.pipboyinterface

import androidx.annotation.DrawableRes

data class SpecialStat(
    val name: String,
    val value: Int,
    val description: String,
    @DrawableRes val imageRes: Int
)

// Información de las habilidades
val specialStats = listOf(
    SpecialStat(
        name = "Strength",
        value = 4,
        description = "Strength is a measure of your raw physical power. It affects how much you can carry, and the damage of all melee attacks.",
        imageRes = R.drawable.strength
    ),
    SpecialStat(
        name = "Perception",
        value = 8,
        description = "Perception is your environmental awareness and 'sixth sense,' and affects your weapon accuracy in V.A.T.S.",
        imageRes = R.drawable.perception
    ),
    SpecialStat(
        name = "Endurance",
        value = 3,
        description = "Endurance is a measure of your overall physical fitness. It affects your total Health and the Action Point drain from sprinting.",
        imageRes = R.drawable.endurance
    ),
    SpecialStat(
        name = "Charisma",
        value = 5,
        description = "Charisma is your ability to charm and convince others. It affects your success to persuade in dialogue and prices when you barter.",
        imageRes = R.drawable.charisma
    ),
    SpecialStat(
        name = "Intelligence",
        value = 2,
        description = "Intelligence is a measure of your overall mental acuity, and affects the number of Experience Points earned.",
        imageRes = R.drawable.intelligence
    ),
    SpecialStat(
        name = "Agility",
        value = 3,
        description = "Agility is a measure of your overall finesse and reflexes. It affects the number of Action Points in V.A.T.S. and your ability to sneak.",
        imageRes = R.drawable.agility
    ),
    SpecialStat(
        name = "Luck",
        value = 3,
        description = "Luck is a measure of your general good fortune, and affects the recharge rate of Critical Hits and your chances of finding better items.",
        imageRes = R.drawable.luck
    )
)

