package ru.pyurkin.pddtest.screens.tests

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.pyurkin.pddtest.R

class SecondaryFragment : Fragment(R.layout.secondary_fragment) {

    companion object {
        val AUTH_TOKEN = "authToken"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val authToken = this.arguments?.getString(AUTH_TOKEN)
        secondary_fragment_text.text = authToken
    }
}