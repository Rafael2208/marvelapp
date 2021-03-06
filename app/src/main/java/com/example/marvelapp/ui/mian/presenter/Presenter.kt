package com.example.marvelapp.ui.mian.presenter

import com.example.marvelapp.model.AuthAPI
import com.example.marvelapp.model.ResponseAPI
import com.example.marvelapp.network.RetrofitConfig
import com.example.marvelapp.ui.mian.contract.Contract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private var view: Contract.CharacterView?): Contract.Presenter {

    private val authAPI = AuthAPI()

    override fun getCharacters() {
        RetrofitConfig()
            .characterService()
            .getCharacter(
                authAPI.limit,
                authAPI.timeStamp,
                authAPI.publicKey,
                authAPI.md5Hash().toString()
            )
            .enqueue(object : Callback<ResponseAPI> {
                override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                    view?.showError(t.message)
                }

                override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                    response.body()?.data?.results?.let {
                        view?.showCharacters(it)
                    }
                }
            })
    }




}