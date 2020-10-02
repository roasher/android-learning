package ru.pyurkin.pddtest.screens.launcher

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.main_fragment.*
import ru.pyurkin.pddtest.R
import ru.pyurkin.pddtest.screens.tests.SecondaryFragment

class MainFragment : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("main_fragment", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        nextButton.setOnClickListener {
            it.findNavController().navigate(R.id.secondaryFragment, Bundle().apply {
                this.putString(SecondaryFragment.AUTH_TOKEN, "Hello from the Main Fragment");
            })
        }
    }
}