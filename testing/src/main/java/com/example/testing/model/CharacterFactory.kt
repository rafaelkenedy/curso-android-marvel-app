package com.example.testing.model

import com.rafael.core.domain.model.Character

class CharacterFactory {

    fun create(hero: Hero) = when(hero) {
        Hero.ThreeDman -> Character(
            "3-D Man",
            imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/3/20/535fecbbb9784.jpg"

        )
        Hero.ABomb -> Character(
            "A-Bomb (HAS)",
            imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg"
        )
    }

    sealed class Hero {
        object ThreeDman: Hero()
        object ABomb : Hero()
    }
}