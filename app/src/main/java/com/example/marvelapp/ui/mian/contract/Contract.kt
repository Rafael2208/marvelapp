package com.example.marvelapp.ui.mian.contract

interface Contract {

    interface CharacterView{
        fun showError(error: String?)
        fun showCharacters(characters: List<Character>)
        abstract fun filterList(filteredList: ArrayList<Character>)
        fun AuthAPI()
    }

    interface Presenter{
        fun getCharacters()
    }
}