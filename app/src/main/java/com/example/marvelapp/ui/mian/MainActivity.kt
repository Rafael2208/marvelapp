package com.example.marvelapp.ui.mian

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapp.BaseActivity
import com.example.marvelapp.R
import com.example.marvelapp.ui.mian.adapter.CharacterAdapter
import com.example.marvelapp.ui.mian.contract.Contract
import com.example.marvelapp.ui.mian.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), Contract.CharacterView {



    private lateinit var presenter: Presenter
    private val context = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kProgressHUD?.show()
        presenter = Presenter(context)
        presenter.getCharacters()

    }



    override fun showError(error: String?) {
        showAlert(
            "Ops...",
            "Connection error: could not connect to the server.",
            DialogInterface.OnClickListener { _, _ ->
                overridePendingTransition(0, 0)
                startActivity(intent)
                overridePendingTransition(0, 0)
                finishAffinity()
            }
        )
        kProgressHUD?.dismiss()
    }

    override fun showCharacters(characters: List<Character>) {
        rcvCharacters.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CharacterAdapter(context, characters)
        }
        kProgressHUD?.dismiss()
    }

    override fun filterList(filteredList: ArrayList<Character>) {
        TODO("Not yet implemented")
    }

    override fun AuthAPI() {
        TODO("Not yet implemented")
    }


}
