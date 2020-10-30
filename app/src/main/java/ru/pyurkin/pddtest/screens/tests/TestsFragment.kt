package ru.pyurkin.pddtest.screens.tests

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_test.*
import ru.pyurkin.pddtest.R

class TestsFragment : Fragment(R.layout.fragment_test) {

    private lateinit var testsViewModel: TestsViewModel

    companion object {
        val AUTH_TOKEN = "authToken"
    }

    private val testsAdapter: TestsAdapter = TestsAdapter(object : OnCheckBoxClick {
        override fun doOnCheckBoxClick(model: TestsAdapter.TestModel, checkBox: AppCompatCheckBox) {
            model.isChecked = checkBox.isChecked
        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val authToken = this.arguments?.getString(AUTH_TOKEN)

        test_list.adapter = testsAdapter;
        test_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        configureViewModel()
    }

    private fun configureViewModel() {
        testsViewModel = ViewModelProviders.of(this).get(TestsViewModel::class.java)
        testsViewModel.items.observe(viewLifecycleOwner, Observer {data ->
            testsAdapter.setModel(data)
        })
    }

}