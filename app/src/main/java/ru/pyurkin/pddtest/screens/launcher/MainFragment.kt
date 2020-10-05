package ru.pyurkin.pddtest.screens.launcher

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import ru.pyurkin.pddtest.R
import ru.pyurkin.pddtest.screens.tests.TestsFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("fragment_main", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        nextButton.setOnClickListener {
            it.findNavController().navigate(R.id.test_fragment, Bundle().apply {
                this.putString(TestsFragment.AUTH_TOKEN, "Hello from the Main Fragment");
            })
        }
    }
}