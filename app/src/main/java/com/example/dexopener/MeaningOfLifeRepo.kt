package com.example.dexopener

class MeaningOfLifeRepo(private val myFinalClassInLib: MyFinalClassInLib) {
    fun stringifiedMeaningOfLife(): String =
        "The number ${myFinalClassInLib.meaningOfLife()} is, in The Hitchhiker's Guide to the Galaxy by Douglas Adams, the \"Answer to the Ultimate Question of Life, the Universe, and Everything\", calculated by an enormous supercomputer named Deep Thought over a period of 7.5 million years."
}
